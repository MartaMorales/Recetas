package com.recetas.springboot.backend.apirest.models.dao;

import com.recetas.springboot.backend.apirest.models.entity.Paso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasoDao extends JpaRepository<Paso, Integer> {
}
