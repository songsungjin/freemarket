package sist.co.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sist.co.model.SistPDSDTO;

@Repository
public class SistPDSDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	String ns="SistPDS.";
	
	public List<SistPDSDTO> getPDSList(){
		return sqlSession.selectList(ns+"getPDSList");
	}
	
	public void uploadPDS(SistPDSDTO dto){
		sqlSession.insert(ns+"uploadPDS", dto);
	}
	
	
	
	public void pdsReadCount(int seq){
		sqlSession.update(ns+"pdsReadCount", seq);
	}
	
	public SistPDSDTO getPDS(int seq){
		return sqlSession.selectOne(ns+"getPDS", seq);
	}
	
	public void pdsdel(int seq){
		sqlSession.delete(ns+"pdsdel", seq);
	}
	
	public void downloadCount(int seq){
		sqlSession.update(ns+"downloadCount", seq);
	}
	
	public void updatePDS(SistPDSDTO pdsdto){
		sqlSession.update(ns+"updatePDS", pdsdto);
	}
	

}






