package com.shuim.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberLogin implements UserDetails  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String passwd;
	private String name;
	private String mobile;
	private String birthday;
	private String gender;
	private String last_login;
	private String login_count;
	private String reg_date;
	private String state;
	private String drop_date;
	private String drop_reason;	
	
	public MemberLogin (String email, String passwd, String name, String mobile, String birthday, String gender, String last_login, String login_count, String reg_date, String state, String drop_date, String drop_reason) {
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.mobile = mobile;
		this.birthday = birthday;
		this.gender = gender;
		this.last_login = last_login;
		this.login_count = login_count;
		this.reg_date = reg_date;
		this.state = state;
		this.drop_date = drop_date;
		this.drop_reason = drop_reason;
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
         
        return authorities;
    }
  
    @Override
    public String getPassword() {
        return passwd;
    }
  
    @Override
    public String getUsername() {
        return email;
    }

    public String getEmail() {
    	return email;
    }
    public String getName() {
    	return name;
    }
    public String getMobile() {
    	return mobile;
    }
    public String getBirthday() {
    	return birthday;
    }
    public String getGender() {
    	return gender;
    }
    public String getLast_login() {
    	return last_login;
    }
    public String getLogin_count() {
    	return login_count;
    }
    public String getReg_date() {
    	return reg_date;    	
    }
    public String getState() {
    	return state;
    }
    public String getDrop_date() {
    	return drop_date;    	
    }
    public String getDrop_reason() {
    	return drop_reason;
    }
    
  
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
  
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
  
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
  
    @Override
    public boolean isEnabled() {
        return true;
    }

}
