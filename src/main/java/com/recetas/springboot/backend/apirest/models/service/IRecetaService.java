package com.recetas.springboot.backend.apirest.models.service;

import com.recetas.springboot.backend.apirest.models.entity.Receta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


public interface IRecetaService {

    List<Receta> findAll() ;

    Receta create(Receta receta);

    Receta buscarId(int id);

    ResponseEntity<Receta> editar(int id, String nombre, String dificultad);

    ResponseEntity<Receta> editar (Receta receta);

    ResponseEntity eliminar (int id);

    ResponseEntity<List<Receta>> buscarRecetaNombre (String nombre, String nombreAutor, String apellidos);
}
