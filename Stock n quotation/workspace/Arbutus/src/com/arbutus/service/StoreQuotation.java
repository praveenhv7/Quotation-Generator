package com.arbutus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import oracle.jdbc.pool.OracleDataSource;

import com.arbutus.Quotation.OrderedItems;
import com.arbutus.Quotation.QuotationInputs;

public class StoreQuotation {
	
	String userName="PRAVEEN";
	String passWrd="praveen";
	String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	
	

	
	public boolean storeAllInfo(QuotationInputs qtnInputs){
		
		
		System.out.println("trying connection");
		OracleDataSource ods;
		Connection conn;
		PreparedStatement stmt;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		 conn = ods.getConnection();
		String insertCust = "insert into quotation_customer values(?,?,QUOTATION_SEQ.nextval,?,?,?,?,?,?,?,?)";
		 stmt=conn.prepareStatement(insertCust);
		stmt.setString(1, qtnInputs.getCompanyName());
		stmt.setString(2, qtnInputs.getName());
	    stmt.setString(3, qtnInputs.getQtnNo());
	    stmt.setString(4, qtnInputs.getPrice());
	    stmt.setFloat(5, qtnInputs.getSalesTax());
	    stmt.setFloat(6, qtnInputs.getPayment());
	    stmt.setString(7, qtnInputs.getFreightCharges());
	    stmt.setString(8, qtnInputs.getValidity());
	    stmt.setString(9, qtnInputs.getNote());
	    stmt.setString(10, qtnInputs.getRemarks());
	    
	   List<OrderedItems> items= qtnInputs.getOrderItems();
	   
	   stmt.executeUpdate();
	   
	   
	   for(int i=0;i<items.size();i++)
	   {
		   
		   String insertItems="insert into quotation_items values(?,?,?)";
		   PreparedStatement stmtItem=conn.prepareStatement(insertItems);
		   stmtItem.setString(1, qtnInputs.getQtnNo());
		   
		   ItemsStore itemStore=new ItemsStore();
		   
		   int supplierNumber=itemStore.getMake(items.get(i).getMake());
		   
		   stmtItem.setInt(2,supplierNumber);
		   stmtItem.setString(3, items.get(i).getPartNo());
		   
		   stmtItem.executeUpdate();
		   
		   
	   }
	   stmt.close();
		conn.close();
		return true;
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}





	private int getSupplierNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

}
