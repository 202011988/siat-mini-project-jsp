<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PC 견적</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="/views/layout/header.jsp" %>
<body>
<style>
    .right-menu {
        width: 200px;
        background-color: #f1f1f1;
        padding: 20px;
    }

    .right-menu ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    .right-menu li a {
        display: block;
        padding: 8px 16px;
        text-decoration: none;
        color: #333;
    }

    .right-menu li a:hover {
        background-color: #ddd;
    }

    .right-menu li a.active {
        background-color: #4CAF50; /* 원하는 배경색 */
        color: white; /* 원하는 텍스트 색상 */
    }

    /*  ------ */
    .product-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: flex-start;
    }

    .product-item {
        width: 300px;
        height: 200px;
        margin-bottom: 30px;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        text-align: center;
    }


    .product-item h3 {
        margin-top: 10px;
        font-size: 18px;
    }

    .product-item p {
        margin: 5px 0;
        font-size: 14px;
        color: #777;
    }

    .price {
        font-weight: bold;
        color: #f00;
    }

    .buttons {
        margin-top: 10px;
    }

    .buy-btn {
        margin-top: 10px;
        padding: 10px 20px;
        background-color: #f00;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .buy-btn button:hover {
        background-color: #a00;
    }

    /*  --------*/
    .product-category {
        display: none;
    }

    /* {*/
    /*    box-sizing: border-box;*/
    /*    margin: 10px;*/
    /*    padding: 10px;*/
    /*}*/

    .parentt {
        width: 300px;
        /*height: 100px;*/
        height: 100%;
        display: flex;
        flex-direction: row;
        border: 3px;
    }

    .childd {
        flex: 1 0 auto;
        border: 3px;
    }
</style>

<div class="parentt">
    <div class="childd">
        <c:forEach items="${requestScope.category}" var="category">
            <div class="right-menu">
                <ul>
                    <li><a href="#">${category.name}</a></li>
                </ul>
            </div>
        </c:forEach>
    </div>

    <div class="product-container childd">

        <%--test--%>
        <c:forEach items="${requestScope.category}" var="category">
            <div class="product-category" id=${category.name}>
                <div class="product-list">
                    <c:forEach items="${requestScope.product}" var="product">
                        <c:if test="${product.category.id eq category.id}">
                            <div class="product-item" id=${product.id}> <%-- 이 코드에 id를 추가한다 (product's id) --%>
                                <h3>${product.name}</h3>
                                <p>${product.description}</p>
                                <p class="price">${product.price}원</p>
                                <button class="buy-btn">담기</button>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>


        <script>
            const buyBtns = document.querySelectorAll('.buy-btn');

            buyBtns.forEach(btn => {
                btn.addEventListener('click', () => {
                    const productId = btn.closest('.product-item').id;

                    console.log(productId[0]);

                    // productId 를 서버로 전송하는 코드
                    fetch("http://localhost:8080/insertCart.do", {
                        method: 'POST',
                        body: JSON.stringify({productId}),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                })
            })
        </script>

        <%-- end test--%>

    </div>
</div>
<div style="width: 100%">
    <%@ include file="/views/layout/footer.jsp" %>
</div>

<script>
    const menuItems = document.querySelectorAll('.right-menu li a');
    const categories = document.querySelectorAll('.product-category');

    menuItems.forEach(item => {
        item.addEventListener('click', function (e) {
            e.preventDefault(); // 링크 이동 방지

            // 기존 선택된 항목의 배경색 제거
            menuItems.forEach(item => item.classList.remove('active'));

            // 클릭한 항목에 active 클래스 추가
            this.classList.add('active');

            // 모든 카테고리 숨김
            categories.forEach(category => category.style.display = 'none');

            // 클릭한 메뉴 항목에 해당하는 카테고리 보임
            const categoryId = this.textContent.replace(' ', '-');
            console.log(typeof categoryId)
            document.getElementById(categoryId).style.display = 'block';
        });
    });
</script>
</body>
</html>
