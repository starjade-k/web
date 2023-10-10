package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.StuDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClassRegiList implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String url = "9_searchCancel.jsp";
		int sNum= (Integer.parseInt(request.getParameter("StudentNum")));
		StuDAO sDao = StuDAO.getInstance();
		List<StuDTO> user_info = sDao.top_Info(sNum);
		request.setAttribute("userList", user_info);


		List<ClassDTO> list = sDao.StuAddClassList(sNum);
		request.setAttribute("classList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
