<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報画面</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>商品情報画面</h1>
			</div>
			<div class="marginLeft center">
				<div>
					<s:form action="GoItemCreateAction" class="marginTop">
						<s:submit value="商品の追加" class="button"/>
					</s:form>
					<s:form action="ItemInfoAction" class="marginTop">
						<input type="hidden" name="deleteFlg" value="1">
						<s:submit value="全部削除" method="delete" class="button" />
					</s:form>
					<s:form action="GoAdminMyPageAction" class="marginTop">
						<s:submit value="管理者画面へ戻る" class="button"/>
					</s:form>
				</div>
				<s:if test="itemInfoList == null">
					<h3>商品情報はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3 class="marginTop">商品情報は以下になります。</h3>
					<table border="1" class="ShowData marginAuto">
						<tr>
							<th>ID</th>
							<th>カテゴリー</th>
							<th>商品名</th>
							<th>価格</th>
							<th>在庫</th>
						</tr>
						<s:iterator value="itemInfoList">
							<tr>
								<th><s:property value="id" /></th>
								<th><s:if test="category_id == 2">
										<span>家電</span>
									</s:if> <s:elseif test="category_id == 3">
										<span>書籍</span>
									</s:elseif> <s:elseif test="category_id == 4">
										<span>ホビー</span>
									</s:elseif></th>
								<th><s:property value="item_name" /></th>
								<th><s:property value="item_price" /><span>円</span></th>
								<th><s:property value="item_stock" /><span>個</span></th>
								<th class="center"><s:form action="ItemInfoChangeAction">
										<input type="hidden" name="itemId"
											value='<s:property value="id"/>'>
										<s:submit value="変更" />
									</s:form></th>
							</tr>
						</s:iterator>
					</table>
				</s:elseif>
				<s:if test="message != null">
					<h3>
						<s:property value="message" />
					</h3>
				</s:if>

			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>