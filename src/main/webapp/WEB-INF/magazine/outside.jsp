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
this로 출력 - <div id="one"></div><br>
<script type="text/javascript">
$(function(){
	var realUrl = location.href;
	//숏컷URL
	TwitShortUrl = "http://api.bitly.com/v3/shorten?login=allcar&apiKey=R_611c3e81a1fd4c38a1855db7b8efeac8&longUrl="+realUrl+"&format=json";
	
	$.ajax({
		url: TwitShortUrl,
		async: false,
		crossDomain:true,
		type : 'get',
		dataType : 'jsonp',
		success:function(data){
			alert(data.data.url+'==URL이 복사 되었습니다');
		}
	});
});
</script>
</body>
</html> 
