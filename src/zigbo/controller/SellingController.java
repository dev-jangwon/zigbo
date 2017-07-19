package zigbo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zigbo.model.ZigboService;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.SellingDTO;

public class SellingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");

		try {
			if(command.equals("addSelling")) {
				addSelling(request, response);
			}else if(command.equals("getSelling")){
				getSelling(request, response);
			}else if(command.equals("getAllSelling")){
				getAllSelling(request, response);
			}else if(command.equals("updateSellingViews")){
				updateSellingViews(request, response);
			}else if(command.equals("updateSellingProgress")){
				updateSellingProgress(request, response);
			}else if(command.equals("getMostViews")){
				getMostViews(request, response);
			}else if(command.equals("getMostRecent")){
				getMostViews(request, response);
			}else if(command.equals("getMostInterest")){
				getMostViews(request, response);
			}else if(command.equals("addPayment")){
				addPayment(request, response);
			}else if(command.equals("getPaymentofMember")){
				getPaymentofMember(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		int itemCode = Integer.parseInt(request.getParameter("ItemCode"));
		String location = request.getParameter("Location");
		SellingDTO selling = new SellingDTO(memberCode, itemCode, location);
		
		try{
			boolean result = ZigboService.addSelling(selling);
			if(result){
				request.setAttribute("selling", selling);
				request.setAttribute("successMsg", "���� �Ϸ�");
				//url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("selling", ZigboService.getSelling(Integer.parseInt(request.getParameter("SellingCode"))));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getAllSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("sellingAll", ZigboService.getAllSelling());
			url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void updateSellingViews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("selling", ZigboService.updateSellingViews(Integer.parseInt(request.getParameter("SellingCode"))));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void updateSellingProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("selling", ZigboService.updateSellingProgress(Integer.parseInt(request.getParameter("SellingCode"))));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void getMostViews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("sellings", ZigboService.getMostViews());
			//url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMostRecent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("sellings", ZigboService.getMostRecent());
			//url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMostInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("sellings", ZigboService.getMostInterest());
			//url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void addPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		int sellingCode = Integer.parseInt(request.getParameter("SellingCode"));
		int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		String address = request.getParameter("Address");
		PaymentDTO payment = new PaymentDTO(sellingCode, memberCode, address);
		
		try{
			boolean result = ZigboService.addPayment(payment);
			if(result){
				request.setAttribute("payment", payment);
				request.setAttribute("successMsg", "���� �Ϸ�");
				//url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getPaymentofMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("paymentAll", ZigboService.getPaymentofMember(Integer.parseInt(request.getParameter("MemberCode"))));
			//url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}