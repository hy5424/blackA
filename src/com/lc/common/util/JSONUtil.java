package com.lc.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	/**
	 * @Title: packJson
	 * @Description: 打包请求的json
	 * @param request
	 * @return String 返回类型
	 * @throws
	 */
	public static String packJson(Object object) throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	/**
	 * @Title: parseJson
	 * @Description: 解析json
	 * @param json
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @return Object 返回类型
	 * @throws
	 */
	public static Object parseJson(String json, Class<?> clz) throws Exception {
		if(json == null || json.equals("")){
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(json);
		Object object = JSONObject.toBean(jsonObject, clz);
		
		Class<? extends Object> clazz = object.getClass();
		Field [] fields = clazz.getDeclaredFields();
		if(fields != null && fields.length > 0) {
			for (Field field : fields) {
				if(field.getType().getName().equals("java.lang.String")) {
					// 对于private私有化的成员变量，通过setAccessible来修改器访问权限
					field.setAccessible(true);
					Object value = field.get(object);
					if(value != null) {
						String v = (String) value;
						field.set(object, v.trim());
					}
					// 重新设置会私有权限
					field.setAccessible(false);
				}
			}
		}
		return object;
	}
	
	public static Object parseJson2(String json, Class<?> clz, 
			Map<String, Class<?>> classMap) throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Object object = JSONObject.toBean(jsonObject, clz, classMap);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public static List parseArray(String json, Class<?> clz) throws Exception {
		JSONArray jsonArray = JSONArray.fromObject(json);
		Object object = clz.newInstance();
		List list = JSONArray.toList(jsonArray, object, new JsonConfig());
		return list;
	}

	/**
	 * @Title: parseJson2
	 * @Description: 解析json
	 * @param json
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @return JSONObject 返回类型
	 * @throws
	 */
	public static JSONObject parseJson2(String json) throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> jsonToMap(String json) {
		Map classMap = new HashMap<String, String>();
		classMap.put("map", Map.class);
		Map<String, String> map = (Map) JSONObject.toBean(JSONObject
				.fromObject(json), Map.class, classMap);
		// 转换null
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object value = map.get(key);
			if (value instanceof JSONNull) {
				map.put(key, null);
			}
		}
		return map;
	}

}
