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

import com.pj.dto.ProDTO;

public class ProDAO {
	public ProDAO() {
	}

	private static ProDAO instance = new ProDAO();

	public static ProDAO getInstance() {
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

	public int login(ProDTO pTo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from professor where ProfessorNum = ?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pTo.getProfessorNum());
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
			if (rs.next()) {

				if (rs.getString(1).equals(pTo.getPwd())) {
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

	public List<ProDTO> my_Info(int ProfessorNum){
		String sql = "select name,ProfessorNum,major.major,tel,email,major.MajorNum from professor inner join major on major.MajorNum where ProfessorNum = ? and major.MajorNum = professor.MajorNum";
		ArrayList<ProDTO> my_info = new ArrayList<ProDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ProfessorNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				ProDTO pTo = new ProDTO();
				pTo.setName(rs.getString("name"));
				pTo.setProfessorNum(rs.getInt("ProfessorNum"));
				pTo.setTel(rs.getString("tel"));
				pTo.setMajor(rs.getString("major.major"));
				pTo.setEmail(rs.getString("email"));
				pTo.setMajorNum(rs.getInt("major.MajorNum"));
				my_info.add(pTo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return my_info;
	}
	public int updateMember(ProDTO pTo) {
		int result = -1;
		String sql = "update professor set tel = ?, email = ? where ProfessorNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pTo.getTel());
			pstmt.setString(2, pTo.getEmail());
			pstmt.setInt(3, pTo.getProfessorNum());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updatePwd(String pwd , int pTo) {
        int result = -1;
        String sql = "update professor set pwd = ? where ProfessorNum = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pwd);
            pstmt.setInt(2, pTo);

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

	public List<ProDTO> check_Pwd(int ProfessorNum){
		String sql = "select pwd from professor where ProfessorNum = ?";
		ArrayList<ProDTO> pwd_info = new ArrayList<ProDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ProfessorNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				ProDTO pTo = new ProDTO();
				pTo.setPwd(rs.getString("pwd"));
				pwd_info.add(pTo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return pwd_info;
	}
}
