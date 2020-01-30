package com.tang.pan.board;

import java.util.Date;

public class BoardVO {
	private String bp_bocode;
	private String bp_bosccode;
	private int bp_no;
	private String bp_name;
	private String bp_content;
	private String bp_writer;
	private String bp_mmcode;
	private Date bp_date;
	private String bp_like;
	private String bp_count;
	
	public String getBp_bocode() {
		return bp_bocode;
	}
	public void setBp_bocode(String bp_bocode) {
		this.bp_bocode = bp_bocode;
	}
	public String getBp_bosccode() {
		return bp_bosccode;
	}
	public void setBp_bosccode(String bp_bosccode) {
		this.bp_bosccode = bp_bosccode;
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
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
	public String getBp_writer() {
		return bp_writer;
	}
	public void setBp_writer(String bp_writer) {
		this.bp_writer = bp_writer;
	}
	public String getBp_mmcode() {
		return bp_mmcode;
	}
	public void setBp_mmcode(String bp_mmcode) {
		this.bp_mmcode = bp_mmcode;
	}
	public Date getBp_date() {
		return bp_date;
	}
	public void setBp_date(Date bp_date) {
		this.bp_date = bp_date;
	}
	public String getBp_like() {
		return bp_like;
	}
	public void setBp_like(String bp_like) {
		this.bp_like = bp_like;
	}
	public String getBp_count() {
		return bp_count;
	}
	public void setBp_count(String bp_count) {
		this.bp_count = bp_count;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bp_bocode=" + bp_bocode + ", bp_bosccode=" + bp_bosccode + ", bp_no=" + bp_no + ", bp_name="
				+ bp_name + ", bp_content=" + bp_content + ", bp_writer=" + bp_writer + ", bp_mmcode=" + bp_mmcode
				+ ", bp_date=" + bp_date + ", bp_like=" + bp_like + ", bp_count=" + bp_count + "]";
	}
	
	
	
}
