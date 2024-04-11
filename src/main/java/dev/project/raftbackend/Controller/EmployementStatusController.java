
package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.EmployementStatusRepo;
import dev.project.raftbackend.model.EmployementStatus;

@RestController
public class EmployementStatusController {

    @Autowired
    EmployementStatusRepo repo;

    @PostMapping("/selectemployementstatus")
    public void selectEmployementstatus(@RequestBody EmployementStatus employementstatus) {
        repo.save(employementstatus);
    }
}