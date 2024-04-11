
package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.EthnicRepo;
import dev.project.raftbackend.model.Ethnic;

@RestController
public class EthnicController {

    @Autowired
    EthnicRepo repo;

    @PostMapping("/selectethnic")
    public void selectEthnic(@RequestBody Ethnic ethnic) {
        repo.save(ethnic);
    }
}