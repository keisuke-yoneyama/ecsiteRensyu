<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>管理者マイページ</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<p>管理者ページ</p>
				<br>
				<p>
					<s:property value="#session.user_name" />
					さん！！！管理者ページへようこそ！ <br>
				</p>
			</div>
			<s:if test='#session.containsKey("address")'>
				<h2>
					管理人:
					<s:property value="#session.user_name" />
					さん<br>
					住所:
					<s:property value="#session.address" />
				</h2>
			</s:if>

			<a href='<s:url action="GoItemCreateAction" />'><input
				type="button" value="商品追加" class="button"></a> <a
				href='<s:url action="UserInfoAction" />'><input type="button"
				value="ユーザー情報" class="button"></a> <a
				href='<s:url action="ItemInfoAction" />'><input type="button"
				value="商品情報を見る" class="button"></a>
			<div id="text-right">


				<p>
					Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</p>
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>