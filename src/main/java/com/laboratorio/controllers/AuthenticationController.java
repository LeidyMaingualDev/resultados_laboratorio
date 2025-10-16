package com.laboratorio.controllers;


import com.laboratorio.entities.users.User;
import com.laboratorio.entities.users.dtos.AuthenticationDTO;
import com.laboratorio.entities.users.dtos.LoginResponseDTO;
import com.laboratorio.entities.users.dtos.RegisterDTO;
import com.laboratorio.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO dto) {
        User user = authenticationService.register(dto);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO dto) {
        LoginResponseDTO response = authenticationService.login(dto);
        return ResponseEntity.ok(response);
    }
}
