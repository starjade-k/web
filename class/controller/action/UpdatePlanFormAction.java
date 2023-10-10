package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.ClassDAO;
import com.pj.dao.PlanDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.PlanDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePlanFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "16_2_updatePlan.jsp";
		String ClassNum=request.getParameter("ClassNum");
		ClassDAO cDao=ClassDAO.getInstance();
		PlanDAO pDao=PlanDAO.getInstance();
		
		ClassDTO cDto=cDao.selectPlanFormByClassNum(ClassNum);   
		PlanDTO pDto=pDao.selectPlan(ClassNum);
		request.setAttribute("name", cDto);
		request.setAttribute("plan", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
