package com.arbutus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import oracle.jdbc.pool.OracleDataSource;

import com.arbutus.Quotation.Customer;

public class CustomerStore {
	
	String userName="Praveen";
	String passWrd="praveen";
	String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public boolean insertCustomer(Customer cust)
	{
		System.out.println(cust.getName());
		System.out.println("trying connection");
		OracleDataSource ods;
		Connection conn;
		PreparedStatement preparedStatement;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser("PRAVEEN");
		ods.setPassword("praveen");
		 conn = ods.getConnection();
		
		String insertTableSQL = "INSERT INTO arbutus_customer_info(COMPANY_NAME,CUSTOMER_NAME,CUSTOMER_MOB_NUMBER,DIVISION,ADDRESS,DESIGNATION,CREATION_DATE,SALES_TAX,VAT) VALUES (?,?,?,?,?,?,?,?,?)";
		 preparedStatement = conn.prepareStatement(insertTableSQL);
		java.util.Date date= new java.util.Date();
		preparedStatement.setString(1, cust.getCompanyName());
		preparedStatement.setString(2, cust.getFirstName());
		preparedStatement.setLong(3, cust.getMobileNumber());
		preparedStatement.setString(4, cust.getDivision());
		preparedStatement.setString(5,cust.getAddress());
		preparedStatement.setString(6, cust.getDesignation());
		preparedStatement.setTimestamp(7,new Timestamp(date.getTime()));
		preparedStatement.setFloat(8, cust.getSalesTax());
		preparedStatement.setFloat(9, cust.getVat());
		// execute insert SQL stetement
		int i=preparedStatement .executeUpdate(); 
		
		System.out.println("updated rows"+i);
		preparedStatement.close();
		conn.close();
		 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
