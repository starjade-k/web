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

import com.pj.dto.ClassDTO;
import com.pj.dto.StuDTO;
public class StuDAO {
	public StuDAO() {
	}

	private static StuDAO instance = new StuDAO();

	public static StuDAO getInstance() {
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

	public int login(StuDTO sTo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from student where StudentNum = ?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sTo.getStudentNum());
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
			if (rs.next()) {

				if (rs.getString(1).equals(sTo.getPwd())) {
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

	public List<StuDTO> top_Info(int StudentNum){
		String sql = "select name,StudentNum,grade,major.major from student inner join major on major.MajorNum where StudentNum = ? and student.MajorNum = major.MajorNum";
		ArrayList<StuDTO> user_info = new ArrayList<StuDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StudentNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				StuDTO dTo = new StuDTO();
				dTo.setStudentNum(rs.getInt("StudentNum"));
				dTo.setMajor(rs.getString("major.major"));
				dTo.setName(rs.getString("name"));
				dTo.setGrade(rs.getString("grade"));


				user_info.add(dTo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return user_info;
	}
	public List<StuDTO> my_Info(int StudentNum){
		String sql = "select name,StudentNum,grade,major.major,tel,email from student inner join major on major.MajorNum where StudentNum = ? and student.MajorNum = major.MajorNum";
		ArrayList<StuDTO> my_info = new ArrayList<StuDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StudentNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				StuDTO dTo = new StuDTO();
				dTo.setName(rs.getString("name"));
				dTo.setStudentNum(rs.getInt("StudentNum"));
				dTo.setTel(rs.getString("tel"));
				dTo.setMajor(rs.getString("major.major"));
				dTo.setEmail(rs.getString("email"));
				my_info.add(dTo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return my_info;
	}

	public int updateMember(StuDTO sTo) {
		int result = -1;
		String sql = "update student set tel = ?, email = ? where StudentNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sTo.getTel());
			pstmt.setString(2, sTo.getEmail());
			pstmt.setInt(3, sTo.getStudentNum());

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

	public int updatePwd(String pwd , int sTo) {
        int result = -1;
        String sql = "update student set pwd = ? where StudentNum = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pwd);
            pstmt.setInt(2, sTo);

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

	public List<StuDTO> check_Pwd(int StudentNum){
		String sql = "select pwd from student where StudentNum = ?";
		ArrayList<StuDTO> pwd_info = new ArrayList<StuDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StudentNum);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

			while(rs.next()) {
				StuDTO dTo = new StuDTO();
				dTo.setPwd(rs.getString("pwd"));
				pwd_info.add(dTo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return pwd_info;
	}
	 public List<ClassDTO> ClassList(){
		 String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor\r\n"
		 		+ "inner join major where addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchLiberal(String key){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and liberal = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, key);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchMajor(String key){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and major.major = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, key);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchKeyword(String keyword){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where className like ? and addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchLiberalMajor(String key, String major){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and liberal = ? and major.major = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, key);
				pstmt.setString(2, major);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchKeywordMajor(String keyword, String major){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where className like ? and addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and major.major = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setString(2, major);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchKeywordKey(String keyword, String key){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where className like ? and addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and liberal = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setString(2, key);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public List<ClassDTO> SearchAll(String keyword, String key, String major){
		 	String sql = "select ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from addclass inner join professor inner join major where className like ? and addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum and liberal = ? and major.major = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setString(2, key);
				pstmt.setString(3, major);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public int StuAddClass(int studentNum, int classnum){
		 	String sql = "insert into studentclass(StudentNum,ClassNum) select StudentNum,ClassNum from student,addclass where StudentNum = ? and ClassNum= ?";

			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, studentNum);
				pstmt.setInt(2, classnum);
				result = pstmt.executeUpdate();// 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

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

	 public List<ClassDTO> StuAddClassList(int studentNum){
		 	String sql = "select distinct student.name,studentclass.ClassNum,time,className,professor.name, major.major,classroom,credit,max,liberal from studentclass join student join addclass join professor join major\r\n"
		 			+ "		on studentclass.StudentNum = student.StudentNum and studentclass.ClassNum = addclass.ClassNum and addclass.ProfessorNum = professor.ProfessorNum and major.MajorNum = professor.MajorNum\r\n"
		 			+ "        where studentclass.StudentNum = ?";
			ArrayList<ClassDTO> class_list = new ArrayList<ClassDTO>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, studentNum);
				rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

				while(rs.next()) {
					ClassDTO dTo = new ClassDTO();
					dTo.setStudentname("student.name");
					dTo.setClassNum(rs.getInt("ClassNum"));
					dTo.setTime(rs.getString("time"));
					dTo.setClassName(rs.getString("className"));
					dTo.setProfessorName(rs.getString("professor.name"));
					dTo.setMajor(rs.getString("major.major"));
					dTo.setLiberal(rs.getString("liberal"));
					dTo.setClassroom(rs.getString("classroom"));
					dTo.setCredit(rs.getInt("credit"));
					dTo.setMax(rs.getInt("max"));

					class_list.add(dTo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				util.DBManager.close(conn, pstmt, rs);
			}
			return class_list;
	 }

	 public int StuDeleteClass(int studentNum, int classnum){
		 	String sql = "delete from studentclass where StudentNum = ? and ClassNum = ?";

			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, studentNum);
				pstmt.setInt(2, classnum);
				result = pstmt.executeUpdate();// 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

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

	 public int NumofMinusPeople(int classnum){
		 	String sql = "update addclass set max = max -1 where ClassNum = ?";

			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classnum);
				result = pstmt.executeUpdate();// 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

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

	 public int NumofPlusPeople(int classnum){
		 	String sql = "update addclass set max = max +1 where ClassNum = ?";

			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classnum);
				result = pstmt.executeUpdate();// 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌

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
}
