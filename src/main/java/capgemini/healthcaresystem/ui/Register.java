package capgemini.healthcaresystem.ui;
import java.util.*;

import capgemini.healthcaresystem.Exceptions.ContactNoException;
import capgemini.healthcaresystem.Exceptions.EmailException;
import capgemini.healthcaresystem.Exceptions.UserNameException;
import capgemini.healthcaresystem.Exceptions.UserPasswordException;
import capgemini.healthcaresystem.dao.UserDaoImpl;
import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;
import capgemini.healthcaresystem.service.ServiceLayer;
import capgemini.healthcaresystem.service.ServiceLayerImpl;

public class Register {
static HashMap<String,String> adminList =new HashMap();
static ServiceLayer service=new ServiceLayerImpl();
static Random rand=new Random();
static Scanner sc=new Scanner(System.in);
static List testList=new ArrayList();
public Register()
{
	addSomeAdminDetails();
}

private void addSomeAdminDetails() {
	adminList.put("Nagireddymani","1111");
	adminList.put("Ashritha","2222");
	adminList.put("Usha","3333");
	adminList.put("Ravali", "4444");		
}

public static void main(String[] args) throws UserNameException, UserPasswordException{

	Register u=new Register();
	
	System.out.println("\n\n \tWelcome to Health Care Management");
	System.out.println("1. Customer");
	System.out.println("2. Admin");
	
	boolean inputFlag = false;
	int choice=0;
	do {
		
		sc = new Scanner(System.in);
		System.out.println("enter ur input");

		try {
			
			choice = sc.nextInt();
			inputFlag = true;
		} catch (InputMismatchException e) {
			inputFlag = false;
			System.err.println("input should contain only digits");
		}

	} while (!inputFlag);
	
	switch(choice)
	{
	case 1 :{
		System.out.println("   Customer ");
		System.out.println("1. register");
		System.out.println("2. login");
		System.out.println("3. download");
		int c=0;
		do {
			
			sc = new Scanner(System.in);
			System.out.println("enter ur input");

			try {
				c = sc.nextInt();
				inputFlag = true;
			} catch (InputMismatchException e) {
				inputFlag = false;
				System.err.println("input should contain only digits");
			}

		} while (!inputFlag);
		
        switch(c)
        {
        case 1  :   register(); break;
        case 2  :   login();break;
        case 3  :  downloadAppointment();break;
        default :  System.out.println("Enter Valid Number ");
	    }
	}break;
    default:
	     System.out.println("Invalid case");
	break;
     }//switch

			}
	
private static void downloadAppointment() {
	
	 System.out.println("  Appointment Form  ");
	 System.out.println("Enter Center Name : ");
	 String center=sc.next();
	 DiagnosticCenter d=(UserDaoImpl.centerList).get(center);
	 List<Test> test=d.getListOfTests();
	 List<Appointment> appointment=d.getAppointmentList();
	 System.out.println("Enter Appointment Id :");
    long appointmentId=sc.nextLong();
    for(Appointment i:appointment)
    {
   	 if(appointmentId==i.getAppointmentId())
   	 {
   		 System.out.println("AppintmentId :   "+ i.getAppointmentId());
   		 System.out.println("UserId       :   "+i.getUser().getUserId());
   		 System.out.println("UserName     :   " +i.getUser().getUserName());
   		 System.out.println("UserRole     :   "+i.getUser().getUserRole());
   		 System.out.println("ContactNo    :   "+i.getUser().getContactNo());
   		 System.out.println("Email        :   "+i.getUser().getEmail());
   		 System.out.println("TestId       :   "+i.getTest().getTestId());
   		 System.out.println("TestName     :   "+i.getTest().getTestName());
   		 System.out.println("Date         :   "+i.getDatetime());
   		 
   	 }
    }

	
}

private static void login() throws UserNameException, UserPasswordException {
	
	  UserDaoImpl dao=new UserDaoImpl();
	  
	  System.out.println("Username :   ");
	  String username=sc.next();
	  System.out.println("Password :   ");
	  String password=sc.next();
	  System.out.println();
	  User u=dao.userList.get(username);
	  if(dao.userList.containsKey(username) && u.getUserPassword().equals(password))
	  {
		  System.out.println("Login Successfully");
		  //makeanappointment(UserDaoImpl.userList.get(username));
	  }
	  else
	  { 
		  System.out.println("Account not found");
		  register();
	  }
	
}

	
	private static void makeanappointment(User user) {
	// TODO Auto-generated method stub
	               System.out.println("Makean apppointment Code ");
     }
	public static void register() throws UserNameException, UserPasswordException 
	{
		System.out.println("\t Registeration Form :   \n-----------------------------------------------");
		//UserId
		User user=new User();
		
		boolean inputFlag=false;
		
		String username;
		
		
			sc = new Scanner(System.in);
			do {

			try 
			{ 
				System.out.println("enter username:");
				
				username = sc.next();
				if(service.validateName(username))
				{
					if(!UserDaoImpl.userList.containsKey(username))
					{
						inputFlag = true;
						user.setUserName(username);
						System.out.println("Validated Successfully");
					}
				}
				
			} catch (InputMismatchException e)
			{
				inputFlag = false;
				System.err.println("username is not valid");
			}
			}while(!inputFlag);
			//System.out.println(user.getUserName());
	    
		try {
		 System.out.println("must contain capital letters,small letters and numbers within 4 places and contain special characters :");
		 System.out.println("UserPassword : \n ");
		 String userpassword=sc.next();
		 if(service.validatePassword(userpassword))
		 {
		   System.out.println("Validated Successfully");
		   user.setUserPassword(userpassword);
		 }
		 else
		 {
			 throw new UserPasswordException(" Password must contain one number,one alphabet,one special character and size should be at least 8 characters and not more than 14 characters.");
		 }
		
	}
    catch(UserPasswordException up) {
		up.printStackTrace();
	}	
		//Contact Number
		boolean inputFlag1 = false;
		int choice=0;
		do {
			System.out.println("Contact No should be of 10 digits: ");
			sc = new Scanner(System.in);
			try {
				
				
			    long contactno=sc.nextLong();
				if(service.validateNum(Long.toString(contactno)))
				{
				    user.setContactNo(contactno);
				    System.out.println("validated Successfully");
				    inputFlag1=true;
				}
				else
				{
					throw new ContactNoException("Invalid Number");
				}
				}
				catch(ContactNoException c)
				{
					c.printStackTrace();
				}

		} while (!inputFlag1);
		
		
		 //StudentRole
		System.out.println("UserRole : ");
		user.setUserRole(sc.next());
		//email
		try {
		System.out.println("email Id : ");          
	    String email=sc.next();
		if(service.validateEmail(email))
		{
		    System.out.println("Validated Successfully");
			user.setEmail(email);	
		}
		else
		{
			throw new EmailException("Invalid Email");
		}	
		}
		catch(EmailException e)
		{
			e.printStackTrace();
		}
		user.setUserId(Integer.toString(Math.abs(rand.nextInt(1000))));
		System.out.println("UserId : "+user.getUserId());
		
		System.out.println(service.register(user)+" is Registered ");
		System.out.println(UserDaoImpl.userList);
		login();
	}
	}

