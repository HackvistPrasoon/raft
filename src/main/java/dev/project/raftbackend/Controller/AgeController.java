
package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.AgeRepo;
import dev.project.raftbackend.model.Age;

@RestController
public class AgeController {

    @Autowired
    AgeRepo repo;

    @PostMapping("/selectage")
    public void selectAge(@RequestBody Age age) {
        repo.save(age);
    }
}