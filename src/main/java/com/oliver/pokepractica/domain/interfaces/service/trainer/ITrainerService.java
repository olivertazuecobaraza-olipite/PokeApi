package com.oliver.pokepractica.domain.interfaces.service.trainer;

import java.util.List;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;

public interface ITrainerService {
    
    // CRUD
// POST
    public Trainer save(Trainer trainer);
// UPDATE
    public Trainer update(Trainer trainer, Long id);
    public Trainer update(Trainer trainer);
// DELETE
    public void deleteById(Long id);
// GET
    public List<Trainer> findAll();
    public Trainer findById(Long id);
    
    // EXTRA
}
