package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBClose;
import util.DBConn;

public class MemberDAO {

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberVO setVO(ResultSet rs) throws Exception {
		MemberVO vo = new MemberVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setId(rs.getString("id"));
		vo.setPw(rs.getString("pw"));
		vo.setName(rs.getString("name"));
		vo.setTel(rs.getString("tel"));
		vo.setGenre(rs.getString("genre"));
		vo.setGubun(rs.getString("gubun"));
		vo.setRentList(rs.getString("rentlist"));
		// vo.setSubdate(rs.getDate("subdate").toString());
		vo.setEmail(rs.getString("email"));
		return vo;
	}

	public int joinMember(MemberVO vo) { // 회원 가입
		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (vo.getSubdate() == null) { // 일반회원 카드, 계좌 정보 X
			String sql = "insert into member(idx,id,pw,name,email,tel,genre) values(member_seq_idx.nextval,?,?,?,?,?,?)";
			try {
				conn = DBConn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getId());
				ps.setString(2, vo.getPw());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getTel());
				ps.setString(6, vo.getGenre());
				flag = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBClose.close(rs, ps, conn);
			}
		} else if (vo.getSubdate() != null && vo.getCard() != null) { // 정기구독회원 카드등록 사용자
			String sql = "insert into member(idx,id,pw,name,email,tel,genre,subdate,gubun,card,cvc) values(member_seq_idx.nextval,?,?,?,?,?,?,sysdate,?,?,?)";
			try {
				conn = DBConn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getId());
				ps.setString(2, vo.getPw());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getTel());
				ps.setString(6, vo.getGenre());
				ps.setString(7, "subcust");
				ps.setString(8, vo.getCard());
				ps.setString(9, vo.getCvc());
				flag = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBClose.close(rs, ps, conn);
			}
		} else if (vo.getSubdate() != null && vo.getBank() != null) { // 정기구독회원 계좌등록 사용자
			String sql = "insert into member(idx,id,pw,name,email,tel,genre,subdate,gubun,bank,bankpw) values(member_seq_idx.nextval,?,?,?,?,?,?,sysdate,?,?,?)";
			try {
				conn = DBConn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getId());
				ps.setString(2, vo.getPw());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getTel());
				ps.setString(6, vo.getGenre());
				ps.setString(7, "subcust");
				ps.setString(8, vo.getBank());
				ps.setString(9, vo.getBankpw());
				flag = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBClose.close(rs, ps, conn);
			}
		}
		return flag;

	}

	public int insertPub(PublisherVO vo) { // 사업자 회원가입
		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into publisher(idx,id,pw,name,email,tel,bno,bfile) values"
				+ "(publisher_seq_idx.nextval,?,?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getTel());
			ps.setString(6, vo.getBno());
			ps.setString(7, vo.getBfile());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return flag;

	}

	public boolean publisher_id_check(String id) {// 출판회원 아이디 체크
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select id from publisher where id = ?";
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			row = ps.executeUpdate();
			if (row != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBClose.close(rs, ps, conn);

		}
		return flag;

	}


	   public boolean member_email_check(String email) { 
	      PreparedStatement ps = null;
	      Connection conn = null;
	      ResultSet rs = null;
	      String sql = "select email from member where email = ?";
	      int row = 0;
	      boolean flag = false;
	      try {
	         conn = DBConn.getConnection();
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, email);
	         row = ps.executeUpdate();
	         if (row != 0) {
	            flag = true;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBClose.close(rs, ps, conn);
	      }
	      return flag;
	   }
	   
	   public boolean publisher_email_check(String email) { 
	      PreparedStatement ps = null;
	      Connection conn = null;
	      ResultSet rs = null;
	      String sql = "select email from  publisher where email = ?";
	      int row = 0;
	      boolean flag = false;
	      try {
	         conn = DBConn.getConnection();
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, email);
	         row = ps.executeUpdate();
	         if (row != 0) {
	            flag = true;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBClose.close(rs, ps, conn);
	      }
	      return flag;
	   }
	
	
	
	
	
	public boolean member_id_check(String id) { // 일반회원 아이디 체크
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select id from member where id = ?";
		int row = 0;
		boolean flag = false;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			row = ps.executeUpdate();
			if (row != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return flag;
	}

	public int midcheck(String id, String pw) {// 회원전용아이디채크
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "select * from member where id =?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String check = rs.getString("pw");
				if (pw.equalsIgnoreCase(check)) {
					row = 1;
				} else {
					row = -1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int pidcheck(String id, String pw) {// 사업자전용아이디채크
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		try {
			String query = "select * from publisher where id =?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String check = rs.getString("pw");
				if (pw.equalsIgnoreCase(check)) {
					row = 1;
				} else {
					row = -1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int agreeCheck(String id) { // 사업자 승인 확인 메소드
		String query = "select agree from publisher where id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt("agree");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public String idSearch(String gubun, String name, String key) { // 회원테이블에서 id찾기
		String query = "select id from member where name=? and " + gubun + "=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, key);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			} else {
				id = "notexit";
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return id;
	}

	public String bidSearch(String gubun, String bno, String eorp) { // 사업자테이블에서 id찾기
		String query = "select id from publisher where bno=? and " + gubun + "=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, bno);
			ps.setString(2, eorp);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			} else {
				id = "notexit";
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return id;
	}

	public int mIdExit(String id) {// 회원 id check(비밀번호 찾을 때 아이디가 존재하는지)
		String query = "select count(*) from member where id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int bIdExit(String id) {// 사업자 id check(비밀번호 찾을 때 아이디가 존재하는지)
		String query = "select count(*) from publisher where id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int id_pSearch(String gubun, String id, String name, String key) {// 회원테이블에서 id와 입력받은 내용에 맞는 정보가 존재하는지 찾기
		String query = "select count(*) from member where id=? and name=? and " + gubun + "=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, key);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int bid_pSearch(String gubun, String id, String bno, String eorp) {// 사업자테이블에서 id와 입력받은 내용에 맞는 정보가 존재하는지 찾기
		String query = "select count(*) from publisher where id=? and bno=? and " + gubun + "=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, bno);
			ps.setString(3, eorp);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int pwModify(String id, String pw) {// 회원 비밀번호 갱신 메소드
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set pw=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public int bpwModify(String id, String pw) {// 사업자 비밀번호 갱신 메소드
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update publisher set pw=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public MemberVO memberInfo(String id) { // 회원정보
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			String query = "select * from member where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
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

	public MemberVO memberView(String id) {// 수정전뷰(회원)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			String query = "select * from member where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setId(id);
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setRentList(rs.getString("rentlist"));
				vo.setGenre(rs.getString("genre"));
				vo.setSubdate(rs.getString("subdate"));
				vo.setGubun(rs.getString("gubun"));
				vo.setCard(rs.getString("card"));
				vo.setCvc(rs.getString("cvc"));
				vo.setBank(rs.getString("bank"));
				vo.setBankpw(rs.getString("bankpw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return vo;
	}

	public PublisherVO publisherView(String id) {// 수정전 뷰(추가)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PublisherVO vo = null;
		try {
			String query = "select * from publisher where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new PublisherVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setId(id);
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setBno(rs.getString("bno"));
				vo.setBfile(rs.getString("bfile"));
				vo.setAgree(rs.getInt("agree"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return vo;
	}

	public int memberDelete(String id) {// 삭제회원
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "delete from member where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public int publisherDelete(String id) {// 삭제(출판사)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "delete from publisher where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public int subCancel(String id) { // 구독회원 구독 취소
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set gubun = 'subcancel' where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public int cancelsub(String id) {// 구독취소신청한 신청취소(구독 계속하기)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set gubun = 'subcust' where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}

		return row;
	}

	public int subsub(String id) { // 일반회원에서 구독신청
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set gubun = 'subcust', subdate=sysdate where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public MemberVO subcancelsea(String id) { // 취소신청한 구독회원
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from member where id = ?";
		MemberVO vo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setRentList(rs.getString("rentlist"));
				vo.setGenre(rs.getString("genre"));
				vo.setSubdate(rs.getString("subdate"));
				vo.setGubun(rs.getString("gubun"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return vo;
	}

	public int subtocust(String id) { //
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set gubun = 'cust', subdate=null where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int memberModify(MemberVO vo) {// 회원수정
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set pw=?,email=?,tel=?,genre=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getPw());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getTel());
			ps.setString(4, vo.getGenre());
			ps.setString(5, vo.getId());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	public int PmemberModify(PublisherVO vo) {// 출판회원수정
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update publisher set pw=?,email=?,tel=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getPw());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getTel());
			ps.setString(4, vo.getId());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}

	// 구독회원 리스트
	public List<MemberVO> subcustList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select id,subdate from member where gubun = 'subcust'";
		MemberVO vo = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setSubdate(rs.getString("subdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return list;
	}

	public int subcon(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set subdate = sysdate where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
	public int memberCardInsert(String card, String cvc, String id) {//카드번호 추가
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set card=?,cvc=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, card);
			ps.setString(2, cvc);
			ps.setString(3, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
	public int memberBankInsert(String bank, String bankpw, String id) {//계좌번호 추가
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set bank=?,bankpw=? where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, bank);
			ps.setString(2, bankpw);
			ps.setString(3, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
	public int memberPayreset(String id) {//결제 방법 수정전 카드번호,계좌번호 삭제
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			String query = "update member set card='0',cvc='0',bankpw='0',bank='0' where id=?";
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, ps, conn);
		}
		return row;
	}
}
