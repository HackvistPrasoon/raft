package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.raftbackend.Repo.AgeRepo;
import dev.project.raftbackend.Repo.RiverslistRepo;
import dev.project.raftbackend.model.Age;
import dev.project.raftbackend.model.Riverslist;

@Service
public class AgeService {
	
private final AgeRepo ageRepository ;
	
	@Autowired
	public AgeService(AgeRepo ageRepository) {
		this.ageRepository = ageRepository;
	}
	
	public List<Age> getAllEntities() {
        return ageRepository.findAll();
    }
	
	public Age getAge(Long id) {
		return ageRepository.getById(id);
	}

	public Boolean ifExist(Long id) {
		return ageRepository.existsById(id);
	}

}
