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
<h1 align="center">판매자 관리 페이지</h1>


<div id="container">
    <c:if test="${not empty sessionScope.seller}">
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
									<a href="/views/detailProduct.jsp?productId=${product.id}">${product.name}</a>
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
        <div align=center>
            <!-- 메인으로 클릭 시, 모든 부서 정보 출력 -->
            <span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href=''"></span>
            <!-- 부서생성 클릭 시, 새로운 부서 정보 입력 페이지로 이동 -->
            <span style="font-size:12pt;"><input type="button" value="부서생성" onclick="location.href='/insertDeptForm.do'"></span>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.userId}">
        <div align="center">
            <span style="font-size:12pt;">로그인이 필요한 서비스입니다.</span>
        </div>
    </c:if>
</div>
<%--<div class="buttons-container">--%>
<%--    <button onclick="location.href='/views/productUpdate.jsp'">수정</button>--%>
<%--    <button onclick="location.href='/productRemove.do'">삭제</button>--%>
<%--</div>--%>


<%--			<c:forEach items="${requestScope.productSeller}" var= "product">--%>
<%--            <tr>--%>
<%--                <td class="productName" name = "productName"><a href="/views/detailProduct.jsp">${product.name}</a></td>--%>
<%--                <td>${product.description}</td>--%>
<%--                <td>${product.price}</td>--%>




<%--<script>--%>
<%--    function sendAjaxDeleteCarts() {--%>
<%--        const selectedProducts = Array.from(document.querySelectorAll('input[name="products"]:checked'))--%>
<%--            .map(checkbox => checkbox.value);--%>
<%--        if (selectedProducts.length === 0) {--%>
<%--            alert('삭제할 제품을 선택해주세요.');--%>
<%--            return;--%>
<%--        }--%>

<%--        fetch('http://localhost:8080/deleteCart.do', {--%>
<%--            method: 'DELETE',--%>
<%--            headers: {--%>
<%--                'Content-Type': 'application/json'--%>
<%--            },--%>
<%--            body: JSON.stringify({products: selectedProducts})--%>
<%--        }).then(response => {--%>
<%--            if (response.ok) {--%>
<%--                // 삭제 성공 시 처리--%>
<%--                alert('제품이 삭제되었습니다.');--%>
<%--                // 페이지 새로고침 또는 필요한 추가 작업 수행--%>
<%--                location.reload();--%>
<%--            }--%>
<%--        })--%>
<%--    }--%>
<%--</script>--%>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
