package sist.co.model;

import java.io.Serializable;
import java.util.Date;

/*
CREATE TABLE SISTPOLL(
	POLLID NUMBER NOT NULL,
	ID VARCHAR2(50) NOT NULL,
	QUESTION VARCHAR2(1000) NOT NULL,
	SDATE DATE NOT NULL,
	EDATE DATE NOT NULL,
	ITEMCOUNT NUMBER NOT NULL,
	POLLTOTAL NUMBER NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT PK_SIST_POLL PRIMARY KEY("POLLID") 
);

CREATE SEQUENCE SEQ_SIST_POLL 
START WITH 1 INCREMENT BY 1;

ALTER TABLE SISTPOLL ADD CONSTRAINT FK_SIST_POLL
FOREIGN KEY("ID")
REFERENCES SISTMEMBER("ID");
*/

// 질문 
public class SistPollDTO implements Serializable {
	
	private int pollid;		// 투표 번호	1 2 3 4 
	private String id;		// 투표 아이디  
	private String question;	// 질문
	private Date sdate;		// 시작일		
	private Date edate;		// 종료일
	private int itemcount;	// 문항수(보기)
	private int polltotal;	// 투표한 사람수
	private Date regdate;	// 투표한 날
	private boolean vote;	// 투표를 했는가?		
	
	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public SistPollDTO() {
	}
	
	public SistPollDTO(int pollid, String id, String question, Date sdate, Date edate,
			int itemcount, int polltotal, Date regdate) {
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.regdate = regdate;
	}
	
	public SistPollDTO(String id, String question, Date sdate, Date edate,
			int itemcount, int polltotal) {		
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;		
	}
	
	public SistPollDTO(String id, String question,int itemcount, int polltotal) {		
		this.id = id;
		this.question = question;		
		this.itemcount = itemcount;	
		this.polltotal = polltotal;
	}

	@Override
	public String toString() {		
		return "sistPollDTO[pollid=" + pollid + ", id=" + id 
				+ ", question=" + question + ", sdate=" + sdate 
				+ ", edate=" + edate + ", itemcount=" + itemcount 
				+ ", polltotal=" + polltotal + ", regdate=" + regdate 
				+ "]";
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPolltotal() {
		return polltotal;
	}

	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}






