package sist.co.model;


public class itemDTO {
/*
   CREATE TABLE FREESALE(
   SEQ number(8) primary key,      --시퀀스
   BBS_NUM NUMBER(1) NOT NULL,       --게시판번호(판매:1, 후기:2)
   ID VARCHAR2(50) NOT NULL,      --아이디
   TITLE VARCHAR2(200) NOT NULL,      --제목
   CONTENT VARCHAR2(4000) NOT NULL,   --내용
   CATEGORY VARCHAR2(200) NOT NULL,   --카테고리
   PRICE NUMBER(20) NOT NULL,      --상품가격
   DEL NUMBER(1) NOT NULL,         --삭제여부(0:존재, 1:삭제)
   FILENAME VARCHAR2(1000) NOT NULL,   --이미지파일이름   
   READCOUNT NUMBER(8) NOT NULL,      --조회수
   REGDATE DATE NOT NULL,         --등록시간   
   AUTH NUMBER(1) NOT NULL         --판매구분(1:판매, 2:구매)
);
 */
	private int seq;
	private int bbs_num;
	private String id;
	private String title;
	private String content;
	private String category;
	private int price;
	private int del;
	private String filename;
	private int readcount;
	private String regidate;
	private int auth;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBbs_num() {
		return bbs_num;
	}
	public void setBbs_num(int bbs_num) {
		this.bbs_num = bbs_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	
}
