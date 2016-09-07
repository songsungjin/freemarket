package sist.co.model;

import java.io.Serializable;
import java.util.Date;

/*
CREATE TABLE SISTVOTER(
	VOTERID NUMBER NOT NULL,
	POLLID NUMBER,
	POLLSUBID NUMBER NOT NULL,
	ID VARCHAR2(50) NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT PK_SIST_VOTER PRIMARY KEY("VOTERID")
);

CREATE SEQUENCE SEQ_SIST_VOTER
START WITH 1 INCREMENT BY 1;

ALTER TABLE SISTVOTER ADD CONSTRAINT FK_SIST_VOTER
FOREIGN KEY ("POLLID")
REFERENCES SISTPOLL("POLLID"); 

ALTER TABLE SISTVOTER ADD CONSTRAINT FK2_SIST_VOTER
FOREIGN KEY ("POLLSUBID")
REFERENCES SISTPOLLSUB("POLLSUBID"); 

ALTER TABLE SISTVOTER ADD CONSTRAINT FK3_SIST_VOTER
FOREIGN KEY ("ID")
REFERENCES SISTMEMBER("ID"); 

*/

// 모든 투표자: 누가 투표했는지 어느 문제에 투표했는지
public class SistVoter implements Serializable {
	private int voterid;	// 답한 사람을 카운터
	private int pollid;		// 질문 번호
	private int pollsubid;	// 보기 나온 순서의 번호
	private String id;		// 답한 사람의 ID
	private Date regdate;	// 답한 날짜와 시간
	
	public SistVoter() {	}
	
	public SistVoter(int voterid, int pollid, int pollsubid,
			String id, Date regdate) {	
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}
	
	public SistVoter(int voterid, int pollid, int pollsubid,
			String id) {	
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;		
	}
	
	public SistVoter(int pollid, int pollsubid, String id) {			
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;		
	}

	@Override
	public String toString() {
		return "VoterDTO [voterid=" + voterid + ", pollid=" + pollid + ", pollsubid=" + pollsubid + ", id=" + id
				+ ", regdate=" + regdate + "]";
	}

	public int getVoterid() {
		return voterid;
	}

	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	
}
