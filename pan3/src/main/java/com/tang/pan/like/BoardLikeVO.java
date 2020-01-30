package com.tang.pan.like;

public class BoardLikeVO {
	private int li_no;
	private int li_bpno;
	private String li_mmcode;
	public int getLi_no() {
		return li_no;
	}
	public void setLi_no(int li_no) {
		this.li_no = li_no;
	}
	public int getLi_bpno() {
		return li_bpno;
	}
	public void setLi_bpno(int li_bpno) {
		this.li_bpno = li_bpno;
	}
	public String getLi_mmcode() {
		return li_mmcode;
	}
	public void setLi_mmcode(String li_mmcode) {
		this.li_mmcode = li_mmcode;
	}
	
	
	@Override
	public String toString() {
		return "BoardLikeVO [li_no=" + li_no + ", li_bpno=" + li_bpno + ", li_mmcode=" + li_mmcode + "]";
	}
	
	
}
