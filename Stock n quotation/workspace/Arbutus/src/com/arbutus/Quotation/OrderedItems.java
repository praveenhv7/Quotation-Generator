package com.arbutus.Quotation;

public class OrderedItems {
	
	String partNo;	
	String description;	
	String make;	
	Integer qty;	
	Integer moq;	
	Integer spq;	
	String leadtime; 	
	Float unitPrice;
	
	
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo.toUpperCase();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make.toUpperCase();
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getMoq() {
		return moq;
	}
	public void setMoq(Integer moq) {
		this.moq = moq;
	}
	public Integer getSpq() {
		return spq;
	}
	public void setSpq(Integer spq) {
		this.spq = spq;
	}
	public String getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(String leadtime) {
		this.leadtime = leadtime;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
		
	
	


}
