package zigbo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zigbo.model.ZigboService;
import zigbo.model.dto.MemberDTO;

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		
		
		try{
			if(command.equals("addMember")){
				addMember(request, response);
			}else if(command.equals("getMember")){
				getMember(request, response);
			}else if(command.equals("updateMember")){
				updateMember(request, response);
			}else if(command.equals("deleteMember")){
				deleteMember(request, response);
			}else if(command.equals("getSellingofMember")){
				getMember(request, response);
			} else if(command.equals("logout")) {
				logout(request, response);
			}
			
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		
		String email = request.getParameter("Email").trim();
		
		try {
			if(ZigboService.getCountByEmail(email)>0){
				request.setAttribute("duplicateMsg", "이미 존재하는 이메일입니다.");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String password = request.getParameter("Password").trim();
		String phone = request.getParameter("Phone").trim();
		String address = request.getParameter("Address").trim();
		String account = request.getParameter("Account").trim();

		if (email == null || email.trim().length() == 0 || password == null || password.trim().length() == 0
				|| phone == null || phone.trim().length() == 0 || address == null || address.trim().length() == 0
				|| account == null || account.trim().length() == 0) {
			request.setAttribute("errorMsg", "모든 정보를 입력해주세요");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		MemberDTO member = new MemberDTO(email, password, phone, address, account);
		try{
			if(ZigboService.addMember(member)){
				request.setAttribute("successMsg", "가입 완료");
				url = "index.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		String email = request.getParameter("Email").trim();
		String password = request.getParameter("Password").trim();
		try {
			MemberDTO member = ZigboService.getMember(email, password);
			if(member!=null){
				request.setAttribute("getMember",member);
				HttpSession session = request.getSession(); // 세션 생성
				session.setAttribute("login", member.getMemberCode());

				url = "index.jsp";
			}else{
				request.setAttribute("errorMsg", "존재하지 않는 회원 정보입니다.");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		response.sendRedirect(url);
	}
	
	public void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      
		  String password = request.getParameter("password").trim();
		  String phone = request.getParameter("phone").trim();
		  String address = request.getParameter("address").trim();
		  String account = request.getParameter("account").trim();
	      
	      try {
	         request.setAttribute("successMsg", ZigboService.updateMember(Integer.parseInt(request.getParameter("MemberCode")), password, phone, address, account));
	         url = "activistDetail.jsp";
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	public void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      try {
	    	  ZigboService.deleteMember(Integer.parseInt(request.getParameter("MemberCode")));
	         url = "main.jsp";
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }
	
	public void getSellingofMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		         request.setAttribute("getSellingofMember", ZigboService.getSellingofMember(Integer.parseInt(request.getParameter("MemberCode"))));
		         //url = "getMember.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
		   }
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
	        session.invalidate();
	        session = null;
	        response.sendRedirect("index.jsp");
	   }
}
