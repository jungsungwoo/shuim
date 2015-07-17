package com.shuim.domain;

public class MagazineCommentVo {
	private Integer comment_idx;
	private String content_id;
    private Integer idx;
    private Integer ROWNUM;
    private String email;
    private Integer grp;
    private String comment;
    private String nick;
    private String reg_date;
    private String reputeY;
    private String reputeN;
    private String notify;
    private String state;
    private String ip;
    private String mobileRefer;
    
    
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
	public String getReputeY() {
		return reputeY;
	}
	public void setReputeY(String reputeY) {
		this.reputeY = reputeY;
	}
	public String getReputeN() {
		return reputeN;
	}
	public void setReputeN(String reputeN) {
		this.reputeN = reputeN;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
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
	public Integer getGrp() {
		return grp;
	}
	public void setGrp(Integer grp) {
		this.grp = grp;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public Integer getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(Integer comment_idx) {
		this.comment_idx = comment_idx;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMobileRefer() {
		return mobileRefer;
	}
	public void setMobileRefer(String mobileRefer) {
		this.mobileRefer = mobileRefer;
	}
	

}
