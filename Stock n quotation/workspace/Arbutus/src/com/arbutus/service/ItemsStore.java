package com.arbutus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.pool.OracleDataSource;

import com.arbutus.Quotation.OrderedItems;

public class ItemsStore {
	
	String userName="PRAVEEN";
	String passWrd="praveen";
	String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	
	public int insertItems(OrderedItems ordItem) {
		// TODO Auto-generated method stub
		
		
		System.out.println("trying connection");
		OracleDataSource ods;
		PreparedStatement stmt;
		Connection conn;
		try{
			
			if(getMake(ordItem.getMake())==0)
			{
				setMake(ordItem.getMake());
				
			}
		int makeID=getMake(ordItem.getMake());	
			
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		 conn = ods.getConnection();
		String queryMake = "insert into arbutus_items_info(SUPPLIER_NUMBER,ITEM_NAME,DESCRIPTION,SPQ,MOQ) values(?,?,?,?,?)";
		 stmt=conn.prepareStatement(queryMake);
		stmt.setInt(1,makeID);
		stmt.setString(2,ordItem.getPartNo());
		stmt.setString(3, ordItem.getDescription());
		stmt.setInt(4, ordItem.getSpq());
		stmt.setInt(5, ordItem.getMoq());
//		stmt.setString(6, ordItem.getLeadtime());
		int inserted=stmt.executeUpdate();
		return inserted;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	
	public  int getMake(String name)
	{
		int makeID=0;
		System.out.println("trying connection");
		OracleDataSource ods;
		PreparedStatement stmt;
		Connection conn;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		 conn = ods.getConnection();
		String queryMake = "select supplier_number from arbutus_Supplier_info where supplier_name=?";
		 stmt=conn.prepareStatement(queryMake);
		stmt.setString(1,name.toUpperCase());
		ResultSet rsetMake=stmt.executeQuery();
		while(rsetMake.next())
		{
			makeID=rsetMake.getInt(1);
		}
		if(makeID==0)
		{
			stmt.close();
			conn.close();
			return 0;
		}
		else
		{
			stmt.close();
			conn.close();
			return makeID;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return makeID;
		
	}
	
	public int setMake(String name)
	{
		int makeID=0;
		System.out.println("trying connection");
		OracleDataSource ods;
		PreparedStatement stmt;
		Connection conn;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		 conn = ods.getConnection();
		String queryMake = "insert into arbutus_Supplier_info values(?,supplier_seq.nextval)";
		 stmt=conn.prepareStatement(queryMake);
		stmt.setString(1,name.toUpperCase());
		int rsetMake=stmt.executeUpdate();
		stmt.close();
		conn.close();
		return rsetMake;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return makeID;
	}

}
