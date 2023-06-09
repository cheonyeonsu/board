package DTO;

public class Board {
	private int board_no; //게시물 번호
	private String title; //제목
	private String reg_date; //등록일
	private int views; //조회수
	private String content; //내용
	private String img; //이미지 경로+이미지명
	public int getBoard_no() {
		return board_no;
	}
	public void setBoards_no(int boards_no) {
		this.board_no = boards_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}