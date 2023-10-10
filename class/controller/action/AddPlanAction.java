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

public class AddPlanAction implements Action { 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlanDTO PVo = new PlanDTO();
		ClassDTO cDTO=new ClassDTO();
		
		PVo.setProfessorNum(Integer.parseInt(request.getParameter("ProfessorNum")));
		PVo.setMajorNum(Integer.parseInt(request.getParameter("MajorNum")));
		PVo.setClassNum(Integer.parseInt(request.getParameter("ClassNum")));
		
		PVo.setWeek1(request.getParameter("week1"));
		PVo.setWeek2(request.getParameter("week2"));
		PVo.setWeek3(request.getParameter("week3"));
		PVo.setWeek4(request.getParameter("week4"));
		PVo.setWeek5(request.getParameter("week5"));
		PVo.setWeek6(request.getParameter("week6"));
		PVo.setWeek7(request.getParameter("week7"));
		PVo.setWeek8(request.getParameter("week8"));
		PVo.setWeek9(request.getParameter("week9"));
		PVo.setWeek10(request.getParameter("week10"));
		PVo.setWeek11(request.getParameter("week11"));
		PVo.setWeek12(request.getParameter("week12"));
		PVo.setWeek13(request.getParameter("week13"));
		PVo.setWeek14(request.getParameter("week14"));
		PVo.setWeek15(request.getParameter("week15"));
		PVo.setWeek16(request.getParameter("week16"));
		PVo.setProfessorName(request.getParameter("professorName"));

		
		cDTO.setClassNum(Integer.parseInt(request.getParameter("ClassNum")));
		cDTO.setPlanYN(request.getParameter("planYN"));
		//데이터집어넣는쪽
		

		PlanDAO pDao = PlanDAO.getInstance();
		ClassDAO cDao=ClassDAO.getInstance();
		pDao.addPlan(PVo);
		cDao.updatePlanYN(cDTO);
		String url="13_my_info.jsp";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		//new BoardListAction().execute(request, response);
	}
}
