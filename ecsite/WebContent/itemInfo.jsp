<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報画面</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>商品情報画面</h1>
			</div>
			<div class="marginLeft center">

				<s:if test="itemInfoList == null">
					<h3>商品情報はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3 class="marginTop">商品情報は以下になります。</h3>
					<table border="1" class="ShowData marginAuto">
						<tr>
							<th>商品名</th>
							<th>価格</th>
							<th>在庫</th>
						</tr>
						<s:iterator value="itemInfoList">
							<tr>
								<th><s:property value="item_name" /></th>
								<th><s:property value="item_price" /><span>円</span></th>
								<th><s:property value="item_stock" /><span>個</span></th>
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