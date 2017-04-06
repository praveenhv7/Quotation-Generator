<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Arbutus Quotation Master</title>
   <script src="jquery.js"></script>
  
  <link rel="stylesheet" href="jquery-ui.css">
  <link rel="stylesheet" href="jquery-ui.structure.css">
  <link rel="stylesheet" href="jquery-ui.theme.css">
  <link rel="stylesheet" href="jquery-ui.min.css">
  
   <script src="jquery-ui.js"></script>
   <script src="jquery-ui.min.js"></script>
  <script  src="arbutusScripts.js"></script>
 
  
  <script>
  $(function() {
    $( "#tabs" ).tabs();
    getData();   
    //alert(availableTags);
  });
  </script>
  <script type="text/javascript">
  i=2;
  function addRows()
  {
	 
	 
	$('#myTable').append('<tr id="Row'+i+'"><td><input type="text" value='+i+' style="width:90px"></td><td><input type="text" class="partFill" style="width:180px"></td><td><input type="text" ></td><td><input type="text" autocomplete="off" class="makeFill" onfocus="populates()" style="width:180px"></td><td><input type="text" style="width:180px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td>');
	    
	i++;
  }
  
  function deleteRows()
  {
	  --i;
	  $('#Row'+i).remove();
	 
	  if(i==1)
		  {
		  i=2;
		  }
	 
  }
  
  </script>
  
  
  
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Create Quotation</a></li>
    <li><a href="#tabs-2">Insert Customer</a></li>
    <li><a href="#tabs-3">Insert Part</a></li>
  </ul>
  <div id="tabs-1">
  <table>
   <tr>
   <td>Quotation Number</td><td><input type="text" value="AR-" id="qtn_num"></td></tr>
   <tr><td>Company Name</td><td><input type="text" id="company_name"></td><td><input type="button" value="search" onclick="findCompany()"></td></tr>
   <tr><td>Address</td><td><textarea rows="5" id="address"></textarea></td></tr>
  	<tr><td>Customer Name</td><td><input type="text" id="name"></td></tr>
   <tr><td>Subject</td><td><input type="text" id="subject"></td><td></td><td>Reference</td><td><input type="text" id="ref"></td></tr>
   <tr><td>Freight</td><td><input type="text" id="freight"></td><td></td><td>Remarks</td><td><input type="text" id="remarks"></td></tr>
   <tr><td>Payment</td><td><input type="text" id="payment"></td><td>% Advance</td></tr>
   <tr><td>Price</td><td><input type="text" id="price"></td></tr>
   <tr><td>Sales Tax</td><td><input type="text" id="salesTax"></td></tr>
   <tr><td>Validity</td><td><input type="text" id="validity"></td></tr>
   <tr><td>Notes</td><td><input type="text" id="notes"></td></tr>
   
   </table>
   &nbsp
   <table border="2" width="80%" id="myTable">
   <tr><th>SL No</th><th>Part No</th><th>Description</th><th>Make</th><th>Qty</th><th>MOQ</th><th>SPQ</th><th>Lead time</th><th>Unit Price</th></tr>
   <tr><td><input type="text" value="1" style="width:90px"></td><td><input type="text" class="partFill" style="width:180px"></td><td><input type="text" ></td><td><input type="text" class="makeFill" onfocus="populates()" style="width:180px"></td><td><input type="text" style="width:180px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td><td><input type="text" style="width:150px"></td>
   </tr>
   </table>
    <input type="button" value="Add Row" onclick="addRows()">
     <input type="button" value="Submit" onclick="sendData()">
     <input type="button" value="delete Row" onclick="deleteRows()">
  </div>
  <div id="tabs-2">
  <div><select>
  <option value="insert">Insert Customer Details</option>
  <option value="modify">Modify Cutomer</option>
  </select></div>
    <table id="details">
<tr>
<td>First Name</td> <td><input type=text id="fName"></td>
<td>Last Name</td><td><input type=text id="lName"> </td>
</tr>
<tr>
<td>Designation</td><td><input type=text id="designation"> </td>
</tr>
<tr>
<td>Company Name</td><td><input type=text id="companyName"> </td>
</tr>

<tr>
<td>Mobile Number</td><td><input type=text id="mobileNum"> </td>
</tr>

<tr>
<td>Division</td><td><input type=text id="division"> </td>
</tr>

<tr>
<td>VAT</td><td><input type=text id="vat"> </td> 
<td>Sales Tax</td><td><input type=text id="salesTaxCust"> </td>
</tr>

<tr>
<td >Address</td><td colspan="15"><textarea id="addressCust" rows=5 cols="52"></textarea></td> 
</tr>
</table>
<input type="button" value="Submit" onclick="insertCust()">
<input type="reset" value="Reset"> 
  </div>
  <div id="tabs-3">
   <table>
    <tr><td>Make</td><td><input type="text" id="make"></td></tr>
    <tr><td>Item</td><td><input type="text" id="item"></td></tr>
    <tr><td>Description</td><td><input type="text" id="desc"></td></tr>
    <tr><td>MOQ</td><td><input type="text" id="moq"></td></tr>
    <tr><td>SPQ</td><td><input type="text" id="spq"></td></tr>
    </table>
    <input type="button" onclick="insertItems()" value="Send">
    <input type="reset" value="Reset">
    
  </div>
</div>
 
 
</body>
</html>