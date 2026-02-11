package com.oliver.pokepractica.infraestructure.controller.pokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.pokepractica.Application.dto.pokemon.PokemonDto;
import com.oliver.pokepractica.Application.mapper.pokemon.MapperPokemon;
import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.infraestructure.service.pokemon.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    
    // Dependencias
    @Autowired(required=true)
    PokemonService pokemonService;

    // CRUD
    // crear un pokemon
    @PostMapping("/post")
    public PokemonDto CrearPokemon(@RequestBody PokemonDto pokemon) {
        return MapperPokemon.toDto(pokemonService.save(MapperPokemon.toEnty(pokemon)));
    }

    // Update
    @PutMapping("/put/{id}")
    public PokemonDto updatePokemon(@PathVariable Long id, @RequestBody PokemonDto pokemon) {
        return MapperPokemon.toDto(pokemonService.update(MapperPokemon.toEnty(pokemon), id)) ;
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deleteById(id);
    }

    // GET 
    @GetMapping("/get/{id}")
    public PokemonDto getPokemonById(@PathVariable Long id) {
        return MapperPokemon.toDto(pokemonService.findById(id));
    }
    @GetMapping("/get/all")
    public List<PokemonDto> getAllPokemon() {
        return pokemonService.findAll().stream().map(MapperPokemon::toDto).toList();
    }
    
// ENDPOINTS ESPECIALES
// POST
    

    // capturar
    @PostMapping("/post/{idTr}/captura/{idPo}")
    public Pokemon CapturarPokemon(@PathVariable Long idTr, @PathVariable Long idPo) {
        return null;
    }

// PATCH
    @PatchMapping("/patch/{idPo}/levelUp")
    public Pokemon LevelUp (@PathVariable Long idPo){
        return null;
    }

    @PatchMapping("/patch/{idPo}/evole")
    public Pokemon Evolucionar (@PathVariable Long idPo){
        return null;
    }

// GET
    @GetMapping("/get/pokemon")
    public List<Pokemon> getPokemon(@RequestParam String type, @RequestParam boolean legendary) {
        return null;
    }
    

    
}
