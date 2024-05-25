<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gntod
  Date: 2024-05-25
  Time: 오후 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문 목록</title>
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>
<h1>
    Order List
</h1>
<table>
    <thead>
    <tr>
        <th>Order ID</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Ordered Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="{orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.product.name}</td>
            <td>${order.quantity}</td>
            <td>${order.orderedDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
