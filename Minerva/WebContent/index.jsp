<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%--@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"--%>
<html lang="no">
<head>
<title>Project:Minerva</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="generator" content="Eclipse Juno" />
<meta name="author" content="dj" />
<link rel="shortcut icon" href="" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />


<%
String contentPage = request.getParameter("page");
if (contentPage == "" || contentPage == null) {
	contentPage = "home";
}
%>
<!--

 Script hentet fra http://twitter.github.com/bootstrap/assets/js/"navn på script".js
 Oversikt over script http://twitter.github.com/bootstrap/javascript.html 
 
 -->
		
		<script src="js/bootstrap.js"></script> 
		<script src="js/dropdown.js"></script> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script src="js/tooltip.js"></script>
		<script src="js/popover.js"></script>	
		<script src="js/collapse.js"></script>	


</head>


<style type="text/css">
BODY {
	padding-top: 15px;
}
</style>
<body>
<div class="container"><!-- begin CONTAINER -->

	<%--	Header + login field	--%>
	<div class="row"><!-- begin ROW -->
		<div class="span8">
			<a href="./"><img src="img/logo.png" style="width:50%;height:50%" /></a>
		</div>
		<div class="span1">
			<div class="btn-group">
				<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">
					<img alt="gb" src="img/gb.png" />&nbsp;<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a tabindex="-1" href="#"><img alt="no" src="img/no.png" />&nbsp;Norsk</a></li>
				
				</ul>
			</div>
		</div>
	<%  // Viser login.jsp hvis email er lagret i session, med andre ord
		// brukeren er logget inn.
		if (request.getParameter("email") != null || session.getAttribute("email") != null){%>
			<%@ include file="login.jsp" %>
 		 <% } else { %>
 		  	<%@ include file="logout.jsp" %>
 		 <%} %>
	</div><!-- end ROW -->
  
  <%--	Navigation	--%>
  <div class="row"><!-- begin ROW -->
    	<div class="span12">
			<div class="navbar nav-tabs navbar-static-top"><div class="navbar-inner">
				<ul class="nav">
				 <li<%if(contentPage.equals("home"))out.print(" class=\"active\"");%>>
				 	<a href="./"><i class="icon-home"></i>&nbsp;Hjem</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("topics"))out.print(" class=\"active\"");%>>
				 	<a href="?page=topics"><i class="icon-star"></i>&nbsp;Emner</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("news"))out.print(" class=\"active\"");%>>
				 	<a href="?page=news"><i class="icon-list-alt"></i>&nbsp;Nyheter</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("search"))out.print(" class=\"active\"");%>>
				 	<a href="?page=search"><i class="icon-search"></i>&nbsp;S&oslash;k</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("info"))out.print(" class=\"active\"");%>>
				 	<a href="?page=info"><i class="icon-asterisk"></i>&nbsp;Informasjon</a>
				 </li>
				</ul>
			</div></div>
    	</div>
  </div><!-- end ROW -->
  
<%	/* Include page content files
	(also experiments with different types of include conventions) */
	if (contentPage.equals("home")) {%>
		<%@ include file="home.jsp" %>
<%	} %>

<% 	if (contentPage.equals("topics")) {%>
		<%@ include file="topic_chooser.jsp" %>
<%	} %>
<% 	if (contentPage.equals("news")) {%>
		<%@ include file="news.jsp" %>
<%	} %>
<%	if (contentPage.equals("search")) {%>
		<jsp:include page="search.jsp"></jsp:include>
<%	} %>
<% 	if (contentPage.equals("info")) {%>
		<jsp:include page="info.jsp" />
<%	} %> 

<% 	/* subtopics*/ 
	if (contentPage.equals("chosen_webdevelopment_subtopic_html")) {%>
		<jsp:include page="chosen_webdevelopment_subtopic_html.jsp" />
<%	} %>

<% 	/* HTML leafnodes*/ 
	if (contentPage.equals("chosen_leafnode_pseudo_elements")) {%>
		<jsp:include page="chosen_leafnode_pseudo_elements.jsp" />
<%	} %>



</div><!-- end CONTAINER -->




</body>
</html>
