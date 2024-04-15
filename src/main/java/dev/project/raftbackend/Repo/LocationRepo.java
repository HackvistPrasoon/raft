package dev.project.raftbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import dev.project.raftbackend.model.Location;

@RestResource
public interface LocationRepo extends JpaRepository<Location, Long> {

}
