package com.oliver.pokepractica.domain.enty.type;

import java.util.HashSet;
import java.util.Set;

import com.oliver.pokepractica.domain.enty.pokemon.Pokemon;
import com.oliver.pokepractica.domain.enums.NameType;

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
@Table(name = "TYPE")
public class Type {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated (EnumType.STRING)
    NameType name;

    // relacion pokemon
    @OneToMany(mappedBy="id")
    public Set<Pokemon> pokemon = new HashSet<>();
}