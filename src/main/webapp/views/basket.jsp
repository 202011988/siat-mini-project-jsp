<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: gntod
  Date: 2024-05-23
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>주문 목록</title>
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>
<h1>
    Order List
</h1>

<form action="/insertOrder.do" method="post">
    <table align="center" border="0" cellpadding="5" cellspacing="2" width="100%"
           bordercolordark="white" bordercolorlight="black">
        <tr>
            <td bgcolor="#4CAF50">
                <p align="center">
                    <font color="white"><b><span style="font-size:12pt;">&nbsp;</span></b></font>
                </p>
            </td>
            <td bgcolor="#4CAF50">
                <p align="center"><font color="white"><b><span style="font-size:12pt;">번호</span></b></font>
                </p>
            </td>
            <td bgcolor="#4CAF50">
                <p align="center"><font color="white"><b><span
                        style="font-size:12pt;">상품명</span></b></font></p>
            </td>
            <td bgcolor="#4CAF50">
                <p align="center"><font color="white"><b><span style="font-size:12pt;">개수</span></b></font>
                </p>
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

    <div class="buttons-container">
        <button type="submit">주문하기</button>
        <button type="reset">모든 선택 풀기</button>
    </div>

</form>
<div class="buttons-container">
    <button onclick="sendAjaxDeleteCarts()">삭제하기</button>
    <button onclick="location.href='/'">메인으로</button>
</div>


<script>
  function sendAjaxDeleteCarts() {
    const selectedProducts = Array.from(document.querySelectorAll('input[name="products"]:checked'))
    .map(checkbox => checkbox.value);
    if (selectedProducts.length === 0) {
      alert('삭제할 제품을 선택해주세요.');
      return;
    }

    fetch('http://localhost:8080/deleteCart.do', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({products: selectedProducts})
    }).then(response => {
      if (response.ok) {
        // 삭제 성공 시 처리
        alert('제품이 삭제되었습니다.');
        // 페이지 새로고침 또는 필요한 추가 작업 수행
        location.reload();
      }
    })
  }
</script>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>
