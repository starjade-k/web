package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.PlanDAO;
import com.pj.dto.PlanDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePlanAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlanDTO pDTO = new PlanDTO();
		pDTO.setClassNum(Integer.parseInt(request.getParameter("ClassNum")));
		pDTO.setWeek1(request.getParameter("week1"));
		pDTO.setWeek2(request.getParameter("week2"));
		pDTO.setWeek3(request.getParameter("week3"));
		pDTO.setWeek4(request.getParameter("week4"));
		pDTO.setWeek5(request.getParameter("week5")); 
		pDTO.setWeek6(request.getParameter("week6"));
		pDTO.setWeek7(request.getParameter("week7"));
		pDTO.setWeek8(request.getParameter("week8"));
		pDTO.setWeek9(request.getParameter("week9"));
		pDTO.setWeek10(request.getParameter("week10"));
		pDTO.setWeek11(request.getParameter("week11"));
		pDTO.setWeek12(request.getParameter("week12"));
		pDTO.setWeek13(request.getParameter("week13"));
		pDTO.setWeek14(request.getParameter("week14"));
		pDTO.setWeek15(request.getParameter("week15"));
		pDTO.setWeek16(request.getParameter("week16"));

		PlanDAO pDao = PlanDAO.getInstance();
		pDao.updatePlan(pDTO);
		String url = "13_my_info.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
