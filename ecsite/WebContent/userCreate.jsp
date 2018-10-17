<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ユーザー情報入力</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>ユーザー情報入力画面</h1>
			</div>
			<s:if test="errorMassage !=''">
				<s:property value="errorMassage" escape="false" />
			</s:if>
			<div>
				<table class="verticalTable">
					<s:form action="UserCreateConfirmAction">
						<tr>
							<td><label>ログインID:</label></td>
							<td><s:textfield type="txt" placeholder="ログインID"
									name="login_id" autocomplete="off" value="%{login_id}" /></td>
						</tr>
						<tr>
							<td><label>ログインPASS:</label></td>
							<td><s:password type="txt" placeholder="パスワード"
									name="login_pass" autocomplete="off" value="%{login_pass}" /></td>
						</tr>
						<tr>
							<td><label>ユーザー名:</label></td>
							<td><s:textfield type="txt" placeholder="名前"
									name="user_name" autocomplete="off" value="%{user_name}" /></td>
						</tr>
						<tr>
							<td><label>宛先:</label></td>
							<td><s:textfield type="txt" placeholder="宛先" name="address"
									autocomplete="off" value="%{address}" /></td>
						</tr>
						<tr>
							<td colspan="2" class="center"><s:submit value="登録"
									class="button marginTop" /></td>
						</tr>
					</s:form>
				</table>
				<div>
					<span>前画面に戻る場合は</span> <a href='<s:url action="HomeAction"/>'>こちら</a>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>