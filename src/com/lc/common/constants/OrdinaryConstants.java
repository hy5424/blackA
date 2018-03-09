package com.lc.common.constants;


/**
 * 普通常量定义
 */
public class OrdinaryConstants {

	/**
	 * 信息录入者
	 */
	public static String CREATE_BY = "system";
	/**
	 * 信息更新者
	 */
	public static String UPDATE_BY = "system";
	
	public static final String A0101 = "A0101";	//微信扫码支付T0
	public static final String A0102 = "A0102";	//微信扫码支付T1
	public static final String A0201 = "A0201";	//微信公众号支付T0
	public static final String A0202 = "A0202";	//微信公众号支付T1
	public static final String A0301 = "A0301";	//微信APP支付T0
	public static final String A0302 = "A0302";	//微信APP支付T1
	public static final String A0401 = "A0401";	//支付宝扫码支付T0
	public static final String A0402 = "A0402";	//支付宝扫码支付T1
	public static final String A0501 = "A0501";	//快捷支付T0
	public static final String A0502 = "A0502";	//快捷支付T1
	public static final String A0600 = "A0600";	//提现T0
	public static final String A0700 = "A0700";	//提现T1
	public static final String A0800 = "A0800";	//实名认证
	public static final String A0900 = "A0900";	//用户升级
	public static final String A0910 = "A0910";	//用户注册公众号下单
	public static final String A0911 = "A0911";	//升级VIP合伙人
	public static final String A0912 = "A0912";	//开通代你还
	public static final String A0913 = "A0913";	//余额充值
	public static final String A0503 = "A0503";	//荣邦B2C
	public static final String A0507 = "A0507";	//易通恒丰快捷
	public static final String A0508 = "A0508";	//易通手机快捷
	public static final String A0509 = "A0509";	//荣邦网关支付
	
	public static final String A0511 = "A0511";	//金易付后台快捷支付
	public static final String A0512 = "A0512";	//金易付银联快捷支付
	public static final String A0513 = "A0513";	//一点即付快捷支付
	public static final String A0514 = "A0514";	//金易付小额快捷支付
	public static final String A0515 = "A0515";	//越满金融快捷支付(有积分)
	public static final String A0516 = "A0516";	//越满金融快捷支付(无积分)
	public static final String A0517 = "A0517";	//荣邦快捷支付
	public static final String A0518 = "A0518";	//一点即付标准快捷
	
	public static final String D0101 = "D0101"; //代付
	public static final String D0102 = "D0102"; //代扣
	public static final String D0103 = "D0103"; //激活
	public static final String D0104 = "D0104"; //保证金
	
	public static final String CHANNEL_TYPE_THIRD = "10";	//第三方通道
	public static final String CHANNEL_TYPE_WX = "20";	//微信
	public static final String CHANNEL_TYPE_WX_PUBLIC = "21";	//微信公众号
	public static final String CHANNEL_TYPE_PAY = "30";	//代付
	public static final String CHANNEL_TYPE_AUTH = "40";//实名认证
	
	public static final String YES = "1";	//是
	public static final String NO = "0";	//否
	
	public static final String AGENT_TYPE_ORGS = "10";
	public static final String AGENT_TYPE_APPS = "20";
	
	public static final String AGENT_AUTH_YES = "10";	//代理商需要实名
	public static final String AGENT_AUTH_NO = "20";	//代理商不需要实名
	
	//账户类型
	public static final String ACCT_TYPE_DEPOSIT = "10";	//存款账户
	public static final String ACCT_TYPE_CREDIT = "20";		//信用账户
	public static final String ACCT_TYPE_FROZEN = "30";		//冻结账户
	
	//账户对象
	public static final String ACCT_OBJECT_MERC = "10";			//商户
	public static final String ACCT_OBJECT_AGENT = "20";		//代理商
	public static final String ACCT_OBJECT_CHANNEL = "30";		//通道
	public static final String ACCT_OBJECT_ENTERPRISE = "40";	//企业自有
	
	//记账状态
	public static final String ACCT_STATUS_DRAFT = "10";		//草稿
	public static final String ACCT_STATUS_WAIT_BOOK = "21";	//待记账
	public static final String ACCT_STATUS_FAILURE = "50";	//失败
	
	//微信支付类型
	public static final String WX_TRADE_TYPE_APP = "APP";	//APP支付
	public static final String WX_TRADE_TYPE_NATIVE = "NATIVE";	//原生扫码支付
	public static final String WX_TRADE_TYPE_JSAPI = "JSAPI";	//公众号支付
	
	/**
	 * 发送验证短信
	 */
	public static String SMS_VERIFICATION_TYPE = "0";
	/**
	 * 发送通知短信
	 */
	public static String SMS_NOTIFICATIONS_TYPE = "1";
	
	public static final String STATUS_REGISTER_SUCC = "1";	//注册成功
	public static final String STATUS_REGISTER_FAIL = "0";	//注册失败
	public static final String STATUS_BINDING_SUCC = "1";	//绑定成功
	public static final String STATUS_BINDING_FAIL = "0";	//绑定失败
	
	/**
	 * 消费银行卡开卡状态：初始状态2，成功为1，失败为0
	 */
	public static final String BANK_CARD_INVALID = "0" ; //0：无效 
	public static final String BANK_CARD_VAILD = "1" ; //1 ：有效 
	public static final String BANK_CARD_CHECK = "2" ; //2:审核中

}
