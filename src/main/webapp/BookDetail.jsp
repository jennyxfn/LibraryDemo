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
  	<a class="insert">Insert</a>
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
   <% 
   		String url = "jdbc:mysql://localhost:3306/project1";
   		String username = "root";
   		String password = "971228";
   		String sql = ("SELECT book.book_id,book_name,topics_name,authors_lname,book_status "+ 
   				      "FROM project1.book book "+
   				      "left join book_author ba "+
   				      "on book.book_id = ba.book_id "+
   				      "left join author a "+
   				      "on ba.authors_id = a.authors_id "+
   				      "left join topic t "+
   				      "on t.topics_id = book.topics_id ");
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con= DriverManager.getConnection(url,username,password);
   		Statement st = con.createStatement();
   		ResultSet rs = st.executeQuery(sql);
   		//rs.next();
   %>

   <% while(rs.next()) {
    out.print("<tr><td>");
    out.print(rs.getString(1));
    out.print("</td>");
    out.print("<td>");
    out.print(rs.getString(2));
    out.print("</td>");
    out.print("<td>");
    out.print(rs.getString(3));
    out.print("</td>");
    out.print("<td>");
    out.print(rs.getString(4));
    out.print("</td>");
    out.print("<td>");
    out.print(rs.getString(5));
    out.print("</td></tr>");}%>
    

   </tr>
   </table>
               
  </div>

</body>
</html> 