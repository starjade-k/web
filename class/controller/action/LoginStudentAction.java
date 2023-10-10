package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.StuDAO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginStudentAction implements Action {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	StuDTO sTo = new StuDTO();

	sTo.setStudentNum(Integer.parseInt(request.getParameter("studentNum")));
	sTo.setPwd(request.getParameter("pwd"));

	StuDAO sDo = StuDAO.getInstance();
	sDo.login(sTo);
	String url="StudentServlet?command=studentTopInfo";
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}

}
