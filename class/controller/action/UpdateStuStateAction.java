package com.pj.controller.action;

import java.io.IOException;

import com.pj.dao.AdmDAO;
import com.pj.dao.ClassDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStuStateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String[] sNum=request.getParameterValues("StudentNum");
		String[] state=request.getParameterValues("state");//state[0]= value

		
		int[] newArr = new int[sNum.length];

		for (int b = 0; b < sNum.length; b++) {
				
				StuDTO sDTO = new StuDTO();
				
	            if(sNum[b]!=null) {
	            	sDTO.setStudentNum(Integer.parseInt(sNum[b]));
	        		sDTO.setIn(state[b]);//
	    		}  
	            
	            newArr[b] = Integer.parseInt(sNum[b]);
	            AdmDAO aDao=AdmDAO.getInstance();
				aDao.updateStuState(sDTO);
	    		
	        }
			
			
		String url = "24_1_studentManage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
