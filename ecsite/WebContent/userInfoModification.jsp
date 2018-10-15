<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報の変更を入力</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ユーザー情報の変更を入力</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
				<s:form action="UserInfoModificationConfirmAction">
					<s:iterator value="userInfoList">

						<tr>
							<th>名前</th>
							<td><input type="text" name="user_name" class="txt"
								value='<s:property value="user_name"/>' placeholder="名前"
								autocomplete="off" /></td>
						</tr>
						<tr>
							<th>ログインID</th>
							<td><input type="text" name="login_id" class="txt"
								value='<s:property value="login_id"/>' placeholder="ログインID"
								autocomplete="off" /></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="text" name="login_pass" class="txt"
								value='<s:property value="password"/>' placeholder="パスワード"
								autocomplete="off" /></td>
						</tr>
						<tr>
							<th> 宛先</th>
							<td><input type="text" name="address" class="txt"
								value='<s:property value="address"/>' placeholder="宛先"
								autocomplete="off" /></td>
						</tr>
						<tr>
							<td colspan="2" class="center"><s:submit value="変更"
									class="button marginTop" /></td>
						</tr>
					</s:iterator>
				</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	</div>
</body>
</html>