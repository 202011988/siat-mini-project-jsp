<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="/views/layout/header.jsp"%>
<style>
  table {
    width: 60%;
    border-collapse: collapse;
    margin-top: 20px;
    margin-left: auto;
    margin-right: auto;
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
<h3 align="center">가입 유형을 선택해 주세요.</h3>
<div class="contatier">
  <div class="table-container">
    <table>
      <thead>
      <tr>
        <th>상품을 구매하고 싶다면</th>
        <th>상품을 판매하고 싶다면</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td><input type="button" value="구매자 계정으로 가입" onclick="location.href='/views/register/user.jsp'"></td>
        <td><input type="button" value="사업자(판매자) 계정으로 가입" onclick="location.href='/views/register/seller.jsp'"></td>
      </tr>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>
