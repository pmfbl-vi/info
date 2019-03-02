<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Code Rally Login</title>
		<link rel="stylesheet" type="text/css" href="style/login.css">
	</head>
	<body>
	<div id="container" class="container">
		<div id="top-banner">
		    <table border="0" cellspacing="0" cellpadding="0" id="banner-table">
				<tr>
					<td>
						<div id="banner-img">
							<img src="../Banner-leaderboard.jpg">
						</div>
					</td> 
				</tr>
		    </table>
		</div>
		
		<h1>Code Rally Login</h1>
		
		<%
		String x = request.getParameter("user");
		String y = request.getParameter("id");
		if(x != null && y != null){
			%>
			A response code has been sent.
			-201 indicates that the accounts has been created/ updated/ successfully logged into
			-403 indicated that the account name has already been taken
			<form action = "../LoginServlet?user=<%=x %>&id=<%=y %>" method = "POST" id = "info">
				<input type = "hidden" name = "user" id = "user" value = "<%=x %>" /> 
				<input type = "hidden" name = "id" id = "id" value = "<%=y %>" />
				<script>document.getElementById('info').submit();</script>
			</form>
			<%
		}else{%>
			
		<div id="button-holder">
		
			<form action = "../LoginServlet" method = "POST" >
			  <button name="loginType" type="submit" value="google">Login With Google</button>
  			  <button name="loginType" type="submit" value="facebook">Login With Facebook</button>
  			  <button name="loginType" type="submit" value="twitter">Login With Twitter</button>
  				<%
  				String z = request.getParameter("user");
  				%>
  				<input type = "hidden" name = "user" id = "user" value = "<%=z %>" />

			</form>
		<%}%>
			
		</div>
		</div>
	</body>
</html>