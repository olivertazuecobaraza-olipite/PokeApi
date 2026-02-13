package com.oliver.pokepractica.application.mapper.trainer;

import com.oliver.pokepractica.application.dto.trainer.TrainerDto;
import com.oliver.pokepractica.domain.enty.trainer.Trainer;

public class MapperTrainer {
    // TO Dto

    public static TrainerDto toDto(Trainer trainer) {
        if (trainer == null) {
            return null;
        }
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName(trainer.getName());
        trainerDto.setRegion(trainer.getRegion());
        trainerDto.setBdgeCount(trainer.getBadgeCount());

        return trainerDto;
    }
    

    // To Entity
    public static Trainer toEntity(TrainerDto trainerDto) {
        if (trainerDto == null) {
            return null;
        }
        Trainer trainer = new Trainer();
        trainer.setName(trainerDto.getName());
        trainer.setRegion(trainerDto.getRegion());
        trainer.setBadgeCount(trainerDto.getBdgeCount());
        
        return trainer;
    }
}
