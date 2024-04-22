package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.raftbackend.Repo.RiverslistRepo;
import dev.project.raftbackend.model.Riverslist;

@Service
public class RiverListService {
	

	private final RiverslistRepo riverRepository ;
	
	@Autowired
	public RiverListService(RiverslistRepo riverRepository) {
		this.riverRepository = riverRepository;
	}
	
	public List<Riverslist> getAllEntities() {
        return riverRepository.findAll();
    }
	
	@SuppressWarnings("deprecation")
	public Riverslist getRiverList(Long river_id) {
		return riverRepository.getById(river_id);
	}

	public Boolean getMaxRiverId (long riverid) {
		return riverRepository.existsById(riverid);
	}

}
