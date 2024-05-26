<%@ page import="entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>판매자 관리</title>
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="/views/layout/header.jsp"%>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    .buttons-container {
        text-align: right;
        margin-bottom: 10px;
    }

    .buttons-container button {
        margin: 5px;
        padding: 10px 20px;
        border: none;
        background-color: #007BFF;
        color: white;
        cursor: pointer;
        border-radius: 5px;
    }

    .buttons-container button:hover {
        background-color: #0056b3;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }
</style>
<body>
<h1 align="center">Compuer Shopping</h1>
    <div class="contatier">
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>상품</th>
                <th>상품 설명</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.productUser}" var="product">
            <tr>
                <td><a href="#">${product.name}</a></td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>
