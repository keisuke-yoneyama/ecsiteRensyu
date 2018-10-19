<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>LOGIN画面</title>
<link rel="stylesheet" href="./css/form.css">
<link rel="stylesheet" href="./css/style.css">
</head>
<jsp:include page="header.jsp" />
<body>

	<div id="container">


		<div id="main" class="clear">
			<h1 class="subTitle">Yonezonへサインイン</h1>

			<s:form class="Form" action="LoginAction">
				<ul>
					<!-- LoginId入力 -->
					<li><s:textfield class="textbox" name="login_id"
							placeholder="ログインIDを入力" /></li>
					<!-- password入力 -->
					<li><s:password class="textbox" name="login_pass"
							placeholder="パスワードを入力" /></li>
					<!-- 送信ボタン -->
					<li><s:submit class="button" id="loginButton" value="ログイン" /></li>
					<!-- 新規登録へのリンク -->
					<li><a href='<s:url action="UserCreateAction"/>' class="link">新規アカウント作成</a>
					</li>
					<!-- homeへlink -->
					<li><a href='<s:url action="GoHomeAction"/>' class="link">ホーム画面へ</a>
					</li>
				</ul>
			</s:form>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>