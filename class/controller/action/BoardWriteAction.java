package com.pj.controller.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.pj.dao.BoardDAO;
import com.pj.dto.BoardVO;

public class BoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		String url="BoardServlet?command=pro_board_list";
		bVo.setTitle(request.getParameter("title"));
		bVo.setWriter(request.getParameter("writer"));
		bVo.setDay(request.getParameter("day"));
		bVo.setType(request.getParameter("type"));
		bVo.setContent(request.getParameter("content"));
		bVo.setProfessorNum(Integer.parseInt(request.getParameter("ProfessorNum")));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
