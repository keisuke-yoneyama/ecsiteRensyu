<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
			<h1>ユーザー情報画面</h1>
		</div>
		<div class="marginLeft">
			<s:if test="userInfoList == null">
				<h3>ユーザー情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ユーザー情報は以下になります。</h3>
			<table border="1" class="ShowData">
				<tr>
					<th>名前</th>
					<th>ログインID</th>
					<th>パスワード</th>
				</tr>
				<s:iterator value="userInfoList">
				<tr>
					<th><s:property value="user_name" /></th>
					<th><s:property value="login_id" /></th>
					<th><s:property value="login_pass" /></th>
				</tr>
				</s:iterator>
			</table>
			</s:elseif>
			<s:form action="UserInfoModificationAction" class="marginTop">
				<s:submit value="ユーザーの変更" class="button"/>
			</s:form>
			<s:form action="UserInfoAction" class="marginTop">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete" class="button" />
			</s:form>
			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<s:form action="GoAdminMyPageAction" class="marginTop">
				<s:submit value="管理者画面へ戻る" class="button"/>
			</s:form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
