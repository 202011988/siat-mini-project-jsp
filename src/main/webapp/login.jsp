<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/static/css/layout.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@ include file="/views/layout/header.jsp" %>

<div id="container">
    <!-- action, method -->
    <form action="/login.do" method="POST">
        <table align="center" cellpadding="5" cellspacing="1" width="600" border="0">
            <tr>
                <td width="1320" height="20" colspan="2" bgcolor="#336699">
                    <p align="center">
                        <font color="white" size="3">
                            <b>로그인</b>
                        </font>
                    </p>
                </td>
            </tr>
            <tr>
                <td width="250" height="20" align="center">
                    <p align="right"><b><span style="font-size:12pt;">ID</span></b></p>
                </td>
                <td width="450" height="20" align="center">
                    <b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="id" size="30" value="123456789">
		        		</span>
                    </b>
                </td>
            </tr>
            <tr>
                <td width="250" height="20">
                    <p align="right"><b><span style="font-size:12pt;">비밀번호</span></b></p>
                </td>
                <td width="450" height="20" align="center">
                    <b>
		        		<span style="font-size:12pt;">
		        			<!-- input 박스 -->
		        			<input type="password" name="pw" size="30" value="password">
		        		</span>
                    </b>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td width="250" height="20">
                    <p><b><span style="font-size:12pt;"><input type="checkbox" id="seller", name="seller">
                            <label for="seller">관리자로 로그인</label></span></b></p>
                </td>
                <td width="450" height="20" align="center">
                    <b>
		        		<span style="font-size:12pt;">
							<input type="submit" value="로그인">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="다시작성">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="button" value="회원가입" onclick="location.href='/views/register/select.jsp'">
                            &nbsp;&nbsp;&nbsp;&nbsp;

						</span>
                    </b>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <div align=center>
        <span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/'"></span>
    </div>
</div>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>