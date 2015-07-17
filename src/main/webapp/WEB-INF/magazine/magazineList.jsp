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
                        <c:choose>
                        	<c:when test="${mapSelect.selectCnt eq '0'}">
							<li class="no_item_area">
								<span class="no_item">죄송합니다.<br>검색결과가 없습니다.</span>
							</li>                        	
                        	</c:when>     
                        	<c:otherwise>
							<c:forEach var="item" items="${list}" varStatus="status">
								<c:if test="${item.classification eq '이미지' }">
	                        	<li>
									<a href="/magazine/magazineView.car?idx=${item.idx}&pageNo=${param.pageNo}&categorize=${param.categorize}">
										<dl>
											<dt><img src="/files/magazine/${item.thumbnailFileName}" alt="${item.subject }"></dt>
											<dd>
												<p class="tit">[${item.categorize}] ${item.subject }</p>
												<p class="txt">${item.detail }</p>
												<div class="add_info">
													<p class="fir source"><span class="blue">${item.origin }</span></p>
													<p class="date"><span class="num">${fn:replace(fn:substring(item.reg_date, 0,10), '-', '.')}</span></p>
													<p class="cnt">조회 <span class="num">${item.read_count }</span></p>
													<p class="reply">댓글 <span class="num">${item.cnt }</span></p>
												</div>
											</dd>
										</dl>
									</a>
	                            </li>								
								</c:if>
								<c:if test="${item.classification eq '텍스트' }">
								<li>
									<a href="/magazine/magazineView.car?idx=${item.idx}&pageNo=${param.pageNo}&categorize=${param.categorize}">
										<dl class="no_thumb">
											<dt>썸네일 이미지 없음</dt>
											<dd>
												<p class="tit">[${item.categorize}] ${item.subject }</p>
												<p class="txt">${item.detail }</p>
												<div class="add_info">
													<p class="fir source"><span class="blue">${item.origin }</span></p>
													<p class="date"><span class="num">${fn:replace(fn:substring(item.reg_date, 0,10), '-', '.')}</span></p>
													<p class="cnt">조회 <span class="num">${item.read_count }</span></p>
													<p class="reply">댓글 <span class="num">${item.cnt }</span></p>
												</div>
											</dd>
										</dl>
									</a>
	                            </li>								
								</c:if>
							</c:forEach>
							</c:otherwise>
						</c:choose>
	                    <c:if test="${mapSelect.selectCnt > 10}">
							<div class="paginate">				
							${mapSearch.pageStr}				
							</div><!--// .paging -->
	                    </c:if>     

</body>
</html>
