package com.oliver.pokepractica.infraestructure.controller.trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.pokepractica.application.dto.trainer.TrainerDto;
import com.oliver.pokepractica.application.mapper.trainer.MapperTrainer;
import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.infraestructure.service.trainer.TrainerService;






@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
    
    @Autowired
    TrainerService trainerService;


// CRUD
    // POST
    @PostMapping("/")
    public TrainerDto postMethodName(@RequestBody TrainerDto trainerDto) {
        return MapperTrainer.toDto(trainerService.save(MapperTrainer.toEntity(trainerDto)));
    }
    // PUT
    @PutMapping("/{id}")
    public TrainerDto putMethodName(@PathVariable Long id, @RequestBody TrainerDto dto) {
        return MapperTrainer.toDto(trainerService.update(MapperTrainer.toEntity(dto),id));
    }
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteMethodName(@PathVariable Long id) {
        trainerService.deleteById(id);
    }
    // GET
    @GetMapping("/{id}")
    public TrainerDto getById(@PathVariable Long id) {
        return MapperTrainer.toDto(trainerService.findById(id));
    }
    @GetMapping("/")
    public List<TrainerDto> getAll() {
        return trainerService.findAll().stream().map(MapperTrainer::toDto).toList();    
    }
    
    


// GET
    // Obtener el equipo del entrenador
    @GetMapping("/team/{idTr}")
    public Pokemon[] getTeam(@PathVariable Long idTr) {
        return null;
    }
    
    @GetMapping("/strongest/{idTr}")
    public Pokemon getStrongest(@PathVariable Long idTr) {
        return null;
    }
    
    
}
