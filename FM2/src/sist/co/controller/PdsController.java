package sist.co.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sist.co.help.FUpUtil;
import sist.co.model.SistPDSDTO;
import sist.co.service.SistPDSService;

@Controller
public class PdsController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(PdsController.class);
	
	@Autowired
	private SistPDSService sistPDSService;
	
	@RequestMapping(value="pdslist.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model){		
		logger.info("PdsController pdslist " + new Date());
		
		List<SistPDSDTO> pdslist = sistPDSService.getPDSList();
		
		model.addAttribute("doc_title", "자료목록");
		model.addAttribute("pdslist", pdslist);
		
		return "pdslist.tiles";		
	}
	
	@RequestMapping(value="pdswrite.do", method=RequestMethod.GET)
	public String pdswrite(Model model){		
		logger.info("PdsController pdswrite " + new Date());		
		model.addAttribute("doc_title", "자료올리기");
		
		return "pdswrite.tiles";			
	}
	
	@RequestMapping(value="pdsupload.do", 
			method=RequestMethod.POST)
	public String pdsupload(SistPDSDTO pdsdto,
							HttpServletRequest request,
							@RequestParam(value="fileload", required=false)
							MultipartFile fileload, Model model){
		
		logger.info("PdsController pdsupload " + new Date());
		model.addAttribute("doc_title", "pds 업로드");
		pdsdto.setFilename(fileload.getOriginalFilename());

		String fupload = request.getServletContext().getRealPath("/upload");
		//String fupload = "c:\\upload";	// 폴더에 올리고 싶을 때
		logger.info(": " + fupload);
		
		String f = pdsdto.getFilename();		
		String newFile = FUpUtil.getNewFile(f);		
		logger.info(fupload+ "/" + newFile);
		
		pdsdto.setFilename(newFile);
		
		try{		
			File file = new File(fupload + "/" + newFile);		
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
		
			sistPDSService.uploadPDS(pdsdto);
			logger.info("pdsupload success");
			
		}catch(IOException e){
			logger.info("pdsupload fail!");
		}
		
		return "redirect:/pdslist.do";		
	}
	
	@RequestMapping(value="pdsdetail.do", 
			method=RequestMethod.GET)
	public String pdsdetail(int seq, Model model){
		logger.info("PdsController pdsdetail " + new Date());
		
		sistPDSService.pdsReadCount(seq);				// 방문회수 증가		
		SistPDSDTO pdsdto = sistPDSService.getPDS(seq);	// 데이터 산출
		
		model.addAttribute("pds", pdsdto);
		model.addAttribute("doc_title", "pds 내용보기");
		
		return "pdsdetail.tiles";
	}
	
	@RequestMapping(value="pdsdel.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String pdsdel(int seq, Model model)throws Exception{
		
		logger.info("PdsController pdsdel " + new Date());		
		sistPDSService.pdsdel(seq);
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value="fileDownload.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String download(int seq, HttpServletRequest request, 
						String filename, Model model) throws Exception{
		logger.info("PdsController fileDownload " + new Date());
		
		String fupload = request.getServletContext().getRealPath("/upload");
		// String fupload = "c:\\upload\\";		// 폴더
		
		File downloadFile = new File(fupload + "/" + filename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
	
	@RequestMapping(value="pdsupdate.do", 
			method={RequestMethod.GET, RequestMethod.POST})
	public String pdsupdate(int seq, Model model){
		logger.info("PdsController pdsupdate " + new Date());
		
		SistPDSDTO pdsdto = sistPDSService.getPDS(seq);
		
		model.addAttribute("pds", pdsdto);
		model.addAttribute("doc_title", "pds 수정하기");
		
		return "pdsupdate.tiles";		
	}
	
	@RequestMapping(value="pdsupdateAf.do", method=RequestMethod.POST)
	public String pdsupdateAf(SistPDSDTO pdsdto, String namefile, 
				HttpServletRequest request,
				@RequestParam(value="fileload", required=false)
				MultipartFile fileload, Model model
			){
		
		logger.info("PdsController pdsupdateAf " + new Date());
		
		pdsdto.setFilename(fileload.getOriginalFilename());
		String fupload = request.getServletContext().getRealPath("/upload");
		
		if(pdsdto.getFilename() != null && !pdsdto.getFilename().equals("")){
		
			String f = pdsdto.getFilename();
			String newFile = FUpUtil.getNewFile(f);
			
			pdsdto.setFilename(newFile);
			
			try{			
				File file = new File(fupload + "/" + newFile);
				FileUtils.writeByteArrayToFile(file, fileload.getBytes());
				
				sistPDSService.updatePDS(pdsdto);				
				
			}catch(IOException e){
				logger.info("pdsupdateAf fail" + new Date());				
			}			
		}else{
			if(namefile != null && !namefile.equals("")){
				pdsdto.setFilename(namefile);				
				sistPDSService.uploadPDS(pdsdto);				
			}else{
				logger.info("pdsupdateAf fail" + new Date());
			}
		}
		return "redirect:/pdslist.do";		
	}	
}





