package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pj.dto.AdmDTO;
import com.pj.dto.ClassDTO;
import com.pj.dto.StuDTO;

import util.DBManager;

public class AdmDAO {
	public AdmDAO() {
	}

	private static AdmDAO instance = new AdmDAO();

	public static AdmDAO getInstance() {
		return instance;
	}

	Connection getConnection(){
		Connection conn = null;
		Context initContext;

		try{
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();

		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}

	public int login(AdmDTO aTo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select Adminpwd from admin where AdminId = ?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aTo.getAdminId());
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
			if (rs.next()) {

				if (rs.getString(1).equals(aTo.getAdminPwd())) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 학번이 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류
	}
	public List<StuDTO> stuMajor(int MajorNum){
		String sql = "select StudentNum, name, grade, student.in from student where MajorNum = ?";
		ArrayList<StuDTO> stuMajor = new ArrayList<StuDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MajorNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				StuDTO dTo = new StuDTO();
				dTo.setStudentNum(rs.getInt("StudentNum"));
				dTo.setName(rs.getString("name"));
				dTo.setGrade(rs.getString("grade"));
				dTo.setIn(rs.getString("in"));


				stuMajor.add(dTo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return stuMajor;
	}
	public void updateStuState(StuDTO sDTO) {
		String sql = "update student set student.in=? where StudentNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sDTO.getIn());
			pstmt.setInt(2, sDTO.getStudentNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		} 
	}
}
