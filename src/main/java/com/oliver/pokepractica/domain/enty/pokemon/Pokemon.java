package com.oliver.pokepractica.domain.enty.pokemon;

import com.oliver.pokepractica.domain.enty.trainer.Trainer;
import com.oliver.pokepractica.domain.enty.type.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "POKEMON")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nickName;
    String species;
    Integer pokedexNumber;
    Integer lv;
    Integer hp;
    Integer attack;
    Integer defense;
    Boolean isShiny;
    Boolean isLegendary;

    
    // Relaicones
    // TYPE
    @ManyToOne
    @JoinColumn(name= "id_tipo1")
    public Type type1;

    @ManyToOne
    @JoinColumn(name= "id_tipo2")
    public Type type2;

    // TRAINER
    @ManyToOne
    @JoinColumn(name= "id_trainer")
    public Trainer trainer;
}
