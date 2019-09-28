package model.bookcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.BookVO;
import util.DBClose;
import util.DBConn;

public class BookCartDAO {

	private BookCartDAO() {

	}

	private static BookCartDAO instance = new BookCartDAO();

	public static BookCartDAO getInstance() {
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

	public int insert(String memberId, int bookIdx, String fileName, String bookName, int price) { // 책 장바구니에 넣기
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into bookcart (memberid,filename,bookname,price) values (?,?,?,?)";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setInt(2, bookIdx);
			ps.setString(3, bookName);
			ps.setInt(4, price);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int delete(String memberId, String bookName) { // 책 장바구니에 뺴기
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete bookcart where memberId=? and bookName=?";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setString(2, bookName);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int delete(String memberId, String[] bookNames) { // 책 여러개 장바구니에 뺴기
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			for (int i = 0; i < bookNames.length; i++) {
				System.out.println( bookNames[i]);
				String sql = "delete bookcart where memberId=? and bookname = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, memberId);
				ps.setString(2, bookNames[i]);
				row = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public List<BookVO> myBookCart(String memberId) { // 내 장바구니
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		String sql = "select * from book where bookname in (select bookname from bookcart where memberId=?)";
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
}
