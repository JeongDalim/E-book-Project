package model.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.book.BookVO;
import util.DBClose;
import util.DBConn;

public class HomeDAO {

	private HomeDAO() {
	}

	private static HomeDAO instance = new HomeDAO();

	public static HomeDAO getInstance() {
		return instance;
	}

	public List<BookVO> list() { // 전체리스트(이모티콘때문에 쓰는거)
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BookVO();
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
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public int book_rownum_max() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select max(rownum) from book";
		int max = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				max = rs.getInt("max(rownum)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return max;
	}

	public BookVO today_book(int random_rownum) { //
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from (select idx,bookname,writer,genre,filename,rownum rn from book where rownum <?) where rn>?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, random_rownum + 1);
			ps.setInt(2, random_rownum - 1);

			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new BookVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setBookName(rs.getString("bookName"));
				vo.setFileName(rs.getString("fileName"));
				vo.setWriter(rs.getString("writer"));
				vo.setGenre(rs.getString("genre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return vo;
	}

	public List<BookVO> best_seller() { //
		BookVO vo = null;
		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from(select * from book order by rentcnt desc) where rownum<11";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BookVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setBookName(rs.getString("bookName"));
				vo.setFileName(rs.getString("fileName"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public List<BookVO> new_book() { // �떊洹쒖콉
		BookVO vo = null;
		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from(select * from book order by pdate desc) where rownum<10";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BookVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setBookName(rs.getString("bookName"));
				vo.setFileName(rs.getString("fileName"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public List<BookVO> foryou_book(String id) { // foryou
		BookVO vo = null;
		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] arr = null;
		int cnt = 0;
		String sql = "select genre from member where id=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String genre = rs.getString("genre");
				arr = genre.split("&&");
			}
			sql = "select * from book where genre =? or genre =? or genre =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, arr[0]);
			ps.setString(2, arr[1]);
			ps.setString(3, arr[2]);
			rs = ps.executeQuery();
			while (rs.next() && cnt < 5) {
				vo = new BookVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setBookName(rs.getString("bookName"));
				vo.setFileName(rs.getString("fileName"));
				list.add(vo);
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}
}
