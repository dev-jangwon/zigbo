<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="/zigbo/assets/paper_img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<title>직구뽀개기</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    
    <link href="/zigbo/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/zigbo/assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="/zigbo/assets/css/demo.css" rel="stylesheet" />
     <link href="/zigbo/assets/css/zigbo.css" rel="stylesheet" />
        
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="/zigbo/index.jsp">ZigBBo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav pull-right">
					<c:choose>
						<c:when test="${sessionScope.login!=null}">
						<li class="active">
							<a href="/zigbo/index.jsp" onclick="logoutFtn()">로그아웃</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="active">
							<a href="/zigbo/login.jsp">로그인</a>
						</li>
						</c:otherwise>
					</c:choose>
					<li>
						<a href="/zigbo/sales/sales_list.jsp">판매</a>
					</li>
					<li>
						<a href="/zigbo/request/request_list.jsp">요청</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">내 정보 <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right" style="transform: translate3d(0px, 40px, 0px);">
							<li><a href="/zigbo/mypage.jsp">내 정보</a></li>
						</ul>
					 </li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	<div class="wrapper">
		<div class="sales-write-main">
			<div class="section section-white section-with-space">
	            <div class="container tim-container">
					<div id="buttons">
	                    <div class="tim-title" style="text-align:center;">
	                        <h3>요청 상세보기<br>
	                            <!--  <small>요청 등록할 상품의 정보를 입력해주세요 </small> -->
	                        </h3>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-8 col-md-offset-2">
		                        	<div class="form-group">
		                        		<c:choose>
										<c:when test="${requestScope.request.progress=='W'}">
											<span class="label label-primary" style="float:right;font-size:15px;">대기중</span>
										</c:when>
										<c:when test="${requestScope.request.progress=='D'}">
											<span class="label label-success" style="float:right;font-size:15px;">완료</span>
										</c:when>
										<c:otherwise>
											<span class="label label-info" style="float:right;font-size:15px;">진행중</span>
										</c:otherwise>
									</c:choose>
			                        	<div class="row" style="margin-bottom:20px;margin-top:20px;">
				                        		<div class="col-md-2">
				                        			<h4 style="margin:0px;padding-top:5px;">요청자</h4>
				                        		</div>
				                        		<div class="col-md-10">
				                        			<div class="row" style="margin-bottom:0px;">
				                        				<div class="col-md-4">
				                        					<img src="/zigbo/img/profile.png" alt="Circle Image" class="img-circle img-no-padding img-responsive">
				                        				</div>
				                        				<div class="col-md-8">
				                        					<div style="margin:20px;">이메일
				                        						<span style="padding-left:40px;">
				                        						${requestScope.member.email}
				                        						</span>
				                        					</div>
				                        					<div style="margin:20px;">등&nbsp;록
				                        						<span style="padding-left:50px;">
				                        							<span class="label label-default">5</span>
				                        						</span>
				                        					</div>
				                        					<div style="margin:20px;">완&nbsp;료
				                        						<span style="padding-left:50px;">
				                        							<span class="label label-success">0</span>
				                        						</span>
				                        					</div>
				                        					<div style="margin:20px;">별&nbsp;점
				                        						<span style="padding-left:50px;">
				                        							<i class="fa fa-star" aria-hidden="true"></i>
				                        							<i class="fa fa-star" aria-hidden="true"></i>
				                        							<i class="fa fa-star" aria-hidden="true"></i>
				                        							<i class="fa fa-star" aria-hidden="true"></i>
				                        						</span>
				                        					</div>
				                        				</div>
				                        			</div>
				                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">상품명</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<input type="text" value="${requestScope.item.title}" disabled class="form-control">		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">제품 설명</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<textarea class="form-control" rows="4" cols="50" disabled>${requestScope.item.detail}</textarea>		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">구매 가격</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<input type="text" value="${requestScope.item.price}" class="form-control" disabled>
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">이미지</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">위치</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			${requestScope.item.location}
			                        		</div>
			                        	</div>
			                        <div class="row text-center" style="margin-bottom:20px;">
			                        		<button onclick="location.href='/zigbo/request?command=supportApply&memberCode=${requestScope.member.memberCode}&requestCode=${requestScope.request.requestCode}&itemCode=${requestScope.item.itemCode}'" class="btn btn-fill btn-primary">지원</button>
			                        	</div>
			                    	</div> 
	                        </div>
	            			</div>
	           		 </div>
        			</div>
			</div>
		</div>
	</div>	
	<footer class="footer-demo section-dark">
	    <div class="container">
	        <div class="copyright center-block">
	            &copy; 2017, made with <i class="fa fa-heart heart"></i> by Zigbbo,  
	            <a href="https://github.com/dev-jangwon/zigbo">GitHub</a>
	        </div>
	    </div>
	</footer>
	<script src="/zigbo/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="/zigbo/assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="/zigbo/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	
	<!--  Plugins -->
	<script src="/zigbo/assets/js/ct-paper-checkbox.js"></script>
	<script src="/zigbo/assets/js/ct-paper-radio.js"></script>
	<script src="/zigbo/assets/js/bootstrap-select.js"></script>
	<script src="/zigbo/assets/js/bootstrap-datepicker.js"></script>
	<script src="/zigbo/assets/js/ct-paper.js"></script>  
</body>
</html>