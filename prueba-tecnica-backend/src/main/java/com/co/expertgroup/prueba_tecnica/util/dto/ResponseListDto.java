package com.co.expertgroup.prueba_tecnica.util.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ResponseListDto<T> {
    private List<T> data;
    private Integer count;
}
