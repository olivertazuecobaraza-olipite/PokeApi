package com.oliver.pokepractica.domain.enty.trainer;
import java.util.HashSet;
import java.util.Set;

import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.domain.enums.Region;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "TRAINER")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Region region;
    Integer badgeCount; // Medallas

    // Relacion pokemon

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    public Set<Pokemon> pokemons = new HashSet<Pokemon>();
}
