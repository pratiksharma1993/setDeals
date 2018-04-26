package com.setDeals.data;

public class SetDealsResponse {
	
	private String shopName;
	private long shopContactNum;
	private String success;
	private String errorCode;
	private String errorMessage;
	
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public long getShopContactNum() {
		return shopContactNum;
	}
	public void setShopContactNum(long shopContactNum) {
		this.shopContactNum = shopContactNum;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
