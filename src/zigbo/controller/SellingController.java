package zigbo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zigbo.model.ItemDAO;
import zigbo.model.ZigboService;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.MemberDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.SellingDTO;
import zigbo.model.dto.SellingMemberDTO;

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
				getMostRecent(request, response);
			}else if(command.equals("getMostInterest")){
				getMostInterest(request, response);
			}else if(command.equals("addPayment")){
				addPayment(request, response);
			}else if(command.equals("getPaymentofMember")){
				getPaymentofMember(request, response);
			} else if (command.equals("sellingDetail")) {
				sellingDetail(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String location = request.getParameter("location");
		String picture = request.getParameter("picture");
		//itemCode가져옴
		ItemDTO item = new ItemDTO(title, price, detail, location, picture);
		int itemCode = 0;
		try{
			if(!ZigboService.addItem(item)){
				//item 추가가 되지 않음
				return;
			}
			itemCode = ItemDAO.getItemCode(title,detail,location);
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		
		//memberCode가져옴
		HttpSession session = request.getSession();
		int memberCode = (int)session.getAttribute("login");
		
		SellingDTO selling = new SellingDTO(memberCode, itemCode, location);
		
		try{
			boolean result = ZigboService.addSelling(selling);
			if(result){
				System.out.println("addSelling됨");
				request.setAttribute("successMsg", "가입 완료");
				url = "./sales/sales_list.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
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
		ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
		
		try {
			ArrayList<SellingMemberDTO> list = ZigboService.getAllSellingMember();
			
			for (int i = 0; i < list.size(); i++) {
				int itemCode = list.get(i).getItemCode();
				ret.add(ZigboService.getItem(itemCode));
			}

			request.setAttribute("sellingList", list);
			request.setAttribute("sellingItems", ret);
			url = "./sales/sales_list_item.jsp";
		}catch(Exception s){
			s.printStackTrace();
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

		ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
		try {
			ArrayList<SellingDTO> list = ZigboService.getMostViews();
			request.setAttribute("sellingList", list);
			for (int i = 0; i < list.size(); i++) {
				int itemCode = list.get(i).getItemCode();
				ret.add(ZigboService.getItem(itemCode));
			}

			request.setAttribute("recentSellingItems", ret);
			url = "selling_index_item.jsp";
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMostRecent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
		try {
			ArrayList<SellingDTO> list = ZigboService.getMostRecent();
			
			for (int i = 0; i < list.size(); i++) {
				int itemCode = list.get(i).getItemCode();
				ret.add(ZigboService.getItem(itemCode));
			}

			request.setAttribute("sellingList", list);
			request.setAttribute("recentSellingItems", ret);
			url = "selling_index_item.jsp";
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getMostInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
		try {
			ArrayList<SellingDTO> list = ZigboService.getMostInterest();
			request.setAttribute("sellingList", list);
			for (int i = 0; i < list.size(); i++) {
				int itemCode = list.get(i).getItemCode();
				ret.add(ZigboService.getItem(itemCode));
			}

			request.setAttribute("recentSellingItems", ret);
			url = "index_item.jsp";
		}catch(Exception s){
			s.printStackTrace();
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
	
	public void sellingDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		int sellingCode = Integer.parseInt(request.getParameter("sellingCode"));
		
		ItemDTO item = new ItemDTO();
		MemberDTO member = new MemberDTO();
		SellingDTO selling = new SellingDTO();
		
		try {
			selling = ZigboService.getSelling(sellingCode);
			member = ZigboService.getMemberByMemberCode(selling.getMemberCode());
			item = ZigboService.getItem(selling.getItemCode());
			
			request.setAttribute("selling", selling);
			request.setAttribute("member", member);
			request.setAttribute("item", item);
			url = "./sales/sales_detail.jsp";
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
