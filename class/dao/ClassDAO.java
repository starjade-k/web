package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pj.dto.ClassDTO;

import jakarta.servlet.http.HttpServletRequest;
import util.DBManager;
public class ClassDAO {
	public ClassDAO() {
	}

	private static ClassDAO instance = new ClassDAO();

	public static ClassDAO getInstance() {
		return instance;
	}

	
	public void addClass(ClassDTO add) {
		
		String sql = "insert into addclass("
				+ "className, time, classroom, credit, max,ProfessorNum,MajorNum,liberal)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, add.getClassName());
			pstmt.setString(2, add.getTime());
			pstmt.setString(3, add.getClassroom());
			pstmt.setInt(4, add.getCredit());
			pstmt.setInt(5, add.getMax());
			pstmt.setInt(6, add.getProfessorNum());
			pstmt.setInt(7, add.getMajorNum());
			pstmt.setString(8, add.getLiberal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public List<ClassDTO> selectMyClass(Integer ProfessorNum) {
		String sql = "select ClassNum, className,time,classroom,max,credit,PlanYN,confirm from addclass where ProfessorNum=?";
		List<ClassDTO> list = new ArrayList<ClassDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ProfessorNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ClassDTO cDTO = new ClassDTO();
				cDTO.setClassNum(rs.getInt("ClassNum"));
				cDTO.setClassName(rs.getString("className"));
				cDTO.setTime(rs.getString("time"));
				cDTO.setClassroom(rs.getString("classroom"));
				cDTO.setMax(rs.getInt("max"));
				cDTO.setCredit(rs.getInt("credit"));
				cDTO.setPlanYN(rs.getString("PlanYN"));
				cDTO.setConfirm(rs.getBoolean("confirm"));
				list.add(cDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return list;
	}
	
		public ClassDTO selectPlanFormByClassNum(String ClassnNum) {
			String sql = "select className, ClassNum, addclass.ProfessorNum, addclass.MajorNum, professor.name  from addclass  right outer join professor on addclass.ProfessorNum = professor.ProfessorNum where ClassNum = ?";
			
			ClassDTO cDto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ClassnNum);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					cDto = new ClassDTO();
					cDto.setClassName(rs.getString("className"));
					cDto.setClassNum(rs.getInt("ClassNum"));
					cDto.setProfessorNum(rs.getInt("ProfessorNum"));
					cDto.setMajorNum(rs.getInt("MajorNum"));
					cDto.setProfessorName(rs.getString("professor.name"));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return cDto;
	}
		public void updatePlanYN(ClassDTO cVO) {
			String sql = "update addclass set PlanYN=? where ClassNum=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cVO.getPlanYN());
				pstmt.setInt(2, cVO.getClassNum());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			} 
		}
		public List<ClassDTO> selectAllClass() {
			String sql = "select ClassNum, className, classroom, max, credit, addclass.confirm ,professor.name,major.major from addclass right outer join professor on addclass.ProfessorNum = professor.ProfessorNum right outer join major on addclass.MajorNum = major.MajorNum  where PlanYN='Y'";
			List<ClassDTO> list = new ArrayList<ClassDTO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ClassDTO cDTO = new ClassDTO();
					cDTO.setClassNum(rs.getInt("ClassNum"));
					cDTO.setClassName(rs.getString("className"));
					cDTO.setClassroom(rs.getString("classroom"));
					cDTO.setMax(rs.getInt("max"));
					cDTO.setCredit(rs.getInt("credit"));
					cDTO.setConfirm(rs.getBoolean("addclass.confirm"));
					cDTO.setProfessorName(rs.getString("professor.name"));
					cDTO.setMajor(rs.getString("major.major"));
					list.add(cDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return list;
		}
		public void updateConfirm(ClassDTO cVO) {
			String sql = "update addclass set confirm=? where ClassNum=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setBoolean(1, cVO.isConfirm());
				pstmt.setInt(2, cVO.getClassNum());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			} 
		}
		
}