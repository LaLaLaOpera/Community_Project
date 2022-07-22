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
	<div class="header_buffer">	
	</div>
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
				<div class="profile_pic">
					<c:choose>
						<c:when test="${sessionScope.user_info eq null }">
							<img src="./images/view/default.png">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${sessionScope.user_info.profile_img == '1'}">
									<img src="./images/view/default.png">
								</c:when>
								<c:otherwise>
									<img src="${sessionScope.user_info.profile_img}">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="input_section">
					<form method="post" action="commentProcess.do"  onsubmit="return checkComment(this)" >
						<input type="hidden" value="${Contentdto.idx}" name="contentidx">
						<input name="writer" value="${sessionScope.user_info.user_id}" type="hidden">
						<textarea name="content"></textarea>
						<button type="submit">댓글전송</button>
					</form>
				</div>
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
				</div>
				<div class="commentExtra">
					<div>
						<span><a>추천하기</a></span>
						<span>${comment.recommanded }</span>
						<a class="commentActive">reply</a>
						<a class="subCommentAreaActive">답글 보기</a>
					</div>
					<div class="commentInput">
						<div class="profile_pic">
							<c:choose>
								<c:when test="${sessionScope.user_info eq null }">
									<img src="./images/view/default.png">
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${sessionScope.user_info.profile_img == '1'}">
											<img src="./images/view/default.png">
										</c:when>
										<c:otherwise>
											<img alt="유저 프로파일" src="${sessionScope.user_info.profile_img}">
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="input_section">
							<form method="post" action="subProcess.do"  onsubmit="return checkComment(this)" >
								<input type="hidden" value="${Contentdto.idx}" name="contentidx">
								<input type="hidden" value="${comment.idx}" name="commentidx">
								<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
								<textarea name="content"></textarea>
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
						</div>
						<div class="commentExtra">
							<div>
								<span><a>추천하기</a></span>
								<span>${subcomment.recommanded }</span>
								<a class="commentActive">reply</a>
							</div>
							<div class="commentInput">
								<div class="profile_pic">
									<c:choose>
										<c:when test="${sessionScope.user_info eq null }">
											<img src="./images/view/default.png">
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${sessionScope.user_info.profile_img == '1'}">
													<img src="./images/view/default.png">
												</c:when>
												<c:otherwise>
													<img alt="유저 프로파일" src="${sessionScope.user_info.profile_img}">
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</div>					
								<div class="input_section">
									<form action="subProcess.do" method="post" onsubmit="return checkComment(this)">
										<input type="hidden" value="${Contentdto.idx}" name="contentidx">
										<input type="hidden" value="${subcomment.commentidx}" name="commentidx">
										<input type="hidden" value="${subcomment.writer}" name="mention">
										<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
										<textarea name="content"></textarea>
										<button type="submit">댓글전송</button>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
					<c:if test="${subCommentMap[comment.idx].size() == 0}">
						<p>답글이 없습니다.</p>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="./js/view.js"></script>
</body>
</html>