package com.shuim.service;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shuim.domain.MemberVo;

@Repository(value="memberMapper")
public interface MemberMapper {
	
	void addMember(MemberVo memberVo);
	
	void updatePasswd (MemberVo memberVo) ;
	
	void updateDrew (MemberVo memberVo);
	
	void updateUserInfo (MemberVo memberVo);
	
	void updateUserLoginLog(String email);
	
	Map<String, String> checkMember(Map map);
	
	Map<String, String> selectMember(String email) ;
	
	String duplicateMember (String email);
	
	String duplicateNick (String nick) ;
	
	String findEmailMember (MemberVo memberVo);
	
	String findPasswdConfirm(Map map);
}
