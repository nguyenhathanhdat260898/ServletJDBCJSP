package com.nguyenhathanhdat.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenhathanhdat.constant.SystemConstant;
import com.nguyenhathanhdat.model.NewModel;
import com.nguyenhathanhdat.model.UserModel;
import com.nguyenhathanhdat.utils.SectionUtil;

public class AuthorizationFilter implements javax.servlet.Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.startsWith("/admin")) {
			UserModel userModel = (UserModel) SectionUtil.getIntance().getValue(request, "USERMODEL");
			if (userModel != null) {
				if (userModel.getRole().equals(SystemConstant.ADMIN)) {
					chain.doFilter(servletRequest, servletResponse);
				}else if(userModel.getRole().equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(
						request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
