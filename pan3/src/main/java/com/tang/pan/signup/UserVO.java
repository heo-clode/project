package com.tang.pan.signup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserVO {
	private String mm_code;
	private String mm_sccode;
	private String mm_id;
	private String mm_pw;
	private String mm_name;
	private String mm_email;
	private String mm_email2;
	private String mm_pnum;
	private Date mm_date;
	private String mm_lev;

	public String getMm_code() {
		return mm_code;
	}

	public void setMm_code(String mm_code) {
		this.mm_code = mm_code;
	}

	public String getMm_sccode() {
		return mm_sccode;
	}

	public void setMm_sccode(String mm_sccode) {
		this.mm_sccode = mm_sccode;
	}

	public String getMm_id() {
		return mm_id;
	}

	public void setMm_id(String mm_id) {
		this.mm_id = mm_id;
	}

	public String getMm_pw() {
		return mm_pw;
	}

	public void setMm_pw(String mm_pw) {
		this.mm_pw = mm_pw;
	}

	public String getMm_name() {
		return mm_name;
	}

	public void setMm_name(String mm_name) {
		this.mm_name = mm_name;
	}

	public String getMm_email() {
		return mm_email;
	}

	public void setMm_email(String mm_email) {
		this.mm_email = mm_email;
	}

	public String getMm_email2() {
		return mm_email2;
	}

	public void setMm_email2(String mm_email2) {
		this.mm_email2 = mm_email2;
	}

	public String getMm_pnum() {
		return mm_pnum;
	}

	public void setMm_pnum(String mm_pnum) {
		this.mm_pnum = mm_pnum;
	}

	public Date getMm_date() {
		return mm_date;
	}

	public void setMm_date(Date mm_date) {
		this.mm_date = mm_date;
	}

	public String getMm_lev() {
		return mm_lev;
	}

	public void setMm_lev(String mm_level) {
		this.mm_lev = mm_level;
	}

	@Override
	public String toString() {
		return "UserVO [mm_code=" + mm_code + ", mm_sccode=" + mm_sccode + ", mm_id=" + mm_id + ", mm_pw=" + mm_pw
				+ ", mm_name=" + mm_name + ", mm_email=" + mm_email + ", mm_email2=" + mm_email2 + ", mm_pnum="
				+ mm_pnum + ", mm_date=" + mm_date + ", mm_lev=" + mm_lev + "]";
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
	
	 public String getPassword() {
           // TODO Auto-generated method stub
           return null;
     }
	 
     public String getUserId() {
           // TODO Auto-generated method stub
           return null;
     }
     
     
     public boolean isAccountNonExpired() {
           // TODO Auto-generated method stub
           return true;
     }
     
     public boolean isAccountNonLocked() {
           // TODO Auto-generated method stub
           return true;
     }
     
     public boolean isCredentialsNonExpired() {
           // TODO Auto-generated method stub
           return true;
     }
     
     public boolean isEnabled() {
           // TODO Auto-generated method stub
           return true;
     }
     
}
