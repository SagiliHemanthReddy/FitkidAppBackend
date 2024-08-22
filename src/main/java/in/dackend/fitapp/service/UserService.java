package in.dackend.fitapp.service;

import in.dackend.fitapp.dto.User;
import in.dackend.fitapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long usr_id) {
        return userRepository.findById(usr_id).orElse(null);
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(user.getUsrPassword());
        
        System.out.println("print "+encryptedPassword);
        
        user.setUsrPassword(encryptedPassword);
        
        // Save the user with the encrypted password
        return userRepository.save(user);
    }

}
