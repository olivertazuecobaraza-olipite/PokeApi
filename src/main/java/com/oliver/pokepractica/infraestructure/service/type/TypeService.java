package com.oliver.pokepractica.infraestructure.service.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliver.pokepractica.domain.enty.type.Type;
import com.oliver.pokepractica.domain.exception.ValoresNoValidos;
import com.oliver.pokepractica.domain.exception.type.TypeNoEncontrado;
import com.oliver.pokepractica.domain.exception.type.TypeNoValido;
import com.oliver.pokepractica.domain.interfaces.service.type.ITypeService;
import com.oliver.pokepractica.infraestructure.repository.type.TypeSpringRepository;

import jakarta.transaction.Transactional;

@Service
public class TypeService implements ITypeService{

    @Autowired
    TypeSpringRepository repository;

    @Transactional
    @Override
    public Type save(Type type) {
        if(type == null){
            throw new TypeNoValido("Error: Type es null");
        }
        return repository.save(type);
    }

    @Transactional
    @Override
    public Type update(Type type, Long id) {
        if(type == null){
            throw new TypeNoValido("Error: Type es null");
        }
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }

        type.setId(type.getId());
        return repository.save(type);
    }

    @Transactional
    @Override
    public Type update(Type type) {
        if(type == null){
            throw new TypeNoValido("Error: Type es null");
        }
        return repository.save(type);
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
    public List<Type> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Type findById(Long id) {
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }
        return repository.findById(id).orElseThrow(() -> new TypeNoEncontrado("Error: Type no se ha encontrado"));
    }
    
}
