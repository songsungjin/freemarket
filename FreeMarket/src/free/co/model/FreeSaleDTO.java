package free.co.model;

import java.io.Serializable;

/*
DROP TABLE FREESALE;

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

CREATE SEQUENCE SEQ_FREESALE
START WITH 1 INCREMENT BY 1;

ALTER TABLE FREESALE
ADD CONSTRAINT FK_FREESALE_ID FOREIGN KEY(ID)
REFERENCES FREEMEMBER(ID);

SELECT * FROM FREESALE;
*/
public class FreeSaleDTO implements Serializable{
	
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
	private String regdate;
	private int auth;
	
	////DB에는 들어가지 않는 항목
	private int page;
	
	public FreeSaleDTO() {}

	public FreeSaleDTO(int seq, int bbs_num, String id, String title, String content, String category, int price,
			int del, String filename, int readcount, String regdate, int auth) {
		this.seq = seq;
		this.bbs_num = bbs_num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.price = price;
		this.del = del;
		this.filename = filename;
		this.readcount = readcount;
		this.regdate = regdate;
		this.auth = auth;
	}

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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "FreeSaleDTO [seq=" + seq + ", bbs_num=" + bbs_num + ", id=" + id + ", title=" + title + ", content="
				+ content + ", category=" + category + ", price=" + price + ", del=" + del + ", filename=" + filename
				+ ", readcount=" + readcount + ", regdate=" + regdate + ", auth=" + auth + "]";
	}
	
}
