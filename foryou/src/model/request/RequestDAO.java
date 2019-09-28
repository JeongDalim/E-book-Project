package model.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBClose;
import util.DBConn;

public class RequestDAO {

	private RequestDAO() {
	}

	private static RequestDAO instance = new RequestDAO();

	public static RequestDAO getInstance() {
		return instance;
	}

	// 게시판 리스트
	public List<RequestVO> requestList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<RequestVO> list = new ArrayList<RequestVO>();
		String query = "select * from request order by indate desc";

		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			RequestVO vo = null;

			while (rs.next()) {
				vo = new RequestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setSubject(rs.getString("subject"));
				vo.setGubun(rs.getString("gubun"));
				vo.setContents(rs.getString("contents"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBClose.close(rs, ps, conn);

			try {

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return list;
	}

	// 전체 글수 카운트
	public int requestCount() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;

		String query = "select count(*) from request";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);

			}
		} catch (Exception e) {

		} finally {
			DBClose.close(rs, ps, conn);

			try {

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return row;

	}

	// 전체 글수 카운트 - 검색 조건 포함
	public int requestCount(String search, String key) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;

		String query = "select count(*) from request where " + search + " like '%" + key + "%'";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}

		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
			}
		}
		return row;

	}

	// 게시글 전체 목록 구하기
	public List<RequestVO> requestList( int pagestart, int endpage) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		
		String query = "select idx,userid,subject,gubun,contents,indate,readcnt from "
				+ "(select rownum rn,idx,userid,subject,gubun,contents,indate,readcnt from(select * from request order by idx desc) where rownum<= ? "
				+ ") where rn > ?";

		
		List<RequestVO> list = new ArrayList<RequestVO>();
		try {

			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);

			rs = ps.executeQuery();
			RequestVO vo = null;
			while (rs.next()) {
				vo = new RequestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setSubject(rs.getString("subject"));
				vo.setGubun(rs.getString("gubun"));
				vo.setContents(rs.getString("contents"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);

			}
		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return list;
	}

	// 게시글 전체 목록 구하기 - 검색 조건 포함
	public List<RequestVO> requestList(String s_query, int pagestart, int endpage) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		
		String query = "select idx,userid,subject,gubun,contents,indate,readcnt from "
				+ "(select rownum rn,idx,userid,subject,gubun,contents,indate,readcnt from request where " + s_query
				+ " and rownum<= ? " + "order by idx desc) where " + s_query + " and rn > ?";

		//System.out.println(s_query);
		//System.out.println(pagestart);
		//System.out.println(endpage);

		List<RequestVO> list = new ArrayList<RequestVO>();
		try {

			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);

			rs = ps.executeQuery();
			RequestVO vo = null;
			while (rs.next()) {
				vo = new RequestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setSubject(rs.getString("subject"));
				vo.setGubun(rs.getString("gubun"));
				vo.setContents(rs.getString("contents"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 게시글 등록 메소드
	public int requestWrite(RequestVO vo) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;

		String query = "insert into request(idx,userid,subject,gubun,contents,indate,readcnt)";
		query += " values (request_seq_idx.nextval, ?, ?, 0, ?, sysdate, 0)";
		int row = 0;
		try {

			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getUserid());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContents());
			row = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return row;
	}

	
	// 조회수 증가
	public void requestHits(int idx) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "update request set readcnt = readcnt + 1 where idx = ?";
		try {

			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
			}
		}
	}

	// 특정(기본키) 게시글 구하기--뷰페이지, 수정 페이지 에서 사용
	public RequestVO requestView(int idx) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		
		String query = "select * from request where idx = ?";
		RequestVO vo = null;
		
		
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new RequestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setSubject(rs.getString("subject"));
				vo.setGubun(rs.getString("gubun"));
				vo.setContents(rs.getString("contents"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			DBClose.close(rs, ps, conn);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 특정글 수정 처리(update)-- 기본키와 비번이 같을 경우
	public int requestUpdate(RequestVO vo) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		

		String query = "update request set subject=?, contents=? where idx = ?";
		int row = 0;
		try {
			
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getContents());
			ps.setInt(3, vo.getIdx());

			row = ps.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
			}
		}
		return row;
	}

	// 특정 글 삭제 처리
	public int requestDelete(int idx) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;

		String query = "delete from request where idx = ?";
		int row = 0;
		try {

			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public int gubunUpdate(int idx) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		
		String query = "update request set gubun = ? where idx = ?";
		int row = 0;
		try {
			
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "2");
			ps.setInt(2, idx);

			row = ps.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
			}
		}
		return row;
	}
	
	
	public int gubunUpdate2(int idx) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		
		String query = "update request set gubun = ? where idx = ?";
		int row = 0;
		try {
			
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1 , "0");
			ps.setInt(2 , idx);

			row = ps.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				DBClose.close(rs, ps, conn);

			} catch (Exception e) {
			}
		}
		return row;
	}
}
