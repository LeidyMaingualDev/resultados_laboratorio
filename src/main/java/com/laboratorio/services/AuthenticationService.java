package com.laboratorio.services;

import com.laboratorio.entities.users.User;
import com.laboratorio.entities.users.UserRole;
import com.laboratorio.entities.users.UserEspecialidad;
import com.laboratorio.entities.users.dtos.AuthenticationDTO;
import com.laboratorio.entities.users.dtos.LoginResponseDTO;
import com.laboratorio.entities.users.dtos.RegisterDTO;
import com.laboratorio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public User register(RegisterDTO dto) {
        UserRole role = UserRole.valueOf(dto.role().toUpperCase());
        UserEspecialidad especialidad = UserEspecialidad.valueOf(dto.especialidad().toUpperCase());

        User user = User.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .tipoDocumento(dto.tipoDocumento())
                .documento(dto.documento())
                .nombreCompleto(dto.nombreCompleto())
                .telefono(dto.telefono())
                .especialidad(especialidad)
                .role(role)
                .build();

        return userRepository.save(user);
    }

    public LoginResponseDTO login(AuthenticationDTO dto) {
        // Buscar usuario en la base de datos
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validar la contraseña
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Generar JWT
        String token = tokenService.generateToken(user);

        // Retornar la respuesta con token + datos del usuario
        return new LoginResponseDTO(
                token,
                user.getEmail(),
                user.getNombreCompleto(),
                user.getEspecialidad().name(),
                user.getRole().name()
        );
    }
}
