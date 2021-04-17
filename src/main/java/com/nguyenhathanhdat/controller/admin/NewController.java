	package com.nguyenhathanhdat.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenhathanhdat.constant.SystemConstant;
import com.nguyenhathanhdat.model.NewModel;
import com.nguyenhathanhdat.paging.PageRequest;
import com.nguyenhathanhdat.paging.Pageble;
import com.nguyenhathanhdat.service.INewService;
import com.nguyenhathanhdat.sort.Sorter;
import com.nguyenhathanhdat.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8483149849610906377L;

	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel newModel = FormUtil.toModel(NewModel.class, req);
		String view = "";
		if (newModel.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(newModel.getPage(), newModel.getMaxPageItem(),
					new Sorter(newModel.getSortName(), newModel.getSortBy()));
			newModel.setListResult(newService.findAll(pageble));
			newModel.setTotalItem(newService.getTotalItem());
			newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
			view = "/view/admin/new/list.jsp";
		} else if (newModel.getType().equals(SystemConstant.EDIT)) {
			if (newModel.getId() != null) {
				newModel = newService.findOne(newModel.getId());
			} else {

			}
			view = "/view/admin/new/list.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
