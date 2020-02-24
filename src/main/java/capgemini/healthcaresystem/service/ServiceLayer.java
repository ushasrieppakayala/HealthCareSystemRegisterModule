package capgemini.healthcaresystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public interface ServiceLayer {
	  public String register(User user);
	  public boolean validateName(String username);
	  public boolean validatePassword(String userpassword);
	  public boolean validateNum(String contactno);
	  public boolean validateEmail(String email);
}
