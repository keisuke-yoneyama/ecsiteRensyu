<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品の変更情報入力</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>商品情報変更画面入力</h1>
			</div>
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false" />
			</s:if>
			<div>
				<table class="verticalTable">
					<s:form action="ItemInfoModificationConfirmAction">
						<s:iterator value="itemInfoList">
							<tr>
								<th>カテゴリー名</th>
								<td><s:radio list="#{2:'家電',3:'書籍',4:'ホビー' }"
										name="category_id" value="category_id" /></td>
							</tr>
							<tr>
								<th>商品名</th>
								<td><input type="text" name="item_name" class="txt"
									value='<s:property value="item_name"/>'
									placeholder='<s:property value="item_name" />'
									autocomplete="off" /></td>
							</tr>
							<tr>
								<th>価格</th>
								<td><input type="number" name="item_price"
									value='<s:property value="item_price" />' class="txt"
									placeholder='<s:property value="price" />' autocomplete="off"
									min="1" max="100000000" /></td>
							</tr>
							<tr>
								<th>在庫</th>
								<td><input type="number" name="item_stock"
									value='<s:property value="item_stock" />' class="txt"
									placeholder='<s:property value="item_stock" />'
									autocomplete="off" min="1" max="1000" /></td>
							</tr>
							<tr>
								<td colspan="2" class="center"><s:submit value="変更する"
										class="button marginTop" /></td>
							</tr>
						</s:iterator>
					</s:form>
				</table>
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