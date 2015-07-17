package com.shuim.util;

import java.util.HashMap;
import java.util.Map;

public class Paging {
	
	public Paging() {
	}
	
	public static Map<String,Object> getPageStringDefault(String totcnt, String nPage,String sPage) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
	
	public static Map<String,Object> getPageString(String totcnt, String nPage,String sPage) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"#counting' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"#counting'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"#counting' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
	
	
	public static Map<String,Object> getPageStringEventRelease(String totcnt, String nPage,String sPage, String state) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"&state="+state+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&state="+state+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"&state="+state+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}	
	public static Map<String,Object> getPageStringEvent(String totcnt, String nPage,String sPage, String event_state) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"&event_state="+event_state+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&event_state="+event_state+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"&event_state="+event_state+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
    
	public static Map<String,Object> getPageStringUsedcarKin(String totcnt, String nPage,String sPage, String array, String searchWord) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"&array="+array+"&searchWord="+searchWord+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&array="+array+"&searchWord="+searchWord+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"&array="+array+"&searchWord="+searchWord+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
	
	public static Map<String,Object> getPageStringManagazine(String totcnt, String nPage,String sPage, String array, String searchWord, String categorize) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"&array="+array+"&searchWord="+searchWord+"&categorize="+categorize+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&array="+array+"&searchWord="+searchWord+"&categorize="+categorize+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"&array="+array+"&searchWord="+searchWord+"&categorize="+categorize+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}

	public static Map<String,Object> getPageStringManagazineComment(String totcnt, String nPage,String sPage, Integer idx, String categorize) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		
		pageStr.append("<a href='?pageNo="+prevPage+"&idx="+idx+"&categorize="+categorize+"#point' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&idx="+idx+"&categorize="+categorize+"#point'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		
		pageStr.append("<a href='?pageNo="+nextPage+"&idx="+idx+"&categorize="+categorize+"#point' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");
	

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
	
	public static Map<String,Object> getPageString(String totcnt, String nPage,String sPage, String idx) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		

		pageStr.append("<a href='?pageNo="+prevPage+"&idx="+idx+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&idx="+idx+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		

		pageStr.append("<a href='?pageNo="+nextPage+"&idx="+idx+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}
	
	public static Map<String,Object> getPageStringCustomCenter(String totcnt, String nPage,String sPage, String idx, String type) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		

		pageStr.append("<a href='?pageNo="+prevPage+"&sch_type=classification&sch_value="+type+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&sch_type=classification&sch_value="+type+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		

		pageStr.append("<a href='?pageNo="+nextPage+"&sch_type=classification&sch_value="+type+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}	

	public static Map<String,Object> getPageStringPostDong(String totcnt, String nPage,String sPage, String dong) {
		
		int totalCount = stringToNumber(totcnt);
		int nowPage = stringToNumber(nPage);
		int pageSize = stringToNumber(sPage);
	
		int startPage = 0;
		int selectPage = 1;
		
		
		if(nowPage > 0){
			selectPage = nowPage;
		}else{
			nowPage = 1;
		}
		
		if(selectPage%10==0){
			startPage = selectPage-9;
		}else{
			startPage = selectPage-(selectPage%10) + 1;
		}
		
		
		int endPage = startPage + 9;
		int prevPage = 1;
		int nextPage = nowPage + 10; // > 클릭 시 이동되는 페이지 수
		if(nowPage>1){
			if(nowPage < 10) {
				prevPage = 1; //현재 페이지가 10보다 작을 경우 1페이지로 이동
			} else {				
				prevPage = nowPage - 10;	// < 클릭 시 이동되는 페이지 수
			}			
		}
		int totalPage = totalCount / pageSize;
		
		if(totalCount%pageSize!=0) totalPage++;
		
		if(totalPage == nextPage){
			nextPage = totalPage;
		}
		
		if (totalPage <= endPage){
			endPage = totalPage;
		}

		StringBuffer pageStr = new StringBuffer();
		

		pageStr.append("<a href='?pageNo="+prevPage+"&dong="+dong+"' class='pre'><img src='/resources/images/btn/btn_page_prev.png' alt='이전페이지'></a>");
				
		
		if(totalPage>1){
			for(int i=startPage; i < endPage+1 ; i++){
				if(selectPage == i){
					pageStr.append("<strong>"+i+"</strong>");
				}else{
					pageStr.append("<a href='?pageNo="+i+"&dong="+dong+"'  data-ajax='false'>"+i+"</a>");
				}
			}
		}else{
			pageStr.append("<strong>"+1+"</strong>");
		}

		if(totalPage <nextPage) { // > 클릭 시 다음10페이지보다 전체페이지가 작을 경우 
			nextPage = totalPage;
		}
		

		pageStr.append("<a href='?pageNo="+nextPage+"&dong="+dong+"' class='next'><img src='/resources/images/btn/btn_page_next.png' alt='다음페이지'></a>");

		int limit = 0 ;
		int offset = pageSize * (selectPage-1) + 1;
		
		if(selectPage==1){
			limit = pageSize;
		}else{
			limit = pageSize * nowPage;
		}
		
		Map<String,Object> pageable = new HashMap<String,Object>();
		pageable.put("startRow", String.valueOf(offset-1)); //limit은 0부터 인식하므로 -1
		pageable.put("endRow", String.valueOf(limit));
		pageable.put("totCnt", totcnt);
		pageable.put("pageSize", pageSize);
		pageable.put("pageStr", pageStr.toString());
		
		return pageable;	
	}	

	
	
	public static int stringToNumber(String number){
		int num = 0;
		if(null!=number && !"".equals(number) && !"null".equals(number)){
			num = Integer.parseInt(number);
		}
		return num;
	}
}