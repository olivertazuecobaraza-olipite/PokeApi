package com.oliver.pokepractica.infraestructure.repository.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.pokepractica.domain.enty.type.Type;

@Repository
public interface TypeSpringRepository extends JpaRepository<Type, Long>{
    
}
