package dev.project.raftbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;

import dev.project.raftbackend.model.TabMapping;


public class TabMappingService {
	
	private final dev.project.raftbackend.Repo.TabMappingRepo TabMappingRepo;
	
	@Autowired
	public TabMappingService(dev.project.raftbackend.Repo.TabMappingRepo TabMappingRepo) {
		this.TabMappingRepo = TabMappingRepo;
	}
	
	public TabMapping findUserByEmail(String emailid) {

	
		TabMapping usd = TabMappingRepo.findByEmailId(emailid);
		
		return usd;
	}
}
