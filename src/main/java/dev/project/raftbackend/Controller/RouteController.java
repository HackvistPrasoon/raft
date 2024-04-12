package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.Service.CookieService;
import dev.project.raftbackend.model.Userdetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import static dev.project.raftbackend.Service.CookieService.getUserByEmail;


@RestController
public class RouteController {
    @Autowired
    private CookieService cookieService;
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
    public void  step1(HttpServletRequest request, @RequestBody Userdetails userdetails1) {
        try {
            System.out.println(request);
            System.out.println(userdetails1);
            System.out.println(cookieService.getCookieValue(request, "token"));
            String email = cookieService.getCookieValue(request, "token");

            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setFirst_name(userdetails1.getFirst_name());
            userdetails.setLast_name(userdetails1.getLast_name());
            repo.save(userdetails);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("api/step2")
    public void  step2(HttpServletRequest request, @RequestBody Userdetails userdetails1) {
        try {
            String email = cookieService.getCookieValue(request, "token");
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setRiver_id(userdetails1.getRiver_id());


            repo.save(userdetails);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    @PostMapping("api/step3")
    public void  step3(HttpServletRequest request, @RequestBody Userdetails userdetails1) {
        try {
            String email = cookieService.getCookieValue(request, "token");
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
            //2nd Row
            userdetails.setDemocrat(userdetails1.getDemocrat());
            userdetails.setRepublican(userdetails1.getRepublican());
            userdetails.setGreen(userdetails1.getGreen());
            userdetails.setIndependent(userdetails1.getIndependent());
            userdetails.setLiberatarian_political_party(userdetails1.getLiberatarian_political_party());
            //3rd row
            userdetails.setText_box1(userdetails1.getText_box1());
            userdetails.setText_box2(userdetails1.getText_box2());


            repo.save(userdetails);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    @PostMapping("api/step4")
    public void  step4(HttpServletRequest request, @RequestBody Userdetails userdetails1) {
        try {
            String email = cookieService.getCookieValue(request, "token");
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setEthnic_id(userdetails1.getEthnic_id());
            userdetails.setGender_id(userdetails1.getGender_id());
            userdetails.setAge_id(userdetails1.getAge_id());
            userdetails.setEducation_id(userdetails1.getEducation_id());
            userdetails.setResedential_detail(userdetails1.getResedential_detail());

            repo.save(userdetails);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    @PostMapping("api/step5")
    public void  step5(HttpServletRequest request, @RequestBody Userdetails userdetails1) {
        try {
            String email = cookieService.getCookieValue(request, "token");
            Userdetails userdetails = getUserByEmail(email).getBody();
            System.out.println(userdetails);
            assert userdetails != null;
            userdetails.setOutside_my_bubble(userdetails1.getOutside_my_bubble());
            userdetails.setOmb_emailid(userdetails1.getOmb_emailid());
            userdetails.setOmb_first_name(userdetails1.getOmb_first_name());
            userdetails.setOmb_last_name(userdetails1.getOmb_last_name());


            repo.save(userdetails);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    
    @GetMapping("/message")
    public String message() {
        return "Congrats !! App deployed";
    }

}
