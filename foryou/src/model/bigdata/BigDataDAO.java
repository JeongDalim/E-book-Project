package model.bigdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.BookVO;
import util.DBClose;
import util.DBConn;

public class BigDataDAO {
	private BigDataDAO() {
	}

	private static BigDataDAO instance = new BigDataDAO();

	public static BigDataDAO getInstance() {
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
		vo.setRentcnt(rs.getInt("readcnt"));
		vo.setCompany(rs.getString("company"));
		vo.setPdate(rs.getDate("pdate").toString());
		vo.setFileName(rs.getString("filename"));
		vo.setIndate(rs.getDate("indate").toString());
		vo.setBookPlot(rs.getString("bookPlot"));
		return vo;
	}

	public void genre_hits(int idx, String genre) { // 회원에 대힌 장르별 조회수(관심분야)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update bigdata set ? = ?+1 where idx=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setString(2, genre);
			ps.setInt(3, idx);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
	}

	public List<BookVO> genre_list(int idx) { // 회원에 대한 관심장르별 책 추천
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book where genre=(select max(*) from bigdata where idx=?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
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
