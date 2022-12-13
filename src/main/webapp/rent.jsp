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
<title>Rent</title>
</head>
<body>
  <div class="mainbook">
    <p class="bookrental" align="center">Online Book Rental</p>
<<<<<<< HEAD
    <%
		    String bkId = request.getParameter("bkid");
    		String userId = request.getParameter("userId");
    		String userType = request.getParameter("userType");
    		
    		System.out.println("Rent.jsp received data");
    		System.out.println("BookId: "+bkId+"; UserId: "+userId+"; UserType: "+ userType);
    		
    	
		%>
    <form class="form3" method="post" action="rent">
    	<input class="unbook" type="datetime-local" name="returndate" value="2022-12-12T00:00" align="center" placeholder="Return Date">
    	
		<input type="hidden" name="bkId" value=<%=bkId%> >
    	<input type="hidden" name="userId" value=<%=userId%> >
    	<input type="hidden" name="userType" value=<%=userType%> >
    	
=======
    <form class="form3" method="post" action="BookRentalServlet">
    	<input class="unbook" type="datetime-local" name="returndate" value="2022-12-12T00:00" align="center" placeholder="Return Date">
>>>>>>> parent of de89cb1 (able to pass userid to anywhere)
    	<button class="submitbook" align="center">Submit</button>
    	<br/>
    	<br/>
    	
    </form>
    <form>
    
    	<button class="backbook" formaction="BookRental.jsp" align="center">Back</button>
    
    </form>          
    </div>
     
</body>
</html>