package capgemini.healthcaresystem.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public interface UserDao {
  public String register(User user);
  
}
