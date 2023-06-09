package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DTO.Board;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt;

	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// DB연결 메소드
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 게시판 리스트 가져오기
	public ArrayList<Board> getList() {
		Connection conn = open();
		ArrayList<Board> boardList = new ArrayList<>();
		return boardList;
	}

	// >쿼리문 실행 : 무조건 try,catch써주기<

	// 게시물 내용 가져오기
	public Board getView(int board_no) {
		Connection conn = open();
		Board b = new Board();
		return b;
	}

	// 조회수 증가
	public void updateViews(int board_no) {
		Connection conn = open();
	}

	// 게시글 등록
	/*
	 * 매개변수로 게시글 객체(Board b)를 받아와서 데이터베이스에 새로운 게시글을 등록 이때 반환값이 필요하지 않기 때문에 void를 반환
	 * 타입으로 사용
	 */
	public void insertBoards(Board b) {
		Connection conn = open();
	} // 등록하는 기능이라 반환값 노필요 >void

	// 게시글 수정화면 보여주기 : 조회한 게시글 반환하기 위해 Board타입을 반환타입으로 사용
	public Board getViewForEdit(int board_no) {
		Connection conn = open();
		Board b = new Board();
		return b;
	}

	// 게시글 수정하기
	public void updateBoards(Board b) {
		Connection conn = open();
	}

	// 게시글 삭제
	public void deleteBoards(int board_no) {
		Connection conn = open();
	}

}
