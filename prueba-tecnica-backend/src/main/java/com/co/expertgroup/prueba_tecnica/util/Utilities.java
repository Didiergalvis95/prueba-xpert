package com.co.expertgroup.prueba_tecnica.util;

import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class Utilities {
    private static final WebClient webClient = WebClient.builder().build();
    public static <T> Mono<T> getItem(String url, Class<T> response) {
        return webClient.get()
                .uri(url)
                .headers(header -> {
                    header.set(HttpHeaders.CONTENT_TYPE, Constants.HEADER_CONTENT_VALUE);
                    header.set(Constants.HEADER_KEY, Constants.HEADER_KEY_VALUE);
                })
                .retrieve()
                .bodyToMono(response);
    }

    public static <T> Mono<List<T>> getList(String url, Class<T> response) {
        return webClient.get()
                .uri(url)
                .headers(header -> {
                    header.set(HttpHeaders.CONTENT_TYPE, Constants.HEADER_CONTENT_VALUE);
                    header.set(Constants.HEADER_KEY, Constants.HEADER_KEY_VALUE);
                })
                .retrieve()
                .bodyToFlux(response)
                .collectList();
    }

    public static <T> Mono<List<T>> getListByParam(String protocol, String url, String endpoint, String paramName, String paramValue, Class<T> response) {
        return webClient.get()
                .uri(uriBuilder ->  uriBuilder
                        .scheme(protocol)
                        .host(url)
                        .path(endpoint)
                        .queryParam(paramName, paramValue)
                        .build())
                .headers(header -> {
                    header.set(HttpHeaders.CONTENT_TYPE, Constants.HEADER_CONTENT_VALUE);
                    header.set(Constants.HEADER_KEY, Constants.HEADER_KEY_VALUE);
                })
                .retrieve()
                .bodyToFlux(response)
                .collectList();
    }
}
