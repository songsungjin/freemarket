package sist.co.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sist.co.model.SistBBSDTO;
import sist.co.model.SistBBSParam;
import sist.co.service.SistBBSService;

@Controller
public class SistBBSController {

	private static final Logger logger 
		= LoggerFactory.getLogger(SistBBSController.class);
	
	@Autowired
	private SistBBSService sistBBSService; 
	
	@RequestMapping(value="bbslist.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbslist(SistBBSParam param, Model model) throws Exception{
		logger.info("환영합니다 SistBBSController bbslist " + new Date());
		
		/*List<SistBBSDTO> bbslist=sistBBSService.getBBSList();		
		model.addAttribute("bbslist", bbslist);*/
		
		model.addAttribute("doc_title", "BBS 글목록");
		
		// paging 처리
		int sn=param.getPageNumber();
		int start=(sn)*param.getRecordCountPerPage() + 1;
		int end=(sn+1)*param.getRecordCountPerPage();
		
		System.out.println("start:" + start);	// 	1	11
		System.out.println("end:" + end);		//	10 	20
		
		param.setStart(start);
		param.setEnd(end);
		
		int totalRecordCount=sistBBSService.getBBSCount(param);
		List<SistBBSDTO> bbslist=sistBBSService.getBBSPagingList(param);
		model.addAttribute("bbslist", bbslist);
		
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 10);
		model.addAttribute("recordCountPerPage", param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		model.addAttribute("s_category", param.getS_category());
		model.addAttribute("s_keyword", param.getS_keyword());		
		
		return "bbslist.tiles";		
	}
	
	// 이동메소드
	@RequestMapping(value="bbswrite.do",
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbswrite(Model model){
		logger.info("환영합니다 SistBBSController bbswrite " + new Date());
		
		model.addAttribute("doc_title", "BBS 글쓰기");		
		return "bbswrite.tiles";
	}
	
	
	@RequestMapping(value="bbswriteAf.do",
			method=RequestMethod.POST)
	public String bbswriteAf(SistBBSDTO bbs, Model model)throws Exception{
				
		if(bbs.getContent().equals("")||bbs.getTitle().equals("")){
			return "redirect:/bbslist.do";
		}
		logger.info("환영합니다 SistBBSController bbswriteAf " + new Date());
		// Mybatis 삽입
		sistBBSService.writeBBS(bbs);
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value="bbsdetail.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(SistBBSDTO bbs, Model model)throws Exception{
		logger.info("환영합니다 SistBBSController bbsdetail " + new Date());
		
		model.addAttribute("doc_title", "BBS 상세보기");	
				
		sistBBSService.readcount(bbs.getSeq());
		SistBBSDTO rbbs = sistBBSService.getBBS(bbs);
				
		model.addAttribute("bbs", rbbs);
		
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value="bbsreply.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbsreply(SistBBSDTO bbs, Model model)throws Exception{
		
		logger.info("환영합니다 SistBBSController bbsreply " + new Date());
		model.addAttribute("doc_title", "BBS 답글달기");
		
		SistBBSDTO rbbs = sistBBSService.getBBS(bbs);
		model.addAttribute("bbs", rbbs);	
		return "bbsreply.tiles";
	}
	
	@RequestMapping(value="bbsreplyAf.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbsreplyAf(SistBBSDTO bbs, Model model){
		
		logger.info("환영합니다 SistBBSController bbsreplyAf " + new Date());
		
		boolean isS=false;
		
		try{
			sistBBSService.reply(bbs);
			isS=true;
		}catch(Exception e){}
		
		if(isS){
			return "redirect:/bbslist.do";
		}else{
			return "redirect:/bbslist.do";
		}		
	}
	
	@RequestMapping(value="bbsupdate.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(SistBBSDTO bbs, Model model) throws Exception{
		
		logger.info("환영합니다 SistBBSController bbsupdate " + new Date());
		logger.info("SistBBSController SistBBSDTO " + bbs);
		
		model.addAttribute("doc_title", "BBS 수정하기");
		
		SistBBSDTO rbbs=sistBBSService.getBBS(bbs);
		model.addAttribute("bbs", rbbs);
		
		return "bbsupdate.tiles";
	}
	
	@RequestMapping(value="bbsupdateAf.do", 
			method=RequestMethod.POST)
	public String bbsupdateAf(SistBBSDTO bbs, Model model)throws Exception{
		logger.info("환영합니다 SistBBSController bbsupdate " + new Date());
		
		sistBBSService.updateBBS(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value="bbsdelete.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String bbsdelete(SistBBSDTO bbs, Model model)throws Exception{
		logger.info("환영합니다 SistBBSController bbsdelete " + new Date());
		
		bbs.setDel(3);		
		sistBBSService.deleteBBS(bbs);		
		return "redirect:/bbslist.do";
	}
}






