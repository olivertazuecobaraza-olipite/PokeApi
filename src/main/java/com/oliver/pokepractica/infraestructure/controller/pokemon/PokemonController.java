package com.oliver.pokepractica.infraestructure.controller.pokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.oliver.pokepractica.application.dto.pokemon.PokemonDto;
import com.oliver.pokepractica.application.mapper.pokemon.MapperPokemon;
import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.infraestructure.service.pokemon.PokemonService;

@RestController("PokemonController")
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class PokemonController {
    
    // Dependencias
    @Autowired(required=true)
    PokemonService pokemonService;

    // CRUD
    // crear un pokemon
    @PostMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public PokemonDto CrearPokemon(@RequestBody PokemonDto pokemon) {
        return MapperPokemon.toDto(pokemonService.save(MapperPokemon.toEnty(pokemon)));
    }

    // Update
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public PokemonDto updatePokemon(@PathVariable Long id, @RequestBody PokemonDto pokemon) {
        return MapperPokemon.toDto(pokemonService.update(MapperPokemon.toEnty(pokemon), id)) ;
    }

    // Delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deleteById(id);
    }

    // GET 
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_TRAINER')")
    public PokemonDto getPokemonById(@PathVariable Long id) {
        return MapperPokemon.toDto(pokemonService.findById(id));
    }
    
    @GetMapping("/")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public List<PokemonDto> getAllPokemon() {
        return pokemonService.findAll().stream().map(MapperPokemon::toDto).toList();
    }
    
// ENDPOINTS ESPECIALES
// POST
    
    // capturar
    @PostMapping("/capturar/{idTr}/{idPo}")
    @PreAuthorize("hasAuthority('ROLE_TRAINER')")
    public Pokemon CapturarPokemon(@PathVariable Long idTr, @PathVariable Long idPo) {
        return null;
    }

// PATCH
    @PatchMapping("/levelUp/{idPo}")
    @PreAuthorize("hasAuthority('ROLE_TRAINER')")
    public Pokemon LevelUp (@PathVariable Long idPo){
        return null;
    }

    @PatchMapping("/evole/{idPo}")
    @PreAuthorize("hasAuthority('ROLE_TRAINER')")
    public Pokemon Evolucionar (@PathVariable Long idPo){
        System.out.println("No se puede evolucionar: " + idPo);
        return null;
    }

// GET
    @GetMapping("/get/pokemon")
    @PreAuthorize("hasAuthority('ROLE_TRAINER')")
    public List<Pokemon> getPokemon(@RequestParam String type, @RequestParam boolean legendary) {
        return null;
    }
}
