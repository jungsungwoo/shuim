package com.shuim.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MagazineVo {
    private Integer idx;
    private Integer ROWNUM;
    private String content_id;
    private String user_name;
    private String subject;
    private String subject_empty_char;
    private String classification;
    private String detail;
    private String content_empty_html;
    private String reg_date;
    private Integer read_count;
    private String state;
    private String main_view;
    private String categorize;
    private String thumbnailFileName;
	private String tempfile1;
	private String cnt;
	private String origin;
	private String cmtCnt;
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public Integer getROWNUM() {
		return ROWNUM;
	}
	public void setROWNUM(Integer rOWNUM) {
		ROWNUM = rOWNUM;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Integer getRead_count() {
		return read_count;
	}
	public void setRead_count(Integer read_count) {
		this.read_count = read_count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMain_view() {
		return main_view;
	}
	public void setMain_view(String main_view) {
		this.main_view = main_view;
	}
	public String getCategorize() {
		return categorize;
	}
	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}
	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	public String getTempfile1() {
		return tempfile1;
	}
	public void setTempfile1(String tempfile1) {
		this.tempfile1 = tempfile1;
	}
	public String getContent_empty_html() {
		return content_empty_html;
	}
	public void setContent_empty_html(String content_empty_html) {
		this.content_empty_html = content_empty_html;
	}
	public String getSubject_empty_char() {
		return subject_empty_char;
	}
	public void setSubject_empty_char(String subject_empty_char) {
		this.subject_empty_char = subject_empty_char;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCmtCnt() {
		return cmtCnt;
	}
	public void setCmtCnt(String cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
    
	

	
}