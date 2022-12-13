<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="./base.css">
  <link rel="stylesheet" href="./bookrental1.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Online Book Rental</title>
</head>

<body>
  <div class="mainbook">
    <p class="bookrental" align="center">Online Book Rental</p>
    <%@ page import = "Login.LoginBean"%>
    <%
    LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");
    //out.print(loginBean.getUserid());
    
    %>
    <%session.setAttribute("loginBean", loginBean); %>
    <%request.setAttribute("loginBean", loginBean); %>
    <form class="form3" method="post" action="BookRental">
    	<input class="unbook" type="text" name="bkName" align="center" placeholder="Book Name">
    	<input class="unbook" type="text" name="bkAuthor" align="center" placeholder="Author">
    	<input class="unbook" type="text" name="bkTopic" align="center" placeholder="Topic">
    	<button class="submitbook" align="center">Submit</button>
    	<br/>
    	<br/>
    	
    </form>
    <form>
    
    	<button class="backbook" formaction="main menu.jsp" align="center">Back</button>
    
    </form>          
    </div>
     
</body>

</html>