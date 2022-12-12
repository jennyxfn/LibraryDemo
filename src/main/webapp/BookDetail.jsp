<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./base.css">
<link rel="stylesheet" href="./bookdetail.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<title>Book Detail</title>
</head>
<body>
  <div class="mainbook">
    <br/>
  	<a href="insertbook.html" class="insert"  >Insert</a>
    <p class="bookrental" align="center">Book Detail</p>
    <table border="2" align="center">
   <tr>
        <td>Book ID</td>
        <td>Book Name</td>
        <td>Topics</td>
        <td>Author</td>
        <td>Book Status</td>
   </tr>
   <tr>
   	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import = "java.util.Iterator"%>
	<%@ page import = "BookRental.BookBean"%>
   <% 	
   		ArrayList<BookBean> rows = new ArrayList();
   		rows = (ArrayList)request.getAttribute("Rows");
   		//rows = rows.get(0);
   		//rows.toArray();
   %>

   <% 
    Iterator i = rows.iterator();
    //out.print(rows.get(0).getBkid());
    //out.print(rows.get(0).getBkname());
    //out.print(rows.get(0).getBktopic());
    //out.print(rows.get(0).getBkauthor());
    //out.print(rows.get(0).getBkstatus());
   int counter = 0;
   	while(i.hasNext()){
   	    out.print("<tr><td>");
   	    out.print(rows.get(counter).getBkid());
   	    out.print("</td>");
   	    out.print("<td>");
   	    out.print(rows.get(counter).getBkname());
   	    out.print("</td>");
   	    out.print("<td>");
   	    out.print(rows.get(counter).getBktopic());
   	    out.print("</td>");
   	    out.print("<td>");
   	    out.print(rows.get(counter).getBkauthor());
   	    out.print("</td>");
   	    out.print("<td>");
   	    out.print(rows.get(counter).getBkstatus());
   	    out.print("</tr>");
   	    i.next();
   	 	counter++;
   	}
    %>
    

   </tr>
   </table>
               
  </div>

</body>
</html> 