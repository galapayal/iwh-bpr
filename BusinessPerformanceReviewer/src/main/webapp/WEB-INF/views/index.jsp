
<%@page import="java.io.Console"%>
<%@ page import="com.iwh.bpr.model.CompanyInfo"%>
<%@ page import="com.iwh.bpr.utilities.AppConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/styles.css">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="resources/js/lib/jquery-2.1.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/style.css">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/bprIcon.png">

<!-- end dashboard links -->

<script src="<%=request.getContextPath()%>/resources/js/lib/angular.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/lib/angular-route.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bprApp.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/authentcation.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/financeController.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/financeAnalysisController.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/compAnalysisController.js"></script>




<!-- Scripts -->

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>

<script src="resources/assets/js/main.js"></script>
<!--  Chart js -->
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>


<title>BPR</title>

</head>

<%
	CompanyInfo companyInfo = (CompanyInfo) request.getSession()
			.getAttribute(String.valueOf(AppConstants.USER));
	
	Gson gson = new Gson();
	String companyInfoJson = gson.toJson(companyInfo);
%>



<body ng-app="bprApp">

	<div ng-controller="authenticationController">
	<script>
			var jsUserData =<%=companyInfoJson%>;	
			
		</script>
		
		<ng-view></ng-view>
	</div>
	

</body>



</html>
