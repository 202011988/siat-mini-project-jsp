# Computer Shoppingmall

<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center">Computer Shoppingmall</h3>

  <p align="center">
    컴퓨터 부품 구매 페이지
    <br />    
</div>


<!-- ABOUT THE PROJECT -->
## About The Project
유저가 컴퓨터 부품을 찾아보고 장바구니에 담을 수 있고 판매자가 상품을 등록할 수 있는 페이지를 만들었다<br/>

[Order]
SELECT o FROM Order o where o.user.userId = :userId
SELECT o FROM Order o WHERE o.id = :id

[Cart]
DELETE FROM Cart c WHERE c.id = :id
UPDATE Cart c set c.quantity = :q where c.id = :id
SELECT c FROM Cart c WHERE c.id = :id
SELECT c FROM Cart c WHERE c.user.id = :userId AND c.product.id = :productId

[User]
SELECT u FROM User u WHERE u.userId = :id AND u.password = :pw

[Seller]
SELECT s FROM Seller s WHERE s.registrationNumber = :id AND s.password = :pw

[Product]
SELECT d FROM Product d
SELECT d FROM Product d  WHERE d.seller.registrationNumber= :registrationNumber
UPDATE Product p SET p.category = :category, p.description = :description, p.name = :name, p.price = :price, p.stock = :stock WHERE p.id = :id
DELETE FROM Product p WHERE p.id = :id




<br>함승우</br>
  - Oder, Cart 구현
<br>이동규</br>
  - Login, User, Seller 구현
<br>배창민</br>
  - Product구현


