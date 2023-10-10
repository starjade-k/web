package com.pj.controller.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.pj.dao.BoardDAO;
import com.pj.dto.BoardVO;

public class BoardUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		String url="BoardServlet?command=pro_board_view&NoticeNum=";
		String num=request.getParameter("NoticeNum");
		bVo.setNoticeNum(Integer.parseInt(request.getParameter("NoticeNum")));
		bVo.setTitle(request.getParameter("title"));
		bVo.setWriter(request.getParameter("writer"));
		//bVo.setDay(request.getParameter("day"));
		bVo.setContent(request.getParameter("content"));
		//bVo.setProfessorNum(request.getParameter("ProfessorNum"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url+num);
		dispatcher.forward(request, response);
	}
}
