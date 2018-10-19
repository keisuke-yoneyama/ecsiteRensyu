<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItemConfirm画面</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<p>BuyItem</p>
			</div>
			<div>
				<s:form>
					<tr>
						<td>商品名</td>
						<td><s:property value="session.buyItem_name" /></td>
					</tr>
					<tr>
						<td>値段</td>
						<td><s:property value="session.total_price" /><span>円</span></td>
					</tr>
					<tr>
						<td>購入個数</td>
						<td><s:property value="session.count" /><span>個</span></td>
					</tr>
					<tr>
						<td>支払い方法</td>
						<td><s:property value="session.pay" /></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					<tr>
						<td><input type="button" value="戻る"
							onclick="submitAction('HomeAction')" /></td>
						<td><input type="button" value="完了"
							onclick="submitAction('BuyItemConfirmAction')" /></td>
					</tr>
				</s:form>

				<div>
					<p>
						前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a>
					</p>
					<p>
						マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>