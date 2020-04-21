<%--
  Created by IntelliJ IDEA.
  User: Tiunchik
  Date: 20.04.2020
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Accident List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Main accident table</h1>
    <p></p>
</div>

<div class="container">
    <table class="table table-striped">
        <thead>
        <col width="10%">
        <col width="20%">
        <col width="50%">
        <col width="20%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Place</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="accidents" scope="request" type="java.util.List"/>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>${accident.id}</td>
                <td>${accident.name}</td>
                <td>${accident.text}</td>
                <td>${accident.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

