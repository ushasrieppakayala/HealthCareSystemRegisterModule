package capgemini.healthcaresystem.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capgemini.healthcaresystem.dao.*;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;
public class ServiceLayer implements UserDao {

	public boolean addCenter(ArrayList<DiagnosticCenter> center) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeCenter(ArrayList<DiagnosticCenter> center) {
		// TODO Auto-generated method stub
		return false;
	}

	public String addTest(ArrayList<Test> test) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeTest(ArrayList<Test> test) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean approveAppointment() {
		// TODO Auto-generated method stub
		return false;
	}

	public String makeAppointment(ArrayList<User> user, ArrayList<DiagnosticCenter> center, ArrayList<Test> test,
			List<Date> datetime) {
		// TODO Auto-generated method stub
		return null;
	}

	public String register(ArrayList user) {
		// TODO Auto-generated method stub
		return null;
	}

}
