package com.lc.common.util; 

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lc.common.constants.ResponseConstants;


/** 
 * @author fengmaogen 
 * @version 创建时间：2016-2-18 上午11:08:40 
 * appservice的工具类
 */
public class CheckUtil {
	
	public static String cardBinUrl = SystemConfig.getProperty("cardBin");


	private static Logger logger = LoggerFactory
			.getLogger(CheckUtil.class);
	/**
	 * request参数验证
	 * @param parameters
	 * @return
	 */
	public static boolean validateRequest(Map<String, String> request){
		if(request != null && !request.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * 单个参数验证
	 * @param parameters
	 * @return
	 */
	public static boolean validateParameters(String parameters){
		if(parameters != null && !"".equals(parameters)){
			return true;
		}
		return false;
	}
	
	/**
	 * 必输参数验证
	 * @param parameters
	 * @return
	 */
	public static String validateMustEnter(Map<String, String> request, String...strings){
		if(validateRequest(request)){
			for (String str : strings) {
				if(!validateParameters(request.get(str))){
					logger.debug("必输参数验证=========================>" + str);
					return str;
				}
			}
		}else{
			return "request";
		}
		return ResponseConstants.SUCCESS;
	}
	
	/**
	 * 校验银行卡卡号
	 * 
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCard(String cardId) {
		char bit = getBankCardCheckCode(cardId
				.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		Double cardNo = Double.valueOf(cardId);
		if(cardNo <= 0){
			return false;
		}
		return cardId.charAt(cardId.length() - 1) == bit;
	}

/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 * 
	 * @param nonCheckCodeCardId
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null
				|| nonCheckCodeCardId.trim().length() == 0
				|| !nonCheckCodeCardId.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}
	
	/**
	 * 必输参数验证
	 * @param parameters
	 * @return
	 */
	public static String validateParmByString(String...strings){
		for (String str : strings) {
			if(!validateParameters(str)){
				logger.debug("必输参数验证=========================>" + str);
				return str;
			}
		}
		return ResponseConstants.SUCCESS;
	}
}
 