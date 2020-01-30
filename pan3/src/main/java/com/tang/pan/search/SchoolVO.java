package com.tang.pan.search;

public class SchoolVO {
	private String sc_code;
	private String sc_name;
	private String sc_local;
	public String getSc_code() {
		return sc_code;
	}
	public void setSc_code(String sc_code) {
		this.sc_code = sc_code;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public String getSc_local() {
		return sc_local;
	}
	public void setSc_local(String sc_local) {
		this.sc_local = sc_local;
	}
	@Override
	public String toString() {
		return "SchoolVO [sc_code=" + sc_code + ", sc_name=" + sc_name + ", sc_local=" + sc_local + "]";
	}
	
	
}
