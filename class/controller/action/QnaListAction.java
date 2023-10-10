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

public class QnaListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "11_qna.jsp";
		int sNum= (Integer.parseInt(request.getParameter("StudentNum")));
		
		QnaDAO qDao = QnaDAO.getInstance();
		StuDAO sDao = StuDAO.getInstance();
		List<QnaDTO> list = qDao.selectQna(sNum);
		List<StuDTO> user_info = sDao.top_Info(sNum);
		request.setAttribute("userList", user_info);

		request.setAttribute("qna", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
