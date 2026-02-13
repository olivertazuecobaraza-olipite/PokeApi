package com.oliver.pokepractica.infraestructure.controller.type;

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

import com.oliver.pokepractica.Application.dto.type.TypeDto;
import com.oliver.pokepractica.Application.mapper.type.MapperType;
import com.oliver.pokepractica.infraestructure.service.type.TypeService;



@RestController
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    // CRUD
// POST
    @PostMapping("/")
    public TypeDto postType(@RequestBody TypeDto dto) {
        return MapperType.toDto(typeService.save(MapperType.toEntity(dto)));
    }
// PUT
    @PutMapping("/{id}")
    public TypeDto putMethodName(@PathVariable Long id, @RequestBody TypeDto dto) {
        return MapperType.toDto(typeService.update(MapperType.toEntity(dto), id));
    }
// DELETE
    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeService.deleteById(id);
    }
// GET
    @GetMapping("/{id}")
    public TypeDto getMethodName(@PathVariable Long id) {
        return MapperType.toDto(typeService.findById(id));
    }
    @GetMapping("/")
    public List<TypeDto> getAllType() {
        return typeService.findAll().stream().map(MapperType::toDto).toList();
    } 
    
}
