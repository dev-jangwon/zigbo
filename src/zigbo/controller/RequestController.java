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
import zigbo.model.dto.ApplyDTO;
import zigbo.model.dto.ApplyRequestDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.MemberDTO;
import zigbo.model.dto.RequestDTO;
import zigbo.model.dto.RequestMemberDTO;

public class RequestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		try{
			if(command.equals("addRequest")){
				addRequest(request, response);
			}else if(command.equals("getRequest")){
				getRequest(request, response);
			}else if(command.equals("getAllRequest")){
				getAllRequest(request, response);
			}else if(command.equals("updateRequestViews")){
				updateRequestViews(request, response);
			}else if(command.equals("updateRequestProgress")){
				updateRequestProgressToP(request, response);
			}else if(command.equals("updateRequestProgress")){
				updateRequestProgressToD(request, response);
			}else if(command.equals("getRequestofMember")){
				getRequestofMember(request, response);
			}else if(command.equals("addApply")){
				addApply(request, response);
			}else if(command.equals("getApply")){
				getApply(request, response);
			}else if(command.equals("getAllApply")){
				getAllApply(request, response);
			}else if(command.equals("deleteApply")){
				deleteApply(request, response);
			}else if(command.equals("getApplyofMember")){
				getApplyofMember(request, response);
			} else if(command.equals("getMostRecentRequest")) {
				getMostRecentRequest(request, response);
			} else if (command.equals("requestDetail")) {
				requestDetail(request, response);
			} else if (command.equals("getMyRequest")) {
				getMyRequest(request, response);
			} else if (command.equals("supportApply")){
				supportApply(request, response);
			} else if (command.equals("getMyApply")) {
				getMyApply(request, response);
			} else if (command.equals("getApplyMemberRequest")) {
				getApplyMemberRequest(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	 public void addRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "./request/request_write.jsp";
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String location = request.getParameter("location");
		String picture = request.getParameter("picture");
		HttpSession session = request.getSession();
		
		if (title == null || title.length() == 0 || detail == null || detail.length() == 0 || price == null
				|| price.length() == 0 || location == null || location.length() == 0 || picture == null
				|| picture.length() == 0) {
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
			session.setAttribute("errorMsg",  s.getMessage());
		}

		int memberCode = (int)session.getAttribute("login");
	    RequestDTO myrequest = new RequestDTO(itemCode, memberCode, location);
	      
	      try{
	         boolean result = ZigboService.addRequest(myrequest);
	         if(result){
	        	 session.setAttribute("sucRequest", "요청 등록 성공");
	        	 url = "./request/request_list.jsp";
	         }
	      }catch(Exception s){
	    	  session.setAttribute("errorMsg",  s.getMessage());
	      }
	      response.sendRedirect(url);
	   }

	 public void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      try {
	         request.setAttribute("myrequest", ZigboService.getRequest(Integer.parseInt(request.getParameter("RequestCode"))));
	         //url = "activistDetail.jsp";
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	   public void getAllRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String url = "showError.jsp";
			ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
			
			try {
				ArrayList<RequestMemberDTO> list = ZigboService.getAllRequestMember();
				
				for (int i = 0; i < list.size(); i++) {
					int itemCode = list.get(i).getItemCode();
					ret.add(ZigboService.getItem(itemCode));
				}
				
				request.setAttribute("requestList", list);
				request.setAttribute("requestItems", ret);
				url = "./request/request_list_item.jsp";
			}catch(Exception s){
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	   public void updateRequestViews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      try {
	         request.setAttribute("myrequest", ZigboService.updateRequestViews(Integer.parseInt(request.getParameter("RequestCode"))));
	         //url = "activistDetail.jsp";
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	   public void updateRequestProgressToP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      try {
	    	  ZigboService.updateRequestProgressToP(Integer.parseInt(request.getParameter("RequestCode")));
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	   public void updateRequestProgressToD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		    	  ZigboService.updateRequestProgressToD(Integer.parseInt(request.getParameter("RequestCode")));
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
		   }
	   
	   public void getRequestofMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		         request.setAttribute("myrequest", ZigboService.getRequestofMember(Integer.parseInt(request.getParameter("MemberCode"))));
		         //url = "activistDetail.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
	   }
	   
	   public void addApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "/zigbo/request/request_list.jsp";
		      
		      int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		      int requestCode = Integer.parseInt(request.getParameter("requestCode"));
		      String detail = request.getParameter("detail");
		      ApplyDTO apply = new ApplyDTO(requestCode, memberCode, detail);
		      HttpSession session = request.getSession();
		      try{
		    	  
		         boolean result = ZigboService.addApply(apply);
		         if(result){
		        	 if(ZigboService.updateRequestProgressToP(requestCode)){
		        		 session.setAttribute("sucApply", "지원 완료");
		        	 }
		         }else{
		        	 session.setAttribute("errorMsg", "다시 시도하세요");
		         }
		      }catch(Exception s){
		    	  session.setAttribute("errorMsg", s.getMessage());
		      }
		      response.sendRedirect(url);
		   }
		   
		   public void getApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		         request.setAttribute("apply", ZigboService.getApply(Integer.parseInt(request.getParameter("ApplyCode"))));
		         //url = "activistDetail.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
		   }
		   
		   public void getAllApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String url = "showError.jsp";
		      try {
		         request.setAttribute("applyAll", ZigboService.getAllApply());
		         url = "request_list.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
		   }
		   
		   public void supportApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   int memberCode = Integer.parseInt(request.getParameter("memberCode"));
			   int itemCode = Integer.parseInt(request.getParameter("itemCode"));
			   int requestCode = Integer.parseInt(request.getParameter("requestCode"));
			   try {
			         request.setAttribute("member", ZigboService.getMemberByMemberCode(memberCode));
			         request.setAttribute("item", ZigboService.getItem(itemCode));
			         request.setAttribute("request", ZigboService.getRequest(requestCode));
			         request.getRequestDispatcher("/request/request_support.jsp").forward(request, response);
			         return;
			      }catch(Exception s){
			         request.setAttribute("errorMsg", s.getMessage());
			         return;
			      }
			   }
		   
