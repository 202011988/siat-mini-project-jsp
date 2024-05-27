<%@ page import="entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>판매자 관리</title>
    <link rel="stylesheet" href="<c:url value='/static/css/layout.css'/>" type="text/css">
<%--    <link src="/static/css/layout.css" rel="stylesheet" type="text/css">--%>
</head>
<%@ include file="/views/layout/header.jsp" %>
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
<h1 align="center">판매자 관리 페이지 <button onclick="location.href='/views/productInsert.jsp'">추가</button></h1>

<div id="container">
        <table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
            <tr>
                <td bgcolor="#336699">
                    <p align="center">
                        <font color="white"><b><span style="font-size:12pt;">상품명</span></b></font></p>
                </td>
                <td bgcolor="#336699">
                    <p align="center"><font color="white"><b><span style="font-size:12pt;">설명</span></b></font></p>
                </td>
                <td bgcolor="#336699">
                    <p align="center"><font color="white"><b><span style="font-size:12pt;">가격</span></b></font></p>
                </td>
            </tr>

            <!-- 부서 객체 유무 검증 -->
            <c:if test="${empty requestScope.productSeller}">
                <tr>
                    <td colspan="5">
                        <p align="center"><b><span style="font-size:12pt;">등록된 상품이 존재하지 않습니다.</span></b></p>
                    </td>
                </tr>
            </c:if>
            <!-- 반복 출력 -->
            <c:forEach items="${requestScope.productSeller}" var="product">
                <tr>
                    <td bgcolor="">
                        <p align="center">

							<span style="font-size:12pt;">
								<!--
									이름
								 -->
								    <b>
									    <a href="/productDetails.do?productId=${product.id}">
                                                ${product.name}
                                        </a>
								    </b>

							</span>

                        </p>
                    </td>
                    <td bgcolor="">
                        <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 설명 -->
				            	<b>${product.description}</b>
				            </span>
                        </p>
                    </td>
                    <td bgcolor="">
                        <p align="center">
			            	<span style="font-size:12pt;">
			            		<!-- 가격 -->
			             		<b>${product.price}</b>
			             	</span>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
</div>



<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
