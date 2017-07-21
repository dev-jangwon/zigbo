<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../assets/paper_img/favicon.ico">
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
			<c:if test="${errorMsg!=null}">
				<script type="text/javascript">
                	var errorMsg = "<%=session.getAttribute("errorMsg").toString()%>";
                    alert(errorMsg);
                    <%session.setAttribute("errorMsg",null);%>
               	</script>
			</c:if>
			<c:if test="${errRetry!=null}">
				<script type="text/javascript">
                	var errRetry = "<%=session.getAttribute("errRetry").toString()%>";
                    alert(errRetry);
                    <%session.setAttribute("errRetry",null);%>
               	</script>
			</c:if>
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
						<a href="./sales_list.jsp">판매</a>
					</li>
					<li>
						<a href="../request/request_list.jsp">요청</a>
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
	            		<div class="alert alert-success" style="text-align:center;">
				            <b>주문 내역 확인 후 결제하여 주시기 바랍니다. 추가 할인/적립, 무료배송 혜택을 꼭 체크하세요
				            </b>
				    </div>
					<div id="buttons">
	                    <div class="tim-title" style="text-align:center;">
	                        <h3>구매하기<br>
	                            <!--  <small>판매 등록할 상품의 정보를 입력해주세요 </small> -->
	                        </h3>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-8 col-md-offset-2">
		                        	<div class="form-group">
			                        	<div class="row" style="margin-bottom:20px;margin-top:20px;">
				                        		<div class="col-md-3">
				                        			<h4 style="margin:0px;padding-top:5px;">판매 상품</h4>
				                        		</div>
				                        		<div class="col-md-9">
				                        			<input type="text" value="${requestScope.item.title}" disabled class="form-control">
				                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">배송 정보</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<div class="row" style="margin-bottom:15px;">
			                        					<div class="col-md-4">
			                        						<label class="radio">
								                            <span class="icons"><span class="first-icon fa fa-circle-o fa-base"></span><span class="second-icon fa fa-dot-circle-o fa-base"></span></span><input type="radio" name="optionsRadios" data-toggle="radio" id="optionsRadios1" value="option1">
								                            <i></i>기본 배송정보
								                        </label>
			                        					</div>
			                        					<div class="col-md-4">
			                        						<label class="radio">
								                            <span class="icons"><span class="first-icon fa fa-circle-o fa-base"></span><span class="second-icon fa fa-dot-circle-o fa-base"></span></span><input type="radio" name="optionsRadios" data-toggle="radio" id="optionsRadios1" value="option1">
								                            <i></i>새로운 배송정보
								                        </label>
			                        					</div>
			                        				</div>
			                        			<div class="row" style="margin-bottom:0px;">
			                        				<div class="col-md-2">
			                        					이메일
			                        				</div>
			                        				<div class="col-md-10">
			                        					<input type="text" value="${requestScope.buyer.email}" disabled class="form-control">
			                        				</div>
			                        			</div>
			                        			<div class="row" style="margin-bottom:0px;">
			                        				<div class="col-md-2">
			                        					휴대폰
			                        				</div>
			                        				<div class="col-md-10">
			                        					<input type="text" value="${requestScope.buyer.phone}" disabled class="form-control">
			                        				</div>
			                        			</div>
			                        			<div class="row" style="margin-bottom:0px;">
			                        				<div class="col-md-2">
			                        					주소
			                        				</div>
			                        				<div class="col-md-10">
			                        					<input type="text" value="${requestScope.buyer.address}" disabled class="form-control">
			                        				</div>
			                        			</div>
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">결제 정보</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<div class="row" style="margin-bottom:0px;">
			                        				<div class="col-md-2">
			                        					상품 금액 
			                        				</div>
			                        				<div class="col-md-10">
			                        					<input type="text" value="$ ${requestScope.item.price}" disabled class="form-control">
			                        				</div>
			                        			</div>
			                        			<div class="row" style="margin-bottom:0px;">
			                        				<div class="col-md-2">
			                        					수수료 
			                        				</div>
			                        				<div class="col-md-10">
			                        					<input type="text" value="$ ${requestScope.item.price*0.1}" disabled class="form-control">
			                        				</div>
			                        			</div>
			                        			<hr>
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">최종 결제 금액</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<div class="row" style="margin-bottom:0px;">
			                        			<div class="col-md-2">
				                        			</div>
				                        			<div class="col-md-10">
				                        				<input type="text" value="$ ${requestScope.item.price*1.1}" disabled class="form-control">
				                        			</div>
				                        		</div>
			                        		</div>
			                        		</div>
			                        	</div>
			                        <div class="row text-center" style="margin-bottom:20px;">
			                        		<button onclick="location.href='/zigbo/selling?command=addPayment&sellingCode=${requestScope.selling.sellingCode}&memberCode=${requestScope.buyer.memberCode}&Address=${requestScope.buyer.address}'" class="btn btn-fill btn-primary">결제</button>
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