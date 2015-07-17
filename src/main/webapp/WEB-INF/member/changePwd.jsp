<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
							<p class="t_desc"><strong>새로운 비밀번호로 재설정 해주세요.</strong><br><span class="desc_s">비밀번호는 6~16자 영문 대소문자, 숫자, 특수문자로 설정 가능합니다. (영문 대소문자 구분)</span></p>
							<form id="updatePasswd" name="updatePasswd">
							<input type="hidden" id="email" name="email" value="${email }">
                            <div class="form_box">
                                <ul class="form">
                                    <li class="pw">
										<input type="password" class="input_e" id="passwd" name="passwd" maxlength="16" title="비밀번호 입력" onFocus="clearImg(this)" onBlur="backImg(this)">
										<span  id="passwdCheck01" class="check abs"></span>
									</li>
									<li class="pwConfirm">
										<input type="password" class="input_e" id="passwdFirm" name="passwdFirm" maxlength="16" title="비밀번호 재확인" onFocus="clearImg(this)" onBlur="backImg(this)">
										<span  id="passwdCheck02" class="check abs"></span>
									</li>
                                </ul>
								<div class="btn_area"><a href="#" onclick="goUpdatePasswd(); return false;" class="txt_btn type03" style="width:285px;"><span>확인</span></a></div>                                
                            </div><!--// .form_box -->
                            </form>

	<script type="text/javascript">
	$(function(){
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
	});
	function goUpdatePasswd(){
        // 영문, 숫자, 특수문자 2종 이상 혼용
        var chk = 0;
        if($('#passwd').val().search(/[0-9]/g) != -1 ) chk ++;
        if($('#passwd').val().search(/[a-z]/ig)  != -1 ) chk ++;
        if($('#passwd').val().search(/[!@#$%^&*()?_~]/g)  != -1  ) chk ++;
		
		if($('#passwd').val()=="" ){
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
		}  else {
			jQuery.ajax({
			    type : 'POST' , 
			    url : '/member/passwdUpdate_ok.car' ,
			    data : jQuery('#updatePasswd').serialize()
			    }).done(function(data) {
			    var message = jQuery(data).find("message").text();
			    var error = jQuery(data).find("error").text();

			    if (error == 'false') {
		    		alert(message);
		    		$(location).attr('href',"/member/login.car");
			    } else {
			    	alert("에러가 발생하였습니다");
			    	$(location).attr('href',"/");
			    }
			    });	
		}
	}
	
	</script>
</body>
</html>
