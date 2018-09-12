package kr.or.ddit.filedata.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.FiledataVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("fileDao")
public class FileDao implements FileDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * 
	 * Method : insertFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 파일 정보 저장
	 */
	@Override
	public int insertFile(FiledataVo fileVo) {
		template.insert("filedata.insertFiledata", fileVo);
		return 1;
	}
	
	
	/**
	 * 
	 * Method : getFrofilePicList
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List
	 * Method 설명 : 프로필사진 첨부파일 목록 조회
	 */
	@Override
	public List<FiledataVo> getFrofilePicList(String mem_id) {
		return template.selectList("filedata.getFrofilePicList", mem_id);
	}
	
	
	/**
	 * 
	 * Method : deleteFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 삭제
	 */
	@Override
	public int deleteFile(FiledataVo fileVo) {
		template.insert("filedata.deleteFiledata", fileVo);
		return 1;
	}
	
	



}