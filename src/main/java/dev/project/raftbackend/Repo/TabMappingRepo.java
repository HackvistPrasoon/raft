package dev.project.raftbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.project.raftbackend.model.TabMapping;

@Repository
public interface TabMappingRepo extends JpaRepository<TabMapping, String>{

	TabMapping findByEmailId (String emailid);
}
