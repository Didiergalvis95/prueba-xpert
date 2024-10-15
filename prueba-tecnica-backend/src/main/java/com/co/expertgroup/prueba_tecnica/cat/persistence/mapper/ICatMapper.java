package com.co.expertgroup.prueba_tecnica.cat.persistence.mapper;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.CatDto;
import com.co.expertgroup.prueba_tecnica.cat.service.dto.response.CatResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICatMapper {
    CatResponse toCatResponse(CatDto dto);
    List<CatResponse> toCatResponseList(List<CatDto> ListDto);
    CatDto toCatDto(CatResponse response);
    List<CatDto> toCatListDto(List<CatResponse> responseList);
}
