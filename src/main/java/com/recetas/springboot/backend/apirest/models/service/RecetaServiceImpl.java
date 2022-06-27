package com.recetas.springboot.backend.apirest.models.service;

import com.recetas.springboot.backend.apirest.models.dao.IRecetaDao;
import com.recetas.springboot.backend.apirest.models.entity.Receta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecetaServiceImpl implements IRecetaService {

    @Autowired
    private IRecetaDao recetaDao;

    @Override
    public List<Receta> findAll() {
        return recetaDao.findAll();
    }

    @Override
    public Receta create(Receta receta) {
        return recetaDao.save(receta);
    }

    @Override
    public Receta buscarId(int id) {
        Optional<Receta> optionalReceta = recetaDao.findById(id);
        if(optionalReceta.isEmpty())
            throw new EntityNotFoundException();
        return optionalReceta.get();
    }

    @Override
    public ResponseEntity<Receta> editar(int id, String nombre, String dificultad) {

        /**
         * Optional es un objeto contenedor que puede contener un nulo o no. Se creo principalmente para evitar los
         * nullpointerException
         */
        Optional<Receta> opReceta = recetaDao.findById(id);
        Receta receta = opReceta.orElse(null);
        if(Objects.nonNull(receta)) {
            receta.setDificultad(dificultad);
            receta.setNombre(nombre);
        }
        recetaDao.save(receta);

        return  ResponseEntity.ok(receta);
    }

    @Override
    public ResponseEntity<Receta> editar(Receta receta) {

        return ResponseEntity.ok(recetaDao.save(receta));
    }

    @Override
    public ResponseEntity eliminar(int id) {
        recetaDao.deleteById(id);
        return ResponseEntity.ok("Se ha borrado la receta");
    }
}
