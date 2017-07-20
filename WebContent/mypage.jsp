<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/paper_img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<title>직구뽀개기</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="assets/css/demo.css" rel="stylesheet" />
     <link href="assets/css/zigbo.css" rel="stylesheet" />
        
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
      
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<c:if test="${successMsg!=null}">
				<script type="text/javascript">
                	var successMsg = "<%=request.getAttribute("successMsg").toString()%>";
                    alert(successMsg);
                </script>
			</c:if>
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">ZigBBo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav pull-right">
					<c:choose>
						<c:when test="${sessionScope.login!=null}">
						<li class="active">
							<a href="index.jsp" onclick="logoutFtn()">로그아웃</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="active">
							<a href="login.jsp">로그인</a>
						</li>
						</c:otherwise>
					</c:choose>
					<li><a href="./sales/sales_list.jsp">판매</a>
					</li>
					<li><a href="./request/request_list.jsp">요청</a>
					</li>
					<c:if test="${sessionScope.login!=null}">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">내 정보 <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right" style="transform: translate3d(0px, 40px, 0px);">
							<li><a href="/zigbo/mypage.jsp">내 정보 수정</a></li>
							<li><a href="/zigbo/mypage.jsp">활동 내역</a></li>
						</ul>
					 </li>
					</c:if>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	
<div class="wrapper">
    <div class="mypage-backgroud">
    		<div class="section section-white section-with-space">
            <div class="container tim-container">
            		<div class="row">
            			 <div class="col-md-8 col-md-offset-2">
            			 	<div class="nav-tabs-navigation">
							<div class="nav-tabs-wrapper">
								<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
									<li class=""><a href="#selling" data-toggle="tab" aria-expanded="false" style="font-size:1.7em;">판매</a></li>
									<li class="active"><a href="#request" data-toggle="tab" aria-expanded="true" style="font-size:1.7em;">요청</a></li>
									<li class=""><a href="#purchase" data-toggle="tab" aria-expanded="false" style="font-size:1.7em;">결제</a></li>
									<li class=""><a href="#apply" data-toggle="tab" aria-expanded="false" style="font-size:1.7em;">지원</a></li>
								</ul>
							</div>
						</div>
						<div id="my-tab-content" class="tab-content text-center">
								<div class="tab-pane" id="selling">
	                                <ul class="selling-ul" style="list-style:none;">
									</ul>
	                            </div>
	                            <div class="tab-pane active" id="request">
	                                <ul class="request-ul" style="list-style:none;">
									</ul>
	                            </div>
	                            <div class="tab-pane" id="purchase">
	                                <ul class="purchase-ul" style="list-style:none;">
									</ul>
	                            </div>
	                            <div class="tab-pane" id="apply">
	                                <ul class="apply-ul" style="list-style:none;">
									</ul>
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
</div>

	<script type="text/javascript">
		function logoutFtn() {
				$.ajax({
					url: "member",
					data: {
						command: "logout",
					},
					method: "post",
					dataType: "html",
					success: function(result) {
					}
				});
		}
	</script>
</body>

    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	
	<!--  Plugins -->
	<script src="assets/js/ct-paper-checkbox.js"></script>
	<script src="assets/js/ct-paper-radio.js"></script>
	<script src="assets/js/bootstrap-select.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/ct-paper.js"></script> 
	<script src="assets/js/mypage.js"></script>
</html>