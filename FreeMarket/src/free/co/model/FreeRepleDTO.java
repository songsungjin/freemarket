package free.co.model;

import java.io.Serializable;

/*

DROP TABLE FREEREPLE;

CREATE TABLE FREEREPLE(
   SEQ NUMBER(8) PRIMARY KEY,
   COTNUN NUMBER(8) NOT NULL,       --댓글이 써있는 글의넘버
   ref number(8) not null,         --댓글에 댓글(대댓글)
   step number(8) not null,
   depth number(8) not null,
   id varchar2(50) not null,
   content varchar2(4000) not null,
   wdate date not null,
   parent number(8) not null,
   del number(1) not null
);

CREATE SEQUENCE SEQ_FREEREPLE
START WITH 1 INCREMENT BY 1;

ALTER TABLE FREEREPLE
ADD CONSTRAINT FK_FREEREPLE_ID FOREIGN KEY(ID)
REFERENCES FREEMEMBER(ID);

SELECT * FROM FREEREPLE;

*/

public class FreeRepleDTO implements Serializable{
	
	private int seq;
	private int cotnum;
	private int ref;
	private int step;
	private int depth;
	private String id;
	private String content;
	private String wdate;
	private int parent;		//필요한지 의문.. 비상용.
	private int del;
	
	public FreeRepleDTO() {}

	public FreeRepleDTO(int seq, int cotnum, int ref, int step, int depth, String id, String content, String wdate,
			int parent, int del) {
		this.seq = seq;
		this.cotnum = cotnum;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
		this.parent = parent;
		this.del = del;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getCotnum() {
		return cotnum;
	}

	public void setCotnum(int cotnum) {
		this.cotnum = cotnum;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "FreeRepleDTO [seq=" + seq + ", cotnum=" + cotnum + ", ref=" + ref + ", step=" + step + ", depth="
				+ depth + ", id=" + id + ", content=" + content + ", wdate=" + wdate + ", parent=" + parent + ", del="
				+ del + "]";
	}
	
}
