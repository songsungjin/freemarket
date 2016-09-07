package sist.co.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sist.co.help.PollBean;
import sist.co.model.SistMemberDTO;
import sist.co.model.SistPollDTO;
import sist.co.model.SistVoter;
import sist.co.service.SistPollService;

@Controller
public class PollController {

	private static final Logger logger 
		= LoggerFactory.getLogger(PollController.class);
	
	@Autowired
	private SistPollService sistPollService; 
	
	@RequestMapping(value="polllist.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String polllist(HttpServletRequest request, Model model){
		
		logger.info("PollController polllist " + new Date());
		
		String id = ((SistMemberDTO)request.getSession().getAttribute("login")).getId();
		
		model.addAttribute("doc_title", "투표 문항");		
		model.addAttribute("plists", sistPollService.getPollAllList(id));		
		
		return "polllist.tiles";
	}
	
	@RequestMapping(value="pollmake.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String pollmake(Model model){		
		logger.info("PollController pollmake " + new Date());		
		model.addAttribute("doc_title", "투표 문항 만들기");		
		return "pollmake.tiles";		
	}
	
	@RequestMapping(value="pollmakeAf.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String pollmakeAf(PollBean pbean, Model model){		
		logger.info("PollController pollmake " + new Date());			
		sistPollService.makePoll(pbean);				
		return "redirect:/polllist.do";		
	}
	
	@RequestMapping(value="polldetail.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String polldetail(SistPollDTO poll, Model model){
		logger.info("PollController polldetail " + new Date());
		
		model.addAttribute("doc_title", "투표 내용");
		model.addAttribute("poll", sistPollService.getPoll(poll));
		model.addAttribute("pollsublist", 
					sistPollService.getPollSubList(poll));
		return "polldetail.tiles";		
	}
	
	@RequestMapping(value="polling.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String polling(SistVoter voter, Model model){		
		logger.info("PollController polling " + new Date());
		
		sistPollService.polling(voter);		
		
		return "redirect:/polllist.do";
	}
	
	@RequestMapping(value="pollresult.do", 
			method={RequestMethod.GET, RequestMethod.POST})	
	public String pollresult(SistPollDTO poll, Model model){
		
		logger.info("PollController pollresult " + new Date());
		
		model.addAttribute("doc_title", "투표 결과");
		
		model.addAttribute("poll", sistPollService.getPoll(poll));
		model.addAttribute("pollsublist", sistPollService.getPollSubList(poll));
		
		return "pollresult.tiles";		
	}
	
}

	
	
	
	
	
	