package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.QnaDAO;
import com.pj.dto.QnaDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAnswerAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QnaDTO qDTO = new QnaDTO();
		qDTO.setQnaNum(Integer.parseInt(request.getParameter("qnaNum")));
		qDTO.setAnswer(request.getParameter("answer"));
		qDTO.setAnswerer(request.getParameter("answerer"));


		QnaDAO qDao = QnaDAO.getInstance();
		qDao.insertAnswer(qDTO);
		String url = "BoardServlet?command=all_qna_list";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
