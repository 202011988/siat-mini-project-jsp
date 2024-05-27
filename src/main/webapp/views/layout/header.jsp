<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>
  <h1>PC shop</h1>
  <p>JPA Mini project</p>
  <div align="right">
	  	<c:if test="${empty sessionScope.user && empty sessionScope.seller}">
			<p class="header-buttons-container">
				<span style="font-size:12pt;"><button onclick="location.href='/login.jsp'">로그인</button></span>
			</p>

	  	</c:if>
  		<c:if test="${not empty sessionScope.user}">
  			<span> ${sessionScope.username} 님 </span>
			<p class="header-buttons-container">
				<span style="font-size:12pt;"><button onclick="location.href='/logout.do'">로그아웃</button></span>
				<span style="font-size:12pt;"><button onclick="location.href='/cart.do'">장바구니</button></span>
				<span style="font-size:12pt;"><button onclick="location.href='/orders.do'">주문내역</button></span>
			</p>


		</c:if>

		<c:if test="${not empty sessionScope.seller}">
			<span> 스토어 ${sessionScope.storeName} </span>
			<p class="header-buttons-container">
				<span style="font-size:12pt;"><button onclick="location.href='/logout.do'">로그아웃</button></span>
			</p>

		</c:if>
	</div>
</header>

<style>
	.header-buttons-container {
		text-align: right;
		margin-bottom: 10px;
	}

	.header-buttons-container button {
		margin: 5px;
		padding: 10px 20px;
		border: none;
		background-color: #FFFFFF;
		color: black;
		cursor: pointer;
		font-weight: bold;
		border-radius: 5px;
	}

	.header-buttons-container button:hover {
		background-color: #cccccc;
	}
</style>