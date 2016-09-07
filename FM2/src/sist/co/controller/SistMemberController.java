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
import org.springframework.web.bind.annotation.ResponseBody;

import sist.co.model.SistMemberDTO;
import sist.co.model.YesMember;
import sist.co.service.SistMemberService;

@Controller
public class SistMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(SistMemberController.class);
		
	@Autowired
	SistMemberService sistMemberService;
		
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model){
		logger.info("환영합니다 SistMemberController login" + new Date());
		return "login.tiles";
	}
	
	@RequestMapping(value="regi.do", method=RequestMethod.GET)
	public String regi(Model model){
		logger.info("환영합니다 SistMemberController regi" + new Date());
		return "regi.tiles";
	}
	
	@RequestMapping(value="regiAf.do", method=RequestMethod.POST)
	public String regiAf(HttpServletRequest request, SistMemberDTO member, Model model)throws Exception{
		logger.info("환영합니다 SistMemberController regiAf" + new Date());
					
		// DB로 이동
		sistMemberService.addMember(member);
		
		//return "redirect:/login.do";
		return "login.tiles";
	}
	
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(HttpServletRequest request, 
							SistMemberDTO member, 
							Model model)throws Exception{
		
		logger.info("환영합니다 SistMemberController loginAf" + new Date());
		
		SistMemberDTO login=null;
		login=sistMemberService.login(member);
				
		if(login != null && !login.getId().equals("")){
			request.getSession().setAttribute("login", login);
		//	return "bbslist.tiles";
			return "redirect:/bbslist.do";	
		}else{
			return "login.tiles";
		}		
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model){
		logger.info("SistMemberController logout " + new Date());		
		
		request.getSession().invalidate();
		return "login.tiles";
	}	
	
	
	@RequestMapping(value="getID.do", method=RequestMethod.POST)
	@ResponseBody
	public YesMember getID(SistMemberDTO member, Model model)throws Exception{
		logger.info("SistMemberController getID " + new Date());	
		
		int count=sistMemberService.getID(member);		
		YesMember yes=new YesMember();
		if(count > 0){
			yes.setMessage("Sucs");
		}else{
			yes.setMessage("Fail");
		}
		return yes;
	}
	
	
	
}








