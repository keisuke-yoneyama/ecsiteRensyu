<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品情報変更完了</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h2>商品情報の変更が完了しました。</h2>
			</div>
			<div class="marginTop">
				<p>
					管理者画面に戻る場合は<a href='<s:url action="GoAdminMyPageAction" />'>こちら</a>
				</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>