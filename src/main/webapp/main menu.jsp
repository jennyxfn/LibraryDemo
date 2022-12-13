<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="./base.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<title>Main Menu</title>
</head>

<body>
  <div class="main">
    <br/>
    <a href="Login2.jsp" class="logout">log out</a>
    <p class="sign" align="center">Menu</p>
    <form class="form1">
    <%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import = "java.util.Iterator"%>
	<%@ page import = "Login.LoginBean"%>
    <%
    	
    	LoginBean loginBean = (LoginBean)request.getAttribute("loginBean");
    	
    %>
    	
    
    <div class="button-center">
    	<%session.setAttribute("loginBean", loginBean); %>
    	
        <button class="submitmenu" formaction = "BookRental.jsp" align="center">Online Book Rental</button>
        
        <br/>
        <br/>
        <br/>
        <button class="submitmenu" align="center">Trending Events</button>
        <br/>
        <br/>
        <br/>
        <button class="submitmenu" align="center">Book Study Room</button>
    </div>
                
    </div>
     
</body>

</html>