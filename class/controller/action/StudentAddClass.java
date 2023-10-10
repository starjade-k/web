package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.StuDAO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentAddClass implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String url = "BoardServlet?command=class_registration&StudentNum=";
		int sNum= (Integer.parseInt(request.getParameter("StudentNum")));
		int cNum = (Integer.parseInt(request.getParameter("ClassNum")));
		StuDAO sDao = StuDAO.getInstance();
		StuDTO sDto = new StuDTO();
		List<StuDTO> user_info = sDao.top_Info(sNum);
		request.setAttribute("userList", user_info);
		sDao.StuAddClass(sNum, cNum);
		sDao.NumofMinusPeople(cNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url + sNum);
		dispatcher.forward(request, response);
	}
}
