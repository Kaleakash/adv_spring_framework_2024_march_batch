<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Product Details</h2>
<table border="1">
<tr>
		<th>PId</th>
		<th>PName</th>
		<th>Price</th>
</tr>
<%
Object obj = request.getAttribute("products");
List<Product> listOfProduct = (List<Product>)obj;
Iterator<Product> li = listOfProduct.iterator();
while(li.hasNext()){
	Product p = li.next();
	%>
	<tr>
		<td> <%=p.getPid() %></td>
		<td> <%=p.getPname() %></td>
		<td> <%=p.getPrice() %></td>
	</tr>
	<%
}
%>
</table>
<br/>
<a href="index.jsp">Back</a>

</body>
</html>