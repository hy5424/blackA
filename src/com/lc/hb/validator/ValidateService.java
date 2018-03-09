package com.lc.hb.validator;

import java.lang.reflect.Field;

import com.lc.common.util.RegexUtil;

public class ValidateService {

	// 解析的入口
	public static void valid(Object object) throws Exception {
		// 获取object的类型
		Class<? extends Object> clazz = object.getClass();
		// 获取该类型声明的成员
		Field[] fields = clazz.getDeclaredFields();
		// 遍历属性
		for (Field field : fields) {
			// 对于private私有化的成员变量，通过setAccessible来修改器访问权限
			field.setAccessible(true);
			validate(field, object);
			// 重新设置会私有权限
			field.setAccessible(false);
		}
	}

	private static void validate(Field field, Object object) throws Exception {

		String description;
		Object value;

		// 获取对象的成员的注解信息
		Validator validator = field.getAnnotation(Validator.class);
		value = field.get(object);

		if (validator == null)
			return;

		description = validator.description().equals("") ? field.getName() : validator.description();

		/************* 注解解析工作开始 ******************/
		if (!validator.nullable()) {
			if (value == null) {
				throw new Exception(description + "不能为空");
			}
		}
		
		if (validator.nullable() && value == null) {
			return;
		}

		//验证最大值
		if(validator.maxLength() != 0) {
			if (value.toString().length() > validator.maxLength()) {
				throw new Exception(description + "长度不能超过" + validator.maxLength());
			}
		}
		
		//验证最小值
		if(validator.minLength() != 0) {
			if (value.toString().length() < validator.minLength()) {
				throw new Exception(description + "长度不能小于" + validator.minLength());
			}
		}

		if (validator.regexType() != RegexType.NONE) {
			String source = value.toString();
			switch (validator.regexType()) {
			case EMAIL:
				if (!RegexUtil.checkEmail(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case IDCARD:
				if (!RegexUtil.checkIdCard(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case MOBILE:
				if (!RegexUtil.checkMobile(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case PHONE:
				if (!RegexUtil.checkPhone(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case DIGIT:
				if (!RegexUtil.checkDigit(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case DECIMALS:
				if (!RegexUtil.checkDecimals(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case CHINESE:
				if (!RegexUtil.checkChinese(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case URL:
				if (!RegexUtil.checkURL(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case POSTCODE:
				if (!RegexUtil.checkPostcode(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case IP:
				if (!RegexUtil.checkIpAddress(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case DATE:
				if (!RegexUtil.checkBirthday(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case MONEY:
				if (!RegexUtil.checkMoney(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			case BANKCARD:
				if (!RegexUtil.checkBankCard(source)) {
					throw new Exception(description + "格式不正确");
				}
				break;
			default:
				break;
			}
		}

		if (!validator.regexExpression().equals("")) {
			if (value.toString().matches(validator.regexExpression())) {
				throw new Exception(description + "格式不正确");
			}
		}
		/************* 注解解析工作结束 ******************/
	}

}
