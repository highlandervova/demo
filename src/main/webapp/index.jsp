<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello World!</h1>
<br/>
<a href="helloServlet?param1=23">Hello Servlet</a>
<form action="/demo_war_exploded/helloServlet" method="POST">
    <input type="hidden" value="23" name="param1">
    <input type="submit" value="POST same">
</form>
<br/>
<form action="/demo_war_exploded/auth" method="GET">
    <input type="submit" value="Authenticate">
</form>
<br/>
<form action="/demo_war_exploded/reg" method="GET">
    <input type="submit" value="Register">
</form>
<br/>
<form action="/demo_war_exploded/main" method="GET">
    <input type="submit" value="To Main Page">
</form>
</body>
</html>