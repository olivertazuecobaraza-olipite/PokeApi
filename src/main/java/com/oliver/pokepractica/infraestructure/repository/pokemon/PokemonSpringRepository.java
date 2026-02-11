package com.oliver.pokepractica.infraestructure.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;

@Repository
public interface PokemonSpringRepository extends JpaRepository<Pokemon, Long> {
    
    // buscar por numero de pokdex
    public Optional<Pokemon> findByPokedexNumber(int pokedexNumber);
}
