<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
					<form id="loginForm" name="loginForm">
                    <h2 class="h2_tit"><img src="/resources/images/login/tit_login.png" alt="로그인"></h2>
                    <div class="conts_box">
                        <div class="left login_box">
							<p class="t_desc"><span class="desc_s">올라잇카에 가입하신 이메일과 비밀번호를 입력해 주세요.<br>비밀번호는 대소문자를 구분합니다.</span></p>
                            <div class="form_box">
                                <ul class="form">
                                    <li class="id"><input type="text" class="input_e" id="email" name="email" title="회원 가입 시, 등록한 이메일 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></li>
                                    <li class="pw"><input type="password" class="input_e" id="passwd" name="passwd" title="비밀번호 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></li>
                                </ul>
                                <div class="btn_area"><a href="#" onclick="login();return false;" class="txt_btn type01" style="width:305px;"><span>로그인</span></a></div>                                
                            </div><!--// .form_box -->
							<ul class="join_find">
								<li class="join_mem"><span class="txt">올라잇카 회원이 아니세요?</span><span class="btn"><a href="/member/register_step01.car">회원가입하기</a></span></li>
								<li class="find_info"><span class="txt">이메일 / 비밀번호를 잊어버리셨나요?</span><span class="btn"><a href="/member/findEmail.car">이메일 / 비밀번호 찾기</a></span></li>
							</ul>
                        </div><!--// .left -->
						<div class="right">
							<ul class="multiSlider rsDefault">
							<c:forEach var="item" items="${loginBanner }" varStatus="status">
								<li>
									<c:if test="${item.linkUrl eq '' }"><img src="/files/banner/${item.thumbnailFileName }" alt="${item.thumbnailFileName }" class="rsImg"></c:if>
									<c:if test="${item.linkUrl ne '' }"><a href="${item.linkUrl }" target="${item.linkType }"><img src="/files/banner/${item.thumbnailFileName }" alt="${item.thumbnailFileName }" class="rsImg"></a></c:if>	
								</li>
							</c:forEach>
							</ul>						
							<script type="text/javascript">
							jQuery(document).ready(function($) {
								$(".conts_box .right .multiSlider").multiSlider({
									imageScaleMode : "fill",
									controlNavigation : 'none',
									fadeinLoadedSlide : false,
									navigateByClick : false,
									arrowsNav : false,
									keyboardNavEnabled : true,
									loop : true	,
									slidesSpacing : 0,
									autoPlay: {
										enabled: true,
										pauseOnHover: true,
										stopAtAction : false,
										delay : 3000
									},
									transitionSpeed : 300
								});
							});
							</script>
						</div><!--// .right -->
                    </div><!--// .conts_box -->                    
                    <input type="hidden" name="loginRedirect" value="${header.referer}" />
                    </form>
	
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
	<c:if test="${param.fail eq 'true' }">
	<script type="text/javascript">
		alert("이메일 / 비밀번호가 틀립니다. 다시 입력해 주세요");
	</script>
	</c:if>
</body>
</html>
