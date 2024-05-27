# Computer Shoppingmall

<!-- PROJECT LOGO -->
<br />
<div align="center">

<h2 align="center">PC Shop</h2>

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
SELECT o FROM Order o WHERE o.id = :id <br/>

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
[전반적인 과정] <br/>
1. 사이트 접속시 카테고리 이름을 선택시 카테고리에 있는 상품을 볼 수 있다. <br/>
3. 회원가입을 통해 판매자와 유저를 구분해서 회원가입이 가능하다. <br/>
4. user 로그인 후 담기 버튼을 클릭시 성공했다면 장바구니에 갈지 말지 묻는 confirm가 뜬다. <br/>
5. 장바구니에 3가지 선택지가 있다. (주문하기, 리셋, 삭제하기)  <br/>
6. 주문하면 해당 제품이 주문되며 리셋하면 선택한 목록이 다 풀어지고  <br/>
7. 삭제하면 해당 장바구니의 제품이 삭제된다. <br/>
8. 주문 완료 시 주문 내역에 등록 되며, 주문 내역에서 주문 내역 번호를 누르면 제품 상세 정보 사이트로 이동하게 되고, 주문 내역 번호를 주문 상세 내역 사이트로 이동하며, 개수와 금액을 곱한 결과가 나온다. <br/>
9. 상품의 이름을 클릭시 상품 상세 페이지로 이동한다. <br/>
10. 관리자 로그인시 판매자가 현재 판매중인 상품 목록을 볼 수 있다. <br/>
11. 추가 버튼을 클릭시 상품을 추가할 수 있다. <br/>
12. 상품의 이름을 클릭시 상품 상세 페이지로 이동한다. <br/>
13. 판매자로 로그인시 상세 페이지를 통해 수정, 삭제 할 수 있다. <br/>

<hr>







