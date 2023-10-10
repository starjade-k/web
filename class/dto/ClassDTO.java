package com.pj.dto;

//강의
public class ClassDTO {
	private int ClassNum;
	private int ProfessorNum;
	private int MajorNum;
	private int PlanNum;
	private String className;
	private String time;
	private String classroom;
	private int credit;
	private int max;
	private boolean confirm;
	private String liberal;
	private String PlanYN;
	private String ProfessorName;
	private String major;
	private String Studentname;
	
	
	
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		this.Studentname = studentname;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public int getClassNum() {
		return ClassNum;
	}
	public void setClassNum(int classNum) {
		ClassNum = classNum;
	}
	public int getProfessorNum() {
		return ProfessorNum;
	}
	public void setProfessorNum(int professorNum) {
		ProfessorNum = professorNum;
	}
	public int getMajorNum() {
		return MajorNum;
	}
	public void setMajorNum(int majorNum) {
		MajorNum = majorNum;
	}
	public int getPlanNum() {
		return PlanNum;
	}
	public void setPlanNum(int planNum) {
		PlanNum = planNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	public String getLiberal() {
		return liberal;
	}
	public void setLiberal(String liberal) {
		this.liberal = liberal;
	}
	public String getPlanYN() {
		return PlanYN;
	}
	public void setPlanYN(String planYN) {
		PlanYN = planYN;
	}
	
	
	
	
}
