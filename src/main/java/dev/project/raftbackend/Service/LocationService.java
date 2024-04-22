package dev.project.raftbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.raftbackend.Repo.LocationRepo;
import dev.project.raftbackend.model.Location;

@Service
public class LocationService {
	
private final LocationRepo locationRepository ;
	
	@Autowired
	public LocationService(LocationRepo locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getAllEntities() {
        return locationRepository.findAll();
    }
	
	public Location getLocation(Long id) {
		return locationRepository.getById(id);
	}

		public Boolean ifExist(Long id) {
		return locationRepository.existsById(id);
	}

}
