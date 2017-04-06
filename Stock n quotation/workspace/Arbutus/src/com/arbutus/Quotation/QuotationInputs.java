package com.arbutus.Quotation;

import java.util.Date;
import java.util.List;

public class QuotationInputs {

	String price;
	Float salesTax;
	Float payment;
	String freightCharges;
	String   validity;
	String note;
	String remarks;
	String Address;
	String qtnNo;
	String date;
	String name;
	String subject;
	String reference;
//	List<OrderedItems> items;
	String companyName;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	List<OrderedItems> orderItems;
	
	public String getPrice() {
		return price;
	}
//	public List<OrderedItems> getItems() {
//		return items;
//	}
//	public void setItems(List<OrderedItems> items) {
//		this.items = items;
//	}
	public List<OrderedItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderedItems> orderItems) {
		this.orderItems = orderItems;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getQtnNo() {
		return qtnNo;
	}
	public void setQtnNo(String qtnNo) {
		this.qtnNo = qtnNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Float getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Float salesTax) {
		this.salesTax = salesTax;
	}
	public Float getPayment() {
		return payment;
	}
	public void setPayment(Float payment) {
		this.payment = payment;
	}
	public String getFreightCharges() {
		return freightCharges;
	}
	public void setFreightCharges(String freightCharges) {
		this.freightCharges = freightCharges;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	


	
}
