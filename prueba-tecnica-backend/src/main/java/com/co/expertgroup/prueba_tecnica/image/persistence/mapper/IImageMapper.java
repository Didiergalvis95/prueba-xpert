package com.co.expertgroup.prueba_tecnica.image.persistence.mapper;

import com.co.expertgroup.prueba_tecnica.image.service.dto.ImageDto;
import com.co.expertgroup.prueba_tecnica.image.service.dto.response.ImageResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IImageMapper {
    ImageResponse toImageResponse(ImageDto dto);
    List<ImageResponse> toImageResponseList(List<ImageDto> listDto);
    ImageDto toImageDto(ImageResponse response);
    List<ImageDto> toImageListDto(List<ImageResponse> listResponse);


}
