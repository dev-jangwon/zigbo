<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../assets/paper_img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<title>직구뽀개기</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    
    <link href="../bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="../assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="../assets/css/demo.css" rel="stylesheet" />
     <link href="../assets/css/zigbo.css" rel="stylesheet" />
        
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
				<a class="navbar-brand" href="#">ZigBBo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav pull-right">
					<li class="active">
						<a href="#">로그인</a>
					</li>
					<li>
						<a href="#">판매</a>
					</li>
					<li>
						<a href="#">구매</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Dropdown <b class="caret"></b></a>
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
	                        <h3>판매 상세보기<br>
	                            <!--  <small>판매 등록할 상품의 정보를 입력해주세요 </small> -->
	                        </h3>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-8 col-md-offset-2">
		                        	<div class="form-group">
		                        		<span class="label label-primary" style="float:right;font-size:15px;">대기중</span>
			                        	<div class="row" style="margin-bottom:20px;margin-top:20px;">
				                        		<div class="col-md-2">
				                        			<h4 style="margin:0px;padding-top:5px;">판매자</h4>
				                        		</div>
				                        		<div class="col-md-10">
				                        			<div class="row" style="margin-bottom:0px;">
				                        				<div class="col-md-4">
				                        					<img src="../img/profile.png" alt="Circle Image" class="img-circle img-no-padding img-responsive">
				                        				</div>
				                        				<div class="col-md-8">
				                        					<div style="margin:20px;">이메일
				                        						<span style="padding-left:40px;">
				                        						bigdata@bigdata.com
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
			                        		<div class="col-md-2">
			                        			<h4 style="margin:0px;padding-top:5px;">상품명</h4>
			                        		</div>
			                        		<div class="col-md-10">
			                        			<input type="text" value="상품" disabled class="form-control">		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-2">
			                        			<h4 style="margin:0px;padding-top:5px;">제품 설명</h4>
			                        		</div>
			                        		<div class="col-md-10">
			                        			<textarea class="form-control" rows="4" cols="50" disabled>상세설명</textarea>		
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-2">
			                        			<h4 style="margin:0px;padding-top:5px;">판매 가격</h4>
			                        		</div>
			                        		<div class="col-md-10">
			                        			<input type="text" value="20000" class="form-control" disabled>
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-2">
			                        			<h4 style="margin:0px;padding-top:5px;">이미지</h4>
			                        		</div>
			                        		<div class="col-md-10">
			                        			
			                        		</div>
			                        	</div>
			                        	<div class="row" style="margin-bottom:20px;">
			                        		<div class="col-md-2">
			                        			<h4 style="margin:0px;padding-top:5px;">위치</h4>
			                        		</div>
			                        		<div class="col-md-10">
			                        		</div>
			                        	</div>
			                        <div class="row text-center" style="margin-bottom:20px;">
			                        		<button href="#" class="btn btn-fill btn-primary">구매</button>
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
	<script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="../bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	
	<!--  Plugins -->
	<script src="../assets/js/ct-paper-checkbox.js"></script>
	<script src="../assets/js/ct-paper-radio.js"></script>
	<script src="../assets/js/bootstrap-select.js"></script>
	<script src="../assets/js/bootstrap-datepicker.js"></script>
	<script src="../assets/js/ct-paper.js"></script>  
</body>
</html>