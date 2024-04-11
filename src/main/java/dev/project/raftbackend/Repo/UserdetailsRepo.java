package dev.project.raftbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import dev.project.raftbackend.model.Userdetails;
import org.springframework.stereotype.Service;

@Service
@RestResource
public interface UserdetailsRepo extends JpaRepository<Userdetails, String> {
    Userdetails findByEmailid(String emailid);

}
