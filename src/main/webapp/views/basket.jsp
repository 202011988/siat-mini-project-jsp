<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: gntod
  Date: 2024-05-23
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>주문 목록</title>
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>
<h1>
    Order List
</h1>

<form action="/insertOrder" method="post">
    <table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
        <tr>
            <td bgcolor="#336699">
                <p align="center">
                    <font color="white"><b><span style="font-size:12pt;">&nbsp;</span></b></font></p>
            </td>
            <td bgcolor="#336699">
                <p align="center"><font color="white"><b><span style="font-size:12pt;">번호</span></b></font></p>
            </td>
            <td bgcolor="#336699">
                <p align="center"><font color="white"><b><span style="font-size:12pt;">상품명</span></b></font></p>
            </td>
            <td bgcolor="#336699">
                <p align="center"><font color="white"><b><span style="font-size:12pt;">개수</span></b></font></p>
            </td>
        </tr>

        <c:if test="${empty requestScope.cartlist}">
            <tr>
                <td colspan="5">
                    <p align="center"><b><span style="font-size:12pt;">항목이 없습니다.</span></b></p>
                </td>
            </tr>
        </c:if>
        <!-- 반복 출력 -->
        <c:forEach items="${requestScope.cartlist}" var="cart">
            <tr>
                <td bgcolor="">
                    <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- checkbox -->
				            	<b>
                                    <input type="checkbox" name="products" value="${cart.id}">
                                </b>
				            </span>
                    </p>
                </td>
                <td bgcolor="">
                    <p align="center">
							<span style="font-size:12pt;">
								<!--
									카트 번호
								 -->
								<b>
									<b>${cart.id}</b>
								</b>
							</span>
                    </p>
                </td>
                <td bgcolor="">
                    <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 수량 -->
				            	<b>${cart.product.name}</b>
				            </span>
                    </p>
                </td>
                <td bgcolor="">
                    <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 개수 -->
				            	<b>${cart.quantity}</b>
				            </span>
                    </p>
                </td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="주문하기" />
</form>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
