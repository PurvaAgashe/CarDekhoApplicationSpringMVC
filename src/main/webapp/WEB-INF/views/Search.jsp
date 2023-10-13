<%@page import="java.util.List"%>
<%@page import="com.jspiders.SpringMvc1.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="NavBar.jsp"></jsp:include>
    <% 
       // CarPOJO pojo=(CarPOJO)request.getAttribute("car");
    List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("car");
        String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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
<legend>Search Car Details</legend>
<form action="./search" method="post">
<table>
                                              <tr>
                                                  <td>Enter Id</td>
                                                  <td><input type="text" name="id"></td>
                                               </tr>    
                                                 <tr>
                    <td>Enter Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Enter Fuel Type</td>
                    <td><input type="text" name="fuel"></td>
                </tr>                                        
</table>
 <input type="submit" value="SEARCH"></></form>
</fieldset>
<%if(msg !=null){ %>
<h3><%=msg %></h3>
<%} %>
<%// if(pojo !=null){ %>
<% if (cars != null && !cars.isEmpty()) { %>
<table id="data">
<tr>
             <th>ID</th>
            <th>NAME</th>
          <th>MODEL</th>
          <th> BRAND</th>
          <th>FUEl</th>
         <th>PRICE</th>
           </tr>

<% for (CarPOJO car : cars) { %>
<tr>
    <td><%= car.getId() %></td>
    <td><%= car.getName() %></td>
    <td><%= car.getModel() %></td>
    <td><%= car.getBrand() %></td>
    <td><%= car.getFuel() %></td>
    <td><%= car.getPrice() %></td>
</tr>
<% } %>
</table>
<%} %>
</div>
</body>

</body>
</html>