<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>

</head>

<body>
단건 출력 - <div id="one"></div><br>
<script type="text/javascript">
$(function(){
 	 $.ajax({
			type : "GET",
			url : "/magazine/view/1/",
			dataType : "JSON",
			success : function(data) {
				var strHtml = "";
				// this로 출력
                $.each(data, function () {
                	strHtml += this.subject+"<br>";
                });
				$("#one").empty().append(strHtml);				
			}, error : function(data, textStatus, xhr) {
				alert(textStatus + "_" + xhr);
			}	
	 });
});
</script>
</body>
</html>
