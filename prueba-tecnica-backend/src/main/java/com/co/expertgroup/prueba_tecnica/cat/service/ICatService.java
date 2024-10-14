package com.co.expertgroup.prueba_tecnica.cat.service;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICatService {
    Mono<List<CatDto>> getAllBreeds();
    Mono<CatDto> getBreedById(String breedId);
    Mono<List<CatDto>> getBreedsBySearch(String search);
}
