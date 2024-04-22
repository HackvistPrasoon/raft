package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.raftbackend.Repo.EducationRepo;
import dev.project.raftbackend.model.Education;

@Service
public class EducationService {
	
private final EducationRepo educationRepository ;
	
	@Autowired
	public EducationService(EducationRepo educationRepository) {
		this.educationRepository = educationRepository;
	}
	
	public List<Education> getAllEntities() {
        return educationRepository.findAll();
    }
	
	public Education getEducation(long id) {
		return educationRepository.getById(id);
	}

	public Boolean ifExist(Long id) {
		return educationRepository.existsById(id);
	}

}
