package dev.project.raftbackend.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import dev.project.raftbackend.Service.AgeService;
import dev.project.raftbackend.Service.EducationService;
import dev.project.raftbackend.Service.EthnicService;
import dev.project.raftbackend.Service.GenderService;
import dev.project.raftbackend.Service.LocationService;
import dev.project.raftbackend.Service.RiverListService;
import dev.project.raftbackend.bean.UserDetailsBean;

public class ValidationClass {
	
	 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	 String String1 = "^[a-zA-Z]+$";
	 String String2 = "^[0-9]+$";
	 String String3 = "^(AA|FA|N|FD|AD)$";
	 String String4 = "^[a-zA-Z0-9@#\\-(){}\\[\\]!&'\"\\s]{1,500}$";
	 String String5 = "^(Pair|Self)$";

	 Pattern pattern;
	 Matcher matcher;
	 
	 
	 	@Autowired
	    RiverListService riverRepo;
	 	
	 	 @Autowired
	     AgeService ageRepo;
	     
	     @Autowired
	     GenderService genderRepo;
	     
	     @Autowired
	     EthnicService ethnicRepo;
	     
	     @Autowired
	     EducationService eduRepo;
	     
	     @Autowired
	     LocationService locRepo;
	 
	 
	 public String validateEmail(String email) {
		 
		 if(email != null) {
		 
		  pattern = Pattern.compile(emailRegex);
		 
		  matcher = pattern.matcher(email);
		 
		 if(!matcher.matches()) {
			 return "Enter valid email.";
		 } else {
			 return "true";
		 }
		 } else {
			 return "Enter Email Id";
		 }
		 
	 }
	 
 public String validateStep1(UserDetailsBean udb) {
	 
	 String result = null;
		 
	 	if(udb.getFirst_name() != null) {
	 
		  pattern = Pattern.compile(String1);
		 
		  matcher = pattern.matcher(udb.getFirst_name());
		 
		 if(!matcher.matches()) {
			 return "Enter valid First Name.";
		 } else {
			 result = "true";
		 }
	 	}  else {
	 		 return "Please Enter First Name.";
	 	}
	 	
	 	if(udb.getLast_name() != null) {
	 		pattern = Pattern.compile(String1);
			 
			  matcher = pattern.matcher(udb.getFirst_name());
			 
			 if(!matcher.matches()) {
				 return "Enter valid Last Name.";
			 } else {
				 result = "true";
			 }
	 	} else {
	 		 return "Please Enter Last Name.";
	 	}
	 	
	 	return result;
		 
	 }
 
public String validateStep2(UserDetailsBean udb) {
	 
	 String result = null;
		 
	 	if(udb.getRiver_id() != null) {
	 
		  pattern = Pattern.compile(String2);
		 
		  matcher = pattern.matcher(udb.getRiver_id()+"");
		// Boolean exist = riverRepo.getMaxRiverId(udb.getRiver_id());
		 
			 if(!matcher.matches() ) {
				 return "Select Valid River.";
			 } else {
				 result = "true";
			 }
	 	} else {
	 		 return "Please Select River or DIY Option.";
	 	}
	 	
	 
	 	
	 	return result;
		 
	 }


	public String validateStep3(UserDetailsBean udb) {
	 
	 String result = null;
		 
	 	if(udb.getConservative() != null) {
	 
		  pattern = Pattern.compile(String3);
		 
		  matcher = pattern.matcher(udb.getConservative()+"");
		
		 
			 if(!matcher.matches() ) {
				 return "Select Valid Conservative Option.";
			 } else {
				 result = "true";
			 }
	 	} else {
	 		 return "Please Select Conservative Option.";
	 	}
	 	
	 	if(udb.getMaga() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getMaga()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Maga Option.";
				 } else {
					 result = "true";
				 }
		 	}  else {
		 		 return "Please Select Maga Option.";
		 	}
	 	
	 	if(udb.getLibertarian() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getLibertarian()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Libertarian Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Libertarian Option.";
		 	}
	 	
	 	if(udb.getModerate() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getModerate()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Moderate Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Moderate Option.";
		 	}
	 	
	 	if(udb.getLiberal() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getLiberal()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Liberal Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Liberal Option.";
		 	}
	 	
