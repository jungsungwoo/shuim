package com.shuim.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.shuim.domain.MagazineCommentVo;
import com.shuim.domain.MagazineVo;

@Service(value = "magazineDao")
//@Transactional(readOnly=true)
public class MagazineDao {
    @Resource(name = "magazineMapper")
    private MagazineMapper magazineMapper;

    /**
     * 컨텐츠 리스트
     * @param map
     * @return List<MagazineVo>
     */
    public List<MagazineVo> getSelect(Map map) {
        return this.magazineMapper.select(map);
    }

    /**
     * 컨텐츠 리스트
     * @param map
     * @return List<Map<String, Object>> 
     */
    public List<Map<String, Object>>  getSelectJson(Map map) {
        return this.magazineMapper.getSelectJson(map);
    }
    
	/**
	 * 컨텐츠 가져오기 - AJAX + JSON
	 * @param idx
	 * @return
	 */
	public Map<String, Object> getSelectJsonView (String idx) {
		return this.magazineMapper.getSelectJsonView(idx);
	}
    
	/**
	 * 컨텐츠 가져오기 - AJAX + XML
	 * @param idx
	 * @return
	 */
	public MagazineVo getSelectXMLView (String idx) {
		return this.magazineMapper.getSelectXMLView(idx);
	}
	
	
    /**
     * 컨텐츠 삭제하기 - AJAX
     * @param idx
     */
	public void deleteContent (String idx) {
		this.magazineMapper.deleteContent(idx);
	}
	
	/**
	 * 컨텐츠 등록하기
	 * @param map
	 */
	public void postContent (Map map) {
		this.magazineMapper.postContent(map);
	}
    
	/**
	 * 컨텐츠 업데이트 - AJAX
	 * @param map
	 */
	public void putContent(Map map) {
		this.magazineMapper.putContent(map);
	}
    
    /**
     * 연관 컨텐츠 8개
     * @param map
     * @return List<MagazineVo>
     */
    public List<MagazineVo> getSelectAddContents(Map map){
    	return this.magazineMapper.selectAddContents(map);
    }
    
    /**
     * 댓글 리스트
     * @param map
     * @return List<MagazineCommentVo>
     */
	public List<MagazineCommentVo> getSelectComment(Map map) {
		return this.magazineMapper.selectComment(map);
	}
    
    /**
     * 모든 컨텐츠 수
     * @return String
     */
    public String getSelectCnt(Map map){
    	return this.magazineMapper.selectCnt(map);
    }
    
    /**
     * 댓글 총 갯수
     * @param idx
     * @return String
     */
    public String getSelectCommentCnt(int idx) {
    	return this.magazineMapper.selectCommentCnt(idx);
    }
    
    /**
     * 조회수 업데이트
     * @param idx
     */
    public void updateReadCount(int idx) {
 	   this.magazineMapper.updateReadCount(idx);
    }
    
    /**
     * 컨텐츠 상세정보
     * @param idx
     * @return MagazineVo
     */
    public MagazineVo getSelectOneWrite(int idx) {
        return this.magazineMapper.selectOneWrite(idx);
    }
    
    
    /**
     * 댓글 등록
     * @param magazineCommentVo
     */
	public void insertComment(MagazineCommentVo magazineCommentVo) {
		this.magazineMapper.insertComment(magazineCommentVo);
	}
	
	/**
	 * 신고하기
	 * @param magazineCommentVo
	 */
	public void updateNotify(MagazineCommentVo magazineCommentVo) {
		this.magazineMapper.updateNotify(magazineCommentVo);
	}

	/**
	 * 커멘트 평판 
	 * @param magazineCommentVo
	 * @return
	 */
	public Map<String, String> getSelectComment_repute (Map map) {
		return this.magazineMapper.getSelectComment_repute(map);
	}
	
	/**
	 * 공감 비공감 추가
	 * @param map
	 */
	public void insertSympathy (Map map) {
		this.magazineMapper.insertSympathy(map);
	}
	
	/**
	 * 커멘트 신고하기
	 * @param magazineCommentVo
	 * @return
	 */
	public String getSelectComment_notify (Map map) {
		return this.magazineMapper.getSelectComment_notify(map);
	}
}
