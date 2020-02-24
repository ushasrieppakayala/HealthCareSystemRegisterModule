package capgemini.healthcaresystem;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import capgemini.healthcaresystem.dao.UserDao;
import capgemini.healthcaresystem.dao.UserDaoImpl;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.User;

public class healthCareSystem {
	User u1=new User("101","Eppakayala","Ushasri",9505411992L,"Customer","ushaeppakayala72@gmail.com");
	User u2=new User("102","Eppakayala","Chandrabhanu",9010330067L,"Customer","bhanueppakayala@gmail.com");
	UserDao ud=new UserDaoImpl();
	public static HashMap<String,DiagnosticCenter> centerList=new HashMap<String, DiagnosticCenter>();
    public static HashMap<String,User> userList= new HashMap<String,User>();
	@Test
	public void test() {
	 assertEquals(u1.getUserName(),ud.register(u1));
	}
	@Test
    public void test1()
    {
    	assertEquals(u2.getUserName(),ud.register(u2));
    }
}
