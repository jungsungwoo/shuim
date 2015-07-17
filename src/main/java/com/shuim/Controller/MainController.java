/*******************************************************************************
 * 작 성 자 : 정성우
 * 작성일자 : 클래스파일 생성일자
 * 개요: 메인화면
 * =============================================================================
 */
package com.shuim.Controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuim.service.MemberService;

@Controller(value = "mainController")
public class MainController {
	private static final Logger logger=LoggerFactory.getLogger(MainController.class);

    
	@Resource(name="memberService")
	private MemberService memberService;
	
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpServletRequest request, Locale locale, Model model, HttpSession session, Principal principal, HttpServletResponse response) {
        try {
            
            //=============로그인 처리===================//
            
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if("anonymousUser".equals(authentication.getName())) {
            } else {
                String email = session.getAttribute("userLoginInfo").toString();
            	Map resultMap = this.memberService.selectMember(email);
           		model.addAttribute("userInfo",resultMap);
            }
            
    		return "main";
        } catch (Exception e) {
    		e.printStackTrace();
    		logger.info(e.getMessage());
    		return "main";
        } 	

    }



}
