<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"--%>
<html lang="no">
<head>
<title>Minerva</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="generator" content="Eclipse Juno" />
<meta name="author" content="dj,rab,bhb,jaj,aan,rf" />
<link rel="shortcut icon" href="img/favicon.ico" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<%
String contentPage = request.getParameter("page");
if (contentPage == "" || contentPage == null) {
	contentPage = "home";
}
%>
</head>

<style type="text/css">
BODY {
	padding-top: 15px;
}
</style>

<body>
<div class="container"><!-- begin CONTAINER -->

	<%--	HEADER + LOGIN FIELD	--%>
	<div class="row"><!-- begin ROW -->
		<div class="span8">
			<a href="./"><img src="img/logo.png" style="width:50%;height:50%" /></a>
		</div>
		<div class="span1">
			<div class="btn-group">
				<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">
					<img alt="no" src="img/no.png" />&nbsp;Norsk&nbsp;<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a class="btn-mini" tabindex="-1" href="#"><img alt="gb" src="img/gb.png" />&nbsp;English</a></li>
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
  
	<%--	NAVIGATION	--%>
	<div class="row"><!-- begin ROW -->
    	<div class="span12">
			<div class="navbar"><div class="navbar-inner"><div class="container">
				<a class="brand" href="./">Minerva</a>
				<ul class="nav">
				 <!-- <li class="divider-vertical"></li> -->
				 <li<%if(contentPage.equals("home"))out.print(" class=\"active\"");%>>
				 	<a href="./"><i class="icon-home"></i>&nbsp;Hjem</a>
				 </li>
				 <!-- <li class="divider-vertical"></li> -->
				 <li<%if(contentPage.equals("categories"))out.print(" class=\"active\"");%>>
				 	<a href="?page=categories"><i class="icon-star"></i>&nbsp;Emner</a>
				 </li>
				 <!-- <li class="divider-vertical"></li> -->
				 <li<%if(contentPage.equals("news"))out.print(" class=\"active\"");%>>
				 	<a href="?page=news"><i class="icon-list-alt"></i>&nbsp;Nyheter</a>
				 </li>
				 <!-- <li class="divider-vertical"></li> -->
				 <li<%if(contentPage.equals("info"))out.print(" class=\"active\"");%>>
				 	<a href="?page=info"><i class="icon-asterisk"></i>&nbsp;Informasjon</a>
				 </li>
				</ul>
				
				<%-- SEARCH FORM --%>
				<% if (!contentPage.equals("search")) { %>
				<form action="search" class="form-search navbar-search pull-right" method="post">
					<div class="input-append">
						<input type="text" name="searchQuery" class="input-medium search-query"
							placeholder="S&oslash;k" />
						<button type="submit" class="btn"><i class="icon-search"></i></button>
					</div>
				</form>	
				<% } %>
			</div></div></div>
    	</div>
  </div><!-- end ROW -->
  
<%	/* Include PAGE CONTENT files
	(also experiments with different types of include conventions) */
	
	//	Home page
	if (contentPage.equals("home")) {%>
		<%@ include file="home.jsp" %>
<%	}

	//	Categories
	else if (contentPage.equals("categories")) {%>
		<%@ include file="categories.jsp" %>
<%	}
	
	//	News
 	else if (contentPage.equals("news")) {%>
		<%@ include file="news.jsp" %>
<%	}
	
	//	Search
	else if (contentPage.equals("search")) {%>
		<jsp:include page="search.jsp"></jsp:include>
<%	}
	
	//	Information
 	else if (contentPage.equals("info")) {%>
		<jsp:include page="info.jsp" />
<%	}
	
 	//	Subcategories
	else if (contentPage.equals("subcategory")) {%>
		<jsp:include page="subcategory.jsp" />
<%	}
	
 	// Topics
	else if (contentPage.equals("topic")) {%>
		<%@ include file="topic.jsp" %>
<%	}
 	
 	// View profile
 	else if (contentPage.equals("viewprofile")) {%>
		<%@ include file="viewprofile.jsp" %>
<%	}
 	
 	//	Edit profile
 	else if (contentPage.equals("editprofile")) {%>
		<%@ include file="editprofile.jsp" %>
<%	}	
 	
 	// Add (sub)topic
 	else if (contentPage.equals("addtopic")) {%>
		<%@ include file="addtopic.jsp" %>	
<%	}
 	
 	//	Error message
 	else if (contentPage.equals("error")) {%>
		<%@ include file="error.jsp" %>	
<%	}

 	else {%>
 		<%@ include file="home.jsp" %>
 	<% } %>


</div><!-- end CONTAINER -->

<%-- Include javascript files at bottom to load page faster --%>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>
