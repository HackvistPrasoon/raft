package dev.project.raftbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import dev.project.raftbackend.model.Ethnic;

@RestResource
public interface EthnicRepo extends JpaRepository<Ethnic, Long> {

}
