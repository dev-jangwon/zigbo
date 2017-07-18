package zigbo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zigbo.model.ZigboService;
import zigbo.model.dto.InterestDTO;
import zigbo.model.dto.ItemDTO;

public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");

		try {
			if(command.equals("addItem")) {
				addItem(request, response);
			}else if(command.equals("getItem")){
				getItem(request, response);
			}else if(command.equals("getItemByPrice")){
				getItemByPrice(request, response);
			}else if(command.equals("getItemByLocation")){
				getItemByLocation(request, response);
			}else if(command.equals("getAllItem")){
				getAllItem(request, response);
			}else if(command.equals("updateItemPrice")){
				updateItemPrice(request, response);
			}else if(command.equals("updateItemLocation")){
				updateItemLocation(request, response);
			}else if(command.equals("deleteItem")){
				deleteItem(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String price = request.getParameter("Price"));
		String detail = request.getParameter("Detail");
		String location = request.getParameter("Location");
		String picture1 = request.getParameter("Picture1");
		String picture2 = request.getParameter("Picture2");
		ItemDTO item = new ItemDTO(price, detail, location, picture1, picture2);
		
		try{
			boolean result = ZigboService.addItem(item);
			if(result){
				request.setAttribute("item", item);
				request.setAttribute("successMsg", "아이템 등록 완료");
				//url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("item", ZigboService.getItem(Integer.parseInt(request.getParameter("ItemCode"))));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getItemByLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("items", ZigboService.getItemByLocation(request.getParameter("Location")));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getAllItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("itemAll", ZigboService.getAllItem());
			//url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			ZigboService.deleteItem(Integer.parseInt(request.getParameter("ItemCode")));
			//url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void addInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		int sellingCode = Integer.parseInt(request.getParameter("SellingCode"));
		InterestDTO interest = new InterestDTO(memberCode, sellingCode);
		
		try{
			boolean result = ZigboService.addInterest(interest);
			if(result){
				request.setAttribute("interest", interest);
				request.setAttribute("successMsg", "찜 등록 완료");
				//url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		int sellingCode = Integer.parseInt(request.getParameter("SellingCode"));
		InterestDTO interest = new InterestDTO(memberCode, sellingCode);
		try {
			request.setAttribute("interest", ZigboService.getInterest(interest));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getInterestOfSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("interest", ZigboService.getInterestOfSelling(Integer.parseInt(request.getParameter("SellingCode"))));
			//url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void deleteInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		int sellingCode = Integer.parseInt(request.getParameter("SellingCode"));
		
		try {
			ZigboService.deleteInterest(memberCode, sellingCode);
			//url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
