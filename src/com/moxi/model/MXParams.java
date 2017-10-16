package com.moxi.model;

public class MXParams implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键id
	private String username;// 用户名（昵称）
	private String account;// 账号
	private String password;// 密码
	private String password2;
	private Integer channelId;// 频道id
	private Integer parentId;// 父频道id参数
	private String tagName;//标签
	private String keyword;// 关键字
	private String keyword1;// 关键字
	private Integer isDelete;// 是否删除
	private Integer pageNo = 0;// 分页起始
	private Integer pageSize = 10;// 分页显示数
	private Integer totalCount = 0;// 总页数
	private String order;// 排序参数
	private String	lotteryType;//彩票类型
	private String cpname;// 彩种名称
	private String cpuid;// 用户id
	private String cptoken;// 开奖用token
	private String orgUrl;//数据采集站点
	private String gatherUrl;//数据采集地址
	private String companyName;//公司名称(广告商)
	private Integer bannerLocationId;//banner位置
	private String title;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	
	public String getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(String lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public String getCpuid() {
		return cpuid;
	}

	public void setCpuid(String cpuid) {
		this.cpuid = cpuid;
	}

	public String getCptoken() {
		return cptoken;
	}

	public void setCptoken(String cptoken) {
		this.cptoken = cptoken;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}

	public String getGatherUrl() {
		return gatherUrl;
	}

	public void setGatherUrl(String gatherUrl) {
		this.gatherUrl = gatherUrl;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getBannerLocationId() {
		return bannerLocationId;
	}

	public void setBannerLocationId(Integer bannerLocationId) {
		this.bannerLocationId = bannerLocationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
