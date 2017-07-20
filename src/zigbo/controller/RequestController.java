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
import zigbo.model.dto.ApplyDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.MemberDTO;
import zigbo.model.dto.RequestDTO;
import zigbo.model.dto.RequestMemberDTO;

public class RequestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
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
				updateRequestProgress(request, response);
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
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	 public void addRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "showError.jsp";
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String location = request.getParameter("location");
		String picture = request.getParameter("picture");
		
		if (title == null || title.length() == 0 || detail == null || detail.length() == 0 || price == null
				|| price.length() == 0 || location == null || location.length() == 0 || picture == null
				|| picture.length() == 0) {
			request.setAttribute("errorMsg", "모든 정보를 입력해주세요");
			request.getAttribute("errorMsg");
			request.getRequestDispatcher("./request/request_write.jsp").forward(request, response);
			return;
		}
		
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

		HttpSession session = request.getSession();
		int memberCode = (int)session.getAttribute("login");
	    RequestDTO myrequest = new RequestDTO(itemCode, memberCode, location);
	      
	      try{
	         boolean result = ZigboService.addRequest(myrequest);
	         if(result){
	            request.setAttribute("myrequest", myrequest);
	            request.setAttribute("successMsg", "요청 등록 성공");
	            url = "./request/request_list.jsp";
	         }else{
	            request.setAttribute("errorMsg", "다시 시도하세요");
	         }
	      }catch(Exception s){
	         request.setAttribute("errorMsg", s.getMessage());
	      }
	      request.getRequestDispatcher(url).forward(request, response);
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
	   
	   public void updateRequestProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      try {
	         request.setAttribute("myrequest", ZigboService.updateRequestProgress(Integer.parseInt(request.getParameter("RequestCode"))));
	         //url = "activistDetail.jsp";
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
		      String url = "showError.jsp";
		      
		      int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
		      int itemCode = Integer.parseInt(request.getParameter("ItemCode"));
		      String location = request.getParameter("Location");
		      ApplyDTO apply = new ApplyDTO(0, memberCode, itemCode, location);
		      
		      try{
		         boolean result = ZigboService.addApply(apply);
		         if(result){
		            request.setAttribute("apply", apply);
		            request.setAttribute("successMsg", "완료");
		            //url = "activistDetail.jsp";
		         }else{
		            request.setAttribute("errorMsg", "다시 시도하세요");
		         }
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
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
		         url = "activistList.jsp";
		      }catch(Exception s){
		         request.setAttribute("errorMsg", s.getMessage());
		      }
		      request.getRequestDispatcher(url).forward(request, response);
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

}
