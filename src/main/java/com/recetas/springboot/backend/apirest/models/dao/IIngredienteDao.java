package com.recetas.springboot.backend.apirest.models.dao;

import com.recetas.springboot.backend.apirest.models.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteDao extends JpaRepository<Ingrediente, Integer> {
}
