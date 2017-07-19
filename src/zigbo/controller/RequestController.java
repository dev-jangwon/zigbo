package zigbo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zigbo.model.ZigboService;
import zigbo.model.dto.ApplyDTO;
import zigbo.model.dto.RequestDTO;

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
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	 public void addRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "showError.jsp";
	      
	      int memberCode = Integer.parseInt(request.getParameter("MemberCode"));
	      int itemCode = Integer.parseInt(request.getParameter("ItemCode"));
	      String location = request.getParameter("Location");
	      RequestDTO myrequest = new RequestDTO(0, itemCode, memberCode, 0, "W", location);
	      
	      try{
	         boolean result = ZigboService.addRequest(myrequest);
	         if(result){
	            request.setAttribute("myrequest", myrequest);
	            request.setAttribute("successMsg", "요청 성공");
	            //url = "activistDetail.jsp";
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
	      try {
	         request.setAttribute("myrequestAll", ZigboService.getAllRequest());
	         url = "activistList.jsp";
	      }catch(Exception s){
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

}
