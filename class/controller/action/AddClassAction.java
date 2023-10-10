package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.ClassDAO;
import com.pj.dto.ClassDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddClassAction implements Action { 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDTO CVo = new ClassDTO();
		
//		String startTime = request.getParameter("startTime");
//		String lastTime = request.getParameter("lastTime");
//		String time= startTime + " ~ " +lastTime;
		
		CVo.setClassName(request.getParameter("className"));
		CVo.setTime(request.getParameter("startTime")+" ~ "+request.getParameter("lastTime"));
		
		//CVo.setTime(time);

		CVo.setClassroom(request.getParameter("classRoom"));
		CVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		CVo.setMax(Integer.parseInt(request.getParameter("max")));
		CVo.setProfessorNum(Integer.parseInt(request.getParameter("professorNum")));
		CVo.setMajorNum(Integer.parseInt(request.getParameter("majorNum")));
		CVo.setLiberal(request.getParameter("liberal"));
		//데이터집어넣는쪽


		ClassDAO cDao = ClassDAO.getInstance();
		cDao.addClass(CVo);
		String url="13_my_info.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		//new BoardListAction().execute(request, response);
	}
}
