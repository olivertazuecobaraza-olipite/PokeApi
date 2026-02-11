package com.oliver.pokepractica.Application.dto.trainer;

import com.oliver.pokepractica.domain.enums.Region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {
    String name;
    Region region;
    int bdgeCount;
}
