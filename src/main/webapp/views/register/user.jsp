<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dept Insertion</title>
  <link href="/static/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<div id="container">
  <!-- action, method -->
  <form action="/registerUser.do" method="POST" id="insertForm" onsubmit="checkData()">
    <table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
      <tr>
        <td width="1300" height="20" colspan="2" bgcolor="#336699">
          <p align="center">
            <font color="white" size="3">
              <b>가입 정보 입력</b>
            </font>
          </p>
        </td>
      </tr>

      <tr>
        <td width="230" height="20">
          <p align="center"><b><span style="font-size:12pt;">ID</span></b></p>
        </td>
        <td width="450" height="20" align="center">
          <b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="userId" size="30">
		        		</span>
          </b>
        </td>
      </tr>


      <tr>
        <td width="230" height="20">
          <p align="center"><b><span style="font-size:12pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20" align="center">
          <b>
		        		<span style="font-size:12pt;">
		        			<input type="password" name="password" size="30">
		        		</span>
          </b>
        </td>
      </tr>


      <tr>
        <td width="230" height="20">
          <p align="center"><b><span style="font-size:12pt;">성명</span></b></p>
        </td>
        <td width="450" height="20" align="center">
          <b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="username" size="30">
		        		</span>
          </b>
        </td>
      </tr>


      <tr>
        <td width="230" height="20">
          <p align="center"><b><span style="font-size:12pt;">주소</span></b></p>
        </td>
        <td width="450" height="20" align="center">
          <b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="address" size="30">
		        		</span>
          </b>
        </td>
      </tr>

      <tr>
        <td width="230" height="20">
          <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20" align="center">
          <b>
		        		<span style="font-size:12pt;">
							<input type="submit" value="회원가입">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="다시작성">
						</span>
          </b>
        </td>
      </tr>
    </table>
  </form>
  <hr>
  <div align=center>
    <span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href=''"></span>
  </div>

</div>

<%@ include file="../layout/footer.jsp" %>

<script type="text/javascript">
  function checkData() {
    let insertForm = document.getElementById('');

    if(insertForm.deptno.value == "") {

      return;
    }
    if(insertForm.dname.value == "") {

      return;
    }
    if(insertForm.loc.value == "") {

      return;
    }
  }

</script>
</body>
</html>