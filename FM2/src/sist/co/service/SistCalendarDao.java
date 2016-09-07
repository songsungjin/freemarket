package sist.co.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sist.co.model.SistCalendar;

@Repository
public class SistCalendarDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	String ns="SistCalendar.";
	
	public List<SistCalendar> getCalendarList(SistCalendar fcal)throws Exception{
		
		List<SistCalendar> callist = new ArrayList<SistCalendar>();
		return callist = sqlSession.selectList(ns+"getCalendarList", fcal);		
	}
	
	public List<SistCalendar> getDayList(SistCalendar fcal)throws Exception{
		List<SistCalendar> callist = new ArrayList<SistCalendar>();
		return callist = sqlSession.selectList(ns+"getDayList", fcal);			
	}
	
	public boolean writeCalendar(SistCalendar cal) throws Exception{
		sqlSession.insert(ns+"writeCalendar", cal);
		return true;		
	}
	
	public SistCalendar getDay(SistCalendar fcal) throws Exception{
		return (SistCalendar)sqlSession.selectOne(ns+"getDay", fcal);
	}
	
	public void caldel(SistCalendar fcal) throws Exception{
		sqlSession.delete(ns+"caldel", fcal);
	}
	
	
}









