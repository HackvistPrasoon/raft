package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dev.project.raftbackend.Repo.GenderRepo;
import dev.project.raftbackend.model.Gender;

@Service
public class GenderService {
	
private final GenderRepo genderRepository ;
	
	@Autowired
	public GenderService(GenderRepo genderRepository) {
		this.genderRepository = genderRepository;
	}
	
	public List<Gender> getAllEntities() {
        return genderRepository.findAll();
    }
	
	public Gender getGender(Long id) {
		return genderRepository.getById(id);
	}

}
