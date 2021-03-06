package com.datastatistics.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆验证过滤器
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间 
 */
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;
		String url = request.getRequestURI();
		
		//System.out.println();
		System.out.println("filter url ---"+url);

		// 判断是否存在login.jsp
		String reg1 = ".*login.*";
		String reg2 = ".*.jsp.*";
		String reg3 = ".*\\..*";

		// 判断是否存在login.jsp
		if (!url.matches(reg1)) {
			if (url.matches(reg2) || url.endsWith(".do")
					|| !url.substring(url.lastIndexOf("/")).matches(reg3)) {
				/*if (SessionUtil.getUser(request) == null) {
					response.sendRedirect(request.getContextPath()
							+ "/login");
					return;
				}else */if(url.contains("/super/") /*&& !SessionUtil.getUser(request).isSupper()*/){
					response.sendRedirect(request.getContextPath()
							+ "/404");
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
