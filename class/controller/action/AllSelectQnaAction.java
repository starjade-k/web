package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.QnaDAO;
import com.pj.dao.StuDAO;
import com.pj.dto.QnaDTO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllSelectQnaAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "19_1_qna_view.jsp";
		int QnaNum=(Integer.parseInt(request.getParameter("QnaNum")));
		
		QnaDAO qDao=QnaDAO.getInstance();
		

		QnaDTO qDto=qDao.selectOneQna(QnaNum);   
		request.setAttribute("qna", qDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
