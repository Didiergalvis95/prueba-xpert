package com.co.expertgroup.prueba_tecnica.auth.service.dto;

import lombok.Data;

@Data
public class AuthRegisterRequestDto {
    private String username;
    private String email;
    private String password;
}
