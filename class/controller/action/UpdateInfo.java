package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.StuDAO;
import com.pj.dto.StuDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateInfo implements Action {
	@Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		System.out.println(request.getParameter("studentNum"));
	    StuDTO sTo = new StuDTO();
	    int id = Integer.parseInt(request.getParameter("studentNum"));

	    sTo.setTel(request.getParameter("tel"));
	    sTo.setEmail(request.getParameter("email"));
	    sTo.setStudentNum(id);


	    StuDAO eDao = StuDAO.getInstance();
	    eDao.updateMember(sTo);

	    new LoginStudentAction().execute(request, response);
	  }
}
