<%--
  Created by IntelliJ IDEA.
  User: gntod
  Date: 2024-05-23
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PC 견적</title>

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
        justify-content: space-between;
      }

      .product-item {
        width: 30%;
        margin-bottom: 30px;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        text-align: center;
      }

      .product-item img {
        max-width: 100%;
        height: auto;
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

      /*  --------*/
      .product-category {
        display: none;
      }
    </style>
</head>
<body>
<div class="right-menu">
    <ul>
        <li><a href="#">CPU</a></li>
        <li><a href="#">쿨러/튜닝</a></li>
        <li><a href="#">메인보드</a></li>
        <li><a href="#">메모리</a></li>
        <li><a href="#">그래픽카드</a></li>
        <li><a href="#">SSD</a></li>
        <li><a href="#">HDD</a></li>
        <li><a href="#">케이스</a></li>
        <li><a href="#">파워</a></li>
        <li><a href="#">소프트웨어</a></li>
    </ul>
</div>

<div class="product-container">
    <div class="product-category" id="CPU">
        <!-- CPU 관련 상품들 -->
    </div>
    <div class="product-category" id="쿨러/튜닝">
        <!-- 쿨러/튜닝 관련 상품들 -->
    </div>
    <div class="product-category" id="메인보드">
        <div class="product-list">
            <div class="product-item">
                <img src="product1.jpg" alt="MSI 지포스 RTX 4070 Ti SUPER">
                <h3>MSI 지포스 RTX 4070 Ti SUPER 벤투스 3X OC D6X 16GB</h3>
                <p>RTX 4070 Ti SUPER/4nm/메모리:23.40GHz/부스트클럭:2640MHz/OC클럭:2655MHz/스트림 프로세서:...</p>
                <p class="price">1,225,800원</p>
                <button class="buy-btn">담기</button>
            </div>

            <!-- 다른 제품 항목들도 유사한 구조로 작성 -->
        </div>
    </div>
    <div class="product-category" id="메모리">

    </div>
    <div class="product-category" id="그래픽카드">

    </div>
    <div class="product-category" id="SSD">

    </div>
    <div class="product-category" id="HDD">

    </div>
    <div class="product-category" id="케이스">

    </div>
    <div class="product-category" id="파워">

    </div>
    <div class="product-category" id="소프트웨어">

    </div>
    <!-- 다른 카테고리들도 유사하게 추가 -->
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
      const categoryId = this.textContent.toLowerCase().replace(' ', '-');
      console.log(categoryId)
      document.getElementById(categoryId).style.display = 'block';
    });
  });
</script>
</body>
</html>
