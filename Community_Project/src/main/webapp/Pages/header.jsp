<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<meta charset="UTF-8">
</head>
<div class="modal_login">
	<div class="login_content">
		<form method="post" action="./login.do">
			<ul>
				<li>아이디</li>
				<li><input type="text" name="user_id"></li>
			</ul>
			<ul>
				<li>비밀번호</li>
				<li><input type="password" name="password"></li>
			</ul>
			<button>로그인</button>
			<button type="button" class="loginExit">창닫기</button>
		</form>
	</div>
</div>
<div class="modal_signUp">
	<div class="signup_content">
		<form method="post" action="./signUp.do">
			<ul>
				<li>아이디</li>
				<li><input type="text" name="user_id"></li>
			</ul>
			<ul>
				<li>비밀번호</li>
				<li><input type="password" name="password"></li>
			</ul>
			<ul>
				<li>이메일</li>
				<li><input type="text" name="user_email"></li>
			</ul>
			<ul>
				<li>이름</li>
				<li><input type="text" name="user_name"></li>
			</ul>
			<button>회원가입</button>
			<button type="button" class="signUpExit">창닫기</button>
		</form>
	</div>
</div>
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
					<c:when test="${sessionScope.user_info eq null}">
						<li><a class="loginBtn">로그인</a></li>
						<li><a class="signUpBtn">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./logOut.do">로그아웃</a></li>
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