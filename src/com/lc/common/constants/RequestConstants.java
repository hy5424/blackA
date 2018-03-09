package com.lc.common.constants;

public class RequestConstants {

	/** 
	 * 请求前缀
	 */
	public static final String ORG_PREFIX = "orgs";
	
	/**
	 * 商户注册请求码
	 */
	public static final String REQ_MEMBER_REGISTER = "T0100";
	
	/**
	 * 商户基本信息更新请求码
	 */
	public static final String REQ_MEMBER_UPDATE = "T0200";
	
	/**
	 * 商户业务信息更新请求码
	 */
	public static final String REQ_MEMBER_UPDATE_BIZ = "T0300";
	
	/**
	 * 商户交易请求码
	 */
	public static final String REQ_MEMBER_TRANSACTION = "T0400";
	
	/**
	 * 商户注册方法
	 */
	public static final String METHOD_MEMBER_REGISTER = "MemberRegister";
	
	/**
	 * 商户基本信息更新方法
	 */
	public static final String METHOD_MEMBER_UPDATE = "MemberUpdate";
	
	/**
	 * 商户业务信息更新方法
	 */
	public static final String METHOD_MEMBER_UPDATE_BIZ = "MemberUpdateBiz";
	
	/**
	 * 商户交易方法
	 */
	public static final String METHOD_MEMBER_TRANSACTION = "MemberTransaction";
	
	/**
	 * 财务计算到账金额请求码
	 */
	public static final String REQ_ACCT_RECEIVE_AMOUNT = "K2991";
	
	/**
	 * 交易请求码
	 */
	public static final String REQ_ACCT_ORGS = "K9010";	//机构收单业务
	public static final String REQ_ACCT_APPS = "K9011";	//APP收单业务
	public static final String REQ_ACCT_WX = "K9012";	//微信收单
	public static final String REQ_ACCT_WITHDRAW = "K2111";	//提现
	
	public static final String REQ_ACCT_ORGS_AUTH = "K9017";	//机构实名认证
	public static final String REQ_ACCT_APPS_AUTH = "K9018";	//app实名认证
	public static final String REQ_ACCT_OUR_WITHDRAW = "K9019";	//企业自有提现
	public static final String REQ_ACCT_PAY = "K9077";	//企业代付
	public static final String REQ_ACCT_DEDUCT = "K9078";	//企业代扣
	
	public static final String REQ_ACCT_REPAYMENT = "K9074";   //还款记账请求码
	public static final String REQ_ACCT_CONSUME = "K9075";     //消费记账请求码
	public static final String REQ_ACCT_UNFREEZE = "K9073";    //解冻请求码
	
	public static final String REQ_ACCT_ORG_ACTIVATE = "K9081";		//信用卡激活
	public static final String REQ_ACCT_ORG_DEPOSIT = "K9082";		//代扣保证金
	public static final String REQ_ACCT_ORG_PAY = "K9083";			//机构代付
	public static final String REQ_ACCT_ORG_DEDUCT = "K9084";		//机构代扣
	
}
