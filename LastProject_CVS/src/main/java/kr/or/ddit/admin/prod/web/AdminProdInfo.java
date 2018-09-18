package kr.or.ddit.admin.prod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.service.AdminProdServiceInf;
import kr.or.ddit.model.CategoryVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/adprod")
@Controller("adminProdInfo")
public class AdminProdInfo {

	@Resource(name="adminProdService")
	AdminProdServiceInf adminProdService;
	
	// 왼쪽 메뉴바 클릭시 이동
	@RequestMapping("/adprodView")
	public String adminProdView(Model model){
		
		CategoryVo vo = new CategoryVo();
		vo.setCtgy_kind("301");
		// 대분류
		List<CategoryVo> categoryLg = adminProdService.getProdCategory(vo);
		
		vo.setCtgy_parent("notnull");
		// 중분류
		List<CategoryVo> categoryMd = adminProdService.getProdCategory(vo);
		
		AdminProdVo pvo = new AdminProdVo();
		// 기본 페이지 
		pvo.setPage(1);
		pvo.setpageSize(25);
		
		// 제품 목록
		Map<String, Object> result = adminProdService.getProdList(pvo);
		
		model.addAttribute("categoryLg", categoryLg);
		model.addAttribute("categoryMd", categoryMd);
		model.addAllAttributes(result);
		
		return "ad_prod";
	}
	
	
	
	
	
}