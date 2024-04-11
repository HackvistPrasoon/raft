package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.GenderRepo;
import dev.project.raftbackend.model.Gender;

@RestController
public class GenderController {

    @Autowired
    GenderRepo repo;

    @PostMapping("/selectgender")
    public void selectGender(@RequestBody Gender gender) {
        repo.save(gender);
    }
}