<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
<div class="main_top_right">
	<h2 class="hidden">로그인,로그아웃</h2>
	<c:choose>
		<c:when test="${sessionScope.userLoginInfo ne null}">
		<!-- 로그인 후 -->
		<div class="logout_box">
			<div class="top_area">
				<p class="left"><span class="name">${userInfo.name}</span>님</p>
				<p class="txt_btn logout"><a href="/member/logout.car"><span>로그아웃</span></a></p>
			</div><!--// .top_area -->
			<div class="bot_area">
				<ul>
					<li class="fir"><a href="/mypage/mypage.car"><span>마이페이지</span></a></li>
					<li class=""><a href="/mypage/mypageModMyinfoStep01.car"><span>정보 수정하기</span></a></li>
				</ul>
			</div><!--// .bot_area -->
		</div><!--// .logout_box -->								
		</c:when>
		<c:otherwise>
		<!-- 로그인 전 -->
		<form id="loginForm" name="loginForm">
		<div class="login_box">
			<p class="fm_input email"><input type="text" id="email" name="email" class="input_e" onfocus="clearImg(this)" onblur="backImg(this)" title="이메일 입력"></p>
			<p class="fm_input pw"><input type="password" id="passwd" name="passwd" class="input_e" onfocus="clearImg(this)" onblur="backImg(this)" title="비밀번호 입력"></p>
			<ul class="service_list">
				<li class="find_info">
					<a href="/member/findEmail.car">아이디 찾기</a>
					<a href="/member/findPassword.car">비밀번호 찾기</a>	
				</li>
				<li><a href="/member/register_step01.car">회원가입</a></li>
			</ul>
			<p class="txt_btn login"><a href="" onclick="login();return false;"><span>로그인</span></a></p>
		</div><!--// .login_box -->
		</form>								
		</c:otherwise>
	</c:choose>
	
	<a href="/magazine/magazineList.car?array=date&pageNo=1&categorize=&searchWord=">컨텐츠 리스트</a><br><br>
	<strong>테스트 페이지에서 Ajax를 이용한 Json 통신</strong><br>
	<a href="/magazine/list/">다중 데이터</a><br>
	<a href="/magazine/view/">다중 데이터</a><br>
	<strong>외부 데이터 제공 테스트 (다른 도메인)</strong><br>
	<a href="/magazine/outside/">외부 API 테스트</a><br>
	
</div><!--// .main_top_right -->
<script type="text/javascript">
function login(){
	if($("#email").val()=="") {
		alert("이메일이 입력되지 않았습니다");
		$("#email").focus();
		return false;
	} else if($("#passwd").val()=="") {
		alert("비밀번호가 입력되지 않았습니다");
		$("#passwd").focus();
		return false;
	} else {
		$("#loginForm").attr("method", "post");
		$("#loginForm").attr("action", "/member/loginProcess");
        $("#loginForm").submit();
	}
}
</script>
</body>
</html>
