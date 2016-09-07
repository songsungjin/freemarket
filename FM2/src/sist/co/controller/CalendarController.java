package sist.co.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sist.co.help.CalendarUtil;
import sist.co.help.myCal;
import sist.co.model.SistCalendar;
import sist.co.model.SistCalendarParam;
import sist.co.model.SistMemberDTO;
import sist.co.service.SistCalendarService;

@Controller
public class CalendarController {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(CalendarController.class);
	
	@Autowired
	private SistCalendarService sistCalendarService; 
	
	@RequestMapping(value="calendar.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String calendar(HttpServletRequest request, myCal jcal, Model model)throws Exception{
		
		logger.info("CalendarController calendar " + new Date());
		
		jcal.calculate();
		
		// 자신의 정보 취득
		String id = ((SistMemberDTO)request.getSession().getAttribute("login")).getId();
				
		String yyyyMm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		SistCalendar fcal = new SistCalendar();
		fcal.setId(id);
		fcal.setWdate(yyyyMm);
		
		List<SistCalendar> flist = sistCalendarService.getCalendarList(fcal);
		
		model.addAttribute("flist", flist);
		model.addAttribute("doc_title", "켈런더");
		model.addAttribute("jcal", jcal);
				
		return "calendar.tiles";
	}
	
	@RequestMapping(value="callist.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String callist(HttpServletRequest request, 
						SistCalendarParam calparam, Model model)throws Exception{
		
		// 자신의 정보 취득
		String id = ((SistMemberDTO)request.getSession().getAttribute("login")).getId();
		String yyyyMmdd = CalendarUtil.yyyymmdd(
					calparam.getYear(), calparam.getMonth(), calparam.getDay());
		
		SistCalendar fcal = new SistCalendar(-1, id, null, null, yyyyMmdd, null);
		
		List<SistCalendar> flist = sistCalendarService.getDayList(fcal);
		model.addAttribute("callist", flist);
		model.addAttribute("doc_title", "켈런더 리스트");
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		
		return "callist.tiles";
	}
	
	@RequestMapping(value="calwrite.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String calwrite(myCal jcal, Model model){
		
		logger.info("CalendarController calwrite " + new Date());
		
		jcal.calculate();
		model.addAttribute("jcal", jcal);
		model.addAttribute("doc_title", "일정 쓰기");
		return "calwrite.tiles";		
	}
	
	/*
	 * DI	: 어노테이션
	 * AOP	: 관점 지향	
	 * IOC 	: 제어의 반전	  
	 */
	
	@RequestMapping(value="calwriteAf.do", 
			method=RequestMethod.POST)
	public String calwriteAf(HttpServletRequest request, 
			SistCalendarParam calparam, Model model)throws Exception
	{
		logger.info("CalendarController calwriteAf " + new Date());
		
		String yyyyMmdd = CalendarUtil.yyyymmddhhmm(calparam.getYear(), 
									calparam.getMonth(), calparam.getDay(), 
									calparam.getHour(), calparam.getMin());
		
		SistCalendar fcal = new SistCalendar(
					calparam.getId(),
					calparam.getTitle(),
					calparam.getContent(),
					yyyyMmdd);
		
		sistCalendarService.writeCalendar(fcal);
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		
	//	return "redirect:/calendar.do";
		return "forward:/calendar.do";
	}	
	/*
	 * redirect	: 객체를 갖고 가지 못한다
	 * forward : 객체를 갖고 간다		 
	 */
	
	
	@RequestMapping(value="caldetail.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String caldetail(HttpServletRequest request, 
				SistCalendar fcal, Model model)throws Exception{
		
		logger.info("CalendarController caldetail " + new Date());
		
		SistCalendar flist = sistCalendarService.getDay(fcal);
		String wdate = flist.getWdate();
		
		String year = wdate.substring(0, 4);
		String month = CalendarUtil.toOne(wdate.substring(4, 6))+"";
		
		String urls = String.format("%s?year=%s&month=%s", 
								"calendar.do", year, month);
		
		model.addAttribute("cal", flist);
		model.addAttribute("urls", urls);
		model.addAttribute("doc_title", "일정 보기");
		
		return "caldetail.tiles";		
	}
	
	@RequestMapping(value="calendar2.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String calendar2(myCal jcal, Model model){
		
		logger.info("CalendarController calendar2 " + new Date());
		model.addAttribute("doc_title", "Ajax Calendar");
		
		jcal.calculate();
		String yyyyMm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		SistCalendar fcal = new SistCalendar();
		fcal.setWdate(yyyyMm);

		model.addAttribute("jcal", jcal);
		
		return "calendar2.tiles";		
	}
	
	@RequestMapping(value="calendarjson.do", 
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<SistCalendar>> 
		calendarjson(SistCalendar fcal, Model model)throws Exception{
		
		logger.info("CalendarController calendarjson " + new Date());
		
		List<SistCalendar> flist=sistCalendarService.getDayList(fcal);
		
		Map<String, List<SistCalendar>> map 
			= new HashMap<String, List<SistCalendar>>();
		map.put("my", flist);
		
		return map;
	}
	
	@RequestMapping(value="caldel.do", 
			method=RequestMethod.POST)
	public String caldel(SistCalendar fcal, Model model) throws Exception{
		logger.info("CalendarController caldel " + new Date());
		
		sistCalendarService.caldel(fcal);
		return "redirect:/calendar3.do";		
	}	


	@RequestMapping(value = "calendar3.do", 
	method = {RequestMethod.POST,RequestMethod.GET})
	public String calendar3(HttpServletRequest request,	myCal jcal, Model model) throws Exception {
		logger.info("Welcome CalendarController calendar3! "+ new Date());
		
		jcal.calculate();
		String id=((SistMemberDTO)request.getSession().getAttribute("login")).getId();
		String yyyyMm=CalendarUtil.yyyymm(
			jcal.getYear(), jcal.getMonth());
		SistCalendar fcal=new SistCalendar();		
		fcal.setId(id);
		fcal.setWdate(yyyyMm);
		
		List<SistCalendar> flist= sistCalendarService.getCalendarList(fcal);
		model.addAttribute("doc_title", "CALENDAR DAYLIST");
		model.addAttribute("callist", flist);
		model.addAttribute("year", jcal.getYear());
		model.addAttribute("month", jcal.getMonth());
		
		return "calendar3.tiles";
	}
}













