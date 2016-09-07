package free.co.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import free.co.model.FreeSaleDTO;
import free.co.model.SistBBSParam;
import free.co.model.SistbbsDTO;
import free.co.service.FreesaleService;

@Controller
public class FreeSaleController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeSaleController.class);
	
	@Autowired FreesaleService freesaleService;
	
	@RequestMapping(value="MainPage.do", method={RequestMethod.GET, RequestMethod.POST}) // GET방식 POST방식 두가지 중 양쪽다 사용하는 경우 대비
	public String bbslist(FreeSaleDTO dto, Model model) throws Exception{
		logger.info("FreeSaleController MainPage" + new Date());
		int page = 0;
		dto.setPage(page);
		
        List<FreeSaleDTO> salelist = freesaleService.salelist();
		model.addAttribute("salelist", salelist);
        model.addAttribute("page", page);
		
		return "MainPage.tiles";
	}
	

	@RequestMapping(value="ajaxList.do", produces = "application/text; charset=utf8", method={RequestMethod.GET, RequestMethod.POST}) // GET방식 POST방식 두가지 중 양쪽다 사용하는 경우 대비
	@ResponseBody
	public String ajaxList(SistbbsDTO bbs, HttpServletRequest request,
            HttpServletResponse response, Model model) throws Exception{
		logger.info("환영합니다SistbbsController ajaxList" + new Date());
			// 기본 페이지번호를 0으로 설정하고
			int page = 0;
			bbs.setPage(page);
			
	        // 넘어온 파라미터가 있다면
	        if (request.getParameter("page") != null) {
	        	
	            // 해당 파라미터를 int형으로 캐스팅후 변수에 대입
	            page = Integer.parseInt(request.getParameter("page"));
	            bbs.setPage(page);
	        }
	        // 그리고 변경된 dao 메서드에 넣어줍니다.
	       /* List<SistbbsDTO> bbslist = sistbbsService.infiniteScrollDown(bbs);
	        model.addAttribute("page", page);*/
	       /////
	        String str = "<ul class=" + "'main_img_list'"+"id=" + "'items'" + ">";
	       /* for(int i = 0; i <bbslist.size(); i++){
	        str += "<li class=" + "'main_img_card'" + "><a href='bbsdetail.do?seq=" + bbslist.get(i).getSeq() + "'>" +
	        		"<img class=" + "'thumbnail_img'" + "id=" + "'lazyload'" +  "width=" + "'228'" + "height=" + "'228'" + "data-th-original=" + "'${item.imageUrl}'"  + "src=" + "'//img.hellomarket.com/images/2016/item/s4/09/04/22/0159_26799580_1.jpg'" +  "/>"
	        		 + "<p></p>"+ "<span class=" + "'item_title'" + ">" + bbslist.get(i).getTitle() + "</span>"+
	        		"<span class=" + "'item_price'" + ">" + bbslist.get(i).getId() + "</span>" + 
	        		"<span class=" + "'item_time_ago'" + ">" + bbslist.get(i).getId() + "</span>"
	        		+ "</a></li>";
	        }
	        str += "</ul>";
	        System.out.println(bbslist.size() + "사이즈");*/
	       ///// 
	     return str;
	     
	     
	     
	}
	//판매하기 컨트롤러
	@RequestMapping(value="FreeSaleSellwrite.do",
			method={RequestMethod.GET, RequestMethod.POST})
	public String FreeSaleSellwrite(Model model){
		logger.info("환영합니다 SistFreeSaleController FreeSaleSellwrite " + new Date());
		
		model.addAttribute("doc_title", "아이템 업로드");		
		return "FreeSaleSellwrite.tiles";
	}
	//구매하기 컨트롤러
	@RequestMapping(value="FreeSaleBuywrite.do",
			method={RequestMethod.GET, RequestMethod.POST})
	public String FreeSaleBuywrite(Model model){
		logger.info("환영합니다 SistFreeSaleController itemBuywrite " + new Date());
		
		model.addAttribute("doc_title", "아이템 업로드");		
		return "FreeSaleBuywrite.tiles";
	}
	
	//판매하기에서 등록 눌렀을때
	@RequestMapping(value="FreeSalewriteAf.do",
			method=RequestMethod.POST)
	public String FreeSalewriteAf(Model model)throws Exception{
				
		
		logger.info("환영합니다 SistFreeSaleController FreeSalewriteAf " + new Date());
		// Mybatis 삽입
		
		return "itemlist.do";
	}
	
	//이미지 사진 클릭했을 시
	@RequestMapping(value="imgupload.do",
	method={RequestMethod.GET, RequestMethod.POST})
	public String imgupload(Model model){
		logger.info("환영합니다 SistFreeSaleController imgupload " + new Date());
		
		model.addAttribute("doc_title", "이미지 업로드");		
		return "imgupload.tiles";
	}
	
	//이미지 업로드 버튼 눌렀을 시
	@RequestMapping(value="imgup.do",
	method={RequestMethod.GET, RequestMethod.POST})
	public String imgup(Model model, ServletContext session, HttpServletRequest request){
		logger.info("환영합니다 SistBBSController imgup " + new Date());
		
		
		return "imgup.tiles";
	}
}
