package in.dackend.fitapp.controller;

import in.dackend.fitapp.dto.User;
import in.dackend.fitapp.dto.UserLogin;
import in.dackend.fitapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fitapp")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/Hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Welcome");
    }

    
    @PostMapping("/signUp")
    public  ResponseEntity<User> createUser(@RequestBody User user) {
    	User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @PostMapping("/getUser")
    public ResponseEntity<User> getUserById(@RequestBody Map<String, Long> request) {
        Long usrId = request.get("usrId");
        User getUser = userService.getUserById(usrId);
        return ResponseEntity.ok(getUser);
    }

//    @PostMapping("/loginUser")
//    public ResponseEntity<String> loginUser(@RequestBody UserLogin userLogin) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userLogin.getUsername());
//
//            return ResponseEntity.ok("Login successful for user: " + userDetails.getUsername());
//        } catch (Exception e) {
//            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
//        }
//        
//    }
     
}
