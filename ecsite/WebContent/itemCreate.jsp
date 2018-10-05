<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品追加画面</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<p>商品追加ページ</p>
			</div>
			<div>
				<s:if test="errorMessage !=''">
					<s:property value="errorMassage" escape="false" />
				</s:if>
				<table>
					<s:form action="ItemCreateConfirmAction" method="post">
						<tr>
							<th>商品名</th>
							<td><input type="text" name="item_name" class="txt"
								placeholder="商品名" required />入力必須</td>
						</tr>
						<tr>
							<th>価格</th>
							<td><input type="number" name="item_price" class="txt"
								placeholder="価格" required />入力必須</td>
						</tr>
						<tr>
							<th>在庫</th>
							<td><input type="number" name="item_stock" class="txt"
								placeholder="在庫数" required />入力必須</td>
						</tr>
						<s:submit value="商品登録" />
					</s:form>
				</table>
				<div class="marginTop">
					<p>
						管理者画面へ戻る場合は<a href='<s:url action="AdminLoginAction" />'>こちら</a>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>