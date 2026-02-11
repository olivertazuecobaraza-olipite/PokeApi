package com.oliver.pokepractica.infraestructure.service.trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;
import com.oliver.pokepractica.domain.exception.ValoresNoValidos;
import com.oliver.pokepractica.domain.exception.trainer.TrainerInvalido;
import com.oliver.pokepractica.domain.exception.trainer.TrainerNoEncontrado;
import com.oliver.pokepractica.domain.interfaces.service.trainer.ITrainerService;
import com.oliver.pokepractica.infraestructure.repository.trainer.TrainerSpringRepository;

import jakarta.transaction.Transactional;

@Service
public class TrainerService implements ITrainerService{

    @Autowired
    TrainerSpringRepository repository;

    @Transactional
    @Override
    public Trainer save(Trainer trainer) {
        if (trainer == null){
            throw new TrainerInvalido("Error: Trainer es null");
        }
        return repository.save(trainer);
    }

    @Transactional
    @Override
    public Trainer update(Trainer trainer, Long id) {
        if (trainer == null){
            throw new TrainerInvalido("Error: Trainer es null");
        }
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }

        Trainer tr = findById(id);
        trainer.setId(tr.getId());
        return repository.save(trainer);
    }

    @Transactional
    @Override
    public Trainer update(Trainer trainer) {
        if (trainer == null){
            throw new TrainerInvalido("Error: Trainer es null");
        }
        return repository.save(trainer);
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
    public List<Trainer> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Trainer findById(Long id) {
        if (id < 0){
            throw new ValoresNoValidos("Error: Id no valido");
        }
        return repository.findById(id).orElseThrow(() -> new TrainerNoEncontrado("Error: Trainer no enconrado"));
    }
    
}
