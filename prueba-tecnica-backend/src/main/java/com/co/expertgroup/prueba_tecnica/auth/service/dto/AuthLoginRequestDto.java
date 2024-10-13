package com.co.expertgroup.prueba_tecnica.auth.service.dto;

import lombok.Data;

@Data
public class AuthLoginRequestDto {
    private String username;
    private String password;
}
