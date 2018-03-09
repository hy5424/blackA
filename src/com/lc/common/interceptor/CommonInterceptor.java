package com.lc.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lc.common.constants.ResponseConstants;
import com.lc.common.util.ConvertTimeUtil;
import com.lc.common.util.IpUtil;
import com.lc.common.util.SystemConfig;

/**
 * 共通拦截器
 */
public class CommonInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2, ModelAndView arg3) {
		// TODO Auto-generated method stub

	}

	/**
	 * 定义操作前必要的拦截处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		logger.info("拦截开始......" + request.getRequestURL());
		
		//远程IP
		String remoteIp = IpUtil.getIpAddr(request).trim();
		logger.info("远程IP地址===================>" + remoteIp);
		//过滤IP
		String filterIp = SystemConfig.getProperty("white.list.ip").trim();
		logger.info("过滤IP地址===================>" + filterIp);
		
		logger.info("remoteIp.equals(filterIp)====================>" + filterIp.contains(remoteIp));
		if(filterIp != null && !filterIp.contains(remoteIp)){
			//系统维护拦截
			boolean preserveFlag = sysPreserveHandle(response);
			if(!preserveFlag) {
				return preserveFlag;
			}
		}
		
		logger.info("拦截结束......");
		return true;
	}

	/**
	 * 系统维护
	 */
	public boolean sysPreserveHandle(HttpServletResponse response) throws Exception {
		Map<String, String> responseMap = new HashMap<String, String>();
		//判断是否是系统维护更新时间
		String startTimeStr = SystemConfig.getProperty("maintenance.start.time");
		String endTimeStr = SystemConfig.getProperty("maintenance.end.time");
		long nowTime = new Date().getTime();
		if(!"".equals(startTimeStr.trim())  &&  !"".equals(startTimeStr.trim())){
			long startTime = ConvertTimeUtil.formatDate(startTimeStr).getTime();
			long endTime =  ConvertTimeUtil.formatDate(endTimeStr).getTime();
			if(endTime > startTime){
				if(nowTime >= startTime && nowTime <= endTime){
					responseMap.put("code", ResponseConstants.SYSTEM_ERROR);
					responseMap.put("msg", "系统正在维护，请稍后再试");
					String retMsg = JSONObject.fromObject(responseMap).toString();
					outPrint(response, retMsg);
					return false;
				}
			}else{
				return true;
			}
		}
		return true;
	}

	/**
	 * 向客户端返回数据
	 * 
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public void outPrint(HttpServletResponse response, String msg)
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("progma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
}
