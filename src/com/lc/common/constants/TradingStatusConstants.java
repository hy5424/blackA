/**   
* @Title: AccountTypeConstants.java 
* @Package com.lc.apps.common.constants;
* @Description: 返回码常量类定义
* @author fengmaogen 
* @date 2016-2-18
* @version V1.0   
*/ 
package com.lc.common.constants;


/**
 * 交易状态常量定义
 * @author fengmaogen
 *
 */
public class TradingStatusConstants {

	
	/** 
	 * 0：已受理
	 */
	public static final String ACCEPTED = "0";
	/** 
	 * 1：交易中/待支付
	 */
	public static final String TRADEING = "1";
	/** 
	 *  2：交易成功
	 */
	public static final String SUCCESS = "2";
	/** 
	 * 3：交易失败
	 */
	public static final String FAILURE = "3";

}
