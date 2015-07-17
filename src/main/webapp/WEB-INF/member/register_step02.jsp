<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
<script src="/module/js/common.js"></script>
</head>

<body>

					<form id="registerForm" name="registerForm">
                    <div class="conts_box">
						<div class="center">
							<div class="form_box">
                                <ul class="form">
									<li class="name">
										<dl>
											<dt><span class="label">이름</span></dt>
											<dd><input type="text" class="input_e" id="name" name="name" title="이름 입력" maxlength="20" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
										</dl>
									</li>
									<li class="id">
										<dl>
											<dt><span class="label">이메일</span></dt>
											<dd><input type="hidden" id="emailCheck" name="emailCheck" value="default">
												<input type="text" class="input_e" id="email" name="email" title="이메일 입력" onFocus="clearImg(this)" onBlur="backImg(this)"><a href="#" onClick="duplicateMember();">중복확인</a>
												<p class="desc">입력해 주신 이메일은 올라잇카 로그인 시, 활용 됩니다.</p>
											</dd>
										</dl>
									</li>
                                    <li class="phone">
										<dl>
											<dt><span class="label">휴대폰</span></dt>
											<dd>
												<input type="text" class="input_e" id="mobile" name="mobile" maxlength="13" title="휴대폰 입력" onFocus="clearImg(this)" onBlur="backImg(this)">
												<p class="desc">- 없이 입력해 주세요. 예) 01011112222</p>
											</dd>
										</dl>
									</li>
									<li class="pw">
										<dl>
											<dt><span class="label">비밀번호</span></dt>
											<dd>
												<input type="password" class="input_e" id="passwd" name="passwd" maxlength="16" title="비밀번호 입력" onFocus="clearImg(this)" onBlur="backImg(this)">
												<p class="desc type02">영문 대소문자, 숫자, 특수문자 6~16자로 설정해주세요.(영문 대소문자 구분)</p>
												<span id="passwdCheck01" class="check abs"></span>
											</dd>
										</dl>
									</li>
									<li class="pwConfirm">
										<dl>
											<dt class="type02"><span class="label">비밀번호<br>재확인</span></dt>
											<dd>
												<input type="password" class="input_e" id="passwdFirm" name="passwdFirm" maxlength="16" title="비밀번호 재확인" onFocus="clearImg(this)" onBlur="backImg(this)">
												<span id="passwdCheck02" class="check abs"></span>
											</dd>
										</dl>
									</li>
									<li class="birth">
										<dl>
											<dt><span class="label">생년월일</span></dt>
											<dd><input type="hidden" id="birthday" name="birthday">
												<input type="text" class="input_e year" id="year" name="year" title="년도 입력" maxlength="4" value="년도" onFocus="clearText(this)" onBlur="backText(this)">
												<select id="month" name="month" title="월 선택" class="month">
													<option selected>월</option>
													<option value="01">1</option>
													<option value="02">2</option>
													<option value="03">3</option>
													<option value="04">4</option>
													<option value="05">5</option>
													<option value="06">6</option>
													<option value="07">7</option>
													<option value="08">8</option>
													<option value="09">9</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
												</select>
												<input type="text" class="input_e day" id="day" name="day" title="날짜 입력" maxlength="2" value="일" onFocus="clearText(this)" onBlur="backText(this)">
											</dd>
										</dl>
									</li>
									<li class="sex">
										<dl>
											<dt class="type02"><span class="label">성별</span></dt>
											<dd>
												<span><input type="radio" name="gender" id="male" class="jq_btn" value="1"><label for="male">남자</label></span>
												<span class="marL50"><input type="radio" name="gender" id="female" class="jq_btn" value="2"><label for="female">여자</label></span>
											</dd>
										</dl>
									</li>
									<li class="nickname">
										<dl>
											<dt><span class="label">닉네임</span></dt>
											<dd><input type="hidden" id="nickCheck" name="nickCheck" value="default">
												<input type="text" class="input_e" id="nick" name="nick" maxlength="10" title="닉네임 입력" onFocus="clearImg(this)" onBlur="backImg(this)"><a href="#" onClick="duplicateNick();">중복확인</a>
												<p class="desc">한글, 영문 대소문자, 숫자로 최대 10자로 설정해 주세요.<br>(영문 대소문자 구분)</p>
											</dd>
										</dl>
									</li>
                                </ul>
                                <div class="btn_area">
									<a href="#" onclick="goStep03(); return false;" class="txt_btn type01" style="width:105px;"><span>가입하기</span></a>
									<a href="/" class="txt_btn type02 marL05" style="width:105px;"><span>취소</span></a>
								</div>

                            </div><!--// .form_box -->
						</div><!--// .center -->
					</div><!--// .conts_box -->
					</form>

	<script type="text/javascript">
	$(function(){
		$("#mobile").keyup(function(){
			fncCheckNumber(); //숫자만 입력가능
		});
		
		$('#passwd').blur(function() {
	        var chk = 0;
	        if($('#passwd').val().search(/[0-9]/g) != -1 ) chk ++;
	        if($('#passwd').val().search(/[a-z]/ig)  != -1 ) chk ++;
	        if($('#passwd').val().search(/[!@#$%^&*()?_~]/g)  != -1  ) chk ++;

			if((!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,16}$/.test($('#passwd').val()) || (chk < 2))) { 
				$('#passwdCheck01').html("비밀번호 규칙을 다시 한번 확인해주세요");
				$('#passwdCheck01').addClass("ok");
			} else {
				$('#passwdCheck01').html("");
				$('#passwdCheck01').removeClass("ok");
			}			
		});
		
		$('#passwdFirm').blur(function() {
			if($('#passwd').val() != $('#passwdFirm').val()) { 
				$('#passwdCheck02').html("비밀번호가 불일치 합니다. 다시 한번 입력해 주세요");
				$('#passwdCheck02').addClass("no");
			} else {
				$('#passwdCheck02').html("");
				$('#passwdCheck02').removeClass("no");
			}			
		});
		
		$('#nick').blur(function() {

			if((!/^[a-zA-Z0-9가-힣]{1,10}$/.test($('#nick').val()))) { 
				alert("닉네임 규칙을 다시 한번 확인해주세요");
				$('#nick').focus();
			}			
		});
		
	});

	function duplicateMember() {
		if($('#email').val()=="" ){
			alert("이메일을 입력해주세요");
			$('#email').focus();
			return false;
		}
		jQuery.ajax({
		    type : 'POST' , 
		    url : '/member/member_duplicate_ok.car' ,
		    data : jQuery('#registerForm').serialize()
		    }).done(function(data) {
		    var message = jQuery(data).find("message").text();
		    var error = jQuery(data).find("error").text();
			//alert(message);
		    if (error == 'false') { 
		    	if("사용 가능한 아이디 입니다"==message) {
		    		$('#emailCheck').val("ok");
		    	} else {
		    		$('#emailCheck').val("no");
		    	}
		    	
		    	alert(message);		    	
		    } else {
		    	alert("에러가 발생하였습니다");
		    }
		    });			
	}
	
	function duplicateNick() {
		if($('#nick').val()=="" ){
			alert("닉네임을 입력해주세요");
			$('#nick').focus();
			return false;
		}
		jQuery.ajax({
		    type : 'POST' , 
		    url : '/member/nick_duplicate_ok.car' ,
		    data : jQuery('#registerForm').serialize()
		    }).done(function(data) {
		    var message = jQuery(data).find("message").text();
		    var error = jQuery(data).find("error").text();
			//alert(message);
		    if (error == 'false') { 
		    	if("사용 가능한 닉네임 입니다"==message) {
		    		$('#nickCheck').val("ok");
		    	} else {
		    		$('#nickCheck').val("no");
		    	}
		    	
		    	alert(message);		    	
		    } else {
		    	alert("에러가 발생하였습니다");
		    }
		    });			
	}	
	
	
	function goStep03(){
        // 영문, 숫자, 특수문자 2종 이상 혼용
        var chk = 0;
        if($('#passwd').val().search(/[0-9]/g) != -1 ) chk ++;
        if($('#passwd').val().search(/[a-z]/ig)  != -1 ) chk ++;
        if($('#passwd').val().search(/[!@#$%^&*()?_~]/g)  != -1  ) chk ++;
		
		if($('#name').val()=="" ){
			alert("이름을 입력해주세요");
			$('#name').focus();
			return false;
		} else if($('#email').val()=="" ){
			alert("이메일을 입력해주세요");
			$('#email').focus();
			return false;
		} else if($('#mobile').val()=="" ){
			alert("휴대폰번호을 입력해주세요");
			$('#mobile').focus();
			return false;
		}  else if($('#passwd').val()=="" ){
			alert("비밀번호를 입력해주세요");
			$('#passwd').focus();
			return false;
		}  else if($('#passwdFirm').val()=="" ){
			alert("비밀번호 재확인을 입력해주세요");
			$('#passwdFirm').focus();
			return false;
		}  else	if($('#passwd').val() != $('#passwdFirm').val()){
			alert("비밀번호가 불일치 합니다. 다시 한번 입력해 주세요");			
			return false;	
	        // 길이
		}  else if(!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,16}$/.test($('#passwd').val())) { 
	        alert("비밀번호 규칙을 다시 한번 확인해주세요");
	        $('#passwd').focus();
	        return false;
		}  else if(chk < 2) {
            alert("비밀번호는 숫자, 영문, 특수문자를 두가지이상 혼용하여야 합니다."); 
            return false;				
		}  else if($('#year').val()=="년도" ){
			alert("생년월일을 입력해주세요");
			$('#year').focus();
			return false;		
		}  else if($('#month').val()=="월" ){
			alert("생년월일을 입력해주세요");
			return false;	
		}  else if($('#day').val()=="일" ){
			alert("생년월일을 입력해주세요");
			$('#day').focus();
			return false;				
		}  else if($('#day').val() > 31 ){
			alert("올바른 날짜를 입력해주세요");
			$('#day').focus();
			return false;			
		}  else	if($(':radio[name="gender"]:checked').length < 1){
			alert("성별을 입력해주세요");			
			return false;	
		} else if($('#nick').val()=="" ){
			alert("닉네임을 입력해주세요");
			$('#nick').focus();
			return false;
		}  else	if("default"==$('#emailCheck').val()){
			alert("이메일을 중복 확인하시기 바랍니다");
			$('#email').focus();
			return false;	
		}  else	if("default"==$('#nickCheck').val()){
			alert("닉네임을 중복 확인하시기 바랍니다");
			$('#nick').focus();
			return false;			
		}  else	if("no"==$('#emailCheck').val()){
			alert("이미 사용중인 이메일입니다. 다시 중복확인하시기 바랍니다");
			$('#email').focus();
			return false;	
		}  else	if("no"==$('#nickCheck').val()){
			alert("이미 사용중인 닉네임입니다. 다시 중복확인하시기 바랍니다");
			$('#nick').focus();
			return false;
		}  else {
			$("#birthday").val($("#year").val()+$("#month").val()+$("#day").val());
			$("#registerForm").attr("method", "post");
			$("#registerForm").attr("action", "/member/register_step03.car");
	        $("#registerForm").submit();
		}
	}
	</script>	
</body>
</html>
