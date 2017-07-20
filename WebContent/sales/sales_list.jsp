<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="/zigbo/image/png" href="../assets/paper_img/favicon.ico">
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
					<c:if test="${sucSales!=null}">
						<script type="text/javascript">
                        	var sucSales = "<%=session.getAttribute("sucSales").toString()%>";
                            alert(sucSales);
                            <%session.setAttribute("sucSales",null);%>
                        </script>
                    </c:if>
                    <c:if test="${sucPurchase!=null}">
						<script type="text/javascript">
                        	var sucPurchase = "<%=session.getAttribute("sucPurchase").toString()%>";
                            alert(sucPurchase);
                            <%session.setAttribute("sucPurchase",null);%>
                        </script>
                    </c:if>
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
					<c:if test="${sucPurchase!=null}">
						<script type="text/javascript">
                        	var sucPurchase = "<%=session.getAttribute("sucPurchase").toString()%>";
                            alert(sucPurchase);
                            <%session.setAttribute("sucPurchase",null);%>
                        </script>
                    </c:if>
					<li>
						<a href="./sales_list.jsp">판매</a>
					</li>
					<li>
						<a href="../request/request_list.jsp">요청</a>
					</li>
					<c:if test="${sessionScope.login!=null}">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">내 정보 <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right" style="transform: translate3d(0px, 40px, 0px);">
							<li><a href="/zigbo/mypage.jsp">내 정보</a></li>
						</ul>
					 </li>
					</c:if>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	<div class="wrapper">
		<div class="sales-list-main">
			<div class="section section-white section-with-space">
	            <div class="container tim-container">
					<div class="row zigbbo-list-header">
						<div class="col-md-1">
						</div>
						<div class="col-md-2">
							<span class="list-text">판매 목록</span>
						</div>
						<div class="col-md-4">
						</div>
						<div class="col-md-3">
							<div class="input-group">
								<input type="text" placeholder="판매 검색" class="form-control">
								<span class="input-group-addon"><i class="fa fa-search"></i></span>
                        		</div>
						</div>
						<div class="col-md-2">
						</div>
					</div>
							<ul class="zigbbo-list-content zigbbo-sales-list">
							</ul>
							<div class="zigbbo-list-paging">
								<!-- <nav>
									<ul class="pagination pagination-primary">
                          				<li><a href="javascript:void(0);">«</a></li>
                          					<li><a href="javascript:void(0);">1</a></li>
                          					<li><a href="javascript:void(0);">2</a></li>
                          					<li class="active"><a href="javascript:void(0);">3</a></li>
                          					<li><a href="javascript:void(0);">4</a></li>
                          					<li><a href="javascript:void(0);">5</a></li>
                          					<li><a href="javascript:void(0);">»</a></li>
                        				</ul>
								</nav> -->
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
	<div id="floating-button" data-toggle="tooltip" data-placement="left" data-original-title="Create" onclick="location.href='../sales/sales_write.jsp'">
	    <p class="plus">+</p>
	    <img class="edit" src="https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_compose2_1x.png">
	  </div>
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
	<script src="/zigbo/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="/zigbo/assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="/zigbo/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	
	<!--  Plugins -->
	<script src="/zigbo/assets/js/ct-paper-checkbox.js"></script>
	<script src="/zigbo/assets/js/ct-paper-radio.js"></script>
	<script src="/zigbo/assets/js/bootstrap-select.js"></script>
	<script src="/zigbo/assets/js/bootstrap-datepicker.js"></script>
	<script src="/zigbo/assets/js/ct-paper.js"></script>
	<script src="/zigbo/assets/js/sales_list.js"></script>
</body>
</html>