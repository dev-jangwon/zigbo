<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="zigbo.model.dto.RequestDTO" %>

<% String url = application.getContextPath() + "/"; %>

<c:forEach var ="item" items = "${requestScope.requestItems}" varStatus="status">
<li>
	<div class="row item-row">
		<div class="zigbbo-list-image-row col-md-4">
			<a class="thumb" href="">
				<img src="../img/profile.png" alt="not found image" onerror="" 
				href='<%=url%>request?command=requestDetail&requestCode=${requestScope.requestList[status.index].requestCode}'>
			</a>
		</div>
		<div class="col-md-8">
			<div class="row">
				<div class="col-md-8">
					<div>
						<div class="zigbbo-list-title">${item.title}</div>
						<div class="zigbbo-list-loc">${item.location}</div>
						<div class="zigbbo-list-desc">
							${item.detail}
						</div>
						<c:choose>
							<c:when test="${requestScope.requestList[status.index].progress=='W'}">
								<span class="label label-primary">대기</span>
							</c:when>
							<c:when test="${requestScope.requestList[status.index].progress=='D'}">
								<span class="label label-success">완료</span>
							</c:when>
							<c:otherwise>
								<span class="label label-info">진행</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div>
					</div>	
				</div>
				<div class="col-md-4">
					<div class="zigbbo-list-member">
					${requestScope.requestList[status.index].email}
					</div>
					<div class="zigbbo-list-price"><i class="fa fa-krw"></i>&nbsp;${item.price}</div>	
				</div>
			</div>
		</div>
	</div>
</li>
</c:forEach>