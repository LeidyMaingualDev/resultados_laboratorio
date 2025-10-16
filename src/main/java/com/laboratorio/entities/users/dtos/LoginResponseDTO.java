package com.laboratorio.entities.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private String token;
    private String email;
    private String nombreCompleto;
    private String especialidad;
    private String role;
}
