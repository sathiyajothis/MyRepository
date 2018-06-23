<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Register page</title>

<script>
window.alert("Hi user!!!   You should Register first");
</script>

</head>
<body>
<form action="AdminRegServlet" method="post">
Emp ID : <input type="text" name="empid"><br>
Emp Name : <input type="text" name="empname"><br>
Department : <input type="text" name="dept"><br>
Date Of Join : <input type="date" name="doj"><br>
Password : <input type="password" name="pass"><br>

<input type="submit" value="Add User">
</form>
</body>
</html>