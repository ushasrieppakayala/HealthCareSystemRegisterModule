package capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public class UserDaoImpl implements UserDao {
	public static HashMap<String,DiagnosticCenter> centerList=new HashMap<String, DiagnosticCenter>();
    public static HashMap<String,User> userList= new HashMap<String,User>();
    static Random rand=new Random();
    public UserDaoImpl()
    {
    	DiagnosticCenter d1=new DiagnosticCenter();
    	d1.setCenterId("77777777");
    	d1.setCenterName("Narsapur");
    	
    	Test t1=new Test();
    	t1.setTestId("101");
    	t1.setTestName("Blood Group");
    	Test t2=new Test();
    	t2.setTestId("102");
    	t2.setTestName("Blood Pressure");
    	Test t3=new Test();
    	t2.setTestId("102");
    	t2.setTestName("Blood Sugar");
    	d1.setListOfTests(Arrays.asList(t1,t2,t3));
    	User u1=new User("101","manikanta","Nagireddy",9505411992L,"Cutomer","nagireddymani080@gmail.com");
    	User u2=new User("102","Mani","Manik",9059689933L,"Cutomer","16211a0278@gmail.com");
    	userList.put(u1.getUserName(),u1);
    	userList.put(u2.getUserName(),u2);
    	Appointment a1=new Appointment();
    	a1.setAppointmentId(10000000001L);
    	a1.setDatetime(new Date(2020,1,20));
    	a1.setTest(t1);
    	a1.setUser(u1);
    	a1.setApproved(false);
    	Appointment a2=new Appointment();
    	a2.setAppointmentId(10000000002L);
    	a2.setDatetime(new Date(2020,1,22));
    	a2.setTest(t2);
    	a2.setUser(u2);
    	a2.setApproved(false);
    	d1.setAppointmentList(Arrays.asList(a1,a2));
    	
    	centerList.put(d1.getCenterName(), d1);
    }
    
	public String register(User user) {
		 userList.put(user.getUserName(), user);
		return user.getUserName();
	}

}
