package sist.co.service;

import java.util.List;
import sist.co.model.SistCalendar;

public interface SistCalendarService {

	public List<SistCalendar> getCalendarList(SistCalendar fcal)throws Exception;
	public List<SistCalendar> getDayList(SistCalendar fcal)throws Exception;
	public boolean writeCalendar(SistCalendar cal) throws Exception;	
	public SistCalendar getDay(SistCalendar fcal) throws Exception;
	
	public void caldel(SistCalendar fcal) throws Exception;
}
