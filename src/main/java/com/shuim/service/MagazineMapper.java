package com.shuim.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shuim.domain.MagazineCommentVo;
import com.shuim.domain.MagazineVo;

@Repository(value = "magazineMapper")
public interface MagazineMapper {

    /**
     * 메인화면 - 컨텐츠 리스트
     * @param map
     * @return List<MagazineVo>
     */
    List<MagazineVo> getSelectMain() ;
	
    /**
     * 컨텐츠 리스트
     * @param map
     * @return List<Map<String, Object>>
     */
    List<MagazineVo> select(Map map);
	
    /**
     * 컨텐츠 리스트
     * @param map
     * @return List<Map<String, Object>> 
     */
    List<Map<String, Object>>  getSelectJson(Map map) ;
    
	/**
	 * 컨텐츠 가져오기 - AJAX + JSON
	 * @param idx
	 * @return
	 */
	Map<String, Object> getSelectJsonView (String idx);
    
	
	/**
	 * 컨텐츠 가져오기 - AJAX + XML
	 * @param idx
	 * @return
	 */
	MagazineVo getSelectXMLView (String idx);
    /**
     * 컨텐츠 삭제하기 - AJAX
     * @param idx
     */
	void deleteContent (String idx);
	
	/**
	 * 컨텐츠 등록하기
	 * @param map
	 */
	void postContent (Map map) ;
	
	/**
	 * 컨텐츠 업데이트 - AJAX
	 * @param map
	 */
	void putContent(Map map) ;
	
	
    /**
     * 연관 컨텐츠 8개
     * @param map
     * @return List<MagazineVo>
     */
	List<MagazineVo> selectAddContents(Map map);
	
    /**
     * 모든 컨텐츠 수
     * @return String
     */
	String selectCnt(Map map);
    /**
     * 조회수 업데이트
     * @param idx
     */
    void updateReadCount(int idx);
    
    /**
     * 컨텐츠 상세정보
     * @param idx
     * @return MagazineVo
     */
    MagazineVo selectOneWrite(int idx);
    
    /**
     * 댓글 리스트
     * @param map
     * @return List<MagazineCommentVo>
     */
	List<MagazineCommentVo> selectComment(Map map);
	
    /**
     * 댓글 총 갯수
     * @param idx
     * @return String
     */
	String selectCommentCnt(int idx);
	
    /**
     * 댓글 등록
     * @param magazineCommentVo
     */
	void insertComment(MagazineCommentVo magazineCommentVo);
	
	/**
	 * 신고하기
	 * @param magazineCommentVo
	 */
	void updateNotify(MagazineCommentVo magazineCommentVo);
	
	/**
	 * 커멘트 평판
	 * @param magazineCommentVo
	 * @return
	 */
	Map<String, String> getSelectComment_repute (Map map) ;
	
	/**
	 * 공감 비공감 추가
	 * @param map
	 */
	void insertSympathy (Map map) ;
	
	/**
	 * 커멘트 신고하기
	 * @param magazineCommentVo
	 * @return
	 */
	String getSelectComment_notify (Map map);

}