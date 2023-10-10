package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pj.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from notice order by NoticeNum desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNoticeNum(rs.getInt("NoticeNum"));
				bVo.setTitle(rs.getString("title"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setDay(rs.getString("day"));
				bVo.setType(rs.getString("type"));
				bVo.setContent(rs.getString("content"));
				bVo.setProfessorNum(rs.getInt("ProfessorNum"));
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(BoardVO bVo) {
		String sql = "insert into notice("
				+ " title, writer, day, type, content, ProfessorNum ) "
				+ "values(?, ?, sysdate(), ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getWriter());
		
			pstmt.setString(3, bVo.getType());
			pstmt.setString(4, bVo.getContent());
			pstmt.setInt(5, bVo.getProfessorNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	*/
	public BoardVO selectOneBoardByNum(String NoticeNum) {
		String sql = "select * from notice where NoticeNum = ?";
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NoticeNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new BoardVO();
				bVo.setNoticeNum(rs.getInt("NoticeNum"));
				bVo.setTitle(rs.getString("title"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setDay(rs.getString("day"));
				bVo.setType(rs.getString("type"));
				bVo.setContent(rs.getString("content"));
				bVo.setProfessorNum(rs.getInt("ProfessorNum"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(BoardVO bVo) {
		String sql = "update notice set title=?, writer=?, day=sysdate(), "
				+ "content=? where NoticeNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getWriter());
			//pstmt.setString(3, bVo.getDay());
			//pstmt.setString(4, bVo.getType());
			pstmt.setString(3, bVo.getContent());
			//pstmt.setInt(6, bVo.getProfessorNum());
			pstmt.setInt(4, bVo.getNoticeNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	public BoardVO checkPassWord(String pass, String num) {
		String sql = "select * from board where pass=? and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bVo;
	}
	*/
	public void deleteBoard(String NoticeNum) {
		String sql = "delete from notice where NoticeNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NoticeNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
