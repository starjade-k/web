package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.ProDAO;
import com.pj.dto.ProDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfessorInfo implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "13_my_info.jsp";
		int num = Integer.parseInt(request.getParameter("professorNum"));
		ProDAO pDao = ProDAO.getInstance();
		List<ProDTO> user_info = pDao.my_Info(num);
		request.setAttribute("userList", user_info);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
