<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品登録完了</title>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<p>商品登録完了</p>
			</div>
			<div>
				<h2>商品登録が完了いたしました。</h2>
				<div class="marginTop">
					<p>
						管理者画面へ戻る場合は<a href='<s:url action="GoAdminMyPageAction" />'>こちら</a>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>