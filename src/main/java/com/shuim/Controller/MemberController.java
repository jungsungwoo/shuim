package com.shuim.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.shuim.domain.MemberVo;
import com.shuim.service.MemberService;
import com.shuim.util.XmlResult;
import com.thoughtworks.xstream.XStream;


@Controller(value="memberController")
@RequestMapping("/member")

public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberService memberService;

	
    @Resource(name = "xstreamMarshaller")
    private XStreamMarshaller xstreamMarshaller;

    @Resource(name = "xmlView")
    private View xmlView;
    
    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @RequestMapping(value = "/register_step01.car", method = RequestMethod.GET)
    public String register_step01(Model model) {
    	
        return "member/register_step01";
    }	
    @RequestMapping(value = "/register_step02.car", method = RequestMethod.POST)
    public String register_step02(Model model) {
     	
        return "member/register_step02";
    }
    @RequestMapping(value = "/register_step03.car", method = RequestMethod.POST)
    public String register_step03(@ModelAttribute("memberVo") @Valid MemberVo memberVo, Model model) {    	
    	
    	try {
        	memberVo.setPasswd(passwordEncoder.encodePassword(memberVo.getPasswd().toString(), null));    	
            this.memberService.addMember(memberVo);  
           
            return "member/register_step03";
    	} catch (Exception e) {
    		e.getMessage();
    		return "redirect:/";
    	}
    	

        
    }
    
	@RequestMapping(value="/member_duplicate_ok.car", method=RequestMethod.POST)
	public View member_duplicate_ok(@ModelAttribute("memberVo") @Valid MemberVo memberVo, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }        
        
        try {
            String memberCheck = this.memberService.duplicateMember(memberVo.getEmail().toString());
            if(memberCheck.equals("1")) {
            	xml.setMessage("이미 사용중인 아이디 입니다");
            } else if(memberCheck.equals("0")) {
            	xml.setMessage("사용 가능한 아이디 입니다");
            }
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView;
	}
	
	@RequestMapping(value="/nick_duplicate_ok.car", method=RequestMethod.POST)
	public View nick_duplicate_ok(@ModelAttribute("memberVo") @Valid MemberVo memberVo, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }        
        
        try {
            String memberCheck = this.memberService.duplicateNick(memberVo.getNick().toString());
            if(memberCheck.equals("1")) {
            	xml.setMessage("이미 사용중인 닉네임 입니다");
            } else if(memberCheck.equals("0")) {
            	xml.setMessage("사용 가능한 닉네임 입니다");
            }
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView;
	}
	
	@RequestMapping(value="/registerMember_ok.car", method=RequestMethod.POST)
	public View procRegisterMember(@ModelAttribute("memberVo") @Valid MemberVo memberVo, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }        
        try {
        	memberVo.setPasswd(passwordEncoder.encodePassword(memberVo.getPasswd().toString(), null));
        	
            this.memberService.addMember(memberVo);
            xml.setMessage("회원 가입이 완료되었습니다.");
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView;
	}	
	
    @RequestMapping(value = "/logout.car", method = RequestMethod.GET)
    public void logout(HttpSession session) {

        session.invalidate();
    }
    
    @RequestMapping(value = "/findEmail.car", method = RequestMethod.GET)
    public String findEmail(Model model) {
      	
        return "member/findEmail";
    }
    
    @RequestMapping(value = "/findPassword.car", method = RequestMethod.GET)
    public String findPassword(Model model) {
     	
        return "member/findPassword";
    }      
    
    
    
    @RequestMapping(value = "/findEmail_ok.car", method = RequestMethod.POST)
    public View findEmail_ok(@ModelAttribute("memberVo") @Valid MemberVo memberVo, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }        
        try {
        	String findEmail = this.memberService.findEmailMember(memberVo);  
        	String resultEmail = "";       	
        	if(null==findEmail) {
        	} else {
            	String email[] = findEmail.split("@");

            	int len = email[0].length(); //전체길이
            	int size = len-2;
            	
            	resultEmail += email[0].substring(0, 2);
            	
            	for (int i=0; i<size; i++){
            		resultEmail += "*";
            	}
            	
           		resultEmail += "@"+email[1];
        	}
            xml.setMessage(resultEmail);
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView; 
    }    
    
    @RequestMapping(value = "/findPasswd_confirm_ok.car", method = RequestMethod.POST)
    public View findPasswd_confirm_ok(@ModelAttribute("memberVo") @Valid MemberVo memberVo,HttpServletRequest request, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }        
        Map mapInput = new HashMap();
    	Map<String, String[]> requestParams = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
			String key = entry.getKey();         
			String[] value = entry.getValue();   
			String valueString = "";			
			if (value.length > 1) {
				for (int i = 0; i < value.length; i++) {
					valueString += value[i] + " ";
				}
			} else {
				valueString = value[0];
			}
			//System.out.println("***** " + key + " - " + valueString);
			mapInput.put(key, valueString);
		}
		
		mapInput.put("birthday", mapInput.get("year").toString()+mapInput.get("month").toString()+mapInput.get("day").toString());
		
        try {        	
        	String findEmail = this.memberService.findPasswdConfirm(mapInput);
            xml.setMessage(findEmail);
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView; 
    }
    
    @RequestMapping(value = "/changePwd.car", method = RequestMethod.POST)
    public String changePwd(HttpServletRequest request, Model model) {
    	String email = request.getParameter("email");
		model.addAttribute("email", email);

    	return "member/changePwd";    	        
    }
    
	
	@RequestMapping(value="/passwdUpdate_ok.car", method=RequestMethod.POST)
	public View passwdUpdate_ok(@ModelAttribute("memberVo") @Valid MemberVo memberVo, BindingResult result,Model model) {
        XStream xst = xstreamMarshaller.getXStream();
        xst.alias("result", XmlResult.class);
        XmlResult xml = new XmlResult();        
        if (result.hasErrors()) {
        	String message = result.getFieldError().toString();
        	xml.setMessage( message );
            xml.setError(true);
            model.addAttribute("xmlData", xml);
            return xmlView;
        }
        try {
        	memberVo.setPasswd(passwordEncoder.encodePassword(memberVo.getPasswd().toString(), null));
        	
            this.memberService.updatePasswd(memberVo);
            xml.setMessage("비밀번호가 재설정 되었습니다. 로그인 해주세요");
            xml.setError(false); 
        } catch(Exception e) {
           xml.setMessage(e.getMessage());
           xml.setError(true);
        }
        model.addAttribute("xmlData", xml);
        return xmlView;
	}	
    
    @RequestMapping(value = "/login.car", method = RequestMethod.GET)
    public String login(Model model) {
    	

        return "member/login";
    }
     
     
    @RequestMapping(value = "/login_duplicate.car", method = RequestMethod.GET)
    public void login_duplicate() {     
        System.out.println("Welcome login_duplicate!");
    }

}
