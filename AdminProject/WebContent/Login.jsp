<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>

<form method="post" action="AdminLogServlet">

User ID : <input type="text" name="id"><br>
Password : <input type="password" name="pass"><br><br>
<input type="submit" value="LOGIN">
<input type="reset" value="RESET"><br><br>
<a href="Register.jsp">New User</a>
</form>
</body>
</html>