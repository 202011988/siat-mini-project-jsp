<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<%@ include file="./layout/header.jsp" %>

<div id="container">
	<!-- action, method -->
	<form action="/productUpdate.do" method="GET" id="productUpdateForm" onsubmit="checkData()">
		<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
			<tr>
				<td width="230" height="20">
					<p align="center"><b><span style="font-size:12pt;">제품번호</span></b></p>
				</td>
				<td width="450" height="20" align="center">
					<b>
		        		<span style="font-size:12pt;">
		        			<input type="number" name="ㅑd" size="30">
		        		</span>
					</b>
				</td>
			</tr>


			<tr>
				<td width="230" height="20">
					<p align="center"><b><span style="font-size:12pt;">가격</span></b></p>
				</td>
				<td width="450" height="20" align="center">
					<b>
		        		<span style="font-size:12pt;">
		        			<input type="number" name="productPrice" size="30">
		        		</span>
					</b>
				</td>
			</tr>


			<tr>
				<td width="230" height="20">
					<p align="center"><b><span style="font-size:12pt;">제품 설명</span></b></p>
				</td>
				<td width="450" height="20" align="center">
					<b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="description" size="30">
		        		</span>
					</b>
				</td>
			</tr>

			<tr>
				<td width="230" height="20">
					<p align="center"><b><span style="font-size:12pt;">재고현황</span></b></p>
				</td>
				<td width="450" height="20" align="center">
					<b>
		        		<span style="font-size:12pt;">
		        			<input type="number" name="stock" size="30">
		        		</span>
					</b>
				</td>
			</tr>

			<tr>
				<td width="230" height="20">
					<p align="center"><b><span style="font-size:12pt;">제품 이름</span></b></p>
				</td>
				<td width="450" height="20" align="center">
					<b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="name" size="30">
		        		</span>
					</b>
				</td>
			</tr>

		</table>
	</form>
</div>

<%@ include file="./layout/footer.jsp" %>
<script type="text/javascript">
	function checkData() {
		let insertForm = document.getElementById('');

		if(insertForm.deptno.value == "") {

			return;
		}
		if(insertForm.dname.value == "") {

			return;
		}
		if(insertForm.loc.value == "") {

			return;
		}
	}

</script>
</body>
</html>
