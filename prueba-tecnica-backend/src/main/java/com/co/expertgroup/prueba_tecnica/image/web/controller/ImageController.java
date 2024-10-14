package com.co.expertgroup.prueba_tecnica.image.web.controller;

import com.co.expertgroup.prueba_tecnica.image.service.IImageService;
import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseDto;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseListDto;
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

import java.util.List;

@Tag(name = "Imágenes", description = "Controlador para la gestión de imágenes por ID de raza")
@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Log4j2
public class ImageController {

    private final IImageService imageService;
    @ApiOperation(value = "Obtener imágenes por ID de raza", notes = "Este endpoint obtiene una lista de imágenes basadas en el ID de una raza específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa. Retorna la lista de imágenes.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(type = "array", implementation = ImageDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado"),
            @ApiResponse(responseCode = "400", description = "Error en la consulta.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("/{breed_id}")
    @ResponseBody
    public ResponseEntity<?> getImagesByBreedId(
            @Parameter(required = true, description = "")
            @PathVariable("breed_id") String breedId){
        try {
            List<ImageDto> listDto = imageService.getImagesByBreedId(breedId).block();
            return ResponseEntity.status(HttpStatus.OK).body(ResponseListDto.<ImageDto>builder()
                    .data(listDto)
                    .count(listDto.size())
                    .build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.ERROR);
        }
    }
}
