package com.oliver.pokepractica.domain.interfaces.repository.trainer;

import java.util.List;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;

public interface  ITrainerRepository {
    
    // CRUD
    
// POST
    public void save(Trainer trainer);
// UPDATE
    public void update(Trainer trainer, Long id);
    public void update(Trainer trainer);
// DELETE
    public void deleteById(Long id);
// GET
    public List<Trainer> findAll();
    public Trainer findById();
    
    // EXTRA
}
