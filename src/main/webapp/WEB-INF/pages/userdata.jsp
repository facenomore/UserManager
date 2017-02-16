<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>UserData</title>
    <style>
        <%@include file="style.css" %>
    </style>

</head>
<body>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<br/>
<h1>User Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Age</th>
        <th width="120">Admin</th>
        <th width="120">CreatedDate</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.admin}</td>
        <td>${user.createdDate}</td>
    </tr>
</table>
</body>
</html>