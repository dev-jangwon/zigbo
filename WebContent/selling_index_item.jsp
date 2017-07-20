<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*"%>
<%@ page import="zigbo.model.dto.SellingDTO" %>

<% String url = application.getContextPath() + "/"; %>

<c:forEach var ="item" items = "${requestScope.recentSellingItems}" varStatus="status"> 
 		<div class="col-sm-4 col-md-3">
			<div class="thumbnail">
				<img src="img/profile.png" alt="" style="width:252.5px;height:252.5px;">
					<div class="caption">
						<h3>${item.title}</h3>
							<p>${item.detail }</p>
							<p style="position:absolute;right:10%;top:64%;">조회수: ${requestScope.sellingList[status.index].views}</p>
							<p>
								<a href='<%=url%>selling?command=sellingDetail&sellingCode=${requestScope.sellingList[status.index].sellingCode}' class="btn btn-primary" role="button" style="margin-left:5px;"><i class="fa fa-krw"></i>${item.price}</a>
								<a href='<%=url%>selling?command=sellingDetail&sellingCode=${requestScope.sellingList[status.index].sellingCode}' class="btn btn-default" role="button">상세보기</a>
							</p>
		      		</div>
		     </div>
		</div>
</c:forEach> 
 	
