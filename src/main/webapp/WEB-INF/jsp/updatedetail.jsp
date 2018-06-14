<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	
		
		
		
</head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.jsp"><span>JANUX</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> Admin
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>Account Settings</span>
								</li>
								
								<li><a href="/houtai/login.jsp"><i class="halflings-icon off"></i> Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header --><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
	
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li>
							<a class="dropmenu" href="#"><span class="hidden-tablet"> Users</span></a>
							<ul>
							    <li><a class="submenu" href="queryUser"><span class="hidden-tablet"> All Users</span></a></li>
								<li><a class="submenu" href="/houtai/insert.jsp"><span class="hidden-tablet"> Add User</span></a></li>
								<li><a class="submenu" href="/houtai/deleteuser.jsp"><span class="hidden-tablet"> Delete User</span></a></li>
								
							</ul>	
						</li>
						<li>
							<a class="dropmenu" href="#"><span class="hidden-tablet"> Products</span></a>
							<ul>
								<li><a class="submenu" href="queryProduct"><span class="hidden-tablet"> All Products</span></a></li>
								<li><a class="submenu" href="/houtai/addproduct.jsp"><span class="hidden-tablet"> Add Product</span></a></li>
								<li><a class="submenu" href="/houtai/deleteproduct.jsp"><span class="hidden-tablet"> Delete Product</span></a></li>
								
							</ul>	
						</li>
						<li>
							<a class="dropmenu" href="#"><span class="hidden-tablet"> Orders</span></a>
							<ul>
								<li><a class="submenu" href="queryOrder"><span class="hidden-tablet"> All Orders</span></a></li>
								<li><a class="submenu" href="/houtai/userorder.jsp"><span class="hidden-tablet"> Add Order</span></a></li>
								<li><a class="submenu" href="/houtai/deleteorder.jsp"><span class="hidden-tablet"> Delete Order</span></a></li>
								
							</ul>		
						</li>
					
					</ul>
				</div>
			</div>
			<!-- end: Main Menu -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			<ul class="breadcrumb">
				<li>
					<a href="#">Home</a> 
				</li>
			</ul>
			


			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>update detail</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					 <c:forEach items="${orderitemList}" var="t">
					<div class="box-content">
						<form class="form-horizontal" action="./updatedetail" method="post">
							<fieldset>
							<div class="control-group warning">
								<label class="control-label" for="inputWarning">详情Id</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="orderitemId" value="<c:out value="${t.orderitemId}"></c:out>">
								</div>
							  </div>
							<div class="control-group warning">
								<label class="control-label" for="inputWarning">订单Id</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="orderId" value="<c:out value="${t.orderId}"></c:out>">
								</div>
							  </div>
							  <div class="control-group warning">
								<label class="control-label" for="inputWarning">商品Id</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="productId" value="<c:out value="${t.productId}"></c:out>">
								</div>
							  </div>
							  <div class="control-group warning">
								<label class="control-label" for="inputWarning">商品名称</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="productName" value="<c:out value="${t.productName}"></c:out>">
								</div>
							  </div>
							  <div class="control-group warning">
								<label class="control-label" for="inputWarning">尺寸</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="size" value="<c:out value="${t.size}"></c:out>">
								</div>
							  </div>
							  <div class="control-group warning">
								<label class="control-label" for="inputWarning">数量</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="count" value="<c:out value="${t.count}"></c:out>">
								</div>
							  </div>
							  <div class="control-group warning">
								<label class="control-label" for="inputWarning">单价</label>
								<div class="controls">
								  <input type="text" id="inputWarning"name="price" value="<c:out value="${t.price}"></c:out>">
								</div>
							  </div>
							  <div class="form-actions">
								<button type="submit" class="btn btn-primary">Update One</button>
								
							  </div>
							</fieldset>
						  </form>
					
					</div>
					 </c:forEach> 
				</div><!--/span-->
			
    

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2013 <a href="downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="js/jquery.ui.touch-punch.js"></script>
	
		<script src="js/modernizr.js"></script>
	
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/jquery.cookie.js"></script>
	
		<script src='js/fullcalendar.min.js'></script>
	
		<script src='js/jquery.dataTables.min.js'></script>

		<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	
		<script src="js/jquery.chosen.min.js"></script>
	
		<script src="js/jquery.uniform.min.js"></script>
		
		<script src="js/jquery.cleditor.min.js"></script>
	
		<script src="js/jquery.noty.js"></script>
	
		<script src="js/jquery.elfinder.min.js"></script>
	
		<script src="js/jquery.raty.min.js"></script>
	
		<script src="js/jquery.iphone.toggle.js"></script>
	
		<script src="js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="js/jquery.gritter.min.js"></script>
	
		<script src="js/jquery.imagesloaded.js"></script>
	
		<script src="js/jquery.masonry.min.js"></script>
	
		<script src="js/jquery.knob.modified.js"></script>
	
		<script src="js/jquery.sparkline.min.js"></script>
	
		<script src="js/counter.js"></script>
	
		<script src="js/retina.js"></script>

		<script src="js/custom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>