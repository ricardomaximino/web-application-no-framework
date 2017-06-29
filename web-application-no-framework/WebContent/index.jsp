<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Index page.</h1>
	<hr />
    <form action="first/form">
      Name: <input type="text" name="name" /><br />
      E-mail: <input type="text" name="email" /><br />
      Address: <input type="text" name="address" /><br />
      Birthday: 
        <input type="text" name="birthday" /><br />
      
      <input type="submit" value="send" />
    </form>
	<a href="http://localhost:8080/web-application-no-framework/ws/rest/hello"> hello </a><br/>
	<a href="http://localhost:8080/web-application-no-framework/ws/rest/param/myParam"> parameter </a><br/>
	<a href="http://localhost:8080/web-application-no-framework/ws/rest/context"> context </a><br/>
	
	<a href="http://localhost:8080/web-application-no-framework/ws/contacts"> GET contacts </a><br/>
	<a href="http://localhost:8080/web-application-no-framework/ws/contacts/1"> GET contact with id = 1 </a><br/>
</body>
</html>