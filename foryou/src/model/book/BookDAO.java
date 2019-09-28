
package model.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBClose;
import util.DBConn;

public class BookDAO {
	private BookDAO() {
	}

	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {
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
		vo.setPublished(rs.getString("published"));
		return vo;
	}

	public List<BookVO> genre_list(String genre) { // 장르별 책 리스트
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book where genre=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
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

	public List<BookVO> genre_list_best(String genre) { // 이 분야의 인기도서
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(genre);
		String sql = "select * from book where genre=? order by rentcnt desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			rs = ps.executeQuery();
			int cnt = 0;
			while (rs.next() || cnt < 8) {
				vo = setVO(rs);
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

	public List<BookVO> writer_list(String writer) { // 저자별 도서
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book where writer=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, writer);
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

	public boolean book_insert(BookVO vo) { // 등록
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean sw = false;
		String query = "insert into book(idx,writer,bookName,genre,contents,intro,price,rentcnt,company,pdate,fileName,indate,bookPlot,published)"
				+ "values(book_seq_idx.nextval,?,?,?,?,?,?,?,?,?,?,sysdate,?,?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getBookName());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getContents());
			ps.setString(5, vo.getIntro());
			ps.setInt(6, vo.getPrice());
			ps.setInt(7, vo.getRentcnt());
			ps.setString(8, vo.getCompany());
			ps.setString(9, vo.getPdate());
			ps.setString(10, vo.getFileName());
			ps.setString(11, vo.getBookPlot());
			ps.setString(12, vo.getPublished());
			ps.executeUpdate();
			sw = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBClose.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sw;
	}

	public boolean book_modify(BookVO vo, int idx) {// 수정
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update book set writer = ? , bookName = ?, pdate = ?, genre = ?, contents = ?,intro = ?, price = ?, fileName = ?, indate = sysdate, bookPlot = ? "
				+ "where idx = ?";
		boolean sw = false;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getBookName());
			ps.setString(3, vo.getPdate());
			ps.setString(4, vo.getGenre());
			ps.setString(5, vo.getContents());
			ps.setString(6, vo.getIntro());
			ps.setInt(7, vo.getPrice());
			ps.setString(8, vo.getFileName());
			ps.setString(9, vo.getBookPlot());
			ps.setInt(10, idx);
			ps.executeUpdate();
			sw = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return sw;
	}

	public boolean book_delete(int idx) {// 삭제
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String query = "delete from book where idx = ?";
		boolean sw = false;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			ps.executeUpdate();
			sw = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return sw;
	}

	public BookVO book_view(int idx) {// 북뷰
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		BookVO vo = null;
		String sql = "select * from book where idx= ?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = setVO(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBClose.close(rs, ps, conn);
		}
		return vo;
	}

	public List<BookVO> book_search(String keyword) { // 북검색
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		String sql = "select * from book where writer like '%" + keyword + "%'"; // 작가로검색
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = setVO(rs);
				list.add(vo);
			}
			sql = "select * from book where company like '%" + keyword + "%'"; // 출판사로검색
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = setVO(rs);
				list.add(vo);
			}
			sql = "select * from book where bookName like '%" + keyword + "%'"; // 책이름으로 검색
			ps = conn.prepareStatement(sql);
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

	public List<CommentsVO> book_comments(int idx, String regdate) { // 책 평가내용//이수정 수정함
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<CommentsVO> list = new ArrayList<CommentsVO>();
		CommentsVO vo = null;
		String sql = "select * from comments where book_idx = (select idx from book where idx=?) order by " + regdate
				+ " desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new CommentsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setBook_idx(rs.getInt("book_idx"));
				vo.setMember_id(rs.getString("member_id")); 	
				vo.setContents(rs.getString("contents"));
				vo.setScore(rs.getInt("score"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public boolean write_Comments(CommentsVO vo) { // 등록
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		System.out.println(vo.getBook_idx());
		System.out.println(vo.getMember_id());
		System.out.println(vo.getContents());

		System.out.println(vo.getScore());
		boolean sw = false;
		int row = 0;
		String sql = "insert into comments(idx,book_idx,member_id,contents,score,regdate) values (comments_seq_idx.nextval,?,?,?,?,sysdate)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getBook_idx());
			ps.setString(2, vo.getMember_id());
			ps.setString(3, vo.getContents());
			ps.setInt(4, vo.getScore());
			row = ps.executeUpdate();
			if (row != 0) {
				sw = true;
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
		return sw;
	}

	public int bookCount(String genre) { // 장르별 책수

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from book where genre=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}
	public int bookCount2(String s_query) { // 총 책 수(검색시)

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from book where "+s_query;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int bookCount(String genre, String keyword) { // 총 책 수(검색시)

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from book where writer like '%"+keyword+"%' or company like '%"+keyword+"%' or bookName like '%"+keyword+"%'";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(keyword);
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public List<BookVO> pagingList(int pagestart, int endpage, String genre) { // 페이징
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select idx,writer,bookName,genre,contents,intro,price,rentcnt,company,pdate,fileName,indate,bookPlot,published from(select rownum rn,idx,writer,bookName,genre,contents,intro,price,rentcnt,company,pdate,fileName,indate,bookPlot,published from book where rownum <= ? and genre=? order by idx desc) where rn > ?";
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endpage);
			ps.setString(2, genre);
			ps.setInt(3, pagestart);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = setVO(rs);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBClose.close(rs, ps, conn);
			} catch (Exception e) {
			}
		}
		return list;
	}

	public List<BookVO> pagingList(String s_query, int pagestart, int endpage) { // 페이징(검색시)
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select distinct * from (select rownum rn,idx,bookname,genre,contents,intro,writer,company,price,rentcnt,filename,indate,pdate,bookPlot,published from (select * from book where writer "
				+ s_query + " or company "+ s_query +" or bookName "+ s_query +" order by idx desc)where rownum<= ?) where rn > ?";
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);
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

	public List<BookVO> pagingList2(String s_query, int pagestart, int endpage) { // 페이징(검색시)
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum rn,idx,bookname,genre,contents,intro,writer,company,price,rentcnt,filename,indate,pdate,bookPlot,published from (select * from book where "
				+ s_query + " order by idx desc)where rownum<= ?) where rn > ?";
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);
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

	public String campanysearch(String id) {
		String name = "";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select name from publisher where id=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return name;
	}

	public List<BookVO> my_insert_list(String company) { // 출판사별 등록 리스트
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book where company=? order by indate desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, company);
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

	public int bookmarksearch(String memberID, String bookidx) { // 북마크 검색기능
		int bookmark = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select bookmark from rent where memberid=? and bookidx=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberID);
			ps.setString(2, bookidx);

			rs = ps.executeQuery();
			while (rs.next()) {
				bookmark = rs.getInt("bookmark");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return bookmark;
	}

	public int goodUp(int idx, String member_id) {// 북리뷰 comments 좋아요 늘리기
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update comments set good=good+1 where idx=? and member_id=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ps.setString(2, member_id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int badUp(int idx, String member_id) {// 북리뷰 comments 싫어요 늘리기
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update comments set bad=bad+1 where idx=? and member_id=?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ps.setString(2, member_id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public List<BookVO> noPublishedBook() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = null;
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where published='no'";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
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
