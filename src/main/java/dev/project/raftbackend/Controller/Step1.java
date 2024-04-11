package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Step1 {
    @Autowired
    UserdetailsRepo repo;
    @PostMapping("/user/update")
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
