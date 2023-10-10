package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pj.dto.BoardVO;
import com.pj.dto.QnaDTO;

import util.DBManager;

public class QnaDAO {
	private QnaDAO() {
	}

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	public List<QnaDTO> selectQna(Integer StudentNum) {
		String sql = "select * from qna where StudentNum=? order by QnaNum desc";
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,StudentNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaDTO qDTO = new QnaDTO();
				qDTO.setQnaNum(rs.getInt("QnaNum"));
				qDTO.setTitle(rs.getString("title"));
				qDTO.setWriter(rs.getString("writer"));
				qDTO.setDay(rs.getString("day"));
				qDTO.setAnswer(rs.getString("answer"));
				list.add(qDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public void insertQna(QnaDTO qDTO) {
		String sql = "insert into qna("
				+ " title, writer,day, type, content, StudentNum ) "
				+ "values( ?,?,now(),? ,? ,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, qDTO.getTitle());
			pstmt.setString(2, qDTO.getWriter());
			pstmt.setString(3, qDTO.getType());
			pstmt.setString(4, qDTO.getContent());
			pstmt.setInt(5, qDTO.getStudentNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public QnaDTO selectOneQna(Integer QnaNum) {
		String sql = "select * from qna where QnaNum = ?";
		QnaDTO qDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, QnaNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qDTO = new QnaDTO();
				qDTO.setQnaNum(rs.getInt("QnaNum"));
				qDTO.setTitle(rs.getString("title"));
				qDTO.setWriter(rs.getString("writer"));
				qDTO.setDay(rs.getString("day"));
				qDTO.setType(rs.getString("type"));
				qDTO.setContent(rs.getString("content"));
				qDTO.setAnswer(rs.getString("answer"));
				qDTO.setAnswerday(rs.getString("answerday"));
				qDTO.setAnswerer(rs.getString("answerer"));
				qDTO.setStudentNum(rs.getInt("StudentNum"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qDTO;
	}

	public void insertAnswer(QnaDTO qDTO) {
		String sql = "update qna set answer=?, answerday=now(), answerer=? where QnaNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qDTO.getAnswer());
			pstmt.setString(2, qDTO.getAnswerer());
			pstmt.setInt(3, qDTO.getQnaNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public List<QnaDTO> selectAllQna() {
		String sql = "select * from qna order by QnaNum desc";
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { 
				QnaDTO qDTO = new QnaDTO();
				qDTO.setQnaNum(rs.getInt("QnaNum"));
				qDTO.setStudentNum(rs.getInt("StudentNum"));
				qDTO.setTitle(rs.getString("title"));
				qDTO.setWriter(rs.getString("writer"));
				qDTO.setDay(rs.getString("day"));
				qDTO.setAnswer(rs.getString("answer"));
				list.add(qDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}
