<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<header>
  <h1>PC shop</h1>
  <p>JPA Mini project</p>
  <div align="right">
	  	<c:if test="${empty sessionScope.userId}">
		  	<span style="font-size:12pt;"><input type="button" value="로그인" onclick="location.href='/login.do'"></span>
	  	</c:if>
  		<c:if test="${not empty sessionScope.userId}">
  			<span> ${sessionScope.userName} 님 </span>
	  		<span style="font-size:12pt;"><input type="button" value="로그아웃" onclick="location.href='/logout.do'"></span>
		</c:if>
	</div>
</header>
