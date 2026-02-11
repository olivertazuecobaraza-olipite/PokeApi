package com.oliver.pokepractica.domain.interfaces.repository.type;

import java.util.List;

import com.oliver.pokepractica.domain.enty.type.Type;

public interface ITypeRepository {
    // CRUD
// GET
    public void save(Type type);
// UPDATE
    public void update(Type type, Long id);
    public void update(Type type);
// DELETE
    public void deleteById(Long id);
// GET
    public List<Type> findAll();
    public Type findByUd(Long id);
    // EXTRA
}
