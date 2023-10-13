<%@page import="com.jspiders.SpringMvc1.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%
    List<CarPOJO> cars =(List<CarPOJO>)request.getAttribute("cars");
    String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
    </style>
</head>
<body>
<div align="center">
                        <fieldset>
                        <legend>Remove Car details</legend>
                        <form action="./remove" method="post">
                        <table>
                            <tr>
                            <td>  Enter the ID   </td>
                            <td><input type="text" name="id">     </td>
                            </tr>
                        </table>
                        <input type="submit" value="REMOVE">
                        </form>
                        </fieldset>
                        <%
                        if(msg!=null){
                        %>
                        <h3><%=msg%></h3>
                        <%} %>
                        <% 
                        if(cars!=null){
                        	%>
                        	<table id="data">
                        	<tr>
                        	<th>Id</th>
                        	<th>NAME</th>
                        	<th>MODEL</th>
                        	<th>BRAND</th>
                        	<th>FUEL</th>
                        	<th>PRICE</th>
                        	</tr>
                        	<% 
                        	for (CarPOJO pojo : cars){
                        	%>
                        	<tr>
                        	<td><%=pojo.getId()%></td>
                        	<td><%=pojo.getName() %></td>
                        	<td><%=pojo.getModel()%></td>
				            <td><%=pojo.getBrand()%></td>
				            <td><%=pojo.getFuel()%></td>
				            <td><%=pojo.getPrice()%></td>
                        	</tr>
                        	<%} %>
                        	</table>
                        <%} %>
                        </div>

</body>
</html>