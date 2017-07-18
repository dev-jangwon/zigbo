package zigbo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zigbo.model.ZigboService;
import zigbo.model.dto.MemberDTO;

public class SellingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");

		try {
			if (command.equals("addSelling")) {
				addSelling(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String email = request.getParameter("");
		String password = request.getParameter("Password");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		String account = request.getParameter("Account");
		
		MemberDTO member = new MemberDTO(email, password, phone, address, account);
		try{
			boolean result = ZigboService.addSelling(member);
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

}
