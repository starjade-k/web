package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.ClassDAO;
import com.pj.dto.ClassDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClassListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "15_myClass.jsp";
		int pNum= (Integer.parseInt(request.getParameter("professorNum")));
		
		ClassDAO cDao = ClassDAO.getInstance();
		List<ClassDTO> list = cDao.selectMyClass(pNum);
		request.setAttribute("classList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
