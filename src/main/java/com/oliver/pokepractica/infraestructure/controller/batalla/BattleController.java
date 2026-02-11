package com.oliver.pokepractica.infraestructure.controller.batalla;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;

@RestController
@RequestMapping("/api/battle")
public class BattleController {

    // Post
    @PostMapping("/start")
    public Trainer Battle(@RequestBody Object battle) { // Battle request
        return null;
    }

}
