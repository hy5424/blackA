package com.lc.common.constants;

public class ResponseConstants {
	
	public static String SUCCESS = "0000";
	
	/**
	 * 参数校验失败
	 */
	public static String INVALID_PARAMETER = "A0001";
	
	/**
	 * 机构号不可用
	 */
	public static String NO_USABLE_AGENT = "A0002";
	
	/**
	 * 暂无可用通道
	 */
	public static String NO_USABLE_CHANNEL = "A0003";
	
	/**
	 * 暂无可用通道商户
	 */
	public static String NO_USABLE_CHANNEL_MERC = "A0004";
	
	/**
	 * 通道商户费率未设定
	 */
	public static String NO_SET_CHANNEL_MERC_RATE = "A0005";
	
	/**
	 * 商户号不可用
	 */
	public static String NO_USABLE_MERC = "A0006";
	
	/**
	 * 机构无可用业务
	 */
	public static String AGENT_NO_USABLE_BIZ = "A0007";
	
	/**
	 * 重复订单号
	 */
	public static String MERC_ORDER_ID_EXISTS = "A0008";
	
	/**
	 * 订单号不存在
	 */
	public static String MERC_ORDER_ID_NOT_EXISTS = "A0009";
	
	/**
	 * 代付失败
	 */
	public static String PAY_ERROR = "A9996";
	
	/**
	 * 验签失败
	 */
	public static String VERIFY_ERROR = "A9997";
	
	/**
	 * 报文格式错误
	 */
	public static String MSG_FORMAT_ERROR = "A9998";
	
	/**
	 * 系统异常
	 */
	public static String SYSTEM_ERROR = "A9999";
	
	/**
	 * 实名认证失败
	 */
	public static String REALNAME_AUTH_FAILURE = "A1001";
	
	/**
	 * 下单成功
	 */
	public static String CREATE_ORDER_SUCCESS = "A1100";
	/**
	 * 快捷下单成功
	 */
	public static String FAST_ORDER_SUCCESS = "A1101";
	/**
	 * 快捷支付成功（等待回调）
	 */
	public static String FAST_PAY_SUCCESS = "A1102";
	
	/**
	 * 代付处理中
	 */
	public static String PAY_WAIT_DISPOSE = "A1200";
	
	/**
	 * 代付接受
	 */
	public static String PAY_WAIT_ACCEPT = "A1300";
	
	/**
	 * 订单号格式错误
	 */
	public static String ORDER_FORMAT_ERROR = "A2001";
	
	/**
	 * 支付方式不存在
	 */
	public static String PAY_WAY_NOT_EXISTS = "A2002";
	
	/**
	 * 支付方式格式错误
	 */
	public static String PAY_WAY_FORMAT_ERROR = "A2003";
	
	/**
	 * 订单失效
	 */
	public static String ORDER_INVALID = "A2004";
	
	/**
	 * 代理商资费未设定
	 */
	public static String AGENT_TARIFF_NOT_EXISTS = "A2005";
	
	/**
	 * 资费设定错误
	 */
	public static String MERC_TARIFF_SET_ERROR = "A2006";
	
	/**
	 * 使用微信浏览器打开
	 */
	public static String BROWSER_TYPE_NOT_WX = "A2007";
	
	/**
	 * 使用支付宝浏览器打开
	 */
	public static String BROWSER_TYPE_NOT_ZFB = "A2008";
	
	/**
	 * 微信授权失败
	 */
	public static String WX_AUTH_FAILURE = "A2009";
	
	/**
	 * 暂无可用支付渠道,请选择其他支付方式
	 */
	public static String NO_PAY_CHANNEL = "A2010";
	
	/**
	 * 超过单笔限额
	 */
	public static String OUT_SINGLE_LIMIT = "A2011";
	
	/**
	 * 不在交易日期范围内
	 */
	public static String OUT_TRANS_TIME = "A2012";
	
	/**
	 * 暂无可用支付方式
	 */
	public static String NO_PAY_WAY = "A2013";
	
	/**
	 * 计算手续费异常
	 */
	public static String CALC_FEE_ERROR = "A2014";
	
	/**
	 * 身份证黑名单
	 */
	public static String IDENTITY_BLACK = "A2015";
	
	/**
	 * 商户信息提交成功
	 */
	public static String MERC_INFO_SUBMIT_SUCC = "A3001";
	
	/**
	 * 商户信息提交失败
	 */
	public static String MERC_INFO_SUBMIT_FAIL = "A3002";
	
	/**
	 * 商户信息已存在,请联系运营
	 */
	public static String MERC_INFO_EXISTS = "A3003";
	
	/**
	 * 商户信息审核中
	 */
	public static String MERC_INFO_CHECK_PENDING = "A3004";
	
	/**
	 * 商户信息审核失败
	 */
	public static String MERC_INFO_CHECK_FAILURE = "A3005";
	
	/**
	 * 商户信息录入成功
	 */
	public static String MERC_INFO_ENTERING = "A3006";
	
	/**
	 * 重复报件
	 */
	public static String MERC_INFO_REPEAT = "A3007";
	
	/**
	 * 银行卡号无效
	 */
	public static String BANK_CARD_ERROR = "A4001";
	/**
	 * 手机号无效
	 */
	public static String MOBILE_ERROR = "A4002";
	/**
	 * token无效
	 */
	public static String TOKEN_INVALID = "A4003";
	/**
	 * 短信发送失败
	 */
	public static String SMS_ERROR = "A4004";
	
	/**
	 * 用户无权限(升级会员)
	 */
	public static String USER_NO_PREMISSION = "A5001";
	
	/**
	 * 短信验证码失效
	 */
	public static String SMS_CAPTCHA_EXPIRED = "A6001";
	
	/**
	 * 短信验证码校验错误
	 */
	public static String SMS_CAPTCHA_ERROR = "A6002";
	
	/**
	 * 短信验证码不存在
	 */
	public static String SMS_CAPTCHA_NOT_EXISTS = "A6003";
	
	/**
	 * 余额不足
	 */
	public static String BALANCE_DEFICIENCY = "A6004";
	
	/**
	 * 注册失败
	 */
	public static String REG_FAIL = "A6005";
	
	/**
	 * 绑卡开通失败
	 */
	public static String BINDING_CARD_FAIL = "A6006";
	
}
