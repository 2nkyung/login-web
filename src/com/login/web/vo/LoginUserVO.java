package com.login.web.vo;

public class LoginUserVO {
// VO /DTO라고 부르는데 옛날에는 엔티티 모델이라고 부름
	private Integer luNum;
	private String luName;
	private String luId;
	private String luPwd;
	//VO의 단점은 테이블이 변경되면 얘도 변경되어야함.
	//맵은 키값틀려도 에러안남. VO쓰는 이유는 실수방지,
	//최소한의 마지노선??
	
	public Integer getLuNum() {
		return luNum;
	}
	public void setLuNum(Integer luNum) {
		this.luNum = luNum;
	}
	public String getLuName() {
		return luName;
	}
	public void setLuName(String luName) {
		this.luName = luName;
	}
	public String getLuId() {
		return luId;
	}
	public void setLuId(String luId) {
		this.luId = luId;
	}
	public String getLuPwd() {
		return luPwd;
	}
	public void setLuPwd(String luPwd) {
		this.luPwd = luPwd;
	}
	@Override
	public String toString() {
		return "LoginUserVO [luNum=" + luNum + ", luName=" + luName + ", luId=" + luId + ", luPwd=" + luPwd + "]";
	}
	
	

}
