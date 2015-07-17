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
리스트 출력 - <div id="list"></div><br>
<script type="text/javascript">
$(function(){
 	$.ajax({
		type : "GET",
		url : "http://localhost:8080/magazine/list/1/date",
		dataType : "JSON",
		success : function(data) {			
			var strHtml ="";				
				$.each(data["list"] ,function(index, entry){
				strHtml += entry["idx"]+"  "+entry["content_id"]+"  "+entry["user_name"]+"  "+entry["subject"]+"<br>";	
				});			
			$("#list").empty().append(strHtml);	
		}, error : function(data, textStatus, xhr) {
			alert(textStatus + "_" + xhr);
		}
	});	 
});
</script>
</body>
</html>
