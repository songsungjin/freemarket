package sist.co.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import sist.co.model.itemDTO;

public class itemDao {
	
	@Autowired	
	private SqlSession sqlSession;		
	private String ns="SistBBS.";
	
	public boolean writeBBS(itemDTO bbs)throws Exception{
		sqlSession.insert(ns+"writeBBS", bbs);
		return true;
	}
}
