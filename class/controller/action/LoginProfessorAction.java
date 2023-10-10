package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.ProDAO;
import com.pj.dto.ProDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginProfessorAction implements Action {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	ProDTO pTo = new ProDTO();

	pTo.setProfessorNum(Integer.parseInt(request.getParameter("professorNum")));
	pTo.setPwd(request.getParameter("pwd"));

	ProDAO pDo = ProDAO.getInstance();
	pDo.login(pTo);
	String url="1_0_login_Professor_Action.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}

}
