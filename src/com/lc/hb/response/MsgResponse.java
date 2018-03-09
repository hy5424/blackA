package com.lc.hb.response;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.lc.common.util.JSONUtil;

public class MsgResponse {

	/**
	 * 响应码
	 */
	private String code;
	
	/**
	 * 响应消息
	 */
	private String msg;
	
	/**
	 * 响应信息
	 */
	private Map<String, Object> response = new HashMap<String, Object>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getResponse() {
		for(Entry<String, Object> entry : response.entrySet()) {
			Object value = entry.getValue();
			if(value == null) {
				response.put(entry.getKey(), "");
			}
		}
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static String packMsg(String code, String msg) {
		Map<String, String> retMap = new HashMap<String, String>();
		retMap.put("code", code);
		retMap.put("msg", msg);
		String retMsg = "";
		try {
			retMsg = JSONUtil.packJson(retMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retMsg;
	}

	/* (非 Javadoc) 
	* <p>Title: toString</p> 
	* <p>Description: </p> 
	* @return 
	* @see java.lang.Object#toString() 
	* @author caoning   
	*/
	@Override
	public String toString() {
		return "MsgResponse [code=" + code + ", msg=" + msg + ", response="
				+ response + "]";
	}

	
}