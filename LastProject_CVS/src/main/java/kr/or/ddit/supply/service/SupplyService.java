package kr.or.ddit.supply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.dao.SupplyDao;
import kr.or.ddit.supply.dao.SupplyDaoInf;
import kr.or.ddit.supply.model.SupplyProdVo;

@Service("supplyService")
public class SupplyService implements SupplyServiceInf {
	
	@Resource(name="supplyDao")
	private SupplyDaoInf SupplyDao;

	@Override
	public int setInsertSupply(SupplyVo supplyVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	* Method : getListSupply
	* Method 설명 :입고 리스트 쫙 출력
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public List<SupplyVo> getListSupply() {
		return SupplyDao.getListSupply();
	}

	/**
	* Method : getListSupply
	* Method 설명 :입고 내역 상세보기
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyListVo> getListSupply(String supply_bcd) {
		return SupplyDao.getListSupply(supply_bcd);
	}

	@Override
	public int updateSupply(SupplyVo supplyVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSupply(String supply_bcd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setInsertSupplyList(SupplyListVo supplyListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSupplyList(SupplyListVo supplyListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SupplyListVo> getListSupplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSupplyList(String splylist_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	* Method : getSupplyDetailProdList
	* Method 설명 :입고 상세내역에서 물품 리스트
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param splylist_id
	* @return
	*/
	@Override
	public List<SupplyListVo> getSupplyDetailProdList(String splylist_id) {
		return SupplyDao.getSupplyDetailProdList(splylist_id);
	}

	
	/**
	* Method : getSupplyProdInfo
	* Method 설명 :
	* 최초작성일 : 2018. 9. 11.
	* 작성자 : PC15
	* 변경이력 :
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyProdVo> getSupplyProdInfo(String supply_bcd) {
		return SupplyDao.getSupplyProdInfo(supply_bcd);
	}
	
}
