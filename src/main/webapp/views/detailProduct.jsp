<%@ page import="entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<style>
body {
	font-family: Arial, sans-serif;
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
<%@ include file="/views/layout/header.jsp"%>
	<h1 align="center">상품 정보</h1>
<div class="container">
	<div class="table-container">
		<table>
			<thead>
			<tr>
				<th>상품 이름</th>
				<th>상품 설명</th>
				<th>가격</th>
				<th>재고</th>
				<th>카테고리</th>
				<th>판매자</th>
			</tr>
			</thead>
			<tbody>
			<% Product product = (Product) request.getAttribute("product"); %>
			<% if (product != null) { %>
			<tr>
				<td><%= product.getName() %></td>
				<td><%= product.getDescription() %></td>
				<td><%= product.getPrice() %></td>
				<td><%= product.getStock() %></td>
				<td><%= product.getCategory().getName() %></td>
				<td><%= product.getSeller().getSellerName() %></td>
			</tr>
			<% } else { %>
			<tr>
				<td colspan="6">상품 정보가 없습니다.</td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</div>

	<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>
