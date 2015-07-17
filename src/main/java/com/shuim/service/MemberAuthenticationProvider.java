package com.shuim.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
public class MemberAuthenticationProvider implements AuthenticationProvider {
	
	@Resource(name="memberService")
	private MemberService memberService;	
	
    @Autowired 
    private PasswordEncoder passwordEncoder;
	
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
         
        String email = (String)authentication.getPrincipal();     
        String passwd = (String)authentication.getCredentials();
       
        //비밀번호 암호화
        passwd = passwordEncoder.encodePassword(passwd, null);
        
        Map searchMap = new HashMap();
        searchMap.put("email", email);
        searchMap.put("passwd", passwd);
        
        Map resultMap = this.memberService.checkMember(searchMap);
        if(null==resultMap){        	

            System.out.println("사용자 크리덴셜 정보가 틀립니다. 에러가 발생합니다.");            
            throw new BadCredentialsException("Bad credentials");
        }else{
            System.out.println("정상 로그인입니다.");            
        	String name = resultMap.get("name").toString();
        	String mobile= resultMap.get("mobile").toString();
        	String birthday= resultMap.get("birthday").toString();
        	String gender= resultMap.get("gender").toString();
        	String last_login= resultMap.get("last_login").toString();
        	String login_count= resultMap.get("login_count").toString();
        	String reg_date= resultMap.get("reg_date").toString();
        	String state= resultMap.get("state").toString();
        	String drop_date= resultMap.get("drop_date").toString();
        	String drop_reason= resultMap.get("drop_reason").toString();	
        	
        	//마지막 로그인 이력
        	this.memberService.updateUserLoginLog(email);
        	
        	
            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
             
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(email, passwd, roles);
            result.setDetails(new MemberLogin ( email, passwd, name, mobile, birthday, gender, last_login, login_count, reg_date, state, drop_date, drop_reason));
            

            return result;   
        }
    }

}
