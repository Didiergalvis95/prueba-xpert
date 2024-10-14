package com.co.expertgroup.prueba_tecnica.image.service;

import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IImageService {
    Mono<List<ImageDto>> getImagesByBreedId(String breedId);
}
