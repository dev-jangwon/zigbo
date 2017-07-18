<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>register.jsp</title>

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
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="height:75px;">ZigBBo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
		</div><!-- /.container-fluid -->
	</nav>
	<div class="wrapper">
		<div class="login-background">
			<div class="container">
				<div class="row">
                        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                            <div class="register-card">
                                <h3 class="title">Welcome</h3>
                                <form class="register-form">
                                    <label>Email</label>
                                    <input type="text" class="form-control" placeholder="Email">

                                    <label>Password</label>
                                    <input type="password" class="form-control" placeholder="Password">
                                    
                                    <label>Phone</label>
                                    <input type="text" class="form-control" placeholder="Phone">
                                    
                                    

								<div class="dropdown">
								<label>Account</label>
									<button class="btn dropdown-toggle" type="button"
										id="dropdownMenu1" data-toggle="dropdown">
										Bank <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="dropdownMenu1">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											h>����</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											>����</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											>�ϳ�</a></li>
									</ul>
									<input type="text" class="form-control" placeholder="Account">
								</div>
								
                                    <label>Address</label>
                                    <input type="text" class="form-control" placeholder="Address">
                                    
                                    <button class="btn btn-danger btn-block">Register</button>
                                </form>
                               
                            </div>
                        </div>
                    </div>
			</div>
		</div>
	</div>


 	<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	
	<!--  Plugins -->
	<script src="assets/js/ct-paper-checkbox.js"></script>
	<script src="assets/js/ct-paper-radio.js"></script>
	<script src="assets/js/bootstrap-select.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/ct-paper.js"></script>    
	
</body>
</html>