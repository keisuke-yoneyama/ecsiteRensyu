<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>header</title>
<!-- 	<link rel="stylesheet"href="./css/style.css"> -->
</head>
<body>
	<header>

		<ul>
			<li><a href='<s:url action="GoHomeAction"/>'><input
					type="button" class="button" value="Yonezon"> </a>
			<li><select name="category_id">
					<option value="1">全てのカテゴリー</option>
					<option value="2">本</option>
					<option value="3">家電・パソコン</option>
					<option value="4">ホビー・ゲーム</option>
			</select></li>
			<li><input type="hidden" name="retrievalFlg" value="1">
				<input type="text" name="keywords" placeholder="キーワードを入力" id="text">
			</li>
			<li><s:if test='#session.containsKey("login_id")'>
					<a href='<s:url action="MyPageAction"/>'><input type="button"
						value="アカウントサービス" class="button"> </a>
				</s:if></li>

			<li><s:if test="#session.id != null">
					<a href='<s:url action="LogoutAction"/>'><input type="button"
						value="サインアウト" class="button"> </a>
				</s:if> <s:else>
					<a href='<s:url action="LoginAction"/>'><input type="button"
						value="サインイン" class="button"> </a>
				</s:else></li>



			<li>注文履歴</li>

			<s:if test='#session.is_admin != "1"'>
				<li><a href='<s:url action="HomeAction"/>'><img
						src="images/cart.png" alt="cart" width="90" height="65"
						class="cartButton"></a></li>
			</s:if>
		</ul>
	</header>
</body>
</html>