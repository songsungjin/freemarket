package sist.co.model;

import java.io.Serializable;

/*
CREATE TABLE SISTCALENDAR(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WDATE VARCHAR2(12) NOT NULL,
	REGDATE DATE NOT NULL 
);
CREATE SEQUENCE SEQ_SIST_CALENDAR
START WITH 1 INCREMENT BY 1;

ALTER TABLE SISTCALENDAR
ADD CONSTRAINT FK_SIST_CALENDAR_ID FOREIGN KEY(ID)
REFERENCES SISTMEMBER(ID);  
 */

public class SistCalendar implements Serializable  {

	private int seq;
	private String id;
	private String title;
	private String content;	
	private String wdate;
	private String regdate;		// 기록 날짜
	
	public SistCalendar() {}

	public SistCalendar(int seq, String id, String title, String content, String wdate, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.regdate = regdate;
	}
	
	public SistCalendar(String id, String title, String content, String wdate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}



