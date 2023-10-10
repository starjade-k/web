package com.pj.dto;

import java.sql.Timestamp;

public class BoardVO {
	private int NoticeNum;
	private String title;
	private String writer;
	private String type;
	private String day;
	private String content;
	private int ProfessorNum;
	
	public int getNoticeNum() {
		return NoticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		NoticeNum = noticeNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProfessorNum() {
		return ProfessorNum;
	}
	public void setProfessorNum(int professorNum) {
		ProfessorNum = professorNum;
	} 
}
	
	
	
	