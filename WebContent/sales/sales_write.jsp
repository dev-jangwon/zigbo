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
			<div class="navbar-header">
				<a class="navbar-brand" href="/zigbo/index.jsp">ZigBBo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav pull-right">
				<c:if test="${errorMsg!=null}">
					<script type="text/javascript">
                    	var errMsg = "<%=session.getAttribute("errorMsg").toString()%>";
                    	alert(errMsg);
                    	<%session.setAttribute("errorMsg",null);%>
                    </script>
                </c:if>
                <c:if test="${errInfo!=null}">
					<script type="text/javascript">
                    	var errInfo = "<%=session.getAttribute("errInfo").toString()%>";
                    	alert(errInfo);
                    	<%session.setAttribute("errInfo",null);%>
                    </script>
                </c:if>
                <c:if test="${errRetry!=null}">
					<script type="text/javascript">
                    	var errRetry = "<%=session.getAttribute("errRetry").toString()%>";
                    	alert(errRetry);
                    	<%session.setAttribute("errRetry",null);%>
                    </script>
                </c:if>
					<li class="active">
						<a href="/zigbo/index.jsp" onclick="logoutFtn()">로그아웃</a>
					</li>
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
					<div id="buttons">
	                    <div class="tim-title" style="text-align:center;">
	                        <h3>판매 등록 <br>
	                            <small>판매 등록할 상품의 정보를 입력해주세요 </small>
	                        </h3>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-8 col-md-offset-2">
		                        	<div class="form-group">
		                        	<form action="/zigbo/selling" method="get">
		                        	<input type="hidden" name="command" value="addSelling">
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">상품명</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<input type="text" value="" placeholder="상품명 또는 판매 제목을 입력하세요" class="form-control" name="title">		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">제품 설명</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<textarea class="form-control" rows="4" cols="50" placeholder="상품에 대한 상세 설명을 해주세요" name="detail"></textarea>		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">판매 가격</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<input type="text" value="" placeholder="판매 가격을 입력해주세요" class="form-control" name="price">
			                        		</div>
			                        	</div>
			                        		<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-3">
			                        			<h4 style="margin:0px;padding-top:5px;">판매 지역</h4>
			                        		</div>
			                        		<div class="col-md-9">
			                        			<input type="text" value="" placeholder="판매 지역을 입력해주세요" class="form-control" name="location">
			                        		</div>
			                        	</div>	
			                        	<div class="row text-center" style="margin-bottom:20px;">
			                        			<button href="./sales/sales_list.jsp" class="btn btn-fill btn-primary" type="submit">등록</button>
			                        	</div>
			                    	</form>
			                    	</div>
	                        </div>
	            			</div>
	           		 </div>
        			</div>
			</div>
		</div>
	</div>	
	<footer class="footer-demo section-dark" style="bottom:0px;position:absolute;width:100%;">
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
	<script type="text/javascript">
		function logoutFtn() {
				$.ajax({
					url: "/zigbo/member",
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
</html>