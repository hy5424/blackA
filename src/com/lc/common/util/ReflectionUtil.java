package com.lc.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

public class ReflectionUtil {
	private static Logger logger = LoggerFactory
			.getLogger(ReflectionUtils.class);

	private ReflectionUtil() {
	}

	/**
	 * 
	 * 直接读取对象属性值,无视private/protected修饰符,不经过getter函数.
	 */

	public static Object getFieldValue(final Object object,
			final String fieldName) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null)
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");
		makeAccessible(field);
		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常{}", e.getMessage());
		}
		return result;

	}

	/**
	 * 
	 * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
	 */

	public static void setFieldValue(final Object object,
			final String fieldName, final Object value) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null)

			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");
		makeAccessible(field);
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}
	}

	/**
	 * 
	 * 循环向上转型,获取对象的DeclaredField.
	 */

	protected static Field getDeclaredField(final Object object,
			final String fieldName) {
		return getDeclaredField(object.getClass(), fieldName);

	}

	/**
	 * 
	 * 循环向上转型,获取类的DeclaredField.
	 */

	@SuppressWarnings("rawtypes")
	protected static Field getDeclaredField(final Class clazz,
			final String fieldName) {
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {

			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
			}
		}
		return null;
	}

	/**
	 * 
	 * 强制转换fileld可访问.
	 */

	protected static void makeAccessible(final Field field) {
		if (!Modifier.isPublic(field.getModifiers())
				|| !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
			field.setAccessible(true);
		}

	}

}
