package com.co.expertgroup.prueba_tecnica.image.service.dto;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import lombok.Data;

import java.util.List;

@Data
public class ImageDto {
    private List<CatDto> breeds;
    private String id;
    private String url;
    private Integer width;
    private Integer height;
}
