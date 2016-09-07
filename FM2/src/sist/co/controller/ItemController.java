package sist.co.controller;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sist.co.model.itemDTO;
import sist.co.service.itemService;

@Controller
public class ItemController {

	private static final Logger logger 
	= LoggerFactory.getLogger(ItemController.class);
	

	
	
	@RequestMapping(value="itemSellwrite.do",
			method={RequestMethod.GET, RequestMethod.POST})
	public String itemSellwrite(Model model){
		logger.info("환영합니다 SistBBSController itemSellwrite " + new Date());
		
		model.addAttribute("doc_title", "아이템 업로드");		
		return "itemSellwrite.tiles";
	}
	
	@RequestMapping(value="itemBuywrite.do",
			method={RequestMethod.GET, RequestMethod.POST})
	public String itemBuywrite(Model model){
		logger.info("환영합니다 SistBBSController itemBuywrite " + new Date());
		
		model.addAttribute("doc_title", "아이템 업로드");		
		return "itemBuywrite.tiles";
	}
	
	@RequestMapping(value="itemwriteAf.do",
			method=RequestMethod.POST)
	public String itemwriteAf(Model model)throws Exception{
				
		
		logger.info("환영합니다 SistItemController itemwriteAf " + new Date());
		// Mybatis 삽입
		
		return "itemlist.do";
	}
	
	
	@RequestMapping(value="imgupload.do",
	method={RequestMethod.GET, RequestMethod.POST})
	public String imgupload(Model model){
		logger.info("환영합니다 SistBBSController imgupload " + new Date());
		
		model.addAttribute("doc_title", "이미지 업로드");		
		return "imgupload.tiles";
	}
	
//	
//	@RequestMapping(value="imgup.do",
//	method={RequestMethod.GET, RequestMethod.POST})
//	public String imgup(Model model, ServletContext session, HttpServletRequest request){
//		logger.info("환영합니다 SistBBSController imgup " + new Date());
//		
//		String realFolder = "";
//		 String filename1 = "";
//		 int maxSize = 1024*1024*5;
//		 String encType = "euc-kr";
//		 realFolder = "C:\\upload\\";
//		 
//		 try{
//		 	 MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
//		 	 Enumeration<?> files = multi.getFileNames();
//		     String file1 = (String)files.nextElement();
//		     filename1 = multi.getFilesystemName(file1);
//
//		 } catch(Exception e) {
//		  e.printStackTrace();
//		 }
//		 
//		 String fullpath = "http://localhost:8090/upload/"+ filename1;//////////////////////// 경로
//		 System.out.println("fullpath = "+fullpath);
//		 
//		 for(int i=0; i<8; i++){
//			 if(session.getAttribute("fullpath"+i) == null){
//				 session.setAttribute("fullpath"+i, fullpath);
//				 break;
//		 	}
//		 }
//		
//		return "imgup.tiles";
//	}
}
