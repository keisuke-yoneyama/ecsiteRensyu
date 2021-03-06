<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<title>ヘッダー</title>
</head>
	<body>
	<div id="header">
	<ul>
		<li><a href='<s:url action="GoHomeAction"/>'><input
				type="button" class="button" value="Yonezon"> </a>
		<li><select name="category_id">
				<option value="1">全てのカテゴリー</option>
				<option value="2">本</option>
				<option value="3">家電・パソコン</option>
				<option value="4">ホビー・ゲーム</option>
		</select></li>
		<li><input type="hidden" name="retrievalFlg" value="1"> <input
			type="text" name="keywords" placeholder="キーワードを入力" id="text">
		</li>
		<s:if test='#session.is_admin != "1"'>
			<li><s:if test='#session.containsKey("login_id")'>
					<a href='<s:url action="MyPageAction"/>'><input type="button"
						value="アカウントサービス" class="button"> </a>
				</s:if></li>
		</s:if>
		<s:if test='#session.is_admin != "1"'>
			<li><a href='<s:url action="ItemListAction" />'><input
					type="button" value="商品一覧" class="button"> </a></li>
		</s:if>
		<li><s:if test="#session.id != null">
				<a href='<s:url action="LogoutAction"/>'><input type="button"
					value="サインアウト" class="button"> </a>
			</s:if> <s:else>
				<a href='<s:url action="LoginAction"/>'><input type="button"
					value="サインイン" class="button"> </a>
			</s:else></li>



		<s:if test='#session.is_admin != "1"'>
			<li><a href='<s:url action="LoginAction"/>'><input type="button"
					value="注文履歴" class="button"> </a></li>
		</s:if>

		<s:if test='#session.is_admin != "1"'>
			<li><a href='<s:url action="LoginAction"/>'><input type="button"
					value="カート" class="button"> </a></li>
		</s:if>
	</ul>
	</div>
	</body>
</html>