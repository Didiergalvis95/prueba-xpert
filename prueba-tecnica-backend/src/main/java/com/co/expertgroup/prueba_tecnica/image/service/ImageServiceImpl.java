package com.co.expertgroup.prueba_tecnica.image.service;

import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ImageServiceImpl implements IImageService{
    private static final String ENDPOINT = "images";
    private final WebClient webClient;

    @Override
    public Mono<List<ImageDto>> getImagesByBreedId(String breedId) {
        String url = String.format("%s/%s/%s",
                Constants.URL_API, ENDPOINT, "search");
        return webClient.get()
                .uri(uriBuilder ->  uriBuilder
                        .path(url)
                        .queryParam("breed_id", breedId)
                        .build())
                .headers(header -> {
                    header.set(HttpHeaders.CONTENT_TYPE, Constants.HEADER_CONTENT_VALUE);
                    header.set(Constants.HEADER_KEY, Constants.HEADER_KEY_VALUE);
                })
                .retrieve()
                .bodyToFlux(ImageDto.class)
                .collectList();
    }
}
