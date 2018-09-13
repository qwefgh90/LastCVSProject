package kr.or.ddit.store_owner.web;

import java.util.List;
import javax.annotation.Resource;
import kr.or.ddit.store_owner.model.salelistJoinVo;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 담당 --김마음
 * CvsChartController.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */
@RequestMapping("/cvs")
@Controller("cvsChartController")
public class CvsChartController {
	
	@Resource(name="somainService")
	private soMainServiceInf somainService;
	
	private Logger logger = LoggerFactory.getLogger(CvsChartController.class);
	
	/**
	 * Method : chartDay
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 점주가 통계 - 날짜별 조회 할 수 있다.
	 */
	@RequestMapping("/chartDay") // 통계 (날짜별)
	public String chartDay(Model model){		
		String mem_id = "hsj";		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		
		System.out.println("saleList ================> " + saleList.size());
			for (int i = 0; i < saleList.size(); i++){
			model.addAttribute("week"+(i+1), saleList.get(i).getSd_sum());
			System.out.println("week"+(i+1) + saleList.get(i).getSd_sum());				
			}	
		
		model.addAttribute("saleList", saleList);
		model.addAttribute("mem_id", mem_id);
		logger.debug("{}",saleList);
		logger.debug("{}",mem_id);		
		return "cvs_chart_day";
	}
	
	/**
	 * Method : days
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 일간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/days", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo days(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+4314); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+31333);
		sale.setWeek3(saleList.get(2).getSd_sum());
		sale.setWeek4(saleList.get(3).getSd_sum()+15333);
	
		sale.setMem_id(mem_id);		
		return sale;
	}
	
	/**
	 * Method : week
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 주간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/week", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo week(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+3333); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+3333);
		sale.setWeek3(saleList.get(2).getSd_sum()+11111);
		sale.setWeek4(saleList.get(3).getSd_sum()+3333);
		
//		if(saleList.get(4).equals(null)){ // 5주가 없다면
//			System.out.println("5주차 없음");
//		}else{
//		sale.setWeek5(saleList.get(5).getSd_sum());	
//		}
		
		sale.setMem_id(mem_id);
		
//		for (int i = 0; i < saleList.size(); i++){
//			sale.setWeek+i("week"+(i+1), saleList.get(i).getSd_sum());
//		System.out.println("week"+(i+1) + saleList.get(i).getSd_sum());
//		}
		
		return sale;
	}
	
	/**
	 * Method : month
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 월간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/month", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo month(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+22214); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+34313);
		sale.setWeek3(saleList.get(2).getSd_sum()-34153);
		sale.setWeek4(saleList.get(3).getSd_sum()+15334);
	
		sale.setMem_id(mem_id);		
		return sale;
	}
	
	/**
	 * Method : years
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 연간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/years", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo years(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+3333); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+25341);
		sale.setWeek3(saleList.get(2).getSd_sum()-1300);
		sale.setWeek4(saleList.get(3).getSd_sum()+14333);
	
		sale.setMem_id(mem_id);		
		return sale;
	}
	
	/**
	 * Method : chartProd
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 점주가 통계 - 제품별 조회 할 수 있다.
	 */
	@RequestMapping("/chartProd") // 통계 (제품별)
	public String chartProd(Model model){
		String mem_id = "hsj";
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		model.addAttribute("saleList", saleList);
		model.addAttribute("mem_id", mem_id);	
		return "cvs_chart_prod";
	}	
}