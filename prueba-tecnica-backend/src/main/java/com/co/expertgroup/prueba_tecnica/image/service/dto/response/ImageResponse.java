package com.co.expertgroup.prueba_tecnica.image.service.dto.response;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import com.co.expertgroup.prueba_tecnica.cat.service.dto.response.CatResponse;
import lombok.Data;

import java.util.List;

@Data
public class ImageResponse {
    private List<CatResponse> breeds;
    private String id;
    private String url;
    private Integer width;
    private Integer height;

}
