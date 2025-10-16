package com.laboratorio.entities.users.dtos;

public record RegisterDTO(
        String email,
        String password,
        String tipoDocumento,
        String documento,
        String nombreCompleto,
        String telefono,
        String especialidad,
        String role
) {
}
