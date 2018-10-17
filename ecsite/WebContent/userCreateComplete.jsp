<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>ユーザー登録完了</title>

<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h2>ユーザー登録が完了しました。</h2>
			</div>

			<s:if test='#session.containsKey("is_admin")'>
				<a href='<s:url action="GoAdminMyPageAction" />' class="marginTop">管理画面へ</a>
			</s:if>
			<s:else>
				<a href='<s:url action="HomeAction"/>'>ホーム画面へ</a>
			</s:else>


		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>