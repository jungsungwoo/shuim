package com.shuim.service;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shuim.domain.MemberVo;

@Service(value="memberService")
public class MemberService {
	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	public void addMember (MemberVo memberVo) {
		this.memberMapper.addMember(memberVo);
	}
	
	public void updatePasswd (MemberVo memberVo) {
		this.memberMapper.updatePasswd(memberVo);
	}
	
	public void updateDrew (MemberVo memberVo){
		this.memberMapper.updateDrew(memberVo);
	}
	
	public void updateUserInfo (MemberVo memberVo){
		this.memberMapper.updateUserInfo(memberVo);
	}
	
	public void updateUserLoginLog(String email) {
		this.memberMapper.updateUserLoginLog(email);
	}
	
	public Map<String, String> checkMember (Map map) {
		return this.memberMapper.checkMember(map);
	}
	
	public Map<String, String> selectMember(String email) {
		return this.memberMapper.selectMember(email);
	}
	
	public String duplicateMember (String email) {
		return this.memberMapper.duplicateMember(email);
	}
	
	public String duplicateNick (String nick) {
		return this.memberMapper.duplicateNick(nick);
	}
	
	public String findEmailMember (MemberVo memberVo) {
		return this.memberMapper.findEmailMember(memberVo);
	}
	
	public String findPasswdConfirm(Map map) {
		return this.memberMapper.findPasswdConfirm(map);
	}
	
}
