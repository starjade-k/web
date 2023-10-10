package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.ClassDAO;
import com.pj.dto.ClassDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddPlanFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "16_1_writeplan.jsp";
		String ClassNum=request.getParameter("ClassNum");
		ClassDAO cDao=ClassDAO.getInstance();
		ClassDTO cDto=cDao.selectPlanFormByClassNum(ClassNum);   
		request.setAttribute("name", cDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
