<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.11.2018
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Customer Manager</h1>
    </div>
</div>
<div id="container">
    <h3>SAVING CUSTOMER</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <form:hidden path="id"/>
        <label>Name: </label><form:input path="name"></form:input><br>
        <label>Last name: </label><form:input path="lastName"></form:input><br>
        <label>Email: </label><form:input path="email"></form:input><br>
        <input type="submit" value="save" class="save">
        <input type="button" value="cancel" class="save" onclick="window.location.href='/customer/list'; return false;">
    </form:form>
</div>


</body>
</html>
