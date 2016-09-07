package sist.co.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sist.co.model.SistCalendar;
import sist.co.service.SistCalendarDao;
import sist.co.service.SistCalendarService;

@Service
public class SistCalendarImpl implements SistCalendarService {

	@Autowired
	private SistCalendarDao sistCalendarDao; 
	
	@Override
	public List<SistCalendar> getCalendarList(SistCalendar fcal) throws Exception {
		return sistCalendarDao.getCalendarList(fcal);		
	}

	@Override
	public List<SistCalendar> getDayList(SistCalendar fcal) throws Exception {
		return sistCalendarDao.getDayList(fcal);		
	}

	@Override
	public boolean writeCalendar(SistCalendar cal) throws Exception {
		
		return sistCalendarDao.writeCalendar(cal);		
	}

	@Override
	public SistCalendar getDay(SistCalendar fcal) throws Exception {		
		return sistCalendarDao.getDay(fcal);		
	}

	@Override
	public void caldel(SistCalendar fcal) throws Exception {
		sistCalendarDao.caldel(fcal);		
	}		
	
	
	
}



