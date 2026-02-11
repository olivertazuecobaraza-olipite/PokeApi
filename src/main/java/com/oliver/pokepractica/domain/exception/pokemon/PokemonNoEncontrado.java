package com.oliver.pokepractica.domain.exception.pokemon;

public class PokemonNoEncontrado extends RuntimeException{
    public PokemonNoEncontrado(String message){
        super(message);
    }
}
