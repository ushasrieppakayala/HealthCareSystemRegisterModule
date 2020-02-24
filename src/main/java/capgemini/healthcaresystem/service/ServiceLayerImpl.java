package capgemini.healthcaresystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import capgemini.healthcaresystem.dao.UserDao;
import capgemini.healthcaresystem.dao.UserDaoImpl;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public class ServiceLayerImpl implements ServiceLayer {
	UserDao userdao=new UserDaoImpl();
	public String register(User user) {
		
		return userdao.register(user);
	}
	public boolean validateName(String userName) {
		Pattern p=Pattern.compile("[A-Z]\\w");
		Matcher m=p.matcher(userName);
		if(m.find())
		   return true;
		else
		   return false;
	}

	public boolean validatePassword(String userPassword) {
		Pattern p1=Pattern.compile("\\w{1,4}[!@#$%^&*]{1,4}+");
		Matcher m1=p1.matcher(userPassword);
		if(m1.find())
		   return true;
		else
		 return false;
	}

	public boolean validateNum(String string) {
		Pattern p1=Pattern.compile("0?[7-9][0-9]{9}");
		Matcher m1=p1.matcher(string);
		if(m1.find())
		   return true;
		else
		   return false;
	}

	public boolean validateEmail(String email) {
		Pattern p1=Pattern.compile("[0-9a-zA-Z][0-9a-zA-Z._]*[@]gmail.com");
		Matcher m1=p1.matcher(email);
		if(m1.find())
		   return true;
		else
		   return false;
	}

	
}
