package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.StuDAO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentCancelClass implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String url = "BoardServlet?command=class_regiList&StudentNum=";
		int sNum= (Integer.parseInt(request.getParameter("StudentNum")));
		int cNum= (Integer.parseInt(request.getParameter("ClassNum")));
		StuDAO sDao = StuDAO.getInstance();
		List<StuDTO> user_info = sDao.top_Info(sNum);
		request.setAttribute("userList", user_info);

		sDao.StuDeleteClass(sNum, cNum);
		sDao.NumofPlusPeople(cNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url + sNum);
		dispatcher.forward(request, response);
	}
}
