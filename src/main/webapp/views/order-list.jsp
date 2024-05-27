<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>주문 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>
<h1>
    Order List
</h1>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white"
       bordercolorlight="black">
    <tr>
        <td bgcolor="#4CAF50">
            <p align="center">
                <font color="white"><b><span style="font-size:12pt;">주문번호</span></b></font></p>
        </td>
        <td bgcolor="#4CAF50">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">상품명</span></b></font></p>
        </td>
        <td bgcolor="#4CAF50">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">수량</span></b></font></p>
        </td>
        <td bgcolor="#4CAF50">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">주문일자</span></b></font></p>
        </td>
    </tr>

    <c:if test="${empty requestScope.orders}">
        <tr>
            <td colspan="5">
                <p align="center"><b><span style="font-size:12pt;">주문 목록이 없습니다.</span></b></p>
            </td>
        </tr>
    </c:if>
    <!-- 반복 출력 -->
    <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td bgcolor="">
                <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 주문번호 -->
                                <b><a href="orderDetail.do?orderId=${order.id}">${order.id}</a></b>
				            </span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
							<span style="font-size:12pt;">
								<!--
									상품명 클릭 시, 해당 상품 상세정보 출력
								 -->
								<b>
									<a href="productDetails.do?productId=${order.product.id}">${order.product.name}</a>
								</b>
							</span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 수량 -->
				            	<b>${order.quantity}</b>
				            </span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 주문일자 -->
				            	<b>${order.orderedDate}</b>
				            </span>
                </p>
            </td>
        </tr>
    </c:forEach>


</table>

<div class="buttons-container">
    <button onclick="location.href='/'">메인으로</button>
</div>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
