package com.arbutus.service;

import com.arbutus.Login.LoginBean;

public class LoginService {
	
	public String authenticate(LoginBean login)
	{
		if(login.getLoginName().equals("kishore"))
		{
			if(login.getLoginPassword().equals("kishore@123"))
				return "true";
		}
		return "false";
		
	}

}
