package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class finalstep {
    @Autowired
    UserdetailsRepo repo;
    @PostMapping("/user/updatefinalstep")
    public String updateData(@RequestBody Userdetails userdetails){

        try{

            repo.save(userdetails);
            return "Data Saved Sucessfully";
        }
        catch (Exception e){
            return "Error";
        }

    }
}
