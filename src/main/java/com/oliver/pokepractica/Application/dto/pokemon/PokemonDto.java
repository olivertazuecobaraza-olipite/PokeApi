package com.oliver.pokepractica.Application.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PokemonDto {
    String nickname;
    String species;
    int pokedexNumber;
    int lv;
    int hp,attack,defense;
    boolean isShiny;
    boolean isLegendary;
}
