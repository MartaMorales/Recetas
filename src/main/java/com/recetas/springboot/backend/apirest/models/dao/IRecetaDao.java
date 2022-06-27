package com.recetas.springboot.backend.apirest.models.dao;

import com.recetas.springboot.backend.apirest.models.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecetaDao extends JpaRepository<Receta, Integer> {
}
