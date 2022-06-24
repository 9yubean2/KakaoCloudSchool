package com.dia.control.guestbook;

public class GuestbookDTO {
	
	private int id = 1;
	private String title = "";
	private String contents = "";
	private String writer = "";
	private String wdate = "";
	private int hit = 0;
	
	//추가적인 생성자를 만들 생각이 없으면 이거 안 만들어도 된다.
	//시스템은 우리가 아무런 생성자도 안 만들면 디폴트 생성자를 만들어서 호출
	//하는 일은 없지만 만들어서 호출
	//필요에 의해서 디폴트 생성자 이외의 생성자를 만들면 시스템이 디폴트 생성자를 안 만들어 준다
	//그래서 기본 객체 생성 못함 GuestbookDTO dto = new GuestbookDTO();
	//실제로 DB에 접근할거면 생성자 없어도 된다 어차피 
	public GuestbookDTO() {//extends Object 생략된 상태
		super(); //부모 클래스의 생성자를 호출
		//default 생성자 매개변수 없는 생성자
		// TODO Auto-generated constructor stub
	}
	

	public GuestbookDTO(int id, String title, String contents, String writer, String wdate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.wdate = wdate;
		this.hit = hit;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
