package com.lc.common.util;

import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
	
	//agentId
	public static String AGENT_ID_KEY_NAME = "agentId";
	//encryptData原文
	public static String ENCRYPT_DATA_KEY_NAME = "encryptData";
	//signData
	public static String SIGNATURE_KEY_NAME = "signature";
	//jsonData原文明文
	public static String JSON_DATA_KEY_NAME = "jsonData";
	//vector
	public static String VECTOR_KEY_NAME = "vector";
	public static String MERC_ORDER_ID = "mercOrderId";
	
	//字符编码
	public static final String charset = "utf-8";

	public static Map<String, String> parseRequest(String requstStr) throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		//解析body，参数之间用"&"分割
		String [] paramArray = requstStr.split("&");
		for (int i = 0; i < paramArray.length; i++) {
			String param = paramArray[i].trim();
			//key与value之间用"="分割，由于base4最后一位为"=",所以截取第一个"="号之前的为key，之后为value
			String key = param.substring(0, param.indexOf("=")).trim();
			String value = param.substring(param.indexOf("=") + 1).trim();
			paramMap.put(key, value);
		}
		return paramMap;
	}
	
}
