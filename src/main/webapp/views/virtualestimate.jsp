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

    <%--test--%>

    <div class="product-category" id="cpu">
        <div class="product-list">
            <div class="product-item" id="1"> <%-- 이 코드에 id를 추가한다 (product's id) --%>
                <img src="product1.jpg" alt="인텔 코어i5-14세대 14600K (렙터레이크 리프레시)">
                <h3>인텔 코어i5-14세대 14600K (렙터레이크 리프레시) (정품)</h3>
                <p>인텔소켓:1700/10nm/렙터레이크/P6+E8코어/12+8논리코어/클럭:3.5GHz/최대 클럭:5.3GHz/L2 캐시:20MB...</p>
                <p class="price">478,500원</p>
                <button class="buy-btn">담기</button>
            </div>
            <div class="product-item" id="2"> <%-- 이 코드에 id를 추가한다 (product's id) --%>
                <img src="product1.jpg" alt="인텔 코어i5-14세대 14600K (렙터레이크 리프레시)">
                <h3>인텔 코어i5-14세대 14600K (렙터레이크 리프레시) (정품)</h3>
                <p>인텔소켓:1700/10nm/렙터레이크/P6+E8코어/12+8논리코어/클럭:3.5GHz/최대 클럭:5.3GHz/L2 캐시:20MB...</p>
                <p class="price">478,500원</p>
                <button class="buy-btn">담기</button>
            </div>
        </div>
    </div>

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

    <div class="product-category" id="cpu">
        <div class="product-list">
            <div class="product-item">
                <img src="product1.jpg" alt="인텔 코어i5-14세대 14600K (렙터레이크 리프레시)">
                <h3>인텔 코어i5-14세대 14600K (렙터레이크 리프레시) (정품)</h3>
                <p>인텔소켓:1700/10nm/렙터레이크/P6+E8코어/12+8논리코어/클럭:3.5GHz/최대 클럭:5.3GHz/L2
                    캐시:20MB...</p>
                <p class="price">478,500원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product2.jpg" alt="AMD 라이젠5-5세대 7600 (랩터월)">
                <h3>AMD 라이젠5-5세대 7600 (랩터월) (정품)</h3>
                <p>AMD(소켓AM5)/5세대(Zen4)/5nm/6코어/12논리코어/클럭:3.8GHz/최대 클럭:5.1GHz/L2 캐시:6MB/L3
                    캐시:32MB...</p>
                <p class="price">272,500원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product3.jpg" alt="인텔 코어i5-13세대 13400F (렙터레이크)">
                <h3>인텔 코어i5-13세대 13400F (렙터레이크) (정품)</h3>
                <p>인텔소켓:1700/10nm/렙터레이크+E6코어/12+4논리코어/클럭:2.5GHz/최대 클럭:4.6GHz/L2 캐시:9.5MB...</p>
                <p class="price">265,000원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product4.jpg" alt="AMD 라이젠7-5세대 7800X3D (랩타윈)">
                <h3>AMD 라이젠7-5세대 7800X3D (랩타윈) (정품)</h3>
                <p>AMD(소켓AM5)/5세대(Zen4)/5nm/8코어/16논리코어/클럭:4.2GHz/최대 클럭:5.0GHz/L2 캐시:8MB/L3
                    캐시:96MB...</p>
                <p class="price">562,000원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product5.jpg" alt="인텔 코어i5-14세대 14400F (렙터레이크 리프레시)">
                <h3>인텔 코어i5-14세대 14400F (렙터레이크 리프레시) (정품)</h3>
                <p>인텔소켓:1700/10nm/렙터레이크+E6코어/12+4논리코어/클럭:2.5GHz/최대 클럭:4.7GHz/L2 캐시:9.5MB...</p>
                <p class="price">291,020원</p>
                <button class="buy-btn">담기</button>
            </div>
        </div>
    </div>
    <div class="product-category" id="쿨러/튜닝">
        <div class="product-list">
            <div class="product-item">
                <img src="product1.jpg" alt="MSI MAG 코어리퀴드 M360 박격포">
                <h3>MSI MAG 코어리퀴드 M360 박격포</h3>
                <p>CPU 쿨러/수랭/팬 굽림/A/S기간5년/[호환]/극기/인텔
                    소켓LGA1700,LGA1200,LGA2066,LGA2011-V3,LGA...</p>
                <p class="price">86,400원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product2.jpg" alt="darkFlash NEBULA DN-360 ARGB (화이트)">
                <h3>darkFlash NEBULA DN-360 ARGB (화이트)</h3>
                <p>CPU 쿨러/수랭/팬 굽림/A/S기간5년/[호환]/극기/인텔 소켓LGA1700,LGA1200,LGA115x/AMD 소켓AM5,...</p>
                <p class="price">88,020원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product3.jpg" alt="PCCOOLER G6 (BLACK)">
                <h3>PCCOOLER G6 (BLACK)</h3>
                <p>CPU 쿨러/유열더렘/공랭/팬 굽림/TDP:250W/A/S기간5년/[호환]/극기/인텔 소켓LGA1700,LGA1200,LG...</p>
                <p class="price">38,780원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product4.jpg" alt="쌌반 CNPS9X PERFORMA (BLACK)">
                <h3>쌌반 CNPS9X PERFORMA (BLACK)</h3>
                <p>CPU 쿨러/상부타렘/공랭/팬 굽림/TDP:200W/[호환]/극기/인텔 소켓LGA1700,LGA1200,LGA115x/AMD ...</p>
                <p class="price">25,380원</p>
                <button class="buy-btn">담기</button>
            </div>

            <div class="product-item">
                <img src="product5.jpg" alt="PCCOOLER PALADIN 400 (BLACK)">
                <h3>PCCOOLER PALADIN 400 (BLACK)</h3>
                <p>CPU 쿨러/상부타렘/공랭/팬 굽림/TDP:200W/A/S기간5년/[호환]/극기/인텔 소켓LGA1700,LGA1200,LG...</p>
                <p class="price">29,570원</p>
                <button class="buy-btn">담기</button>
            </div>
        </div>
    </div>
    <div class="product-category" id="메인보드">

    </div>
    <div class="product-category" id="메모리">

    </div>
    <div class="product-category" id="그래픽카드">
        <div class="product-list">
            <div class="product-item">
                <img src="product1.jpg" alt="MSI 지포스 RTX 4070 Ti SUPER">
                <h3>MSI 지포스 RTX 4070 Ti SUPER 벤투스 3X OC D6X 16GB</h3>
                <p>RTX 4070 Ti SUPER/4nm/메모리:23.40GHz/부스트클럭:2640MHz/OC클럭:2655MHz/스트림
                    프로세서:...</p>
                <p class="price">1,225,800원</p>
                <button class="buy-btn">담기</button>
            </div>
            <!-- 다른 제품 항목들도 유사한 구조로 작성 -->
        </div>
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

<%@ include file="/views/layout/footer.jsp" %>

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
