package com.pj.controller;

import java.io.IOException;

import com.pj.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public StudentServlet() {
        super();

    }
//    @Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init() 실행됨!");
//	}
//
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service() 실행됨!");
//	}


    @Override
	protected void doGet(HttpServletRequest request,
    	      HttpServletResponse response) throws ServletException, IOException {
    	    doPost(request, response);
    	  }

    @Override
	protected void doPost(HttpServletRequest request,
    	HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String command = request.getParameter("command");

    	ActionFactory af = ActionFactory.getInstance();
    	Action action = af.getAction(command);

    	if (action != null) {
    	  action.execute(request, response);
    	}
    }
}


