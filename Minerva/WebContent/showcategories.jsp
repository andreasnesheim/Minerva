<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Enkel testklasse med metoder for å hente ut data om kategorier og subkategorier fra databasen via Hibernate -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<%@ page import="Connection.CategoryCon"%>
	<%@ page import="tables.MainCategory"%>
	<%@ page import="tables.SubCategory"%>
	<%@ page import="java.util.List"%>

	<table border="2">
		<%
			List<MainCategory> maincat = CategoryCon.getMainCategories();
			for (int i = 0; i < maincat.size(); i++) {
		%>

		<tr>
			<td><b><%=maincat.get(i).getName()%></b></td>
		</tr>
		<%
			List<SubCategory> subcat = CategoryCon.getSubCategories();
				for (int j = 0; j < subcat.size(); j++) {
		%>
		<tr>
			<td><%=subcat.get(j).getName()%></td>
		</tr>
		<%
			}
		}
			%>

	</table>
</body>
</html>