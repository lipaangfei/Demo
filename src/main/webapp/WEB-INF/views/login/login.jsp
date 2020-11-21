<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录界面~</title>
	<style type="text/css">
		.loginForm input#loginButton {
			width: 200px;
		}
	</style>
</head>
<script type="text/javascript" src='/public/js/jquery-3.1.1.js'></script>
<script type="text/javascript">
	function checkConform(){
		return window.confirm("确认提交?")
	}
</script>

<body>
	<h1 style="text-align: center;" align="center">登  录</h1>
	<div align="center">
		<form accept="/login" method="post" class="loginForm" onsubmit="checkConform()">
			邮   箱： <input type="text" name="email" value="${email}" maxlength="1024"><br>
			密   码： <input type="password" name="password" value="${password}" maxlength="1024"><br>
			验证码: <input type="text" name="verifyCode" maxlength="4" size="8"><br>
			<img alt="点击更换验证码" src="captcha" onclick="changeIMG()" id="captchaIMG" width="60" height="21" style="margin-bottom: -5px"><br>
			<font color="red" size="4">${errorMessage}</font><br>
			<input type="submit" value="登    录" id="loginButton"><br>
		</form>
	</div>

	<script type="text/javascript">
		function changeIMG() {
			var captchaIMG = document.getElementById("captchaIMG");
			captchaIMG.src = "captcha?" + Math.random();
		}
		function showErrorMessage(){
			confirm(${errorMessage})
		}
	</script>
</body>
</html>