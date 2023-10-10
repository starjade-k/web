package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.ClassDAO;
import com.pj.dao.PlanDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.PlanDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectAdminPlanAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "23_2_plan.jsp";
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
