package com.arbutus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.arbutus.Quotation.Customer;
import com.arbutus.Quotation.CustomerExtract;
import com.arbutus.Quotation.MakeItems;
import com.arbutus.Quotation.OrderedItems;
import com.arbutus.Quotation.QuotationInputs;
import com.arbutus.service.CompanyDetails;
import com.arbutus.service.CustomerStore;
import com.arbutus.service.ItemsStore;
import com.arbutus.service.QuotationPDF;
import com.arbutus.service.QuotationStore;
import com.arbutus.service.StoreQuotation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext());
		System.out.println(getServletContext().getContextPath());
		System.out.println(getServletContext().getResourcePaths("/PdfRelated"));
		
//		ServletContext context = getServletContext();
		
		String pathToFonts =getServletContext().getRealPath(getServletContext().getInitParameter("fontPath"));
		System.out.println(pathToFonts);
		System.out.println("inside post");
		String option=request.getParameter("argument");
		
		if(option.equals("insert"))
		{
		String obtainedData=request.getParameter("details");
		System.out.println(obtainedData);
		
		String obtainedList=request.getParameter("items");
		System.out.println(obtainedList);
		
		QuotationInputs qtnInputs=new QuotationInputs();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		try {
			//validity
			jsonObject = (JSONObject) jsonParser.parse(obtainedData);
			qtnInputs.setQtnNo((String) jsonObject.get("qtnNumber"));
			qtnInputs.setCompanyName((String) jsonObject.get("companyName"));
			qtnInputs.setAddress((String) jsonObject.get("address"));
			qtnInputs.setName((String) jsonObject.get("name"));
			qtnInputs.setSubject((String) jsonObject.get("subject"));
			qtnInputs.setValidity((String) jsonObject.get("validity"));
			qtnInputs.setReference((String)jsonObject.get("reference"));
			qtnInputs.setFreightCharges((String)jsonObject.get("freight"));
			qtnInputs.setRemarks((String)jsonObject.get("remarks"));
			qtnInputs.setPayment(Float.parseFloat((String)jsonObject.get("payment")));
            qtnInputs.setPrice((String)jsonObject.get("price"));
            qtnInputs.setSalesTax(Float.parseFloat((String)jsonObject.get("salesTax")));
            qtnInputs.setNote((String)jsonObject.get("notes"));
			Date date=new Date();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
			String dateNew=formatter.format(date);			
			qtnInputs.setDate(dateNew);
			
			List<OrderedItems> itemsList=new ArrayList<OrderedItems>();
			JsonArray entries = (JsonArray) new JsonParser().parse(obtainedList);
			System.out.println("size of array"+entries.size());
			for(int i=0;i<entries.size();i++)
			{
			System.out.println(entries.get(i));
			JsonElement elem=entries.get(i);
			String jsonNew=elem.toString();
			OrderedItems items=new OrderedItems();
			jsonObject = (JSONObject) jsonParser.parse(jsonNew);
            items.setPartNo((String) jsonObject.get("partNumber"));
            items.setDescription((String) jsonObject.get("description"));
            items.setLeadtime((String) jsonObject.get("leadTime"));
            items.setMake((String) jsonObject.get("make"));
            String moq= ((String) jsonObject.get("moq"));
            items.setMoq(Integer.parseInt(moq));
            items.setQty(Integer.parseInt((String) jsonObject.get("qty")));
            items.setSpq(Integer.parseInt((String) jsonObject.get("moq")));
            items.setLeadtime(((String) jsonObject.get("leadTime")));
            items.setUnitPrice(Float.parseFloat((String) jsonObject.get("unitPrice")));
            
            itemsList.add(items);
			}
            qtnInputs.setOrderItems(itemsList);
            System.out.println(qtnInputs.getOrderItems().size());
			//items.setPartNo();
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		           // get a String from the JSON object
		
		
		
			StoreQuotation storeQtn=new StoreQuotation();
			boolean passed=storeQtn.storeAllInfo(qtnInputs);
		
			if(passed){
			QuotationPDF quote=new QuotationPDF(pathToFonts);
			quote.createPDF(qtnInputs);
			}
			
		}
		
		if(option.equals("getMake"))
		{
			QuotationStore store=new QuotationStore();
			List<MakeItems> make= store.getMake();
//			response.setContentType("text/plain");
//			PrintWriter out=response.getWriter();
//			System.out.println(make.toString());
//			out.print(make.toString());
			
			Gson send=new Gson();
			 PrintWriter out=response.getWriter();
			 response.setContentType("text/html");
			 out.println(send.toJson(make));
			System.out.println(send.toJson(make));
			
			
			/*
			 Gson send=new Gson();
			 PrintWriter out=response.getWriter();
			 response.setContentType("text/html");
			 out.println(send.toJson(retBean));
			  */
			
		}
		
		if(option.equals("insertCust"))
		{
			String custDetails=request.getParameter("custDet");
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			Customer cust=new Customer();
			CustomerStore insertCust=new CustomerStore();
			
			try {
				jsonObject=(JSONObject) jsonParser.parse(custDetails);
				cust.setFirstName((String) jsonObject.get("firstName"));
				//cust.setLastName((String) jsonObject.get("lastName"));
				cust.setDesignation((String) jsonObject.get("designation"));
				cust.setCompanyName((String) jsonObject.get("companyName"));
				cust.setMobileNumber((String) jsonObject.get("mobileNum"));
				cust.setDivision((String) jsonObject.get("division"));
				cust.setVat((String) jsonObject.get("vat"));
				cust.setSalesTax((String) jsonObject.get("salesTaxCust"));
				cust.setAddress((String) jsonObject.get("addressCust"));
				insertCust.insertCustomer(cust);
				System.out.println(cust.getAddress());
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(option.equals("getCompany"))
		{
			CompanyDetails details=new CompanyDetails();
			String name=request.getParameter("cName");
			List<String> allComp=details.getCompany(name);
			if(allComp.isEmpty())
			{
				allComp.add(name+"Not a valid company");
			}
			Gson send=new Gson();
			 PrintWriter out=response.getWriter();
			 response.setContentType("text/html");
			 out.println(send.toJson(allComp));
			System.out.println(send.toJson(allComp));
		}
		
		if(option.equals("getCustomerAddress"))
		{
			CompanyDetails details=new CompanyDetails();
			String companyName=request.getParameter("company_name");
			List<CustomerExtract> custInfo=details.getCustomerInfo(companyName);
			Gson send=new Gson();
			 PrintWriter out=response.getWriter();
			 response.setContentType("text/html");
			 out.println(send.toJson(custInfo));
			System.out.println(send.toJson(custInfo));
			
		}
		
//		"Make":	$('#make').val(),
//		"Item":$('#item').val(),
//		"Description":$('#desc').val(),
//		"MOQ":$('moq').val(),
//		"SPQ":$('spq').val()
		
		if(option.equals("insertItems"))
		{
			String items=request.getParameter("ItemData");
			System.out.println(items);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			OrderedItems ordItem=new OrderedItems();
			try{
			jsonObject=(JSONObject) jsonParser.parse(items);
			ordItem.setMake((String) jsonObject.get("Make"));
			ordItem.setPartNo((String) jsonObject.get("Item"));
			ordItem.setDescription((String) jsonObject.get("Description"));
			ordItem.setMoq(Integer.parseInt((String) jsonObject.get("MOQ")));
			ordItem.setSpq(Integer.parseInt((String) jsonObject.get("SPQ")));
			ItemsStore insertStore=new ItemsStore();
			insertStore.insertItems(ordItem);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
