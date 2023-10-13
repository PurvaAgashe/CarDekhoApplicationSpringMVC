<%@page import="com.jspiders.SpringMvc1.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%
    List<CarPOJO> cars=(List<CarPOJO>)request.getAttribute("cars");
    CarPOJO pojo=(CarPOJO)request.getAttribute("car");
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
                        <%
	                       	if (pojo == null) {
	                   	%>
                              <fieldset>
                                      <legend>Enter car id</legend>
                                      <form action="./update" method="post">
                                    <table>
                                      <tr>
                                           <td>Enter Id </td>
                                           <td> <input type="text" name="id"></td>
                                      </tr>
                                    </table>
                                            <input type="submit" value="SELECT"  >
                                      </form>
                             </fieldset>
                                       <% if(msg != null) {%>
                                     <h3><%=msg %></h3> 
                                       <%} %>
                             <%
                             if(cars !=null){
                             %>
                           <table id="data">
   <tr>
   <th>ID</th>
    <th>NAME</th>
     <th>MODEL</th>
      <th>BRAND</th>
       <th>FUEL</th>
       <th>PRICE</th>
   </tr>
  <%
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getModel()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuel()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		} 
		else {
		%>
		<fieldset>
			<legend>Update cat</legend>
			<form action="./updateCar" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><%=pojo.getId()%></td>
						<td><input type="text" name="id" value="<%=pojo.getId()%>" hidden="true"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="<%=pojo.getName()%>"></td>
					</tr>
					<tr>
						<td>MODEL</td>
						<td><input type="text" name="model"
							value="<%=pojo.getModel()%>"></td>
					</tr>
					<tr>
						<td>BRAND</td>
						<td><input type="text" name="brand"
							value="<%=pojo.getBrand()%>"></td>
					</tr>
					<tr>
						<td>FUEL</td>
						<td><input type="text" name="fuel"
							value="<%=pojo.getFuel()%>"></td>
					</tr>
					<tr>
						<td>PRICE</td>
						<td><input type="text" name="price"
							value="<%=pojo.getPrice()%>"></td>
					</tr>
				</table>
				<input type="submit" value="UPDATE">
			</form>
		</fieldset>
		<%
		}
		%>
</div>

</body>
</html>