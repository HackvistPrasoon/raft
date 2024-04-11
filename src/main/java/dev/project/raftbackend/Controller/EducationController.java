
package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.EducationRepo;
import dev.project.raftbackend.model.Education;

@RestController
public class EducationController {

    @Autowired
    EducationRepo repo;

    @PostMapping("/selecteducation")
    public void selectEducation(@RequestBody Education education) {
        repo.save(education);
    }
}
