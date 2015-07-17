/*******************************************************************************
 * 작 성 자 : 정성우
 * 작성일자 : 클래스파일 생성일자
 * 개요: 매거진
 * =============================================================================
 */
package com.shuim.Controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.mysql.jdbc.StringUtils;
import com.shuim.domain.MagazineCommentVo;
import com.shuim.domain.MagazineVo;
import com.shuim.service.MagazineDao;
import com.shuim.service.MemberService;
import com.shuim.util.Paging;
import com.shuim.util.StringUtil;

@Controller(value = "magazineController")
@RequestMapping("/magazine")
public class MagazineController {
    private static final Logger logger = LoggerFactory.getLogger(MagazineController.class);

    @Resource(name = "magazineDao")
    private MagazineDao magazineDao;
    
    @Resource(name="messageSource")
	private MessageSource messageSource;
    
	@Resource(name="memberService")
	private MemberService memberService;    

    //일반적인 컨텐츠 읽기 - 리스트
    @RequestMapping(value = "/magazineList.car", method = RequestMethod.GET)
    public String magazineList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        logger.info("===============> magazineList");
        
        try {
            //게시판 검색
            String categorize = request.getParameter("categorize"); 
            if(null==categorize){
            	categorize="";
            }
            String searchWord = request.getParameter("searchWord");
            if(null==searchWord){
            	searchWord="";
            }
            String array = request.getParameter("array");
            if(null==array){
            	array="";
            }
            Map mapSearch = new HashMap();
            mapSearch.put("searchWord", searchWord);
            mapSearch.put("array", array);
            mapSearch.put("categorize", categorize);
            model.addAttribute("mapSearch", mapSearch);

            //모든 컨텐츠 수
            String selectCnt = this.magazineDao.getSelectCnt(mapSearch);
            Map mapSelect = new HashMap();
            mapSelect.put("selectCnt", selectCnt);
            model.addAttribute("mapSelect", mapSelect);
            
        	//게시판 페이징
            String pageNo = request.getParameter("pageNo");
        	Map<String, Object> paging = Paging.getPageStringManagazine(selectCnt, pageNo, "10",array ,searchWord, categorize);   
        	mapSearch.putAll(paging);
        	
        	
            //컨텐츠 리스트
            List<MagazineVo> list = this.magazineDao.getSelect(mapSearch);
            
            model.addAttribute("list", list);
 
         	//사용자 정보 가져오기
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if("anonymousUser".equals(authentication.getName())) {
            } else {
                String email = session.getAttribute("userLoginInfo").toString();
            	Map resultMap = this.memberService.selectMember(email);
           		model.addAttribute("userInfo",resultMap);
            }

            return "magazine/magazineList";
        } catch (Exception e) {
    		e.printStackTrace();
    		logger.info(e.getMessage());
            return "magazine/magazineList";
        }

    }

	//일반적인 컨텐츠 읽기 - 단건
	@RequestMapping(value = "/magazineView.car", method = RequestMethod.GET)
	public String magazineView(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session)throws Exception {
        Integer idx = Integer.parseInt(request.getParameter("idx"));
        
        // 저장된 쿠키 불러오기
        Cookie cookies[] = request.getCookies();
        Map mapCookie = new HashMap();
       if(request.getCookies() != null){
         for (int i = 0; i < cookies.length; i++) {
           Cookie obj = cookies[i];
           mapCookie.put(obj.getName(),obj.getValue());
         }
       }
       // 저장된 쿠키중에 read_count 만 불러오기
       String cookie_read_count = (String) mapCookie.get("read_count");
       // 저장될 새로운 쿠키값 생성        
       String new_cookie_read_count = "|" + idx;

       // 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사
        if ( StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1 ) {
            // 없을 경우 쿠키 생성
            Cookie cookie = new Cookie("read_count", cookie_read_count + new_cookie_read_count);
            //cookie.setMaxAge(1000); // 초단위
            response.addCookie(cookie);

            // 조회수 업데이트
            this.magazineDao.updateReadCount(idx);
        }

        //컨텐츠 상세정보
        MagazineVo object = this.magazineDao.getSelectOneWrite(idx);
        
        //특수문자 제거
        object.setSubject_empty_char(StringUtil.StringReplace(object.getSubject()));
        //HTML 제거
        object.setContent_empty_html(StringUtil.metaDescriptionCut(object.getDetail(), 100, ""));
        
        
        model.addAttribute("object", object);
        
    	//사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if("anonymousUser".equals(authentication.getName())) {
        } else {
            String email = session.getAttribute("userLoginInfo").toString();
        	Map resultMap = this.memberService.selectMember(email);
       		model.addAttribute("userInfo",resultMap);
        }
	    
    	logger.info("===============> End magazineView");
		return "magazine/magazineView";
	}
	
    
    //REST-매거진 리스트 정보 읽기
    @RequestMapping(value = "/magazine/list/", method = RequestMethod.GET)
    public void List(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session)throws Exception  {
        logger.info("===============> magazineList");
        
        try {
    		String pageNo = request.getHeader("pageNo");
    		String array = request.getHeader("array");
        	
            Map mapSearch = new HashMap();
            mapSearch.put("array", array);
            model.addAttribute("mapSearch", mapSearch);

            //모든 컨텐츠 수
            String selectCnt = this.magazineDao.getSelectCnt(mapSearch);
            Map mapSelect = new HashMap();
            mapSelect.put("selectCnt", selectCnt);
            model.addAttribute("mapSelect", mapSelect);
        	        	
            //컨텐츠 리스트
        	List<Map<String, Object>> list = this.magazineDao.getSelectJson(mapSearch);
        	JSONObject obj = new JSONObject();
            obj.put("list", list);            
            System.out.println("list="+list);
            response.setContentType("application/x-json; charset=utf-8"); 
            response.getWriter().print(obj);
         } catch (Exception e) {
    		e.printStackTrace();
    		logger.info(e.getMessage());
        }

    }
    
    //REST-매거진 상세정보 읽기
	@RequestMapping(value = "/magazine/", method = RequestMethod.GET)
	public void ViewJson(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		Enumeration<String> em = request.getHeaderNames();
		 
	    while(em.hasMoreElements()){
	        String name = em.nextElement() ;
	        String val = request.getHeader(name) ;
	         
	        System.out.println(name + " : " + val) ;
	    }
		
    	try {
    		String idx = request.getHeader("idx");
    		response.setCharacterEncoding("UTF-8");
            Map<String, Object> view = this.magazineDao.getSelectJsonView(idx);
            JSONObject obj = new JSONObject();
            obj.putAll(view);            
            System.out.println("view="+view);
            response.setContentType("application/x-json; charset=utf-8"); 
            response.getWriter().print(obj);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}   
    
    //REST-매거진 삭제
	@RequestMapping(value = "/magazine/", method = RequestMethod.DELETE)
	public void DeleteJson (HttpServletRequest request, HttpServletResponse response) throws Exception {
		Enumeration<String> em = request.getHeaderNames();
		 
	    while(em.hasMoreElements()){
	        String name = em.nextElement() ;
	        String val = request.getHeader(name) ;
	         
	        System.out.println(name + " : " + val) ;
	    }	
    	try {
    		String idx = request.getHeader("idx");
    		this.magazineDao.deleteContent(idx);  
    		response.setCharacterEncoding("UTF-8");
    		JSONObject obj = new JSONObject();
            obj.put("result", "DELETE_ok");            
            response.setContentType("application/x-json; charset=utf-8"); 
            response.getWriter().print(obj);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
    //REST-매거진 등록
	@RequestMapping(value = "/magazine/", method = RequestMethod.POST)
	public void PostJson (HttpServletRequest request,HttpServletResponse response) throws Exception {
    	try {
    		Enumeration<String> em = request.getHeaderNames();
      		 
    	    while(em.hasMoreElements()){
    	        String name = em.nextElement() ;
    	        String val = request.getHeader(name) ;
    	         
    	        System.out.println(name + " : " + val) ;
    	    }
    	    String content_id = request.getHeader("content_id");
    	    String user_name = request.getHeader("user_name");
    	    String subject = request.getHeader("subject");
    	    String classification = request.getHeader("classification");
    	    String detail = request.getHeader("detail");
    	    String thumbnailFileName = request.getHeader("thumbnailFileName");
    	    String categorize = request.getHeader("categorize");
    	    String origin = request.getHeader("origin");
    	    String state = request.getHeader("state");
    	    
    	    Map mapPut = new HashMap();
    	    mapPut.put("content_id", content_id);
    	    mapPut.put("user_name", user_name);
    	    mapPut.put("subject", subject);
    	    mapPut.put("detail", detail);
    	    mapPut.put("classification", classification);
    	    mapPut.put("state", state);
    	    mapPut.put("origin", "sadf");  //헤더값 겹침
    	    mapPut.put("categorize", categorize);
    	    mapPut.put("thumbnailFileName", thumbnailFileName);
    	    
    		this.magazineDao.postContent(mapPut); 
    		response.setCharacterEncoding("UTF-8");
    		JSONObject obj = new JSONObject();
            obj.put("result", "CREATE_ok");            
            response.setContentType("application/x-json; charset=utf-8"); 
            response.getWriter().print(obj);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
    //REST-매거진 컨텐츠 수정
	@RequestMapping(value = "/magazine/", method = RequestMethod.PUT)
	public void PutJson (HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		Enumeration<String> em = request.getHeaderNames();
   		 
    	    while(em.hasMoreElements()){
    	        String name = em.nextElement() ;
    	        String val = request.getHeader(name) ;
    	         
    	        System.out.println(name + " : " + val) ;
    	    }
    	    String idx = request.getHeader("idx");
    	    String subject = request.getHeader("subject");
    	    
    	    Map mapPut = new HashMap();
    	    mapPut.put("idx", idx);
    	    mapPut.put("subject", subject);
    		this.magazineDao.putContent(mapPut);  
    		response.setCharacterEncoding("UTF-8");
    		JSONObject obj = new JSONObject();
            obj.put("result", "UPDATE_ok");            
            response.setContentType("application/x-json; charset=utf-8"); 
            response.getWriter().print(obj);	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	//
	@RequestMapping(value = "/{idx}.json", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDetailsAsJson(@PathVariable String idx) {
		return this.magazineDao.getSelectJsonView(idx);
	}
		
	
	@RequestMapping(value = "/{idx}.xml", method = RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	public MagazineVo getDetailsAsXml(@PathVariable String idx) {
		return this.magazineDao.getSelectXMLView(idx);
	}	
	

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model) {
        return "magazine/view";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        return "magazine/list";
    }    
    @RequestMapping(value = "/outside", method = RequestMethod.GET)
    public String outside(Model model) {
        return "magazine/outside";
    } 
 
    
    @Resource(name = "xstreamMarshaller")
    private XStreamMarshaller xstreamMarshaller;

    @Resource(name = "xmlView")
    private View xmlView;    
 
}

 