package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.QnaDAO;
import com.pj.dto.QnaDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddQnaAction implements Action { 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QnaDTO qDTO = new QnaDTO();
		String StudentNum=request.getParameter("StudentNum");
//		String startTime = request.getParameter("startTime");
//		String lastTime = request.getParameter("lastTime");
//		String time= startTime + " ~ " +lastTime;
		
		qDTO.setTitle(request.getParameter("title"));
		qDTO.setType(request.getParameter("type"));
		qDTO.setWriter(request.getParameter("writer"));
		qDTO.setStudentNum(Integer.parseInt(request.getParameter("StudentNum")));
		qDTO.setContent(request.getParameter("content"));
		
		//CVo.setTime(time);
		//데이터집어넣는쪽


		QnaDAO qDao = QnaDAO.getInstance();
		qDao.insertQna(qDTO);
		String url="BoardServlet?command=qna_list&StudentNum="+StudentNum;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		//new BoardListAction().execute(request, response);
	}
}
