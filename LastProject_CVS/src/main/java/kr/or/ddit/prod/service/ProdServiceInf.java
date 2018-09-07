package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.user.search.model.CvsSearchVo;

public interface ProdServiceInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
	
	/**
	 * Method			:getCtgyProdList
	 * Method 설명  : 카테고리별 제품 목록 조회
	 * 
	 * 최초 작성일 : 2018. 9. 03.
	 * 작성자 : 김현경
	 * 변경 이력 : 신규 
	 * @param map (카테고리 종류, 카테고리 아이디, page, pageSize)
	 * @return List<ProdVo> (조건에 맞는 제품들)
	 */
	Map<String, Object> getCtgyProdList(Map<String, Object> map);
	
	CategoryVo getCtgy(String ctgy_id);
	
	/**
	 * 
	 * Method   : getListProdBestCategory 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param map -카테고리명, 원하는 갯수
	 * @return 
	 * Method 설명 : 카테고리별 평점평균 베스트
	 */
	List<ProdVo> getCategoryBestProdList(Map<String, String> map );

	
	
	/**
	 * 
	 * Method   : getSearchProdList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 한수정
	 * 변경이력 : 신규
	 * @param searchWord
	 * @return 
	 * Method 설명 : 해당 검색어를 포함한 상품 리스트를 검색하는 메서드
	 */
	List<ProdVo> getSearchProdList(String searchWord);
	
	/**
	 * 
	 * Method	: getProd
	 * 최초작성일 : 2018. 9. 4.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param prod_id
	 * @return
	 * Method 설명 : 제품Id로 제품 조회
	 */
	ProdVo getProd(String prod_id);
	
	/**
	 * 
	 * Method	: getAllProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 상품 조회
	 */
	List<ProdVo> getAllProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getAllEventProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 행사 상품 조회
	 */
	List<ProdVo> getAllEventProd(Map<String, Object> map);
	
	List<ProdVo> getListProdEvent(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getEventCtgyProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32, event 종류, 카테고리 종류, 카테고리 아이디)
	 * @return
	 * Method 설명 : 전체 행사 상품 조회
	 */
	List<ProdVo> getEventCtgyProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: searchProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32, 최소금액, 최대금액, 상품명)
	 * @return
	 * Method 설명 : 상품조회에서 상품 검색
	 */
	List<ProdVo> searchProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getCgEventProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32,카테고리 종류, 카테고리아이디)
	 * @return
	 * Method 설명 : 카테고리별 행사 상품 조회
	 */
	List<ProdVo> getCgEventProd(Map<String, Object> map);
	
}
