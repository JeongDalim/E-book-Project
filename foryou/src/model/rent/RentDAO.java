package model.rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.BookVO;
import util.DBClose;
import util.DBConn;
import util.ReturnDate;

public class RentDAO {
	private RentDAO() {
	}

	private static RentDAO instance = new RentDAO();

	public static RentDAO getInstance() {
		return instance;
	}

	public BookVO setVO(ResultSet rs) throws SQLException { // vo에 값 넣기
		BookVO vo = new BookVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setWriter(rs.getString("writer"));
		vo.setBookName(rs.getString("bookName"));
		vo.setGenre(rs.getString("genre"));
		vo.setContents(rs.getString("contents"));
		vo.setIntro(rs.getString("intro"));
		vo.setPrice(rs.getInt("price"));
		vo.setRentcnt(rs.getInt("rentcnt"));
		vo.setCompany(rs.getString("company"));
		vo.setPdate(rs.getDate("pdate").toString());
		vo.setFileName(rs.getString("filename"));
		vo.setIndate(rs.getDate("indate").toString());
		vo.setBookPlot(rs.getString("bookPlot"));
		return vo;
	}

	public int bookRent(String memberId, int bookIdx) { // 책 대여
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into rent (memberid,bookidx,returnDate) values (?,?,?)";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setInt(2, bookIdx);
			ps.setString(3, ReturnDate.ReturnDate());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int bookRent(String memberId, String[] bookIdxs) { // 책 여러권 대여
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			for (int i = 0; i < bookIdxs.length; i++) {
				System.out.println(bookIdxs[i]);
			}

			for (int i = 0; i < bookIdxs.length; i++) {
				String sql = "insert into rent (memberid,bookidx,returnDate) values (?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, memberId);
				ps.setString(2, bookIdxs[i]);
				ps.setString(3, ReturnDate.ReturnDate());
				row = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int bookReturn(String memberId, int bookIdx) { // 책 반납
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete rent where memberId=? and bookIdx=?";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setInt(2, bookIdx);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public List<BookVO> myRent(String memberId) { // 내 서재
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		String sql = "select * from book where idx in (select bookIdx from rent where memberId=?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = setVO(rs);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public int bookMark(int page, String bookIdx) { // 책 북마크
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update rent set bookmark=? where bookidx=?";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setString(2, bookIdx);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int plusRentCnt(int bookIdx) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update book set rentcnt=rentcnt+1 where idx=?";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookIdx);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int nowRead(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from rent where memberid=? order by bookmark desc";
		int bookIdx = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				bookIdx = Integer.parseInt(rs.getString("bookidx"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return bookIdx;
	}

	public int nowReview() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select book_idx from comments order by regdate desc";
		int bookIdx = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				bookIdx = Integer.parseInt(rs.getString("book_idx"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return bookIdx;
	}
}
