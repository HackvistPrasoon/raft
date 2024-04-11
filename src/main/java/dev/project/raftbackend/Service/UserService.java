package dev.project.raftbackend.Service;

import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserdetailsRepo userRepository; // Assuming you have a UserRepository
    @Autowired
    public UserService(UserdetailsRepo userRepository) {
        this.userRepository = userRepository;
    }


    public Userdetails findUserByEmail(String emailid) {


        return userRepository.findByEmailid(emailid);
    }
}

