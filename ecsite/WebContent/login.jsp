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
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />

		<div id="main" class="clear">
			<div id="top">
				<p>サインイン画面</p>
			</div>
			<div>
				<h2>サインインをしてより便利に</h2>
				<s:form action="LoginAction">
					<s:textfield name="login_id" />
					<s:password name="login_pass" />
					<s:submit value="ログイン" />
				</s:form>
				<br />
				<div id="text-link">
					<p>
						新規ユーザー登録は <a href='<s:url action="UserCreateAction"/>'>こちら</a>
					</p>
					<p>
						Homeへ戻る場合は <a href='<s:url action="GoHomeAction"/>'>こちら</a>
					</p>
				</div>
			</div>

			<jsp:include page="footer.jsp" />
		</div>
	</div>


</body>
</html>