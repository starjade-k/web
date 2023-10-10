package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.ClassDAO;
import com.pj.dao.PlanDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.PlanDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminConfirmAction implements Action { 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String[] RA=request.getParameterValues("RA");
		
		int[] newArr = new int[RA.length];
        for (int i = 0; i < RA.length; i++) {
        	ClassDTO cDTO=new ClassDTO();
            if(RA[i]!=null) {
    			cDTO.setConfirm(Boolean.parseBoolean("true"));
    		} else {
    			cDTO.setConfirm(Boolean.parseBoolean(""));
    		}
            newArr[i] = Integer.parseInt(RA[i]);
            cDTO.setClassNum(newArr[i]);
            ClassDAO cDao=ClassDAO.getInstance();
    		cDao.updateConfirm(cDTO);
        }
        
        
		
		//데이터집어넣는쪽
		
		
		String url="BoardServlet?command=admin_class_list";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		//new BoardListAction().execute(request, response);
	}
}
