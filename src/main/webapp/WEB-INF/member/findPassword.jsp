<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
						<form id="findPasswdForm" name="findPasswdForm">
						<!-- 비밀번호 찾기 -->
						<div id="find_pw" class="center">
							<div class="form_box">
                                <ul class="form">
									<li class="id">
										<dl>
											<dt><span class="label">이메일</span></dt>
											<dd><input type="text" class="input_e"  id="email" name="email" maxlength="60" title="이름 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
										</dl>
									</li>
                                    <li class="name">
										<dl>
											<dt><span class="label">이름</span></dt>
											<dd><input type="text" class="input_e" id="name" name="name" maxlength="20" title="이름 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
										</dl>
									</li>
                                    <li class="phone">
										<dl>
											<dt><span class="label">휴대폰</span></dt>
											<dd><input type="text" class="input_e" id="mobile" name="mobile" title="휴대폰 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
										</dl>
									</li>
									<li class="birth">
										<dl>
											<dt><span class="label">생년월일</span></dt>
											<dd><input type="hidden" id="birthday2" name="birthday2">
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
                                </ul>
                                <div class="btn_area"><a id="savebutton" href="" onclick="return false;" class="txt_btn type03" style="width:285px;"><span>확인</span></a></div><a href="javascript:history.back(-1);">뒤로</a>
                            </div><!--// .form_box -->
							<div id="msg_area" class="msg_area">
							</div><!--// .msg_area -->                            
						</div><!--// .center -->
						</form>
	<script type="text/javascript">
	$(function(){ 	
		$("#mobile").keyup(function(){
			fncCheckNumber(); //숫자만 입력가능
		});
		$("#savebutton").click(function() {			
			if($('#findPasswdForm').find('#email').val()=="" ){
				alert("이메일을 입력해주세요");
				$('#findPasswdForm').find('#email').focus();
				return false;
			} else if($('#findPasswdForm').find('#name').val()=="" ){
				alert("이름을 입력해주세요");
				$('#findPasswdForm').find('#name').focus();
				return false;
			} else if($('#findPasswdForm').find('#mobile').val()=="" ){
				alert("휴대폰번호을 입력해주세요");
				$('#findPasswdForm').find('#mobile').focus();
				return false;
			}  else if($('#findPasswdForm').find('#year').val()=="년도" ){
				alert("생년월일을 입력해주세요");
				$('#findPasswdForm').find('#year').focus();
				return false;		
			}  else if($('#findPasswdForm').find('#month').val()=="월" ){
				alert("생년월일을 입력해주세요");
				return false;	
			}  else if($('#findPasswdForm').find('#day').val()=="일" ){
				alert("생년월일을 입력해주세요");
				$('#findPasswdForm').find('#day').focus();
				return false;				
			}  else if($('#findPasswdForm').find('#day').val() > 31 ){
				alert("올바른 날짜를 입력해주세요");
				$('#findPasswdForm').find('#day').focus();
				return false;			
			}  else	if($('#findPasswdForm').find(':radio[name="gender"]:checked').length < 1){
				alert("성별을 입력해주세요");			
				return false;	
			}  else {
				$("#birthday").val($("#year").val()+$("#month").val()+$("#day").val());				
				jQuery.ajax({
				    type : 'POST' , 
				    url : '/member/findPasswd_confirm_ok.car' ,
				    data : jQuery('#findPasswdForm').serialize()
				    }).done(function(data) {
				    var message = jQuery(data).find("message").text();
				    var error = jQuery(data).find("error").text();
					//alert(message);
				    if (error == 'false') { 
				    	if(message=="1") {
							$("#findPasswdForm").attr("method", "post");
							$("#findPasswdForm").attr("action", "/member/changePwd.car");
					        $("#findPasswdForm").submit();
				    	} else {
				    		alert("입력하신 정보로 가입된 내역이 없습니다");
				    	}
				    } else {
				    	alert("에러가 발생하였습니다");
				    	$(location).attr('href',"/");
				    }
				});		
			}
		});
	});
	
	</script>    
</body>
</html>
