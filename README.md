# Computer Shoppingmall

<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center">Computer Shoppingmall</h3>

  <p align="center">
    컴퓨터 부품 구매 페이지
    <br />    
</div>
<hr>
[사용목적] <br/>
유저가 컴퓨터 부품을 찾아보고 장바구니에 담을 수 있고 판매자가 상품을 등록할 수 있는 페이지를 만들었다<br/>
<hr>
함승우
  - Oder, Cart 구현 <br/>
  
이동규
  - Login, User, Seller 구현 <br/>
  
배창민
  - Product구현

<hr>
[Order] <br/>
SELECT o FROM Order o where o.user.userId = :userId <br/>
SELECT o FROM Order o WHERE o.id = :id 

[Cart] <br/>
DELETE FROM Cart c WHERE c.id = :id <br/>
UPDATE Cart c set c.quantity = :q where c.id = :id <br/>
SELECT c FROM Cart c WHERE c.id = :id <br/>
SELECT c FROM Cart c WHERE c.user.id = :userId AND c.product.id = :productId <br/>

[User] <br/>
SELECT u FROM User u WHERE u.userId = :id AND u.password = :pw <br/>
 
[Seller] <br/>
SELECT s FROM Seller s WHERE s.registrationNumber = :id AND s.password = :pw <br/>

[Product] <br/>
SELECT d FROM Product d <br/>
SELECT d FROM Product d  WHERE d.seller.registrationNumber= :registrationNumber <br/>
UPDATE Product p SET p.category = :category, p.description = :description, p.name = :name, p.price = :price, p.stock = :stock WHERE p.id = :id <br/>
DELETE FROM Product p WHERE p.id = :id <br/>
<hr>
[전반적으로 돌아가는 과정] <br/>
1. 사이트 접속시 카테고리 이름을 선택시 카테고리에 있는 상품을 볼 수 있다. <br/>
2. user 로그인 후 담기 버튼을 클릭시 장바구니에 상품이 담긴다. <br/>
3. 상품의 이름을 클릭시 상품 상세 페이지로 이동한다. <br/>
4. 관리자 로그인시 판매자가 현재 판매중인 상품 목록을 볼 수 있다. <br/>
5. 추가 버튼을 클릭시 상품을 추가할 수 있다. <br/>
6. 상품의 이름을 클릭시 상품 상세 페이지로 이동한다. <br/>
7. 판매자로 로그인시 상세 페이지를 통해 수정, 삭제 할 수 있다. <br/>







