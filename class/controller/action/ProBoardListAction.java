package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.BoardDAO;
import com.pj.dao.StuDAO;
import com.pj.dto.BoardVO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProBoardListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "10_notice.jsp";
		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardVO> list = bDao.selectAllBoards();
		request.setAttribute("boardList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
