<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品追加確認</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">！商品追加確認！</div>
			<div>
				<h2>以下の情報で商品登録します。</h2>
				<table>
					<s:form action="ItemCreateCompleteAction">
						<tr id="box">
							<th>商品名</th>
							<td><s:property value="#session.item_name" /></td>
						</tr>
						<tr id="box">
							<th>価格</th>
							<td><s:property value="#session.item_price" /></td>
						</tr>
						<tr id="box">
							<th>在庫</th>
							<td><s:property value="#session.item_stock" /></td>
						</tr>
						<tr id="box">
							<td><s:submit value="登録" colspan="2" class="center" /></td>
						</tr>
					</s:form>
				</table>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>