<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>

<head>
  <link rel="stylesheet" href="./base.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  <title>Sign in</title>
</head>

<body>
  <div class="main">
    <p class="sign" align="center">Sign in</p>
    <form class="form1" action="SignInServlet" method="post" >
      <input class="un " type="text" name = "username" align="center" placeholder="Email">
      <input class="pass" type="password" name="password" align="center" placeholder="Password">
      <select class="pass" name="usertype">
        <option value="admin">Admin</option>
        <option value="customer">Customer</option>
      </select>
      <br/>
      <button class="submit" align="center">Sign in</button>
      <br/>
      <br/>
      <br/>
      <a href="http://localhost:8081/LibraryDemo/Register.html" class="submit" align="center">Sign up</a>
      <p class="forgot" align="center"><a href="#">Forgot Password?</p>
     </form>
            
                
    </div>
     
</body>

</html>