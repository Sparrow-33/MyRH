package com.example.myrh.api;

import com.example.myrh.config.JwtUtil;
import com.example.myrh.dto.AuthenticationRequest;
import com.example.myrh.exceptions.NoSuchUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authentication {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    @PostMapping("/recruteur")
    public ResponseEntity<String> RecruteurAuthentication(@RequestBody AuthenticationRequest auth) throws NoSuchUserException {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth.getEmail()+ "-RECRUITER", auth.getPassword())
        );
        final UserDetails user = userDetailsService.loadUserByUsername(auth.getEmail()+ "-RECRUITER");
        if(user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("error occurred");

    }
}
