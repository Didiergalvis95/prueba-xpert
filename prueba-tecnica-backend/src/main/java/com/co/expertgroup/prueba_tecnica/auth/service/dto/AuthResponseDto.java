package com.co.expertgroup.prueba_tecnica.auth.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthResponseDto {
    private String username;
    private String message;
    private String jwt;
}
