package com.oliver.pokepractica.infraestructure.service.pokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.domain.exception.ValoresNoValidos;
import com.oliver.pokepractica.domain.exception.pokemon.PokemonInvalido;
import com.oliver.pokepractica.domain.exception.pokemon.PokemonNoEncontrado;
import com.oliver.pokepractica.domain.interfaces.service.pokemon.IPokemonService;
import com.oliver.pokepractica.infraestructure.repository.pokemon.PokemonSpringRepository;

import jakarta.transaction.Transactional;

@Service
public class PokemonService implements IPokemonService {


    @Autowired
    PokemonSpringRepository repository;

    @Transactional
    @Override
    public Pokemon save(Pokemon pokemon) {
        if (pokemon == null){
            throw new PokemonInvalido("Error: Pokemon es null");
        }
        return repository.save(pokemon);
    }

    @Transactional
    @Override
    public Pokemon update(Pokemon pokemon, Long id) {
        if (pokemon == null){
            throw new PokemonInvalido("Error: Pokemon es null");
        }
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }

        Pokemon p = findById(id);
        pokemon.setId(p.getId());
        return repository.save(pokemon);
    }

    @Transactional
    @Override
    public Pokemon update(Pokemon pokemon) {
        if (pokemon == null){
            throw new PokemonInvalido("Error: Pokemon es null");
        }
        return repository.save(pokemon);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }
        
        repository.deleteById(id);
        
    }

    @Transactional
    @Override
    public List<Pokemon> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Pokemon findById(Long id) {
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }
        return repository.findById(id).orElseThrow(
            () -> new PokemonNoEncontrado("Error: Pokemon no encontrado"));
    }

    @Transactional
    @Override
    public Pokemon findByPokedexNumber(int pokedexNumber) {
        if (pokedexNumber < 0){
            throw new ValoresNoValidos("Error: Numero de pokedex no valido");
        }

        return repository.findByPokedexNumber(pokedexNumber)
            .orElseThrow(() -> new PokemonNoEncontrado("Error: Pokemon no encontrado"));

    }
    
}
