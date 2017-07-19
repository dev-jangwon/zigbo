<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>

<c:forEach var ="item" items = "${requestScope.recentSellingItems}"> 
 		<div class="col-sm-4 col-md-3">
			<div class="thumbnail">
				<img src="img/profile.png" alt="" style="width:252.5px;height:252.5px;">
					<div class="caption">
						<h3>${item.title}</h3>
							<p>${item.detail }</p>
							<p>
								<a href='<%=url%>selling?command=sellingDetail&itemCode=${item.itemCode}' class="btn btn-primary" role="button">${item.price}</a>
								<a href='<%=url%>selling?command=sellingDetail&itemCode=${item.itemCode}' class="btn btn-default" role="button">상세보기</a>
							</p>
		      		</div>
		     </div>
		</div>
</c:forEach> 
 	
