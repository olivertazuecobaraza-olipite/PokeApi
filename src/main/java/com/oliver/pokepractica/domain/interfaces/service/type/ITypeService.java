package com.oliver.pokepractica.domain.interfaces.service.type;

import java.util.List;

import com.oliver.pokepractica.domain.enty.type.Type;

public interface ITypeService {
    // CRUD
// GET
    public Type save(Type type);
// UPDATE
    public Type update(Type type, Long id);
    public Type update(Type type);
// DELETE
    public void deleteById(Long id);
// GET
    public List<Type> findAll();
    public Type findById(Long id);
    // EXTRA
}
