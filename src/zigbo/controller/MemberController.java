package zigbo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String url = "showError.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String account = request.getParameter("account");
		
		MemberDTO member = new MemberDTO(email, password, phone, address, account);
		try{
			boolean result = ZigboService.addMember(member);
			if(result){
				request.setAttribute("member", member);
				request.setAttribute("successMsg", "가입 완료");
				//url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      
		      try {
		         request.setAttribute("getMember", ZigboService.getMember(Integer.parseInt(request.getParameter("memberCode"))));
		         //url = "getMember.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      
		  String password = request.getParameter("password");
		  String phone = request.getParameter("phone");
		  String address = request.getParameter("address");
		  String account = request.getParameter("account");
	      
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
