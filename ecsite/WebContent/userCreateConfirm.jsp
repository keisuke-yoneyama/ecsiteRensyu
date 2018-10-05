<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>UserCreateConfirm画面</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr id="box">
						<td><label>ログインID:</label></td>
						<td><s:property value="login_id" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>ログインPASS:</label></td>
						<td><s:property value="login_pass" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>ユーザー名:</label></td>
						<td><s:property value="user_name" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>宛先:</label></td>
						<td><s:property value="address" escape="false" /></td>
					</tr>
					<tr>
						<td><s:submit value="完了" /></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	</div>
</body>
</html>