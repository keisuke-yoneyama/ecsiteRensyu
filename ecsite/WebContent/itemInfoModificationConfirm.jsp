<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報確認</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>商品情報確認画面</h1>
				<h2>以下の内容でよろしいですか。</h2>
			</div>
			<div>
				<table class="verticalTable marginTop">
					<tr>
						<th>商品名</th>
						<td><s:property value="#session.item_name" /></td>
					</tr>
					<tr>
						<th>カテゴリー名</th>
						<td><s:if test="#session.category_id.hashCode() == 2">家電</s:if>
							<s:elseif test="#session.category_id.hashCode() == 3">本</s:elseif>
							<s:else>ゲーム</s:else></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><s:property value="#session.item_price" /></td>
					</tr>
					<tr>
						<td colspan="2" class="center"><a
							href='<s:url action="ItemInfoModificationCompleteAction" />'>
								<input type="button" value="登録" class="button">
						</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>