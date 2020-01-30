package com.tang.pan.reply;

import java.util.Date;

public class ReplyVO {
	private int re_no;
	private String re_bpbocode;
	private int re_bpno;
	private String re_content;
	private String re_writer;
	private String re_mmcode;
	private Date re_date;
	
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public String getRe_bpbocode() {
		return re_bpbocode;
	}
	public void setRe_bpbocode(String re_bpbocode) {
		this.re_bpbocode = re_bpbocode;
	}
	public int getRe_bpno() {
		return re_bpno;
	}
	public void setRe_bpno(int re_bpno) {
		this.re_bpno = re_bpno;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_writer() {
		return re_writer;
	}
	public void setRe_writer(String re_writer) {
		this.re_writer = re_writer;
	}
	public String getRe_mmcode() {
		return re_mmcode;
	}
	public void setRe_mmcode(String re_mmcode) {
		this.re_mmcode = re_mmcode;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	@Override
	public String toString() {
		return "ReplyVO [re_no=" + re_no + ", re_bpbocode=" + re_bpbocode + ", re_bpno=" + re_bpno + ", re_content="
				+ re_content + ", re_writer=" + re_writer + ", re_mmcode=" + re_mmcode + ", re_date=" + re_date + "]";
	}
	
	
	
}
