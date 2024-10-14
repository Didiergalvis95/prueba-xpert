package com.co.expertgroup.prueba_tecnica.cat.web.controller;

import com.co.expertgroup.prueba_tecnica.cat.service.ICatService;
import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseDto;
import com.co.expertgroup.prueba_tecnica.util.dto.ResponseItemDto;
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

@Tag(name = "Razas de Gatos", description = "API para gestionar las razas de gatos, permitiendo obtener todas las razas, buscar por ID o realizar búsquedas por nombre.")
@RestController
@RequestMapping("/cat/breeds")
@RequiredArgsConstructor
@Log4j2
public class CatController {
    private final ICatService catService;

    @ApiOperation(value = "Obtener todas las razas", notes = "Este endpoint devuelve una lista de todas las razas de gatos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa. Retorna una lista de razas.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "array", implementation = CatDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado."),
            @ApiResponse(responseCode = "400", description = "Error en la consulta.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Object.class)))
    })
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllBreeds(){
        try {
            List<CatDto> listDto = this.catService.getAllBreeds().block();
            return ResponseEntity.status(HttpStatus.OK).body(ResponseListDto.<CatDto>builder()
                    .data(listDto)
                    .count(listDto.size())
                    .build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(Constants.ERROR));
        }
    }

    @ApiOperation(value = "Obtener raza por ID", notes = "Este endpoint devuelve los detalles de una raza específica basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa. Retorna los detalles de la raza.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CatDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado."),
            @ApiResponse(responseCode = "400", description = "Error en la consulta.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("/{breed_id}")
    @ResponseBody
    public ResponseEntity<?> getBreedById(
            @Parameter(required = true, description = "")
            @PathVariable("breed_id") String breedId){
        try {
            CatDto dto = catService.getBreedById(breedId).block();
            return ResponseEntity.status(HttpStatus.OK).body(ResponseItemDto.<CatDto>builder()
                    .data(dto)
                    .build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(Constants.ERROR));
        }
    }

    @ApiOperation(value = "Buscar razas por nombre", notes = "Este endpoint permite buscar razas de gatos utilizando un término de búsqueda.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa. Retorna una lista de razas que coinciden con el término de búsqueda.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "array", implementation = CatDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado."),
            @ApiResponse(responseCode = "400", description = "Error en la consulta.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<?> getBreedsBySearch(
            @Parameter(required = true, description = "")
            @RequestParam String search){
        try {
            List<CatDto> listDto = catService.getBreedsBySearch(search).block();
            return ResponseEntity.status(HttpStatus.OK).body(ResponseListDto.<CatDto>builder()
                    .data(listDto)
                    .count(listDto.size())
                    .build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(Constants.ERROR));
        }
    }
}