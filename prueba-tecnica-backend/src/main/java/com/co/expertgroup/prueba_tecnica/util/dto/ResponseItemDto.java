package com.co.expertgroup.prueba_tecnica.util.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseItemDto<T> {
    private T data;
}
