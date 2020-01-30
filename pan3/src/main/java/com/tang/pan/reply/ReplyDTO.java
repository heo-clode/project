package com.tang.pan.reply;

public class ReplyDTO {
	private String re_bpbocode;
	private String bo_code;
	private String bo_name;
	private String re_content;
	private String bp_name;
	private String bp_content;

	public String getRe_bpbocode() {
		return re_bpbocode;
	}

	public void setRe_bpbocode(String re_bpbocode) {
		this.re_bpbocode = re_bpbocode;
	}

	public String getBo_code() {
		return bo_code;
	}

	public void setBo_code(String bo_code) {
		this.bo_code = bo_code;
	}

	public String getBo_name() {
		return bo_name;
	}

	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public String getBp_name() {
		return bp_name;
	}

	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	
	public String getBp_content() {
		return bp_content;
	}

	public void setBp_content(String bp_content) {
		this.bp_content = bp_content;
	}

	@Override
	public String toString() {
		return "ReplyDTO [re_bpbocode=" + re_bpbocode + ", bo_code=" + bo_code + ", bo_name=" + bo_name
				+ ", re_content=" + re_content + ", bp_name=" + bp_name + ", bp_content=" + bp_content + "]";
	}

}
