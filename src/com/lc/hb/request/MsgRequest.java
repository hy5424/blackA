package com.lc.hb.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MegRequest
 * @Description: Request
 * 
 */
public class MsgRequest implements Serializable {

	private static final long serialVersionUID = -4752265663021291191L;
	/**
	 * 请求码
	 */
	private String code;
	/**
	 * 请求的request信息
	 */
	private Map<String, String> request = new HashMap<String, String>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, String> getRequest() {
		return request;
	}

	public void setRequest(Map<String, String> request) {
		this.request = request;
	}

}
