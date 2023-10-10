package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.ClassDAO;
import com.pj.dto.ClassDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminClassListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "23_1_registrationApproval.jsp";
		ClassDAO cDao = ClassDAO.getInstance();
		List<ClassDTO> list = cDao.selectAllClass();
		request.setAttribute("classList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