	 	if(udb.getProgressive() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getProgressive()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Progressive Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Progressive Option.";
		 	}
	 	
	 	if(udb.getSocialist() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getSocialist()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Socialist Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Socialist Option.";
		 	}
	 	
	 	
	 	
	 	if(udb.getApolitical() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getApolitical()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Apolitical Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Apolitical Option.";
		 	}
	 	
	 	if(udb.getDemocrat() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getDemocrat()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Democrat Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Democrat Option.";
		 	}
	 	
	 	if(udb.getRepublican() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getRepublican()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Republican Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Republican Option.";
		 	}
	 	
	 	if(udb.getGreen() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getGreen()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Green Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Green Option.";
		 	}
	 	
	 	if(udb.getIndependent() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getIndependent()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Independent Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Independent Option.";
		 	}
	 	
	 	if(udb.getLiberatarian_political_party() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getLiberatarian_political_party()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Liberatarian_political_party Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Liberatarian_political_party Option.";
		 	}

	 	if(udb.getOther() != null) {
	 		 
			  pattern = Pattern.compile(String3);
			 
			  matcher = pattern.matcher(udb.getOther()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Other Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Other Option.";
		 	}
	 
	 	if(udb.getText_box1() != null) {
	 		 
			  pattern = Pattern.compile(String4);
			 
			  matcher = pattern.matcher(udb.getText_box1()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Enter Valid Input in First Question (Only Character, Number and less than 500 characters allowed.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Enter First Question.";
		 	}
	 	
	 	if(udb.getText_box2() != null) {
	 		 
			  pattern = Pattern.compile(String4);
			 
			  matcher = pattern.matcher(udb.getText_box2()+"");
			
			 
				 if(!matcher.matches() ) {
					 return "Enter Valid Input in Second Question (Only Character, Number and less than 500 characters allowed.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Enter Second Question.";
		 	}
	 	
	 	if(udb.getRadio_comfort() != null) {
	 		 
			  pattern = Pattern.compile(String2);
			 
			  matcher = pattern.matcher(udb.getRadio_comfort()+"");
			
			 
				 if(!matcher.matches() && 0<udb.getRadio_comfort() && udb.getRadio_comfort()<11 ) {
					 return "Select Valid How comfortable are you being friends with them?";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select How comfortable are you being friends with them? Option.";
		 	}
	 	
	 	if(udb.getRadio_feel() != null) {
	 		 
			  pattern = Pattern.compile(String2);
			 
			  matcher = pattern.matcher(udb.getRadio_feel()+"");
			
			 
				 if(!matcher.matches() && 0<udb.getRadio_feel() && udb.getRadio_feel()<11) {
					 return "Select Valid How do you feel about them?";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select How do you feel about them? Option.";
		 	}
	 	
	 	if(udb.getRadio_pov() != null) {
	 		 
			  pattern = Pattern.compile(String2);
			 
			  matcher = pattern.matcher(udb.getRadio_pov()+"");
			
			 
				 if(!matcher.matches() && 0<udb.getRadio_pov() && udb.getRadio_pov()<11) {
					 return "Select Valid How difficult do you find seeing it to see things from their point of view?";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select How difficult do you find seeing it to see things from their point of view? Option.";
		 	}
	 	
	 	if(udb.getRadio_prespective() != null) {
	 		 
			  pattern = Pattern.compile(String2);
			 
			  matcher = pattern.matcher(udb.getRadio_prespective()+"");
			
			 
				 if(!matcher.matches() && 0<udb.getRadio_prespective() && udb.getRadio_prespective()<11) {
					 return "Select Valid How important do you feel it is to understand their perspective?";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select How important do you feel it is to understand their perspective? Option.";
		 	}
	 	
	 	return result;
		 
	 }
	
	public String validateStep4(UserDetailsBean udb) {
		 
		 String result = null;
			 
		 	if(udb.getEthnic_id() != null) {
		 
			  pattern = Pattern.compile(String2);
			 
			  matcher = pattern.matcher(udb.getEthnic_id()+"");
			// Boolean exist = ethnicRepo.ifExist(udb.getRiver_id());
			 
				 if(!matcher.matches() ) {
					 return "Select Valid Ethnic Option.";
				 } else {
					 result = "true";
				 }
		 	} else {
		 		 return "Please Select Ethnic Option.";
		 	}
		 	
		 	if(udb.getGender_id() != null) {
				 
				  pattern = Pattern.compile(String2);
				 
				  matcher = pattern.matcher(udb.getGender_id()+"");
			//	 Boolean exist = ethnicRepo.ifExist(udb.getGender_id());
				 
					 if(!matcher.matches() ) {
						 return "Select Valid Gender Option.";
					 } else {
						 result = "true";
					 }
			 	}  else {
			 		 return "Please Select Gender Option.";
			 	}
		 	
		 	if(udb.getAge_id() != null) {
				 
				  pattern = Pattern.compile(String2);
				 
				  matcher = pattern.matcher(udb.getAge_id()+"");
				// Boolean exist = ethnicRepo.ifExist(udb.getAge_id());
				 
					 if(!matcher.matches() ) {
						 return "Select Valid Age Option.";
					 } else {
						 result = "true";
					 }
			 	} else {
			 		 return "Please Select Age Option.";
			 	}
		 	
		 	if(udb.getEducation_id() != null) {
				 
				  pattern = Pattern.compile(String2);
				 
				  matcher = pattern.matcher(udb.getEducation_id()+"");
				// Boolean exist = ethnicRepo.ifExist(udb.getEducation_id());
				 
					 if(!matcher.matches() ) {
						 return "Select Valid Education Option.";
					 } else {
						 result = "true";
					 }
			 	} else {
			 		 return "Please Select Education Option.";
			 	}
		 	
		 	if(udb.getLocation_id() != null) {
				 
				  pattern = Pattern.compile(String2);
				 
				  matcher = pattern.matcher(udb.getLocation_id()+"");
				// Boolean exist = ethnicRepo.ifExist(udb.getLocation_id());
				 
					 if(!matcher.matches() ) {
						 return "Select Valid Location Option.";
					 } else {
						 result = "true";
					 }
			 	}else {
			 		 return "Please Select Location Option.";
			 	}
		 	return result;
	}
		 	
		 	public String validateStep5(UserDetailsBean udb) {
				 
				 String result = null;
					 
				 	if(udb.getOutside_my_bubble() != null) {
				 
					  pattern = Pattern.compile(String5);
					 
					  matcher = pattern.matcher(udb.getOutside_my_bubble()+"");
					 
						 if(!matcher.matches() ) {
							 return "Select Valid Option.";
						 } else {
							 result = "true";
						 }
				 	} else {
						 result = "Please Select An Option";
					 }
				 	
				 	if(udb.getOmb_first_name() != null && udb.getOutside_my_bubble().equalsIgnoreCase("Self")) {
						 
						  pattern = Pattern.compile(String1);
						 
						  matcher = pattern.matcher(udb.getOmb_first_name()+"");
						 
							 if(!matcher.matches() ) {
								 return "Enter Valid First Name.";
							 } else {
								 result = "true";
							 }
					 	} else if(udb.getOutside_my_bubble().equalsIgnoreCase("Self")){
							 result = "Please Enter First Name";
						 }
				 	
				 	if(udb.getOmb_last_name() != null && udb.getOutside_my_bubble().equalsIgnoreCase("Self")) {
						 
						  pattern = Pattern.compile(String1);
						 
						  matcher = pattern.matcher(udb.getOmb_last_name()+"");
						 
							 if(!matcher.matches() ) {
								 return "Enter Valid Last Name.";
							 } else {
								 result = "true";
							 }
					 	} else if(udb.getOutside_my_bubble().equalsIgnoreCase("Self")){
							 result = "Please Enter Last Name";
						 }
				 	
				 	if(udb.getOmb_emailid() != null && udb.getOutside_my_bubble().equalsIgnoreCase("Self")) {
						 
						  pattern = Pattern.compile(emailRegex);
						 
						  matcher = pattern.matcher(udb.getOmb_emailid()+"");
						 
							 if(!matcher.matches() ) {
								 return "Enter Valid Email ID.";
							 } else {
								 result = "true";
							 }
					 	} else if(udb.getOutside_my_bubble().equalsIgnoreCase("Self")){
							 result = "Please Enter Email Id";
						 }
				 	
				 	
		 	
		 	return result;
			 
		 }
	 
}
