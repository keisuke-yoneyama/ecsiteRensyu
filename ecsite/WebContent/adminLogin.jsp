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
<title>管理者ログイン</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />

		<div id="main" class="clear">
			<div id="top">
				<p>管理者ログイン画面</p>
			</div>
			<div>
				<h3>管理者ページに移行するにはログインをお願いします。</h3>
				<s:form action="AdminLoginAction">
					<s:textfield name="login_Id" />
					<s:password name="login_pass" />
					<s:submit value="管理者としてログイン" />
				</s:form>
				<br>
				<div id="text-link">
					<p>
						Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>