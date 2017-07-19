package zigbo.controller;

import java.io.IOException;

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
		String password = request.getParameter("Password").trim();
		String phone = request.getParameter("Phone").trim();
		String address = request.getParameter("Address").trim();
		String account = request.getParameter("Account").trim();

		if (email == null || email.trim().length() == 0 || password == null || password.trim().length() == 0
				|| phone == null || phone.trim().length() == 0 || address == null || address.trim().length() == 0
				|| account == null || account.trim().length() == 0) {
			response.sendRedirect("register.jsp");
			return;
		}
		
		MemberDTO member = new MemberDTO(email, password, phone, address, account);
		try{
			boolean result = ZigboService.addMember(member);
			if(result){
				request.setAttribute("member", member);
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
			System.out.println("getMember");
			//String url = "showError.jsp";
		      String email=request.getParameter("Email").trim();
		      HttpSession session = request.getSession(); //세션 생성
		      session.setAttribute("login", email);
		      System.out.println(email+" "+request.getParameter("Password"));
		      /*try { //수정 필요!!!
		         request.setAttribute("getMember", ZigboService.getMember(Integer.parseInt(request.getParameter("memberCode"))));
		         url = "index.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);*/
		      String url = "index.jsp";
		      System.out.print("세션에 담겨있는  값 : " + session.getAttribute("login")); 
		      request.getRequestDispatcher(url).forward(request, response);
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
	
}
