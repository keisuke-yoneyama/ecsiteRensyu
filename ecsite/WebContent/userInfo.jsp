<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ユーザー情報</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>ユーザー情報画面</h1>
			</div>
			<div class="center">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1" class="ShowData marginAuto">
					<tr>
						<th>ID</th>
						<th>管理者権限</th>
						<th>名前</th>
						<th>ログインID</th>
						<th>ログインパスワード</th>
						<th>宛先</th>
						<th>変更する</th>
					</tr>
					<s:iterator value="userInfoList">
						<tr>
							<th><s:property value="id" /></th>
							<th><s:if test='is_admin == "1"'>
									<span>有</span>
								</s:if> <s:else>
									<span>無</span>
								</s:else></th>
							<th><s:property value="user_name" /></th>
							<th><s:property value="login_id" /></th>
							<th><s:property value="login_pass" /></th>
							<th><s:property value="address" /></th>
							<th class="center"><s:if test="is_admin == 1">
									<span>変更できません</span>
								</s:if> <s:else>
									<s:form action="UserInfoChangeAction">
										<input type="hidden" name="userId"
											value='<s:property value="id"/>'>
										<s:submit value="変更" />
									</s:form>
								</s:else></th>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserCreateAction" class="marginTop">
					<s:submit value="ユーザーの追加" class="button" />
				</s:form>
				<s:form action="UserInfoAction" class="marginTop">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="全部削除" method="delete" class="button" />
				</s:form>
				<s:if test="message != null">
					<h3>
						<s:property value="message" />
					</h3>
				</s:if>
				<s:form action="GoAdminMyPageAction" class="marginTop">
					<s:submit value="管理者画面へ戻る" class="button" />
				</s:form>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>