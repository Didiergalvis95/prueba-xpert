package com.co.expertgroup.prueba_tecnica.cat.service;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import com.co.expertgroup.prueba_tecnica.util.Constants;
import com.co.expertgroup.prueba_tecnica.util.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CatServiceImpl implements ICatService {

    private static final String ENDPOINT = "breeds";

    private WebClient webClient;

    @Override
    public Mono<List<CatDto>> getAllBreeds() {
        String url = String.format("%s/%s",
                Constants.URL_API, ENDPOINT);
        return Utilities.getList(url, CatDto.class);
    }

    @Override
    public Mono<CatDto> getBreedById(String breedId) {
        String url = String.format("%s/%s/%s",
                Constants.URL_API, ENDPOINT, breedId);
        return Utilities.getItem(url, CatDto.class);
    }

    @Override
    public Mono<List<CatDto>> getBreedsBySearch(String search) {
        String url = String.format("%s/%s/%s",
                Constants.URL_API, ENDPOINT, search);
        return Utilities.getList(url, CatDto.class);
    }
}
