package com.arbutus.Quotation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MakeItems {

	String make;
//	List<String> items;
//	List<String> description;
	Map<String,String> itemDesc;
	
	public MakeItems()
	{
//		items=new ArrayList<String>();
//		description=new ArrayList<String>();
		itemDesc=new LinkedHashMap<String,String>();
	}
	
	public Map<String, String> getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(Map<String, String> itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
//	public List<String> getItems() {
//		return items;
//	}
//	public void setItems(List<String> items) {
//		this.items = items;
//	}
//	public List<String> getDescription() {
//		return description;
//	}
//	public void setDescription(List<String> description) {
//		this.description = description;
//	}
	
	
}
