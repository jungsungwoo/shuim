<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>

<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>

					<form id="registerForm" name="registerForm">
						<div class="center">
							<!-- 이용약관 -->
							<h4 class="h4_tit">이용약관</h4>
							<p class="agree"><input type="checkbox" class="jq_btn" id="agree_clause" name="agree_clause"><label for="agree_clause">위의 <strong>이용약관</strong>에 동의합니다.</label></p>
							
							<!-- 개인정보 수집 및 이용동의 -->
							<h4 class="h4_tit marT35">개인정보 수집 및 이용동의</h4>
							<div class="policy_box">								
							<p class="agree"><input type="checkbox" class="jq_btn" id="agree_privacy" name="agree_privacy"><label for="agree_privacy">위의 <strong>개인정보 보호를 위한 이용자 동의사항</strong>에 동의합니다.</label></p>
							
							<div class="btn_area">
								<a href="#" onclick="goStep02(); return false;"class="txt_btn type01" style="width:105px;"><span>약관동의</span></a>
								<a href="/" class="txt_btn type02 marL05" style="width:105px;"><span>취소</span></a>
							</div>							

						</div><!--// .center -->
					</div><!--// .conts_box -->
					</form>
	<script type="text/javascript">
	function goStep02(){
		if(($('input:checkbox[id="agree_clause"]').is(":checked") == false) && ($('input:checkbox[id="agree_privacy"]').is(":checked") == false) ){
			alert("이용약관, 개인정보 수집 및 이용 동의를 해주세요");
			return false;
		} else if($('input:checkbox[id="agree_clause"]').is(":checked") == false) {
			alert("이용약관을 동의해주세요");
			return false;
		} else if($('input:checkbox[id="agree_privacy"]').is(":checked") == false) {
			alert("개인정보 수집 및 이용 동의를 해주세요");
			return false;
		} else {
			$("#registerForm").attr("method", "post");
			$("#registerForm").attr("action", "/member/register_step02.car");
	        $("#registerForm").submit();
		}
	}
	</script>
</body>
</html>
