package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.AdmDAO;
import com.pj.dto.AdmDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginAdminAction implements Action {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdmDTO aTo = new AdmDTO();

	aTo.setAdminId((request.getParameter("adminId")));
	aTo.setAdminPwd(request.getParameter("adminPwd"));

	AdmDAO aDo = AdmDAO.getInstance();
	aDo.login(aTo);
	String url="1_0_login_Admin_Action.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}

}
