package com.co.expertgroup.prueba_tecnica.cat.util;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "cat", description = "")
@RestController
@RequestMapping("/cat/breeds")
public class Constants {

    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "401", description = ""),
            @ApiResponse(responseCode = "404", description = "")
    })
    @GetMapping
    public ResponseEntity<?> getAllBreed(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "401", description = ""),
            @ApiResponse(responseCode = "404", description = "")
    })
    @GetMapping("/{breed_id}")
    public ResponseEntity<?> getBreedById(
            @Parameter(required = true, description = "")
            @PathVariable("breed_id") String breedId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "401", description = ""),
            @ApiResponse(responseCode = "404", description = "")
    })
    @GetMapping
    public ResponseEntity<?> getBreedBySearch(
            @Parameter(required = true, description = "")
            @RequestParam String search){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
