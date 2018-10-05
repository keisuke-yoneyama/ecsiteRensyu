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
<title>UserCreateComplete画面</title>

<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<div id="pr"></div>
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<p>新規登録完了</p>
			</div>
			<div>
				<h3>ユーザー登録が完了いたしました。</h3>
				<div>
					<s:if test='#session.containsKey("is_admin")'>
						<a href='<s:url action="GoAdminMyPageAction" />' class="marginTop">管理画面へ</a>
					</s:if>
					<s:else>
						<a href='<s:url action="HomeAction"/>'>ホーム画面へ</a>
					</s:else>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>