package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.Board;

@WebServlet("/")
@MultipartConfig(maxFileSize=1024*1024*2, location="c:/Temp/img")
public class Boardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDAO dao;
	private ServletContext ctx;
	
	public Boardcontroller() {
		super();

	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new BoardDAO(); 
		ctx = getServletContext();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
		String command = request.getServletPath();
		String site = null;
		
		//경로 라우팅(경로를 찾아줌)
				switch (command) {
				case "/list":
					site = getList(request);
					break;
				case "/view":
					site = getView(request);
					break;
				case "/write": //글쓰기 화면을 보여줌
					site = "write.jsp";
					break;	
				case "/insert": //insert 기능
					site = insertBoard(request);
					break;
				case "/edit": //수정 화면을 보여줌
					site = getViewForEdit(request);
					break;
				case "/update": //update 기능
					site = updateBoard(request);
					break;
				case "/delete": //delete 기능
					site = deleteBoard(request);
					break;
				}
	}

	public String getList(HttpServletRequest request) {
		List<Board> list;
		return "index.jsp";
	}
		
	public String getView(HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		return "view.jsp";
	}
	
	public String insertBoard(HttpServletRequest request) {
		Board b = new Board();
		return "redirect:/list";
	}
       
	public String getViewForEdit(HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		return "edit.jsp";
	}
	
	public String updateBoard(HttpServletRequest request) {
		Board b = new Board();
		return "redirect:/view?board_no=" + b.getBoard_no();
	}
	
	public String deleteBoard(HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		return "redirect:/list";
	}
}
