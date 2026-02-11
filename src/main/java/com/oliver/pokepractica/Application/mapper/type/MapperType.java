package com.oliver.pokepractica.Application.mapper.type;

import com.oliver.pokepractica.Application.dto.type.TypeDto;
import com.oliver.pokepractica.domain.enty.type.Type;

public class MapperType {
    

    // TO Dto
    public static TypeDto toDto(Type type) {
        if (type == null) {
            return null;
        }
        TypeDto typeDto = new TypeDto();
        typeDto.setName(type.getName());

        return typeDto;
    }

    // To Entity

    public static Type toEntity(TypeDto typeDto) {
        if (typeDto == null) {
            return null;
        }
        Type type = new Type();
        type.setName(typeDto.getName());
        
        return type;
    }
}
