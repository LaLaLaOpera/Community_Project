<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/view.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="contentWrap">
		<div class="contentArea">
			<div>
				<p>글부분</p>
				${Contentdto.title }
				<img alt="" src="${Contentdto.thumnail}">
				${Contentdto.content}
			</div>
		</div>
		<div class="commentArea">
		<!-- 일반 댓글 쓰는 부분 -->
			<div class="commentInput">
				<form method="post" action="commentProcess.do"  onsubmit="return checkComment(this)" >
					<input type="hidden" value="${Contentdto.idx}" name="contentidx">
					<input name="writer" value="${sessionScope.user_id}" type="hidden">
					<input name="content" type="text">
					<button type="submit">댓글전송</button>
				</form>
			</div>
			<!-- 댓글을 하나하나 표시해주는 부분 -->
			<c:forEach items="${commentList}" var="comment" varStatus="loop"> -->
				<div class="commentBox">
					<div class="commentatorInfo">
					${comment.writer}
					</div>
					<div class="commentcontent">
					${comment.content}
					</div>
					<div class="commentExtra">
						<button>댓글쓰기</button>
						<div class="commentInput">
							<form action="subProcess.do"  method="post" onsubmit="return checkComment(this)">
								<input type="hidden" value="${Contentdto.idx}" name="contentidx">
								<input type="hidden" value="${comment.idx}" name="commentidx">
								<input type="hidden" value="${sessionScope.user_id}" name="writer">
								<input type="text" name="content">
								<button type="submit">댓글전송</button>
							</form>
						</div>
					</div>
				</div>
				<div class="subCommentArea">
				<p>-----------서브 코멘트 영역-------------------</p>
					<c:forEach items="${subCommentMap[comment.idx]}" var="subcomment">
						<div class="commentatorInfo">
						${subcomment.writer}
						</div>
						<div class="commentcontent">
						${subcomment.content}
						</div>
						<div class="commentExtra">
							<button>댓글쓰기</button>
							<div class="commentInput">
								<form action="subProcess.do" method="post" onsubmit="return checkComment(this)">
									<input type="hidden" value="${Contentdto.idx}" name="contentidx">
									<input type="hidden" value="${subcomment.commentidx}" name="commentidx">
									<input type="hidden" value="${subcomment.writer}" name="mention">
									<input type="hidden" value="${sessionScope.user_id}" name="writer">
									<span>@${subcomment.writer}</span>
									<input type="text" name="content" class="subComment">
									<button type="submit">댓글전송</button>
								</form>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		function checkComment(frm){
			if(frm.content.value == ""){
				alert("빈 값을 제출할 수 없습니다.");
				frm.content.focus();
				return false;
			}
		}
	</script>
</body>
</html>