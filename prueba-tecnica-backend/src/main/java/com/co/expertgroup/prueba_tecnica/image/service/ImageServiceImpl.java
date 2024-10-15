package com.co.expertgroup.prueba_tecnica.image.service;

import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import com.co.expertgroup.prueba_tecnica.util.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ImageServiceImpl implements IImageService{
    private static final String ENDPOINT = "/v1/images/search";
    @Override
    public Mono<List<ImageDto>> getImagesByBreedId(String breedId) {
        return Utilities.getListByParam(Constants.PROTOCOL, Constants.URL, ENDPOINT,
                "breed_id", breedId, ImageDto.class);
    }
}
