<%@page import="com.jspiders.SpringMvc1.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    List<CarPOJO> cars =(List<CarPOJO>)request.getAttribute("cars");
    String msg= (String)request.getAttribute("msg");
    %>
    <jsp:include page="NavBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style>
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
</style>
</head>
<body>
<div align="center">
       <fieldset>
       <legend> Add a Car</legend>
        <form action="./add" method="post">
       <table>
                                  <tr>
                                       <td>Name:</td>
                                       <td><input type="text" name="name"></td>
                                  </tr>
                                  <tr>
                                       <td>Model:</td>
                                       <td><input type="text" name="model" ></td>
                                  </tr>
                                  <tr>
                                       <td>Brand:</td>
                                       <td><input type="text"  name="brand" ></td>
                                  </tr>
                                  <tr>
                                        <td>Fuel:</td>
                                        <td><input type="text"  name="fuel" ></td>
                                 </tr>
                                 <tr>
                                        <td>Price:</td>
                                        <td><input type="text"  name="price" ></td>
                                 </tr>
                             </table>
                              <input type="submit" value="ADD">
                       </form>
               </fieldset>
               <%
               if(msg!=null){
            	   %> 
            	   <h3><%=msg%></h3>  <% 
               }
               %>
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
                        	<td><%=pojo.getModel() %></td>
				            <td><%=pojo.getBrand()%></td>
				            <td><%=pojo.getFuel()%></td>
				            <td><%=pojo.getPrice() %></td>
                        	</tr>
                        	<%} %>
                        	</table>
                        <%} %>
               
       </div>

</body>
</html>