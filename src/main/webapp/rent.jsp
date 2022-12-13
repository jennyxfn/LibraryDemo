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
    <form class="form3" method="post" action="BookRentalServlet">
    	<input class="unbook" type="datetime-local" name="returndate" value="2022-12-12T00:00" align="center" placeholder="Return Date">
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