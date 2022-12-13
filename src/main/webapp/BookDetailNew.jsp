<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="./base.css">
<link rel="stylesheet" href="./bookdetail.css">
<link rel="stylesheet" href="./bookdetailbutton.css">
<meta charset="ISO-8859-1">
	<title>User Management Application</title>
    <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
</head>

<body>
	<div class="mainbook">
           <!-- <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                    </ul>
                </nav>  
            </header> -->
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="bookrental" align="center">Book Detail</h3>

                    <div class="container text-center">

                        <a href="managebook.html" class="bookdetailbutton">Manage</a>
                        <br/>
                        <br/>
                        
                    </div>
                    
                    <div>
                    <br>
                    <table border="4" align="center" text-align="center">
                        <thead>
                            <tr>
                                <th>Book ID</th>
                                <th>Book Name</th>
                                <th>Topics</th>
                                <th>Author</th>
                                <th>Book Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <%@ page import ="java.util.ArrayList"%>
						<%@ page import ="java.util.List"%>
						<%@ page import = "java.util.Iterator"%>
						<%@ page import = "BookRental.BookBean"%>
                        <% 	
						   		ArrayList<BookBean> Rows = new ArrayList();
								
						   		Rows = (ArrayList)request.getAttribute("Rows");
						   		String userId = (String)request.getAttribute("userId");
						   		String userType = (String)request.getAttribute("userType");
						   		
						   		System.out.println("userId transferred to BookDetail success, it is: "+userId);
								System.out.println("userType transferred to BookDetail success, it is: "+userType);
						%>
						
                        <tbody>
                             <c:forEach var="book" items="${Rows}">

                                <tr>
                                    <td>
                                        <c:out value="${book.getBkid()}" />
                                    </td>
                                    <td>
                                        <c:out value="${book.getBkname()}" />
                                    </td>
                                    <td>
                                        <c:out value="${book.getBktopic()}" />
                                    </td>
                                    <td>
                                        <c:out value="${book.getBkauthor()}" />
                                    </td>
                                    <td>
                                        <c:out value="${book.getBkstatus()}" />
                                    </td>
                                    <td><a href="rent.jsp?bkid=<c:out value='${book.getBkid()}' />&userId=<c:out value='${userId}' />&userType=<c:out value='${userType}' />">Rent</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="return.jsp?id=<c:out value='${book.getBkid()}' />">Return</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    
                </div>
            </div>
           </div>
           <br/>
           <br/>
           <a href="BookRental.jsp" class="bookdetailbuttonback">Back</a>
        </body>

        </html>