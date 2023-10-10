package com.pj.controller.action;

import java.io.IOException;
import java.util.List;

import com.pj.dao.StuDAO;
import com.pj.dto.ClassDTO;
import com.pj.dto.StuDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchClass implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "8_application.jsp";

		int sNum= (Integer.parseInt(request.getParameter("StudentNum")));
		StuDAO sDao = StuDAO.getInstance();
		List<StuDTO> user_info = sDao.top_Info(sNum);
		request.setAttribute("userList", user_info);

		String key = request.getParameter("select");
		String major = request.getParameter("major");
		String keyword = request.getParameter("search");

		if(key.equals("전체")&& major.equals("전체")&& keyword.equals("")) { // 검색이용 안했을 때
			List<ClassDTO> list = sDao.ClassList();
			request.setAttribute("classList", list);
		} else if(key.equals("전체") && major.equals("전체")) { // 검색창만 이용할 때
			List<ClassDTO> list = sDao.SearchKeyword(keyword);
			request.setAttribute("classList", list);
		} else if(key.equals("전체") && keyword.equals("")) { // 전공으로만 검색할 때
			List<ClassDTO> list = sDao.SearchMajor(major);
			request.setAttribute("classList", list);
		} else if(major.equals("전체") && keyword.equals("")) { // 전공 or 교양 으로만 검색할 때
			List<ClassDTO> list = sDao.SearchLiberal(key);
			request.setAttribute("classList", list);
		} else if(!major.equals("전체") && !keyword.equals("") && key.equals("전체")) { // 학과&검색창 이용할 때
			List<ClassDTO> list = sDao.SearchKeywordMajor(keyword,major);
			request.setAttribute("classList", list);
		} else if(key.equals("교양") && major.equals("전체") && !keyword.equals("")) { // 교양&검색창 이용할 때
			List<ClassDTO> list = sDao.SearchKeywordKey(keyword,key);
			request.setAttribute("classList", list);
		} else if(key.equals("전공") && major.equals("전체") && !keyword.equals("")) { // 전공&검색창 이용할 때
			List<ClassDTO> list = sDao.SearchKeywordKey(keyword,key);
			request.setAttribute("classList", list);
		} else if(!major.equals("전체") && !keyword.equals("") && !key.equals("전체")) { // 모든 검색조건 이용할 때
			List<ClassDTO> list = sDao.SearchAll(keyword,key,major);
			request.setAttribute("classList", list);
		} else if(!major.equals("전체") && keyword.equals("") && !key.equals("전체")) { // 구분&학과 검색 할 때
			List<ClassDTO> list = sDao.SearchLiberalMajor(key,major);
			request.setAttribute("classList", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
