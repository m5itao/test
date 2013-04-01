package com.loongsoft.base.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆验证
 * @author F
 *
 */
public class LoginFilter implements Filter {
	
	private String[] anonymousPath = null;

	private String loginurl = null;
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String servletPath = ((HttpServletRequest) request).getServletPath();
		String contextpath = ((HttpServletRequest) request).getContextPath();
		//System.out.println(servletPath+"--servletPath");
		try{
			if (servletPath == null || "".equals(servletPath)) {
				chain.doFilter(request, response);
				return;
			} else if(!((servletPath.endsWith(".do"))||(servletPath.endsWith(".jsp")))){
				chain.doFilter(request, response);
				return;
			} else {
				if (this.anonymousPath != null) {
					for (int i = 0; i < this.anonymousPath.length; i++)
						if (servletPath.startsWith(this.anonymousPath[i])) {
							chain.doFilter(request, response);
							return;
						}
				}
			}
			// 验证Session中的用户信息
			HttpSession session = ((HttpServletRequest) request).getSession(false);
			//未验证
//			((HttpServletResponse) response).sendRedirect("");return;
			chain.doFilter(request, response);
			return;
		}catch(Exception ex){
		//	ex.printStackTrace();
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		String value = arg0.getInitParameter("anonymousPath");
		if (value != null && value.length() > 0) {
			this.anonymousPath = value.split(",");
		}
		value = arg0.getInitParameter("loginurl");
		if (value != null && value.length() > 0) {
			this.loginurl = value;
		}
	}

}
