<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>index.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link rel="stylesheet" type="text/css"
	href="./bootstrap-3.3.5-dist/css/bootstrap.css">

<script type="text/javascript" src="./jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.5-dist/js/bootstrap.js"></script>
</head>

<body>
	<!-- Top menu -->
	<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Firecode.io - Coding Interview Questions, Answers and Preparation</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="top-navbar-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="scroll-link" href="#features">Features</a></li>
					<li><a class="scroll-link" href="#testimonials">Testimonials</a></li>
                    <li><a class="scroll-link" href="#sharepads">Sharepad</a></li>
                    <li><a href="https://angel.co/firecode-io/jobs?utm_source=startup_profile_header" target="_blank">Careers</a></li>
                    <li><a href="/blog">Blog</a></li>
					<li><a class="btn btn-link-2" href="/users/sign_in">Log In</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-lg-12"></div>
			<div class="divider"></div>

			<div class="col-sm-3"></div>
			<div class="col-sm-6 custom-form-style">
				<!--h1 class="centered" style="color: black;">Firecode.io is in Private Beta. <a href="/pages/landing">Request an invite</a> to get started!</h1-->
				<p>&nbsp;</p>
				<!-- Sign in panel -->
				<form accept-charset="UTF-8" action="<%=basePath%>home/saveUser!signIn.action"
					class="new_user" id="new_user" method="post">

					<div class="form-group">
						<label class="custom-label" for="user_email">Email</label> <input
							autofocus="autofocus" class="form-control"
							data-parsley-required="" data-parsley-trigger="blur"
							data-parsley-type="email" id="user_email" name="user.email"
							placeholder="example@gmail.com" type="email" value="" />
					</div>

					<div class="form-group">
						<label class="custom-label" for="user_password">Password</label> <input
							class="form-control" data-parsley-minlength="6"
							data-parsley-required="" data-parsley-trigger="blur"
							id="user_password" name="user.password" placeholder="Password"
							type="password" />
					</div>

					<!-- <div class="form-group">
						<div class="checkbox custom-label">
							<input name="user.remember_me" type="hidden" value="0" /><input
								id="user_remember_me" name="user.remember_me" type="checkbox"
								value="1" /> <label class="small" for="user_remember_me">Remember
								me</label>
						</div>
					</div> -->

					<div class="form-group">
						<input class="btn btn-success btn-lg btn-block" 
							type="submit" value="Sign in" />
					</div>


					<a class="small" href="/users/password/new">Forgot your
						password?</a>





				</form>
				<!-- Other services sign up -->
				<br>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<a href="/users/auth/facebook"
							onclick="mxSocialStamp(&quot;Facebook&quot;)"> <span
							class="btn btn-block btn-facebook"> <i
								class="fa fa-facebook"></i><small> Sign in with Facebook</small>
						</span>
						</a>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<a href="/users/auth/google_oauth2"
							onclick="mxSocialStamp(&quot;Google&quot;)"> <span
							class="btn btn-block btn-google-plus"> <i
								class="fa fa-google-plus"></i><small> Sign in with
									Google</small>
						</span>
						</a>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<a href="/users/auth/linkedin"
							onclick="mxSocialStamp(&quot;LinkedIn&quot;)"> <span
							class="btn btn-block btn-linkedin"> <i
								class="fa fa-linkedin"></i><small> Sign in with LinkedIn</small>
						</span>
						</a>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<a href="/users/auth/bitbucket"
							onclick="mxSocialStamp(&quot;Bitbucket&quot;)"> <span
							class="btn btn-block btn-bitbucket"> <i
								class="fa fa-bitbucket"></i><small> Sign in with
									Bitbucket</small>
						</span>
						</a>
					</div>
				</div>

			</div>
			<!-- Login panel end -->
			<div class="col-sm-3"></div>
		</div>
		<!-- Row End -->


	</div>
	<!--/ .container -->
	</div>
	<!--/ #headerwrap -->

	</div>
</body>
</html>
