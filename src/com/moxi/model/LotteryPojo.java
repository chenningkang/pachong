package com.moxi.model;

import java.util.Date;

public class LotteryPojo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;//主键
	private String qihao;//期号
	private String dateline;//时间字符串
	private String number;//中奖号码
	private String type;//彩票类型
	private Date creatTime;//创建时间
	private Date sysCreateTime;//信息录入时间
	private Integer isDelete;//是否删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQihao() {
		return qihao;
	}

	public void setQihao(String qihao) {
		this.qihao = qihao;
	}

	public String getDateline() {
		return dateline;
	}

	public void setDateline(String dateline) {
		this.dateline = dateline;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getSysCreateTime() {
		return sysCreateTime;
	}

	public void setSysCreateTime(Date sysCreateTime) {
		this.sysCreateTime = sysCreateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
