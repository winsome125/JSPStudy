package model2.mvcboard;

// mvcboard 테이블의 레코드를 저장하기 위한 DTO클래스
public class MVCBoardDTO {

	// 멤버 변수 선언
	private String idx;
	private String name;
	private String title;
	private String content;
	private java.sql.Date postdate; // 날짜타입이므로 Date형
	private String ofile;
	private String sfile;
	private int downcount;  // 다운로드 카운트 int형
	private String pass;
	private int visitcoutn;  // 조회수 int형
	
	
	// getter/setter
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public int getDowncount() {
		return downcount;
	}
	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getVisitcoutn() {
		return visitcoutn;
	}
	public void setVisitcoutn(int visitcoutn) {
		this.visitcoutn = visitcoutn;
	}
	
	
}
