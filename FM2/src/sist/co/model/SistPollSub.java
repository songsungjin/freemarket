package sist.co.model;

import java.io.Serializable;

/*
CREATE TABLE SISTPOLLSUB(
	POLLSUBID NUMBER NOT NULL,
	POLLID NUMBER NOT NULL,
	ANSWER VARCHAR2(1000) NOT NULL,
	ACOUNT NUMBER NOT NULL,
	CONSTRAINT PK_SIST_POLLSUB PRIMARY KEY("POLLSUBID")
);

CREATE SEQUENCE SEQ_SIST_POLLSUB
START WITH 1 INCREMENT BY 1;

ALTER TABLE SISTPOLLSUB ADD CONSTRAINT FK_SIST_POLLSUB
FOREIGN KEY("POLLID")
REFERENCES SISTPOLL ("POLLID");

1 1 사과 	1
2 1 배 	0
3 1 귤 	0

4 2 이석희 0
5 2 황혜린 2


*/

// 선택항목수(보기) 사과, 배 
public class SistPollSub implements Serializable {
	private int pollsubid;	// 보기 나온 순서에 대한 번호
	private int pollid;		// 질문 번호
	private String answer;	// 보기: 1, 2,  a, b
	private int acount;		// 보기를 선택한 사람수	
	
	public SistPollSub() {}
	
	public SistPollSub(int pollsubid, int pollid, String answer, int acount) {
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}
	
	public SistPollSub(int pollid, String answer, int acount) {
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}

	@Override
	public String toString() {		
		return "sistPollSubDTO[pollsubid=" + pollsubid 
				+ ", pollid" + pollid + ", answer=" + answer
				+ ", acount=" + acount;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}
	
	
	
}



