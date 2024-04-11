
package dev.project.raftbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.raftbackend.Repo.RiverslistRepo;
import dev.project.raftbackend.model.Riverslist;

@RestController
public class RiverslistController {

    @Autowired
    RiverslistRepo repo;

    @PostMapping("/selectriver")
    public void selectRiver(@RequestBody Riverslist riverslist) {
        repo.save(riverslist);
    }
}