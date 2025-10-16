package com.laboratorio.entities.users.dtos;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String email;
    private String password;
}
