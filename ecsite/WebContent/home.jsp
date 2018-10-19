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
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./css/form.css" />
<title>Home画面</title>
</head>
<jsp:include page="header.jsp" />
<body>
	<div id="container">

		<div id="main" class="clear">



			<div id="top" style="height: 97px;">
				<p class="subTitle">Yonezonへようこそ！</p>
			</div>
			<s:if test='#session.containsKey("user_name")'>
				<h2>
					<s:property value="#session.user_name" />
					さん、こんにちは！
				</h2>
			</s:if>

			<s:if test='#session.containsKey("address")'>
				<h2>
					お届け先:
					<s:property value="#session.user_name" />
					さん<br>
					<s:property value="#session.address" />
					にお届け
				</h2>
			</s:if>



			<div >
				<s:form action="HomeAction">
					<s:submit value="商品購入" />
				</s:form>



				<s:if test="#session.id != null">
					<p>
						ログアウトする場合は <a href='<s:url action="LogoutAction"/>'>こちら</a>
					</p>
				</s:if>
			</div>
		</div>

	</div>
</body>
<jsp:include page="footer.jsp" />
</html>