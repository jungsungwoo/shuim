<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
							<form id="idfind" name="idfind">							
                            <div class="form_box">
                                <ul class="form">
                                    <li class="name">
										<dl>
											<dt><span class="label">이름</span></dt>
											<dd><input type="text" class="input_e" id="name" name="name" maxlength="20" title="이름 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
										</dl>
									</li>
                                    <li class="phone">
										<dl>
											<dt><span class="label">휴대폰</span></dt>
											<dd><input type="text" class="input_e" id="mobile" name="mobile" maxlength="13" title="휴대폰 입력" onFocus="clearImg(this)" onBlur="backImg(this)"></dd>
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
                                </ul>
                                <p class="btn_area"><a id="savebutton" href="" onclick="return false;" class="txt_btn type03" style="width:285px;"><span>확인</span></a></p><a href="javascript:history.back(-1);">뒤로</a>
                            </div><!--// .form_box -->
                            </form>
							<div id="msg_area" class="msg_area">
							</div><!--// .msg_area -->
	
	<script type="text/javascript">
	$(function(){ 	
		$("#mobile").keyup(function(){
			fncCheckNumber(); //숫자만 입력가능
		});
		$("#savebutton").click(function() {			
			if($('#name').val()==""){			
				alert("이름을 입력해주세요");
				$('#name').focus();
				return false;
			}
			if($('#mobile').val()==""){			
				alert("휴대폰을 입력해주세요");
				$('#mobile').focus();
				return false;
			}
			if($('#year').val()=="년도" ){
				alert("생년월일을 입력해주세요");
				$('#year').focus();
				return false;		
			}			
			if($('#month').val()=="월" ){
				alert("생년월일을 입력해주세요");
				return false;	
			} 
			if($('#day').val()=="일" ){
				alert("생년월일을 입력해주세요");
				$('#day').focus();
				return false;				
			}  
			if($('#day').val() > 31 ){
				alert("올바른 날짜를 입력해주세요");
				$('#day').focus();
				return false;	
			}
			
			$("#birthday").val($("#year").val()+$("#month").val()+$("#day").val());
			$.ajax({
				type : "POST",
				url : "/member/findEmail_ok.car",
				data : $("#idfind").serialize(),
				success : function(data) {
				    var message = jQuery(data).find("message").text();
				    var error = jQuery(data).find("error").text();					
					var strHtml ="";

				    if (error == 'false') { 
				    	if(message!=""){
				    		strHtml += "<div class='msg_box'>";
				    		strHtml += "<p class='txt'><strong>고객님께서 올라잇카에 가입한 이메일 정보는 아래와 같습니다.</strong></p>";
				    		strHtml += "<p class='email'>"+message+"</p>";
				    		strHtml += "<p class='b_desc'><span class='caution'>전체 메일 주소 확인을 원하실 경우, 고객센터 <strong class='ff_verd tel'>02-784-1201</strong> 로 전화주세요.</span></p>";
				    		strHtml += "</div>";
				    	} else if (message=="") {
				    		strHtml += "<div class='msg_box'>";
				    		strHtml += "<p class='txt'>";
				    		strHtml += "<strong>고객님 올라잇카에 회원 가입이 안되어 계시네요.<br>입력하신 이름과 생년월일을 다시 한번 확인해 주세요</strong>";
				    		strHtml += "</p>";
				    		strHtml += "</div>";				    	
					    }	
				    	$("#msg_area").empty().append(strHtml);
				    } else {
				    	alert("에러가 발생하였습니다");
				    	$(location).attr('href',"/");
				    }
				    
				}
			});			
		});
	});
	
	</script>    
</body>
</html>
