package sist.co.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sist.co.model.SistBBSDTO;
import sist.co.model.SistBBSParam;

@Repository
public class SistBBSDao {
	
	@Autowired	
	private SqlSession sqlSession;		
	private String ns="SistBBS.";
	
	public List<SistBBSDTO> getBBSList()throws Exception{
		List<SistBBSDTO> list = new ArrayList<SistBBSDTO>();
		list=sqlSession.selectList(ns+"getBBSList");
		return list;
	}
	
	public boolean writeBBS(SistBBSDTO bbs)throws Exception{
		sqlSession.insert(ns+"writeBBS", bbs);
		return true;
	}
	
	public SistBBSDTO getBBS(SistBBSDTO bbs) throws Exception{
		bbs=sqlSession.selectOne(ns+"getBBS", bbs);
		return bbs;
	}
	
	public boolean readcount(int seq) throws Exception{
		sqlSession.update(ns+"readcount", seq);
		return true;		
	}
	
	public int getBBSCount(SistBBSParam param) throws Exception{
		int num=0;
		num=(Integer)sqlSession.selectOne(ns+"getBBSCount", param);
		return num;
	}
	
	public List<SistBBSDTO> getBBSPagingList(SistBBSParam param)throws Exception{
		List<SistBBSDTO> list = new ArrayList<SistBBSDTO>();
		list=sqlSession.selectList(ns+"getBBSPagingList", param);
		return list;		
	}
	
	
	public boolean replyBBSUpdate(SistBBSDTO bbs) throws Exception{
		sqlSession.update(ns+"replyBBSUpdate", bbs);
		return true;
	}	
	public boolean replyBBSInsert(SistBBSDTO bbs) throws Exception{
		sqlSession.insert(ns+"replyBBSInsert", bbs);
		return true;
	}
	
	public void updateBBS(SistBBSDTO bbs){
		sqlSession.update(ns+"updateBBS", bbs);
	}
	
	public void deleteBBS(SistBBSDTO bbs){
		sqlSession.update(ns+"deleteBBS", bbs);
	}
	
	
	
}





