<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>주문 상세</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>
<h1>
    Order Details
</h1>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%"
       bordercolordark="white" bordercolorlight="black">
    <tr>
        <td bgcolor="#336699">
            <p align="center">
                <font color="white"><b><span style="font-size:12pt;">주문번호</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span
                    style="font-size:12pt;">상품명</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span
                    style="font-size:12pt;">수량</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span
                    style="font-size:12pt;">주문일자</span></b></font></p>
        </td>
    </tr>

    <c:if test="${empty requestScope.order}">
        <tr>
            <td colspan="5">
                <p align="center"><b><span style="font-size:12pt;">주문 상세가 없습니다.</span></b></p>

            </td>
        </tr>
    </c:if>

    <c:if test="${not empty requestScope.order}">
        <tr>
            <td bgcolor="">
                <p align="center">
                    <span style="font-size:12pt;">
                        <b>${requestScope.order.id}</b>
                    </span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
                    <span style="font-size:12pt;">
                        <b>${requestScope.order.product.name}</b>
                    </span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
                    <span style="font-size:12pt;">
                        <b>${requestScope.order.quantity}</b>
                    </span>
                </p>
            </td>
            <td bgcolor="">
                <p align="center">
                    <span style="font-size:12pt;">
                        <b>${requestScope.order.orderedDate}</b>
                    </span>
                </p>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <h2>총액</h2>
            </td>
            <td colspan="2">
                <h3>${requestScope.total}</h3>
            </td>
        </tr>
    </c:if>
</table>
<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>