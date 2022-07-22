<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Main Page</title>
<link href="./css/index.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header_buffer">	
	</div>
	<div class="topContent">
		${dailyTop}
		${weeklyTop}
		${monthlyTop}
	</div>
	<div class="indexWrap">	
		<div class="contentWrap">
			<c:forEach items="${boardLists}" var="board">
				<div class="cardWrapper">
					<a>r/${board.board_cat}</a><p>posted by ${board.writer}</p>
					<a href="view.do?idx=${board.idx }">${board.title}</a>
					<div class="imageWrapper">
						<img class="thumb" src="${board.thumnail}">
					</div>
				</div>	
			</c:forEach>
			 <div id="endOfcontents">
			</div>
		</div>
		<div class="rightsideWrap">
		기타정보를 넣어둔다.
		</div>
	</div>

</body>
</html>