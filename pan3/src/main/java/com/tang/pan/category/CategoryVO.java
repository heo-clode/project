package com.tang.pan.category;

public class CategoryVO {
	private String bo_code;
	private String bo_sccode;
	private String bo_name;
	private int bo_num;
	
	
	public String getBo_code() {
		return bo_code;
	}
	
	public void setBo_code(String bo_code) {
		this.bo_code = bo_code;
	}
	
	public String getBo_sccode() {
		return bo_sccode;
	}
	
	public void setBo_sccode(String bo_sccode) {
		this.bo_sccode = bo_sccode;
	}
	
	public String getBo_name() {
		return bo_name;
	}
	
	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}

	public int getBo_num() {
		return bo_num;
	}

	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}

	@Override
	public String toString() {
		return "CategoryVO [bo_code=" + bo_code + ", bo_sccode=" + bo_sccode + ", bo_name=" + bo_name + ", bo_num="
				+ bo_num + "]";
	}
	

}
