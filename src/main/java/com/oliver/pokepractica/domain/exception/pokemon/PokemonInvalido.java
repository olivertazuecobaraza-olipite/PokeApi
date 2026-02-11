package com.oliver.pokepractica.domain.exception.pokemon;

public class PokemonInvalido extends RuntimeException{
    public PokemonInvalido(String message){
        super(message);
    }
}
