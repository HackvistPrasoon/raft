package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Repo.TabMappingRepo;
import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.Service.AgeService;
import dev.project.raftbackend.Service.CookieService;
import dev.project.raftbackend.Service.EducationService;
import dev.project.raftbackend.Service.EthnicService;
import dev.project.raftbackend.Service.GenderService;
import dev.project.raftbackend.Service.LocationService;
import dev.project.raftbackend.Service.RiverListService;
import dev.project.raftbackend.bean.ApiStatus;
import dev.project.raftbackend.bean.ResponseData;
import dev.project.raftbackend.bean.UserDetailsBean;
import dev.project.raftbackend.bean.UserDetailsPreview;
import dev.project.raftbackend.model.Age;
import dev.project.raftbackend.model.Education;
import dev.project.raftbackend.model.Ethnic;
import dev.project.raftbackend.model.Gender;
import dev.project.raftbackend.model.Location;
import dev.project.raftbackend.model.Riverslist;
import dev.project.raftbackend.model.TabMapping;
import dev.project.raftbackend.model.Userdetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static dev.project.raftbackend.Service.CookieService.getUserByEmail;

import java.util.List;


@RestController
public class RouteController {
    @Autowired
    private CookieService cookieService;
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
    
    @Autowired
    TabMappingRepo mappingRepo;
    @Autowired
    UserdetailsRepo repo;
    @CrossOrigin(origins = "*")

