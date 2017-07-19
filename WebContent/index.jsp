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
					<li><a href="#">판매</a>
					</li>
					<li><a href="#">구매</a>
					</li>
					<c:if test="${sessionScope.login!=null}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle"	data-toggle="dropdown" aria-expanded="false">
							Dropdown 
							<b class="caret"></b>
							</a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	
<div class="wrapper">
    <div class="demo-header">
            <div class="motto">
            		<img class="img-responsive" src="img/profile.png" alt="">
				<h1 class="title-uppercase">직구 뽀개기</h1>
				<hr class="custom-hr-white">
 				<h3>직구 뽀개기</h3>
            </div>
    </div>

    <div class="main">
    		<div class="section section-white section-with-space">
            <div class="container tim-container">
            		<div class="row">
            			<div class="class=col-lg-12 text-center sale-list-text">
            				<h2>추천 상품</h2>
            				<hr class="custom-hr-dark">
            			</div>
            		</div>
            		<div class="jb-extra-row row">
            			<div class="col-lg-9">
            			</div>
            			<div class="col-lg-3">
            				<div class="jb-extra-dropdown dropdown">
								<button class="btn dropdown-toggle" type="button" id="dropdownMenuSale" data-toggle="dropdown">
									정렬
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dropdownMenuSale">
									<li role="presentation"><a role="menuitem" tabindex="-1" onclick="getRecentSelling()">최신</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" onclick="getViewSelling()">조회수</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" onclick="getZZimSelling()">찜</a></li>
			    					</ul>
								<button class="btn btn-primary">더보기</button>
							</div>
            			</div>
            		</div>
                <div class="row" id="index_selling_list">
  					
				</div>
            </div>
        </div>
        <div class="section section-white section-with-space">
            <div class="container tim-container">
            		<div class="row">
            			<div class="class=col-lg-12 text-center sale-list-text">
            				<h2>최신 요청</h2>
            				<hr class="custom-hr-dark">
            			</div>
            		</div>
            		<div class="jb-extra-row row">
            			<div class="col-lg-11">
            			</div>
            			<div class="col-lg-1">
						<button class="btn btn-primary pull-right">더보기</button>
            			</div>
            		</div>
                <div class="row" id="index_request_list">
				</div>
            </div>
        </div>
        <div class="section section-white section-with-space">
            <div class="container tim-container text-center">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center about-text">
                        <h2>About Zigbbo</h2>
                        <p>
                        	판매: 해외에서 싸고 좋은 물건을 발견하면 직뽀에서 직접 판매자가 되어보세요.<br>
                        	요청: 해외에서 필요한 물건이 있으면 무엇이든 요청해보세요. 비싸고 오래걸리는 해외배송의 문제점을 해결했습니다.<br>
                        	수입: 오늘도 평화로운 중고OO에서 많이 당해보셨나요? 직뽀가 중간에서 안전한 거래를 보장하겠습니다.마음 놓고 거래를 통해 수수료를 받아가세요.<br>
                        </p>
                    </div>
                </div>
                <div class="row example-pages">
                    <div class="col-md-4">
                        <a href="examples/landing.html" target="_blank">
                            <img src="assets/paper_img/examples/landing.jpg" alt="Rounded Image" class="img-rounded img-responsive">
                            <h5>판매</h5>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="examples/register.html" target="_blank">
                            <img src="assets/paper_img/examples/register.jpg" alt="Rounded Image" class="img-rounded img-responsive">
                            <h5>구매</h5>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="examples/profile.html" target="_blank">
                            <img src="assets/paper_img/examples/profile.jpg" alt="Rounded Image" class="img-rounded img-responsive">
                            <h5>지원</h5>
                        </a>
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
	<%session.invalidate();
			session = null;%>
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
	<script src="assets/js/index.js"></script>   
</html>