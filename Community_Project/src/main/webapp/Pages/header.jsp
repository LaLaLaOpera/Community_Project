<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="./css/header.css">
<body>
	<div class="headerWrap">
		<nav class="navWrap">
			<h2 class="logo" onclick="location.href='index.do?Start=1'">logo</h2>
			<div class="searchWrap">
				<form class="searchFrm">
					<input type="text" class="search_bar">
					<button class="searchBtn"><img src="./images/header/searchBtn.png"></button>
				</form>
			</div>
			<div class="header_menu">
				<ul>
				<c:choose>
					<c:when test="${sessionScope.user_id eq null}">
						<li><a href="">로그인</a></li>
						<li><a href="">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="">기타</a></li>
						<li><a href="">등등</a></li>
						<li><a href="">필요한기능</a></li>
					</c:otherwise>
				</c:choose>
					<li>
						<button type="button" id="AccordionBtn">아코디언 버튼</button>
					</li>
				</ul>
			</div>
		</nav>
		<div class="Accordion off" id="AccordionMenu">
			<ul>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
			</ul>
		</div>
	</div>
	<script src="./js/header.js"></script>
</body>
</html>