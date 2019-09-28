package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBClose;
import util.DBConn;

public class AdminDAO {

	private AdminDAO() {
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public List<PublisherVO> agreeList() { //출판사 승인 리스트
		List<PublisherVO> list = new ArrayList<PublisherVO>();
		PublisherVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from publisher order by idx desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new PublisherVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setBno(rs.getString("bno"));
				vo.setBfile(rs.getString("bfile"));
				vo.setEmail(rs.getString("email"));
				vo.setAgree(rs.getInt("agree"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}
	public int agree(String idx, int agree) { //출판사 승인, 거절
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "update publisher set agree="+agree+" where idx=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, idx);
			row=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
	public int deletePublisher(String idx) { //출판사 삭제
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "delete from publisher where idx=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, idx);
			row=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
}
