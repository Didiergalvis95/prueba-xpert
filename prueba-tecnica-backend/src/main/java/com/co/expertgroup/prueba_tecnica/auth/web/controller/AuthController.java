package com.co.expertgroup.prueba_tecnica.auth.web.controller;

import com.co.expertgroup.prueba_tecnica.auth.service.dto.AuthLoginRequestDto;
import com.co.expertgroup.prueba_tecnica.auth.service.dto.AuthRegisterRequestDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "", description = "")
@RestController
@RequestMapping("/auth")
@Log4j2
public class AuthController {
    @ApiOperation(value = "", notes = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthLoginRequestDto.class))),
            @ApiResponse(responseCode = "404", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthLoginRequestDto.class)))
    })
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(
            @Parameter(description = "")
            @RequestBody AuthLoginRequestDto requestDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @ApiOperation(value = "", notes = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthRegisterRequestDto.class))),
            @ApiResponse(responseCode = "404", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthRegisterRequestDto.class)))
    })
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(
            @Parameter(description = "")
            @RequestBody AuthRegisterRequestDto requestDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }
}