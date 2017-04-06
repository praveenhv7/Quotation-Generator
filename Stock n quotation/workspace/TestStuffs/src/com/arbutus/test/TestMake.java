package com.arbutus.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.pool.OracleDataSource;

public class TestMake {
	
	static String userName="PRAVEEN";
	static String passWrd="praveen";
	static String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getMake("SONy"));
		
	}
	
	public static int getMake(String name)
	{
		int makeID=0;
		System.out.println("trying connection");
		OracleDataSource ods;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		Connection conn = ods.getConnection();
		String queryMake = "select supplier_number from arbutus_Supplier_info where supplier_name=?";
		PreparedStatement stmt=conn.prepareStatement(queryMake);
		stmt.setString(1,name);
		ResultSet rsetMake=stmt.executeQuery();
		while(rsetMake.next())
		{
			makeID=rsetMake.getInt(1);
		}
		if(makeID==0)
		{
			return 0;
		}
		else
		{
			return makeID;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return makeID;
		
	}
	
	public static int setMake(String name)
	{
		int makeID=0;
		System.out.println("trying connection");
		OracleDataSource ods;
		try{
		ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser(userName);
		ods.setPassword(passWrd);
		Connection conn = ods.getConnection();
		String queryMake = "insert into arbutus_Supplier_info values(?,supplier_seq.nextval)";
		PreparedStatement stmt=conn.prepareStatement(queryMake);
		stmt.setString(1,name);
		int rsetMake=stmt.executeUpdate();
		return rsetMake;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return makeID;
	}

}
