package com.nguyenhathanhdat.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenhathanhdat.model.NewModel;
import com.nguyenhathanhdat.model.UserModel;
import com.nguyenhathanhdat.service.ICategoryService;
import com.nguyenhathanhdat.service.INewService;
import com.nguyenhathanhdat.service.IUserService;
import com.nguyenhathanhdat.utils.FormUtil;
import com.nguyenhathanhdat.utils.SectionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8483149849610906377L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;
	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");

			if (message != null | alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SectionUtil.getIntance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
			req.setAttribute("categories", categoryService.fillAll());
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/home.jsp");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel userModel = FormUtil.toModel(UserModel.class, req);
			userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(),
					1);
			if (userModel != null) {
				SectionUtil.getIntance().putValue(req, "USERMODEL", userModel);
				if (userModel.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if (userModel.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/home-admin");
				} else {
					resp.sendRedirect(req.getContextPath()
							+ "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
				}
			}
		}
	}

}
