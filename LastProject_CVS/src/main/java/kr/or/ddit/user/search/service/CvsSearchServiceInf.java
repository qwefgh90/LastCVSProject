package kr.or.ddit.user.search.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.model.CvsSearchVo;

/** 
 * UserSearchServiceInf.java 
 * 
 * @author 조계환 
 * @since 2018. 9. 3. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 3.    조계환 최초 생성 
 * 
 * </pre>
 */
public interface CvsSearchServiceInf {
	
	/** 
	 * Method   : getListMember 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param word
	 * @return 
	 * Method 설명 : 매개 변수로 가져온 검색어를 DB상에 포함 검색 (예:대흥점 검색하면 대흥점 포함한 편의점 이름 검색) 
	 */
	List<MemberVo> getListMember(String word);
	
	/** 
	 * Method   : getCvsPageList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param map
	 * @return 
	 * Method 설명 : 편의점 이름 검색했을때 그 편의점 목록의 페이징 처리
	 */
	Map<String, Object> getCvsPageList(Map<String, Object> map);

	/**
		 * Method : getListProdMember
		 * 최초작성일 : 오전 12:32:57
		 * 작성자 : 조종원
		 * 변경이력 : 신규
		 * @param   : 2018. 9. 4.
		 * @return  : List<CvsSearchVo>
		 * Method 설명 : 제품코드로 현재 고를 가지고 있는 편의점 검색 기능
		 */
	List<CvsSearchVo> getListProdMember(String prod_id);
	

}