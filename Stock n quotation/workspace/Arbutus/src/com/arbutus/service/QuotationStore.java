package com.arbutus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arbutus.Quotation.MakeItems;

import oracle.jdbc.pool.OracleDataSource;

public class QuotationStore {
	
	String userName="PRAVEEN";
	String passWrd="praveen";
	String connString="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public List<MakeItems> getMake()
	{
		int i=0;
		List<MakeItems> listItems=new ArrayList<MakeItems>();
		System.out.println("trying connection");
		OracleDataSource ods;
		Connection conn ;
		Statement stmt ;
		
		String[] makeAll = new String[20];
		try {
			ods = new OracleDataSource();
		
		ods.setURL(connString);
		ods.setUser("PRAVEEN");
		ods.setPassword("praveen");
		 conn = ods.getConnection();
		  stmt = conn.createStatement();
		 ResultSet rset = stmt.executeQuery("select distinct supplier_name,supplier_number from arbutus_Supplier_info");
		 while(rset.next())
		 {
			 MakeItems makeItems=new MakeItems();
			 String company=rset.getString("supplier_name");    //setting make fsuch that each make will have list of items along with description
			 makeItems.setMake(company);
			 Integer supplier_number=Integer.parseInt(rset.getString("supplier_number")); 
			 PreparedStatement stmtPrep = null;
			 stmtPrep=conn.prepareStatement("Select * from arbutus_items_info where supplier_number=?");
			 stmtPrep.setInt(1, supplier_number);
			 ResultSet rsetItem=stmtPrep.executeQuery();
			 while(rsetItem.next())
			 {
//				makeItems.getItems().add(rsetItem.getString("PART_NUMBER"));
//				makeItems.getDescription().add(rsetItem.getString("DESCRIPTION"));
				makeItems.getItemDesc().put(rsetItem.getString("item_name"), rsetItem.getString("description"));
				 
			 }
			 listItems.add(makeItems);
			 System.out.println(company);
			 makeAll[i]=company;
			 
			 
			 
		 }
		 stmt.close();
			conn.close();
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listItems;
		
	}

}
