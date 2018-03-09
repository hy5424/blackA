package com.lc.common.constants;

public enum BrowserEnum {
	
	WX("1","WX"),
	ZFB("2","ZFB"),
	OTHER("3","OTHER");

	private String id;
	private String type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private BrowserEnum(String id, String type) {
		this.id = id;
		this.type = type;
	}
	
}