    @GetMapping("/api/getuser")
    public Userdetails getuser(HttpServletRequest request) {

        System.out.println("I'm here at step0");
        String email = cookieService.getCookieValue(request,"token");
        System.out.println(email);
        return getUserByEmail(email).getBody();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/step1")
    public ResponseEntity<?>  step1(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1, HttpServletResponse response) {
    	
    	try {
//        	System.out.println(token);
        	System.out.println("page called");
            System.out.println(request);
            System.out.println(userdetails1);
            //System.out.println(cookieService.getCookieValue(request, "token"));
            String email = cookieService.getEmailId(userdetails1.getToken());
            System.out.println(email);

            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setFirst_name(userdetails1.getFirst_name());
            userdetails.setLast_name(userdetails1.getLast_name());
            repo.saveAndFlush(userdetails);
            
            TabMapping tabs = new TabMapping();
            tabs.setEmailId(email);
            tabs.setTab1("true");
            mappingRepo.saveAndFlush(tabs);
			
			ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
			
        }
        catch (Exception e){
        	System.out.println("page Catch");
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/riverlist")
    public List<Riverslist> getAllEntities() {
        return riverRepo.getAllEntities();
    }
    
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/step2")
    public ResponseEntity<?>  step2(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        try {
        	System.out.println("Step 2");
            String email = cookieService.getEmailId(userdetails1.getToken());
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setRiver_id(userdetails1.getRiver_id());

            System.out.println("After setting river id"+userdetails);

            repo.saveAndFlush(userdetails);
            
            TabMapping tabs = mappingRepo.findByEmailId(email);
            tabs.setTab2("true");
            mappingRepo.saveAndFlush(tabs);
            
            ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
        }
        catch (Exception e){
            System.out.println("Error");
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/step3")
    public ResponseEntity<?>  step3(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        try {
        	String email = cookieService.getEmailId(userdetails1.getToken());
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            //First Row
            userdetails.setConservative(userdetails1.getConservative());
            userdetails.setMaga(userdetails1.getMaga());
            userdetails.setLibertarian(userdetails1.getLibertarian());
            userdetails.setModerate(userdetails1.getModerate());
            userdetails.setLiberal(userdetails1.getLiberal());
            userdetails.setProgressive(userdetails1.getProgressive());
            userdetails.setApolitical(userdetails1.getApolitical());
            //2nd Row
            userdetails.setDemocrat(userdetails1.getDemocrat());
            userdetails.setRepublican(userdetails1.getRepublican());
            userdetails.setGreen(userdetails1.getGreen());
            userdetails.setIndependent(userdetails1.getIndependent());
            userdetails.setLiberatarian_political_party(userdetails1.getLiberatarian_political_party());
            userdetails.setOther(userdetails1.getOther());
            //3rd row
            userdetails.setText_box1(userdetails1.getText_box1());
            userdetails.setText_box2(userdetails1.getText_box2());
            //4th row
            userdetails.setRadio_comfort(userdetails1.getRadio_comfort());
            userdetails.setRadio_feel(userdetails1.getRadio_feel());
            userdetails.setRadio_pov(userdetails1.getRadio_pov());
            userdetails.setRadio_prespective(userdetails1.getRadio_prespective());


            repo.saveAndFlush(userdetails);
            
            TabMapping tabs = mappingRepo.findByEmailId(email);
            tabs.setTab3("true");
            mappingRepo.saveAndFlush(tabs);
            
            ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
        }
        catch (Exception e){
            System.out.println("Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/agelist")
    public List<Age> getAllAgeEnteries() {
        return ageRepo.getAllEntities();
    }
    
    @GetMapping("/genderlist")
    public List<Gender> getAllGenderEnteries() {
        return genderRepo.getAllEntities();
    }
    
    @GetMapping("/ethniclist")
    public List<Ethnic> getAllEthnicEnteries() {
        return ethnicRepo.getAllEntities();
    }
    
    @GetMapping("/educationlist")
    public List<Education> getAllEducationEnteries() {
        return eduRepo.getAllEntities();
    }
    
    @GetMapping("/locationlist")
    public List<Location> getAllLocationEnteries() {
        return locRepo.getAllEntities();
    }
    
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/step4")
    public ResponseEntity<?>  step4(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        try {
        	String email = cookieService.getEmailId(userdetails1.getToken());
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setEthnic_id(userdetails1.getEthnic_id());
            userdetails.setGender_id(userdetails1.getGender_id());
            userdetails.setAge_id(userdetails1.getAge_id());
            userdetails.setEducation_id(userdetails1.getEducation_id());
           // userdetails.setResedential_detail(userdetails1.getResedential_detail());
            userdetails.setLocation_id(userdetails1.getLocation_id());
            repo.saveAndFlush(userdetails);
            
            TabMapping tabs = mappingRepo.findByEmailId(email);
            tabs.setTab4("true");
            mappingRepo.saveAndFlush(tabs);
            
            ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
        }
        catch (Exception e){
            System.out.println("Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/step5")
    public ResponseEntity<?>  step5(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        try {
        	String email = cookieService.getEmailId(userdetails1.getToken());
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println("Step 5");
            System.out.println(userdetails1);
            assert userdetails != null;
            userdetails.setOutside_my_bubble(userdetails1.getOutside_my_bubble());
            userdetails.setOmb_emailid(userdetails1.getOmb_emailid());
            userdetails.setOmb_first_name(userdetails1.getOmb_first_name());
            userdetails.setOmb_last_name(userdetails1.getOmb_last_name());


            repo.saveAndFlush(userdetails);
            
            TabMapping tabs = mappingRepo.findByEmailId(email);
            tabs.setTab5("true");
            mappingRepo.saveAndFlush(tabs);
            
            ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
        }
        catch (Exception e){
            System.out.println("Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/stepList")
    public ResponseEntity<?> getBooleanObject(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        // Create a BooleanObject instance and set the boolean variables
    	
    	 try {
    		 ApiStatus booleanObject = new ApiStatus();
    	    	
    	    	TabMapping tabs = mappingRepo.findByEmailId(userdetails1.getToken());
    	    	
    	    	if(tabs != null && tabs.getTab5() != null && tabs.getTab5().equalsIgnoreCase("True")) {
    	    		 booleanObject.setStep5(true);
    	    	} else {
    	    		booleanObject.setStep5(false);
    	    	}
    	    		
    	    	if (tabs != null && tabs.getTab4() != null && tabs.getTab4().equalsIgnoreCase("True")) {
    	    		 booleanObject.setStep4(true);
    	    	} else {
    	    		booleanObject.setStep4(false);
    	    	}
    	    		
    	    	if (tabs != null && tabs.getTab3() != null && tabs.getTab3().equalsIgnoreCase("True")) {
    	    		booleanObject.setStep3(true);
    	    	} else {
    	    		booleanObject.setStep3(false);
    	    	}
    	    		
    	    	if (tabs != null && tabs.getTab2() != null && tabs.getTab2().equalsIgnoreCase("True")) {
    	    		booleanObject.setStep2(true);
    	    	}else {
    	    		booleanObject.setStep2(false);
    	    	}
    	        
    	        booleanObject.setStep1(true);
 	        
 	        // Return response with status OK and response object
 	        return ResponseEntity.ok(booleanObject);
         }
         catch (Exception e){
             System.out.println("Error");
             System.out.println(e);
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/preview")
    public ResponseEntity<?>  preview(HttpServletRequest request, @RequestBody UserDetailsBean userdetails1) {
        try {
        	String email = cookieService.getEmailId(userdetails1.getToken());
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println("Preview");
            System.out.println(userdetails1);
            UserDetailsPreview udp = new UserDetailsPreview();
            assert userdetails != null;
            udp.setEmailid(userdetails.getEmailid());
            udp.setFirst_name(userdetails.getFirst_name());
            udp.setLast_name(userdetails.getLast_name());
            Riverslist river = riverRepo.getRiverList(userdetails.getRiver_id());
            udp.setRiver(river.getRiver());
            udp.setRiver_level(river.getLevel());
            udp.setRiver_outfitter(river.getOutfitter());
            udp.setRiver_section(river.getRiver_section());
            udp.setRiver_states(river.getStates());
            udp.setRiver_date(river.getDate());
            udp.setOutside_my_bubble(userdetails.getOutside_my_bubble());
            Ethnic eth = ethnicRepo.getEthnic(userdetails.getEthnic_id());
            udp.setEthnicType(eth.getEthnicType());
            Gender gen = genderRepo.getGender(userdetails.getGender_id());
            udp.setGender(gen.getGender());
            Education edu = eduRepo.getEducation(userdetails.getEducation_id());
            udp.setEducationType(edu.getEducationType());
            Age age = ageRepo.getAge(userdetails.getAge_id());
            udp.setAgeGroup(age.getAgeGroup());
            Location loc = locRepo.getLocation(userdetails.getLocation_id());
            udp.setLocation(loc.getLocation());
            udp.setConservative(userdetails.getConservative());
            udp.setMaga(userdetails.getMaga());
            udp.setLibertarian(userdetails.getLibertarian());
            udp.setModerate(userdetails.getModerate());
            udp.setLiberal(userdetails.getLiberal());
            udp.setProgressive(userdetails.getProgressive());
            udp.setSocialist(userdetails.getSocialist());
            udp.setApolitical(userdetails.getApolitical());
            udp.setDemocrat(userdetails.getDemocrat());
            udp.setRepublican(userdetails.getRepublican());
            udp.setLiberatarian_political_party(userdetails.getLiberatarian_political_party());
            udp.setGreen(userdetails.getGreen());
            udp.setIndependent(userdetails.getIndependent());
            udp.setOther(userdetails.getOther());
            udp.setText_box1(userdetails.getText_box1());
            udp.setText_box2(userdetails.getText_box2());
            udp.setRadio_comfort(userdetails.getRadio_comfort());
            udp.setRadio_feel(userdetails.getRadio_feel());
            udp.setRadio_pov(userdetails.getRadio_pov());
            udp.setRadio_prespective(userdetails.getRadio_prespective());
            
            TabMapping tabs = mappingRepo.findByEmailId(email);
            tabs.setTab5("true");
            mappingRepo.saveAndFlush(tabs);
            
            ResponseData responseData = new ResponseData();
	        responseData.setStatus("ok");
	        responseData.setToken(userdetails1.getToken());
	        responseData.setUdp(udp);
	        
	        // Return response with status OK and response object
	        return ResponseEntity.ok(responseData);
        }
        catch (Exception e){
            System.out.println("Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/message")
    public String message() {
        return "Congrats !! App deployed";
    }

}
