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
	<h1 align="center">판매자 관리 페이지</h1>
	<div class="buttons-container">
		<button onclick="/productUpdate.do">수정</button>
		<button onclick="/productRemove.do">삭제</button>
	</div>
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
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>100</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>100</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>100</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>10</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>10</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>10</td>
					</tr>
					<tr>
						<td><a href="#">상품</a></td>
						<td>설명</td>
						<td>10</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>
