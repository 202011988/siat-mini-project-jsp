<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="/views/layout/header.jsp"%>
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
	<h1 align="center">상품 정보</h1>
	<div class="contatier">
		<div class="table-container">
			<table>
				<thead>
					<tr>
						<th>상품 이름</th>
						<th>상품 설명</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>상품</td>
						<td>설명</td>
						<td>100</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>
