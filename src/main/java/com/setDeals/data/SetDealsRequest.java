package com.setDeals.data;

public class SetDealsRequest {
	private String shopName;
	private long shopContactNum;
	private SaleDetails saleDetails;
	private SaleDates saleDates;
	
	
	
	public SaleDates getSaleDates() {
		return saleDates;
	}
	public void setSaleDates(SaleDates saleDates) {
		this.saleDates = saleDates;
	}
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
	public SaleDetails getSaleDetails() {
		return saleDetails;
	}
	public void setSaleDetails(SaleDetails saleDetails) {
		this.saleDetails = saleDetails;
	}

}
