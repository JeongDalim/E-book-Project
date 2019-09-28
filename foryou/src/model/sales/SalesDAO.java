package model.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBClose;
import util.DBConn;

public class SalesDAO {
	private SalesDAO() {
	}

	private static SalesDAO instance = new SalesDAO();

	public static SalesDAO getInstance() {
		return instance;
	}

	public SalesVO setVO(ResultSet rs) throws SQLException { // vo에 값 넣기
		SalesVO vo = new SalesVO();
		vo.setCompany(rs.getString("company"));
		vo.setYear(rs.getInt("year"));
		vo.setMonth(rs.getInt("month"));
		vo.setDay(rs.getInt("day"));
		vo.setSales(rs.getInt("sales"));
		return vo;
	}

	public int salesinsert(SalesVO vo) { // 각 매출액 등록
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int sw = 0;
		String sql = "insert into sales values (?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCompany());
			ps.setInt(2, vo.getYear());
			ps.setInt(3, vo.getMonth());
			ps.setInt(4, vo.getDay());
			ps.setString(5, vo.getName());
			ps.setInt(6, vo.getSales());
			sw = ps.executeUpdate();

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

	public int real_sales(int year, int month) { //일반결제자들 매출
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int sw = 0;
		String sql = " select sum(sales),company from sales where year=? and month=? and company='foryou' group by company";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, month);
			rs = ps.executeQuery();
			if (rs.next()) {
				sw=rs.getInt(1);
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
	
	public List<SalesVO> list(int year, int month) { // 출판사 매출액 리스트
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<SalesVO> list = new ArrayList<SalesVO>();
		SalesVO vo = null;
		String sql = "select sum(sales),company from sales where year=? and month=? and company != 'foryou' group by company order by sum(sales) desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new SalesVO();
				vo.setSales(rs.getInt(1));
				vo.setCompany(rs.getString(2));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public List<SalesVO> view_list(int year, int month, String company) { // 출판사 뷰 일별 매출액 리스트
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<SalesVO> list = new ArrayList<SalesVO>();
		SalesVO vo = null;
		String sql = "select day,sum(sales) from sales where year=? and month=? and company=? group by day order by day";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, month);
			ps.setString(3, company);

			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new SalesVO();
				vo.setDay(rs.getInt(1));
				vo.setSales(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public List<SalesVO> view_list_sales(int year, int month, String company) { // 출판사 뷰 일별 매출액 리스트
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<SalesVO> list = new ArrayList<SalesVO>();
		SalesVO vo = null;
		String sql = "select sum(sales),name from sales where year=? and month=? and company=? group by name order by sum(sales) desc";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, month);
			ps.setString(3, company);

			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new SalesVO();
				vo.setSales(rs.getInt(1));
				vo.setName(rs.getString(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public List<SalesVO> foryou_list(int year, int month) { // ForYou 월별 매출액 리스트
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<SalesVO> list = new ArrayList<SalesVO>();
		SalesVO vo = null;
		String sql = "select sum(sales),day from sales where year=? and month=? group by day order by day";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new SalesVO();
				vo.setSales(rs.getInt(1));
				vo.setDay(rs.getInt(2));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public int foryou_list_people(int year, int month) { // ForYou 구독자 수 매출액
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int r = 0;
		String sql = "select count(id) from member where subdate between '" + year + "/" + month + "/1' and '" + year
				+ "/" + month + "/30'";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			/*
			 * ps.setInt(1, year); ps.setInt(2, month); ps.setInt(3, year); ps.setInt(4,
			 * month);
			 */
			rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return r;
	}
}