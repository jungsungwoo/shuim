<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ko">
<head>
<title>프로젝트</title>
<script src="/resources/js/jquery-1.11.1.js"></script>
</head>

<body>
<a href="javascript:history.back(-1);">뒤로</a>
카테고리:${object.categorize }<br>
제목:${object.subject }<br>
날짜:${fn:replace(fn:substring(object.reg_date, 0,10), '-', '.')}<br>
조회수:${object.read_count }<br>
댓글:${mapSelect.selectCnt}<br>
출처:${object.origin }<br>
내용:${object.detail }<br>
</body>
</html>
