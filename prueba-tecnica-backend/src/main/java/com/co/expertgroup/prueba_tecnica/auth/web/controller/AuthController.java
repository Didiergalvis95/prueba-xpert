package com.co.expertgroup.prueba_tecnica.auth.web.controller;

import com.co.expertgroup.prueba_tecnica.auth.service.UserDetailServiceImpl;
import com.co.expertgroup.prueba_tecnica.auth.service.dto.AuthLoginRequestDto;
import com.co.expertgroup.prueba_tecnica.auth.service.dto.AuthRegisterRequestDto;
import com.co.expertgroup.prueba_tecnica.auth.service.dto.AuthResponseDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseDto;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseItemDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "Controlador para la autenticación de usuarios.")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {

    private final UserDetailServiceImpl userDetailService;

    @ApiOperation(value = "Iniciar sesión", notes = "Permite a un usuario iniciar sesión con sus credenciales.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthLoginRequestDto.class))),
            @ApiResponse(responseCode = "404", description = "Error en las credenciales proporcionadas.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponseDto.class)))
    })
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(
            @Parameter(description = "Credenciales del usuario para el inicio de sesión.")
            @RequestBody AuthLoginRequestDto requestDto){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(
                    ResponseItemDto.<AuthResponseDto>builder()
                            .data(userDetailService.login(requestDto))
                            .build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(Constants.ERROR));
        }
    }

    @ApiOperation(value = "Registrar usuario", notes = "Permite registrar un nuevo usuario en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro exitoso.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthRegisterRequestDto.class))),
            @ApiResponse(responseCode = "404", description = "Error al registrar el usuario.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseDto.class)))
    })
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(
            @Parameter(description = "Información del nuevo usuario para el registro.")
            @RequestBody AuthRegisterRequestDto requestDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(userDetailService.createUser(requestDto)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(Constants.ERROR));
        }
    }
}