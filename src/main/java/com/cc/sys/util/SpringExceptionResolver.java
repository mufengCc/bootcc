package com.cc.sys.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cc
 * @data 2019/6/22 14:39
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) {
		//先获取URL
		String url = request.getRequestURL().toString();

		ModelAndView modelAndView;
		String defaultMsg = "System error";

		//如果请求是 .json结尾
		if (url.endsWith((".json")) ) {
			if (ex instanceof PermissionException) {
				JsonData result = JsonData.fail(ex.getMessage());
				modelAndView = new ModelAndView("jsonView",result.toMap());
			} else {
				log.error("unknow json exception, url:"+url,ex);
				JsonData result = 	JsonData.fail(defaultMsg);
				modelAndView = new ModelAndView("jsonView",result.toMap());
			}
			//请求page页面，使用 .page结尾
		} else if (url.endsWith(".page")) {
			log.error("unknow page exception, url:"+url,ex);
			JsonData result = JsonData.fail(defaultMsg);
			modelAndView = new ModelAndView("exception",result.toMap());
		} else {
			log.error("unknow exception, url:"+url,ex);
			JsonData result = JsonData.fail(defaultMsg);
			modelAndView = new ModelAndView("jsonView",result.toMap());
		}

		return modelAndView;
	}
}
