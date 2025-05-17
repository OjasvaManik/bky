package net.ojm.bky.controller;

import lombok.RequiredArgsConstructor;
import net.ojm.bky.entity.UserEntity;
import net.ojm.bky.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserEntity loginUser) {
        return userRepository.findByUsername(loginUser.getUsername())
                .filter(u -> u.getPassword().equals(loginUser.getPassword()))
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body("Invalid credentials."));
    }

}
