package com.arbutus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arbutus.Quotation.CustomerExtract;

import oracle.jdbc.pool.OracleDataSource;

public class CompanyDetails {
	

	String userName="PRAVEEN";
	String passWrd="praveen";
	String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public List<String> getCompany(String compName)
	{
		
		List<String> listItems=new ArrayList<String>();
		System.out.println("trying connection");
		OracleDataSource ods;
		Connection conn;
		 PreparedStatement stmt;
		
		try {
			ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser("PRAVEEN");
		ods.setPassword("praveen");
		 conn = ods.getConnection();
		 
		 
		  stmt=conn.prepareStatement("select distinct(company_name) from arbutus_customer_info where company_name like ?");
		 stmt.setString(1,compName+"%");
		 ResultSet rset=stmt.executeQuery();
		 while(rset.next())
		 {
			 String company=null;
			 if(rset.getString(1)==null)
			 {
				 listItems.add("No items found for the search criteria");
			 }
			 else
			 {
				 company=rset.getString(1); 
			 }
			 
			 listItems.add(company);
		 }
		 stmt.close();
			conn.close();
			 
		 return listItems;

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listItems;

	}

	public List<CustomerExtract> getCustomerInfo(String companyName) {
	   
		List<CustomerExtract> customerInfo=new ArrayList<CustomerExtract>();
		
		System.out.println("trying connection");
		OracleDataSource ods;
		Connection conn;
		 PreparedStatement stmt;
		
		try {
			ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser("PRAVEEN");
		ods.setPassword("praveen");
		 conn = ods.getConnection();
		 
		 
		  stmt=conn.prepareStatement("select customer_name,address from  arbutus_customer_info where company_name=?");
		 stmt.setString(1,companyName);
		 ResultSet rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 CustomerExtract customer=new CustomerExtract();
			 customer.setCustomerName(rs.getString(1));
			 customer.setAddress(rs.getString(2));
			 customerInfo.add(customer);
			 
		 }
		 stmt.close();
		conn.close();
		 
		return customerInfo;
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
	}
		
	return null;
	}
	
	
}
