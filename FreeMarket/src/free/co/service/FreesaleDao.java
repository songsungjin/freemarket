package free.co.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import free.co.model.FreeSaleDTO;

@Repository
public class FreesaleDao {
	
	@Autowired	// DI 'new'를 생략할 수 있다
	private SqlSession sqlSession;
	
	private String ns = "FreeSale.";
	
	public List<FreeSaleDTO> salelist() throws Exception{
		List<FreeSaleDTO> list = new ArrayList<FreeSaleDTO>();
		list = sqlSession.selectList(ns + "salelist");
		
		return list;
	}
}
