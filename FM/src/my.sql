
INSERT INTO SISTBBS
(SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, 
			WDATE, PARENT, DEL, READCOUNT)
VALUES(SEQ_SISTBBS.nextval, 1111,
	(SELECT NVL(MAX(REF), 0)+1 FROM SISTBBS),
	0, 0, '안녕', 'world', SYSDATE, 0, 0, 0)
	
select * from SISTBBS