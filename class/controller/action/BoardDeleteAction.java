package com.pj.controller.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.pj.dao.BoardDAO;
import com.pj.dto.BoardVO;

public class BoardDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("NoticeNum");
		String url="BoardServlet?command=pro_board_list";
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.deleteBoard(num);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}
}
