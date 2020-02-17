package capgemini.healthcaresystem.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public interface UserDao {
  
  public boolean addCenter(ArrayList <DiagnosticCenter> center);
  public boolean removeCenter(ArrayList <DiagnosticCenter> center);
  public String addTest(ArrayList<Test> test);
  public boolean removeTest(ArrayList<Test> test);
  public boolean approveAppointment();
  public String makeAppointment(ArrayList <User> user,ArrayList <DiagnosticCenter> center,ArrayList<Test> test,List<Date> datetime);
  public String register(ArrayList<User> user);
  
}
