<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品一覧</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>商品一覧画面</h1>
			</div>
			<s:if test="itemInfoList.isEmpty()">
				<h2>検索結果がありません。</h2>
			</s:if>
			<s:else>
				<div id="itemList">
					<s:iterator value="#session.itemInfoList">
						<div class="itemListBox">
							<ul>
								<!-- 								<li><a -->
								<%-- 									href='<s:url action="ItemDetailsAction"> --%>
								<%-- 							<s:param name="itemId" value="%{id}"/></s:url>'> --%>
								<!-- 										<img class="itemImage" -->
								<%-- 										src='<s:property value="image_file_path"/><s:property value="image_file_name"/>'> --%>
								<!-- 								</a></li> -->
								<li><s:property value="item_name" /></li>
								<li><s:property value="item_price" />円</li>
							</ul>
						</div>
					</s:iterator>
				</div>

				<div class="center">
					<ul id="pageNo">
						<s:if test="#session.hasPreviousPage">
							<li class="page"><a
								href='<s:url action="ItemListAction">
							<s:param name="PageNo" value="#session.previousPageNo" />
							<s:param name="retrievalFlg" value="%{retrievalFlg}" />
							<s:param name="keywords" value="%{keywords}" />
							</s:url>'>&laquo;</a>
							</li>
						</s:if>
						<s:iterator begin="1" end="#session.totalPageNum" status="pageNo">
							<s:if test="#session.currentPageNo == #pageNo.count">
								<li class="pageAct"><s:property value="%{#pageNo.count}" /></li>
							</s:if>
							<s:else>
								<li class="page"><a
									href='<s:url action="ItemListAction">
								<s:param name="PageNo" value="%{#pageNo.count}" />
								<s:param name="retrievalFlg" value="%{retrievalFlg}" />
								<s:param name="keywords" value="%{keywords}" />
								</s:url>'><s:property
											value="%{#pageNo.count}" /></a></li>
							</s:else>
						</s:iterator>
						<s:if test="#session.hasNextPage">
							<li class="page"><a
								href='<s:url action="ItemListAction">
							<s:param name="PageNo" value="#session.nextPageNo" />
							<s:param name="retrievalFlg" value="%{retrievalFlg}" />
							<s:param name="keywords" value="%{keywords}" />
							</s:url>'>&raquo;</a>
							</li>
						</s:if>
					</ul>
				</div>
			</s:else>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>