			public void deleteApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			      String url = "showError.jsp";
			      try {
			    	  ZigboService.deleteApply(Integer.parseInt(request.getParameter("ApplyCode")));
			         //url = "main.jsp";
			      }catch(Exception s){
			         request.setAttribute("errorMsg", s.getMessage());
			      }
			      request.getRequestDispatcher(url).forward(request, response);
			   }
		   
		   public void getApplyofMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			      String url = "showError.jsp";
			      try {
			         request.setAttribute("apply", ZigboService.getApplyofMember(Integer.parseInt(request.getParameter("MemberCode"))));
			         //url = "activistDetail.jsp";
			      }catch(Exception s){
			         request.setAttribute("errorMsg", s.getMessage());
			      }
			      request.getRequestDispatcher(url).forward(request, response);
			   }
		   
		   public void getMostRecentRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   String url = "showError.jsp";
				ArrayList<ItemDTO> ret = new ArrayList<ItemDTO>();
				try {
					ArrayList<RequestDTO> list = ZigboService.getMostRecentRequest();
					
					for (int i = 0; i < list.size(); i++) {
						int itemCode = list.get(i).getItemCode();
						ret.add(ZigboService.getItem(itemCode));
					}

					request.setAttribute("requestList", list);
					request.setAttribute("recentRequestItems", ret);
					url = "request_index_item.jsp";
				}catch(Exception s){
					s.printStackTrace();
					request.setAttribute("errorMsg", s.getMessage());
				}
				request.getRequestDispatcher(url).forward(request, response);
		   }
		   
		   public void requestDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String url = "showError.jsp";
				
				int requestCode = Integer.parseInt(request.getParameter("requestCode"));
				
				ItemDTO item = new ItemDTO();
				MemberDTO member = new MemberDTO();
				RequestDTO request1 = new RequestDTO();
				
				try {
					request1 = ZigboService.getRequest(requestCode);
					member = ZigboService.getMemberByMemberCode(request1.getMemberCode());
					item = ZigboService.getItem(request1.getItemCode());
					
					request.setAttribute("request", request1);
					request.setAttribute("member", member);
					request.setAttribute("item", item);
					url = "./request/request_detail.jsp";
				}catch(Exception s){
					s.printStackTrace();
					request.setAttribute("errorMsg", s.getMessage());
				}
				request.getRequestDispatcher(url).forward(request, response);
			}
		   
		   public void getMyRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   	PrintWriter writer = response.getWriter();
			   	int memberCode = (Integer)request.getSession().getAttribute("login");
			   	
			   	JSONArray jsonList = new JSONArray();

			   	try {
					ArrayList<RequestDTO> requestList = ZigboService.getRequestofMember(1);
					JSONObject jsonOb = new JSONObject();
					String stringList = new Gson().toJson(requestList);
				    jsonOb.put("requestList", stringList);
				    jsonList.add(jsonOb);
				} catch (Exception e) {
					e.printStackTrace();
				}

			    writer.print(jsonList);
		   }
		   
		   public void getMyApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   PrintWriter writer = response.getWriter();
			   	int memberCode = (Integer)request.getSession().getAttribute("login");
			   	
			   	JSONArray jsonList = new JSONArray();

			   	try {
					ArrayList<ApplyDTO> applyList = ZigboService.getApplyofMember(1);
					JSONObject jsonOb = new JSONObject();
					String stringList = new Gson().toJson(applyList);
				    jsonOb.put("applyList", stringList);
				    jsonList.add(jsonOb);
				} catch (Exception e) {
					e.printStackTrace();
				}

			    writer.print(jsonList);
		   }
		   
		   public void getApplyMemberRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   PrintWriter writer = response.getWriter();
			   	int memberCode = (Integer)request.getSession().getAttribute("login");
			   	
			   	JSONArray jsonList = new JSONArray();

			   	try {
					ArrayList<ApplyRequestDTO> applyList = ZigboService.getApplyMemberRequest(1);
					JSONObject jsonOb = new JSONObject();
					String stringList = new Gson().toJson(applyList);
				    jsonOb.put("applyList", stringList);
				    jsonList.add(jsonOb);
				} catch (Exception e) {
					e.printStackTrace();
				}

			    writer.print(jsonList);
		   }

}
