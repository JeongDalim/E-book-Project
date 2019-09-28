package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.member.BookCartAction;
import action.member.EmailCheckAction;
import action.member.GotoPwModifyAction;
import action.member.IdSearchAction;
import action.member.IdSearchProAction;
import action.member.LoginAction;
import action.member.LoginCheckAction;
import action.member.LogoutAction;
import action.member.MemberDeleteAction;
import action.member.MemberEmailSend;
import action.member.MemberIdCheckAction;
import action.member.MemberInsert1Action;
import action.member.MemberInsert2Action;
import action.member.MemberInsert3Action;
import action.member.MemberInsert3_BAction;
import action.member.MemberInsert4Action;
import action.member.MemberInsertAction;
import action.member.MemberInsert_BAction;
import action.member.MemberModifyAction;
import action.member.MemberModifyProAction;
import action.member.MemberPayAction;
import action.member.MemberPayCheckAction;
import action.member.MemberPayInsertAction;
import action.member.MemberPayUpdateAction;
import action.member.MemberPayUpdateProAction;
import action.member.MemberSubPayAction;
import action.member.MemberSubPayProAction;
import action.member.MemberSubcancelAction;
import action.member.MemberSubscriptPayCheckAction;
import action.member.MemberSubscriptPayInsertAction;
import action.member.MemberSubscriptPayUpdateAction;
import action.member.MemberSubscriptPayUpdateProAction;
import action.member.MemberViewAction;
import action.member.PmemberModifyProAction;
import action.member.PublisheEmailCheck;
import action.member.PublisherIDcheck;
import action.member.PwModifyAction;
import action.member.PwSearch1Action;
import action.member.PwSearchAction;
import action.member.PwSearchProAction;
import action.member.PwcheckAction;
import action.member.PwcheckPro;
import action.member.RDMemberPayCheckAction;
import action.member.RDMemberPayInsertAction;
import action.member.RDMemberPayUpdateAction;
import action.member.RDMemberPayUpdateProAction;
import action.member.id_EmailsendOKAction;

@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;

		if (cmd.equals("insert")) {
			action = new MemberInsertAction();
		} else if (cmd.equals("insert1")) {
			action = new MemberInsert1Action();
		} else if (cmd.equals("insert2")) {
			action = new MemberInsert2Action();
		} else if (cmd.equals("insert3")) {
			action = new MemberInsert3Action();
		} else if (cmd.equals("insert4")) {
			action = new MemberInsert4Action();
		} else if (cmd.equals("insert_B")) {
			action = new MemberInsert_BAction();
		} else if (cmd.equals("insert3_B")) {
			action = new MemberInsert3_BAction();
		} else if (cmd.equals("login")) {
			action = new LoginAction();
		} else if (cmd.equals("login_check")) {
			action = new LoginCheckAction();
		} else if (cmd.equals("logout")) {
			action = new LogoutAction();
		} else if (cmd.equals("idsearch")) {
			action = new IdSearchAction();
		} else if (cmd.equals("idsearch_pro")) {
			action = new IdSearchProAction();
		} else if (cmd.equals("MemberPay")) {
			action = new MemberPayAction();
		} else if (cmd.equals("pwsearch")) {
			action = new PwSearchAction();
		} else if (cmd.equals("pwsearch1")) {
			action = new PwSearch1Action();
		} else if (cmd.equals("pwsearch_pro")) {
			action = new PwSearchProAction();
		} else if (cmd.equals("pwmodify")) {
			action = new PwModifyAction();
		} else if (cmd.equals("bookcart")) {
			action = new BookCartAction();
		} else if (cmd.equals("memberview")) {
			action = new MemberViewAction();
		} else if (cmd.equals("pwcheck")) {
			action = new PwcheckAction();
		} else if (cmd.equals("membermodify")) {
			action = new MemberModifyAction();
		} else if (cmd.equals("memberdelete")) {
			action = new MemberDeleteAction();
		} else if (cmd.equals("membersubcancel")) {
			action = new MemberSubcancelAction();
		} else if (cmd.equals("membersubpay")) {
			action = new MemberSubPayAction();
		} else if (cmd.equals("membersubpaypro")) {
			action = new MemberSubPayProAction();
		} else if (cmd.equals("membermodifypro")) {
			action = new MemberModifyProAction();
		} else if (cmd.equals("pmembermodifypro")) {
			action = new PmemberModifyProAction();
		} else if (cmd.equals("Mid_check")) {
			action = new MemberIdCheckAction();
		} else if (cmd.equals("Pid_check")) {
			action = new PublisherIDcheck();
		} else if (cmd.equals("gotopwmodify")) {
			action = new GotoPwModifyAction();
		} else if (cmd.equals("pwcheckpro")) {
			action = new PwcheckPro();
		} else if (cmd.equals("email_check")) {
			action = new EmailCheckAction();
		} else if (cmd.equals("Pemail_check")) {
			action = new PublisheEmailCheck();
		} else if (cmd.equals("email_send")) {
			action = new MemberEmailSend();
		} else if (cmd.equals("id_EmailsendOK")) {
			action = new id_EmailsendOKAction();
		} else if (cmd.equals("MemberPayCheck")) {//일반회원중에  카드나 계좌 등록되있는지
			action = new MemberPayCheckAction();
		} else if (cmd.equals("MemberPayInsert")) {//일반회원중에 결제정보 새로 등록
			action = new MemberPayInsertAction();
		} else if (cmd.equals("MemberPayUpdate")) {//일반회원중에 결제정보 수정
			action = new MemberPayUpdateAction();
		} else if (cmd.equals("MemberPayUpdatePro")) {//일반회원중에 결제정보 수정
			action = new MemberPayUpdateProAction();
		} else if (cmd.equals("RDMemberPayCheck")) {//일반회원중에  카드나 계좌 등록되있는지-장바구니버전
			action = new RDMemberPayCheckAction();
		} else if (cmd.equals("RDMemberPayUpdate")) {//일반회원중에 결제정보 수정
			action = new RDMemberPayUpdateAction();
		} else if (cmd.equals("RDMemberPayUpdatePro")) {//일반회원중에 결제정보 수정
			action = new RDMemberPayUpdateProAction();
		} else if (cmd.equals("RDMemberPayInsert")) {//일반회원중에 결제정보 새로 등록
			action = new RDMemberPayInsertAction();
		} else if (cmd.equals("MemberSubscriptPayCheck")) {//일반회원->구독회원 결제 정보 등록되어있는지
			action = new MemberSubscriptPayCheckAction();
		} else if (cmd.equals("MemberSubscriptPayInsert")) {//일반회원중에 결제정보 새로 등록
			action = new MemberSubscriptPayInsertAction();
		} else if (cmd.equals("MemberSubscriptPayUpdate")) {//일반회원중에 결제정보 수정
			action = new MemberSubscriptPayUpdateAction();
		} else if (cmd.equals("MemberSubscriptPayUpdatePro")) {//일반회원중에 결제정보 수정
			action = new MemberSubscriptPayUpdateProAction();
		}

		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}