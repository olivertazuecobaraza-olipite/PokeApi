package com.oliver.pokepractica.Application.dto.type;

import com.oliver.pokepractica.domain.enums.NameType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    NameType name;
}
