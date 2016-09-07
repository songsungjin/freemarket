package free.co.model;

import java.io.Serializable;

/*
DROP TABLE FREEFAQ;

CREATE TABLE FREEFAQ(
   SEQ NUMBER(8) PRIMARY KEY,
   TITLE VARCHAR2(200) NOT NULL,
   CONTENT VARCHAR2(4000) NOT NULL,
   WDATE DATE NOT NULL,
   DEL NUMBER(1) NOT NULL   
);

CREATE SEQUENCE SEQ_FREEFAQ
START WITH 1 INCREMENT BY 1;

SELECT * FROM FREEFAQ;
*/
public class FreeFaq implements Serializable{
	
	private int seq;
	private String title;
	private String content;
	private String wdate;
	private int del;
	
	public FreeFaq() {}

	public FreeFaq(int seq, String title, String content, String wdate, int del) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "FreeFaq [seq=" + seq + ", title=" + title + ", content=" + content + ", wdate=" + wdate + ", del=" + del
				+ "]";
	}
}
