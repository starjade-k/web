package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.QnaDAO;
import com.pj.dto.QnaDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllQnaListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "19_qna_pro.jsp";		
		QnaDAO qDao=QnaDAO.getInstance();
		List<QnaDTO> list=qDao.selectAllQna();
		request.setAttribute("qna", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
