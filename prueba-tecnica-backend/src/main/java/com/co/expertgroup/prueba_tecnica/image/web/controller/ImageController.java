package com.co.expertgroup.prueba_tecnica.image.web.controller;

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
@RequestMapping("/image")
@Log4j2
public class ImageController {
    @ApiOperation(value = "", notes = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "401", description = ""),
            @ApiResponse(responseCode = "404", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Object.class)))
    })
    @GetMapping("/{breed_id}")
    @ResponseBody
    public ResponseEntity<?> getImagesByBreedId(
            @Parameter(required = true, description = "")
            @PathVariable("breed_id") String breedId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }
}
