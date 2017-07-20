package zigbo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import zigbo.model.ItemDAO;
import zigbo.model.ZigboService;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.MemberDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.RequestDTO;
import zigbo.model.dto.SellingDTO;
import zigbo.model.dto.SellingMemberDTO;

public class SellingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
			} else if( command.equals("sellingPurchase")){
				sellingPurchase(request, response);
			} else if (command.equals("getMySelling")) {
				getMySelling(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void sellingPurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int sellingCode = Integer.parseInt(request.getParameter("sellingCode"));
		HttpSession session = request.getSession();
		try {
			int buyerCode = (int)session.getAttribute("login");
			MemberDTO buyer = ZigboService.getMemberByMemberCode(buyerCode);
			SellingDTO selling = ZigboService.getSelling(sellingCode);
			int itemCode = selling.getItemCode();
			ItemDTO item = ZigboService.getItem(itemCode);
			
			request.setAttribute("buyer", buyer);
			request.setAttribute("selling", selling);
			request.setAttribute("item", item);
			
			url = "/sales/purchase.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void addSelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "./sales/sales_write.jsp";
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String location = request.getParameter("location");
		String picture = request.getParameter("picture");
		
		if (title == null || title.length() == 0 || detail == null || detail.length() == 0
				|| price == null || price.length() == 0 || location == null || location.length() == 0
				|| picture == null || picture.length() == 0) {
			session.setAttribute("errInfo", "모든 정보를 입력해주세요");
			response.sendRedirect(url);
			return;
		}
		
		ItemDTO item = new ItemDTO(title, price, detail, location, picture);
		int itemCode = 0;
		try{
			if(!ZigboService.addItem(item)){
				return;
			}
			itemCode = ItemDAO.getItemCode(title,detail,location);
		}catch(Exception s){
			session.setAttribute("errorMsg", s.getMessage());
		}

		int memberCode = (int)session.getAttribute("login");
		SellingDTO selling = new SellingDTO(memberCode, itemCode, location);
		
		try{
			boolean result = ZigboService.addSelling(selling);
			if(result){
				session.setAttribute("sucSales", "판매 등록 완료");
				url = "./sales/sales_list.jsp";
			}else{
				session.setAttribute("errRetry", "다시 시도하세요");
			}
		}catch(Exception s){
			session.setAttribute("errorMsg", s.getMessage());
		}
		response.sendRedirect(url);
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
		request.setCharacterEncoding("UTF-8");
		String url = "/sales/purchase.jsp";
		System.out.println("addPayment옴");
		int sellingCode = Integer.parseInt(request.getParameter("sellingCode"));
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		String address = (String)request.getParameter("Address");
	
		PaymentDTO payment = new PaymentDTO(sellingCode, memberCode, address);
		HttpSession session = request.getSession();
		try{
			boolean result = ZigboService.addPayment(payment);
			if(result){
				session.setAttribute("sucPurchase", "결제 완료");
				response.sendRedirect("/zigbo/sales/sales_list.jsp");
				return;
			}else{
				session.setAttribute("errRetry", "다시 시도하세요");
			}
		}catch(Exception s){
			session.setAttribute("errorMsg", s.getMessage());
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
	
	public void getMySelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	PrintWriter writer = response.getWriter();
	   	int memberCode = (Integer)request.getSession().getAttribute("login");
	   	
	   	JSONArray jsonList = new JSONArray();

	   	try {
			ArrayList<SellingDTO> sellingList = ZigboService.getSellingofMember(1);
			JSONObject jsonOb = new JSONObject();
			String stringList = new Gson().toJson(sellingList);
		    jsonOb.put("sellingList", stringList);
		    jsonList.add(jsonOb);
		} catch (Exception e) {
			e.printStackTrace();
		}

	    writer.print(jsonList);
   }
}
