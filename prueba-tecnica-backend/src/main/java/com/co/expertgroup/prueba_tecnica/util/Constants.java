package com.co.expertgroup.prueba_tecnica.util;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Constants {
    public static final String URL_API = "https://api.thecatapi.com/v1";
    public static final String HEADER_KEY = "x-api-key";
    public static final String HEADER_KEY_VALUE = "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP";
    public static final String HEADER_CONTENT_VALUE = "application/json";
    public static final String  ERROR = "Error al obtener la información";
}
