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
			}else if(command.equals("getMember")){//모든 재능 기부자 검색
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
		
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		String account = request.getParameter("Account");
		
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
		  //public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		         request.setAttribute("getMember", ZigboService.getMember());
		         url = "probonoProjectList.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
		   }


	
	
	
	
}
