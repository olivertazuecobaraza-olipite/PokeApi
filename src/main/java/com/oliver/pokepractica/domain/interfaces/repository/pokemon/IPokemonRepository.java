package com.oliver.pokepractica.domain.interfaces.repository.pokemon;

import java.util.List;

import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;

public interface IPokemonRepository {

    // CRUD
// POST
    public Pokemon save(Pokemon pokemon); 
// PUT
    public Pokemon update(Pokemon pokemon, Long id);
    public Pokemon update(Pokemon pokemon);
// DELETE
    public void deleteById(Long id);
// GET
    public List<Pokemon> findAll();
    public Pokemon findById(Long id);
    public Pokemon findByPokedexNumber();
    // EXTRA


} 
