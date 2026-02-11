package com.oliver.pokepractica.infraestructure.repository.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;

@Repository
public interface TrainerSpringRepository extends JpaRepository<Trainer, Long>{
    
}
