package com.pj.controller;

import com.pj.controller.action.Action;
import com.pj.controller.action.AddAnswerAction;
import com.pj.controller.action.AddClassAction;
import com.pj.controller.action.AddClassFormAction;
import com.pj.controller.action.AddPlanAction;
import com.pj.controller.action.AddPlanFormAction;
import com.pj.controller.action.AddQnaAction;
import com.pj.controller.action.AddQnaFormAction;
import com.pj.controller.action.AdminClassListAction;
import com.pj.controller.action.AdminConfirmAction;
import com.pj.controller.action.AdminStuListAction;
import com.pj.controller.action.AllQnaListAction;
import com.pj.controller.action.AllSelectQnaAction;
import com.pj.controller.action.BoardDeleteAction;
import com.pj.controller.action.BoardListAction;
import com.pj.controller.action.BoardUpdateAction;
import com.pj.controller.action.BoardUpdateFormAction;
import com.pj.controller.action.BoardViewAction;
import com.pj.controller.action.BoardWriteAction;
import com.pj.controller.action.BoardWriteFormAction;
import com.pj.controller.action.ClassListAction;
import com.pj.controller.action.ClassNoticeForm;
import com.pj.controller.action.ClassRegiList;
import com.pj.controller.action.ClassRegistration;
import com.pj.controller.action.LoginAdminAction;
import com.pj.controller.action.LoginFormAction;
import com.pj.controller.action.LoginProfessorAction;
import com.pj.controller.action.LoginStudentAction;
import com.pj.controller.action.Main;
import com.pj.controller.action.ProBoardListAction;
import com.pj.controller.action.ProBoardViewAction;
import com.pj.controller.action.ProfessorInfo;
import com.pj.controller.action.QnaListAction;
import com.pj.controller.action.SearchClass;
import com.pj.controller.action.SelectAdminPlanAction;
import com.pj.controller.action.SelectPlanAction;
import com.pj.controller.action.SelectQnaAction;
import com.pj.controller.action.StudentAddClass;
import com.pj.controller.action.StudentCancelClass;
import com.pj.controller.action.StudentTopInfo;
import com.pj.controller.action.UpdatePlanAction;
import com.pj.controller.action.UpdatePlanFormAction;
import com.pj.controller.action.UpdateStuStateAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);

		if (command.equals("home")) {	// 메인 화면
			action = new LoginFormAction();
		} else if(command.equals("loginStudent")) { // 학생 로그인
			action = new LoginStudentAction();
		} else if(command.equals("loginProfessor")) { // 교수 로그인
			action = new LoginProfessorAction();
		} else if (command.equals("studentTopInfo")) { // 학생 상단 메뉴바의 좌측의 학생정보
			action = new StudentTopInfo();
		} else if (command.equals("professorInfo")) { // 교수 정보변경의 교수 정보
			action = new ProfessorInfo();
		} else if (command.equals("loginAdmin")) { // 관리자 로그인
			action = new LoginAdminAction();
		} else if (command.equals("add_class")) { // 교수의 강의등록 view로 이동
			action = new AddClassFormAction();
		} else if (command.equals("add_class_write")) { // 교수의 강의등록
			action = new AddClassAction();
		} else if (command.equals("class_list")) { // 로그인된 교수의 강의등록한 강의목록
			action = new ClassListAction();
		} else if (command.equals("board_list")) { // 공지사항 view
			action = new BoardListAction();
		} else if (command.equals("pro_board_list")) { // 교수의 공지사항 작성
			action = new ProBoardListAction();
		} else if (command.equals("board_view")) { // 교수의 공지사항 목록
			action = new BoardViewAction();
		} else if (command.equals("pro_board_view")) { // 교수의 공지사항 목록
			action = new ProBoardViewAction();
		} else if (command.equals("board_write_form")) { // 교수의 공지사항 등록 페이지
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) { // 교수의 공지사항 등록
			action = new BoardWriteAction();
		} else if (command.equals("board_update_form")) { // 공지사항 수정 view
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) { // 공지사항 수정
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) { // 공지사항 삭제
			action = new BoardDeleteAction();
		} else if (command.equals("add_plan_write")) { // 강의계획서 작성 view
			action = new AddPlanFormAction();
		} else if (command.equals("add_plan")) { // 강의계획서 작성
			action = new AddPlanAction();
		} else if (command.equals("select_plan")) { // 클릭한 강의의 강의계획서
			action = new SelectPlanAction();
		} else if (command.equals("update_plan_form")) { // 강의계획서 수정 view
			action = new UpdatePlanFormAction();
		} else if (command.equals("update_plan")) { // 강의계획서 수정
			action = new UpdatePlanAction();
		} else if (command.equals("add_qna")) { // 문의사항 view
			action = new AddQnaFormAction();
		} else if (command.equals("add_qna_write")) { // 문의사항 작성
			action = new AddQnaAction();
		} else if (command.equals("qna_list")) { // 문의사항 목록
			action = new QnaListAction();
		}  else if (command.equals("select_qna")) { // 문의사항 선택 후 상세내용
			action = new SelectQnaAction();
		}  else if (command.equals("admin_class_list")) { // 관리자 강의승인 목록
			action = new AdminClassListAction();
		}  else if (command.equals("admin_select_plan")) { // 관리자 강의계획서 선택 할 시
			action = new SelectAdminPlanAction();
		} else if (command.equals("admin_confirm")) { // 관리자의 강의 승인
			action = new AdminConfirmAction();
		} else if (command.equals("admin_stu_list")) { // 관리자의 학생 리스트
			action = new AdminStuListAction();
		} else if (command.equals("update_stu_state")) { // 학생 상태 업데이트
			action = new UpdateStuStateAction();
		} else if (command.equals("all_qna_list")) { // 학생문의글 목록
			action = new AllQnaListAction();
		} else if (command.equals("all_select_qna")) { // 학생 문의글 선택
			action = new AllSelectQnaAction();
		} else if (command.equals("add_answer")) { // 문의글 답변 추가
			action = new AddAnswerAction();
		} else if (command.equals("class_registration")) { // 수강신청의 강의 목록
			action = new ClassRegistration();
		} else if (command.equals("search_class")) { // 강의 검색
			action = new SearchClass();
		} else if (command.equals("main")) { // 메인화면 view
			action = new Main();
		} else if (command.equals("class_regiList")) { // 수강 신청한 강의목록
			action = new ClassRegiList();
		} else if (command.equals("stu_add_class")) { // 수강 신청 버튼 클릭시
			action = new StudentAddClass();
		} else if (command.equals("stu_class_cancel")) { // 수강 신청취소
			action = new StudentCancelClass();
		} else if (command.equals("class_notice")) { // 수강신청 안내 view
			action = new ClassNoticeForm();
		}

		return action;
}
}

