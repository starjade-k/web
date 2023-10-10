package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.AdmDAO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminStuListAction implements Action{
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "24_2_studentManage.jsp";
		
	    
		int mNum= (Integer.parseInt(request.getParameter("MajorNum")));
		AdmDAO aDao = AdmDAO.getInstance();
		List<StuDTO> list = aDao.stuMajor(mNum);
		request.setAttribute("stuList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}



}
