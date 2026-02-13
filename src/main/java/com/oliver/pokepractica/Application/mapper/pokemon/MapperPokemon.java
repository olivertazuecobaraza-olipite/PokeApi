package com.oliver.pokepractica.application.mapper.pokemon;

import com.oliver.pokepractica.application.dto.pokemon.PokemonDto;
import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;

public class MapperPokemon {
    
    // TO DTO
    public static PokemonDto toDto(Pokemon enty){
        PokemonDto dto = new PokemonDto();
        
        dto.setNickname(enty.getNickName());
        dto.setSpecies(enty.getSpecies());
        dto.setPokedexNumber(enty.getPokedexNumber());
        dto.setLv(enty.getLv());
        dto.setHp(enty.getHp());
        dto.setAttack(enty.getAttack());
        dto.setDefense(enty.getDefense());
        dto.setShiny(enty.getIsShiny());
        dto.setLegendary(enty.getIsLegendary());

        return dto;
    }
    // TO ENTY
    public static Pokemon toEnty(PokemonDto dto){
        Pokemon enty = new Pokemon();
        
        enty.setNickName(dto.getNickname());
        enty.setSpecies(dto.getSpecies());
        enty.setPokedexNumber(dto.getPokedexNumber());
        enty.setLv(dto.getLv());
        enty.setHp(dto.getHp());
        enty.setAttack(dto.getAttack());
        enty.setDefense(dto.getDefense());
        enty.setIsShiny(dto.isShiny());
        enty.setIsLegendary(dto.isLegendary());

        return enty;
    }
}
