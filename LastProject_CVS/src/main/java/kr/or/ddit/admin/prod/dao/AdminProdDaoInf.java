package kr.or.ddit.admin.prod.dao;

import java.util.List;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;

public interface AdminProdDaoInf {

	/** 
	 * Method   : getProdList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<AdminProdVo>
	 * Method 설명 : 관리자 상품 조회
	 */
	List<AdminProdVo> getProdList(AdminProdVo vo);
	
	/** 
	 * Method   : getProdListCount 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<AdminProdVo>
	 * Method 설명 : 관리자 상품 조회 전체 카운트
	 */
	int getProdListCount(AdminProdVo vo);
	
	/** 
	 * Method   : getProdCategory 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<CategoryVo>
	 * Method 설명 : 관리자 상품 조회
	 */
	List<CategoryVo> getProdCategory(CategoryVo  vo);
}
