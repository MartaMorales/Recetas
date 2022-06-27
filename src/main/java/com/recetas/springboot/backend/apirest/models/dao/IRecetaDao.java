package com.recetas.springboot.backend.apirest.models.dao;

import com.recetas.springboot.backend.apirest.models.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecetaDao extends JpaRepository<Receta, Integer> {

    List<Receta> findByNombreLikeOrAutorNombreLikeOrAutorApellidosLike(String nombre, String nombreAutor, String apellidos);
}
