package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.raftbackend.Repo.EthnicRepo;
import dev.project.raftbackend.model.Ethnic;

@Service
public class EthnicService {

private final EthnicRepo ethnicRepository ;
	
	@Autowired
	public EthnicService(EthnicRepo ethnicRepository) {
		this.ethnicRepository = ethnicRepository;
	}
	
	public List<Ethnic> getAllEntities() {
        return ethnicRepository.findAll();
    }
	
	public Ethnic getEthnic(Long id) {
		return ethnicRepository.getById(id);
	}

	public Boolean ifExist(Long id) {
		return ethnicRepository.existsById(id);
	}
	
}
