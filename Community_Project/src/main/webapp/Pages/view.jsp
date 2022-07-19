<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/view.css">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="contentWrap">
		<div class="contentArea">
			<div>
				<h2>${Contentdto.title }</h2>
				<div>
					<img alt="" src="${Contentdto.thumnail}">
				</div>
				<p>${Contentdto.content}</p>
			</div>
		</div>
		<div class="commentArea">
		<!-- 일반 댓글 쓰는 부분 -->
			<div class="commentInput">
				<form method="post" action="commentProcess.do"  onsubmit="return checkComment(this)" >
					<input type="hidden" value="${Contentdto.idx}" name="contentidx">
					<input name="writer" value="${sessionScope.user_info.user_id}" type="hidden">
					<input name="content" type="text">
					<button type="submit">댓글전송</button>
				</form>
			</div>
			<!-- 댓글을 하나하나 표시해주는 부분 -->
			<c:forEach items="${commentList}" var="comment" varStatus="loop">
				<div class="commentBox">
					<div class="commentatorInfo">
					${comment.writer}
					</div>
					<div class="commentcontent">
					${comment.content}
					</div>
					<div class="commentExtra">
						<a class="commentActive">reply</a>
						<div class="commentInput">
							<form action="subProcess.do"  method="post" onsubmit="return checkComment(this)">
								<input type="hidden" value="${Contentdto.idx}" name="contentidx">
								<input type="hidden" value="${comment.idx}" name="commentidx">
								<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
								<input type="text" name="content">
								<button type="submit">댓글전송</button>
							</form>
						</div>
					</div>
				</div>
				<div class="subCommentArea">
					<c:forEach items="${subCommentMap[comment.idx]}" var="subcomment">
						<div class="subCommnetBox">
							<div class="commentatorInfo">
							${subcomment.writer}
							</div>
							<div class="commentcontent">
							<c:if test="${!(subcomment.mention eq null)}">
								@${subcomment.mention}
							</c:if>
							${subcomment.content}
							</div>
							<div class="commentExtra">
								<a class="commentActive">reply</a>
								<div class="commentInput">
									<form action="subProcess.do" method="post" onsubmit="return checkComment(this)">
										<input type="hidden" value="${Contentdto.idx}" name="contentidx">
										<input type="hidden" value="${subcomment.commentidx}" name="commentidx">
										To<input type="text" value="${subcomment.writer}" name="mention" readonly>
										<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
										<input type="text" name="content" class="subComment">
										<button type="submit">댓글전송</button>
									</form>
								</div>
							</div>	
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="./js/view.js"></script>
</body>
</html>