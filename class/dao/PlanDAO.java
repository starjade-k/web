package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pj.dto.BoardVO;
import com.pj.dto.ClassDTO;
import com.pj.dto.PlanDTO;

import util.DBManager;
public class PlanDAO {
	public PlanDAO() {
	}

	private static PlanDAO instance = new PlanDAO();

	public static PlanDAO getInstance() {
		return instance;
	}

	
	public void addPlan(PlanDTO add) {
		
		String sql = "insert into plan("
				+ "ClassNum,ProfessorNum,MajorNum, week1, week2, week3, week4,"
				+ "week5,week6,week7,week8,week9,week10,week11,week12,week13,"
				+ "week14,week15,week16)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, add.getClassNum());
			pstmt.setInt(2, add.getProfessorNum());
			pstmt.setInt(3, add.getMajorNum());
			pstmt.setString(4, add.getWeek1());
			pstmt.setString(5, add.getWeek2());
			pstmt.setString(6, add.getWeek3());
			pstmt.setString(7, add.getWeek4());
			pstmt.setString(8, add.getWeek5());
			pstmt.setString(9, add.getWeek6());
			pstmt.setString(10, add.getWeek7());
			pstmt.setString(11, add.getWeek8());
			pstmt.setString(12, add.getWeek9());
			pstmt.setString(13, add.getWeek10());
			pstmt.setString(14, add.getWeek11());
			pstmt.setString(15, add.getWeek12());
			pstmt.setString(16, add.getWeek13());
			pstmt.setString(17, add.getWeek14());
			pstmt.setString(18, add.getWeek15());
			pstmt.setString(19, add.getWeek16());
					
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public PlanDTO selectPlan (String ClassNum) {
		String sql = "select PlanNum,ClassNum,week1,week2,"
				+ "week3,week4,week5,week6,week7,"
				+ "week8,week9,week10,week11,"
				+ "week12,week13,week14,week15,week16,professor.name from plan right outer join professor on plan.ProfessorNum = professor.ProfessorNum where ClassNum=?";
		PlanDTO pDTO=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ClassNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pDTO = new PlanDTO();
				pDTO.setPlanNum(rs.getInt("PlanNum"));
				pDTO.setClassNum(rs.getInt("ClassNum"));
				pDTO.setWeek1(rs.getString("week1"));
				pDTO.setWeek2(rs.getString("week2"));
				pDTO.setWeek3(rs.getString("week3"));
				pDTO.setWeek4(rs.getString("week4"));
				pDTO.setWeek5(rs.getString("week5"));
				pDTO.setWeek6(rs.getString("week6"));
				pDTO.setWeek7(rs.getString("week7"));
				pDTO.setWeek8(rs.getString("week8"));
				pDTO.setWeek9(rs.getString("week9"));
				pDTO.setWeek10(rs.getString("week10"));
				pDTO.setWeek11(rs.getString("week11"));
				pDTO.setWeek12(rs.getString("week12"));
				pDTO.setWeek13(rs.getString("week13"));
				pDTO.setWeek14(rs.getString("week14"));
				pDTO.setWeek15(rs.getString("week15"));
				pDTO.setWeek16(rs.getString("week16"));
				pDTO.setProfessorName(rs.getString("professor.name"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return pDTO;
	}
	public void updatePlan(PlanDTO pDTO) {
		String sql = "update plan set week1=?,week2=?,week3=?,"
				+ "week4=?,week5=?,week6=?,"
				+ "week7=?,week8=?,week9=?,"
				+ "week10=?,week11=?,week12=?,"
				+ "week13=?,week14=?,week15=?,week16=?"
				+ " where ClassNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pDTO.getWeek1());
			pstmt.setString(2, pDTO.getWeek2());
			pstmt.setString(3, pDTO.getWeek3());
			pstmt.setString(4, pDTO.getWeek4());
			pstmt.setString(5, pDTO.getWeek5());
			pstmt.setString(6, pDTO.getWeek6());
			pstmt.setString(7, pDTO.getWeek7());
			pstmt.setString(8, pDTO.getWeek8());
			pstmt.setString(9, pDTO.getWeek9());
			pstmt.setString(10, pDTO.getWeek10());
			pstmt.setString(11, pDTO.getWeek11());
			pstmt.setString(12, pDTO.getWeek12());
			pstmt.setString(13, pDTO.getWeek13());
			pstmt.setString(14, pDTO.getWeek14());
			pstmt.setString(15, pDTO.getWeek15());
			pstmt.setString(16, pDTO.getWeek16());
			pstmt.setInt(17, pDTO.getClassNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	}
