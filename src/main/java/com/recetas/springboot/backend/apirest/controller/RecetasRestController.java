package com.recetas.springboot.backend.apirest.controller;


import com.recetas.springboot.backend.apirest.models.entity.Receta;
import com.recetas.springboot.backend.apirest.models.service.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receta")
public class RecetasRestController {

    @Autowired
    private IRecetaService recetaService;

    /**
     *
     * GET: se utiliza para solicitar datos de un recurso especifico
     * La cadena de consulta se envia en la url de una solicitud GET
     * /test/demo_form.php?name1=value1&name2=value2
     * - Las solicitudes GET se pueden almacenar en cache, permanecen en el historial del navegador
     * se pueden marcar, nunca deben usarse cuando son datos confidenciales, tienen restricciones de longitud
     * solo se utilizan para solicitar datos (no para modificar)
     *
     *
     * POST: se utiliza para enviar datos a un servidor para crear/actualizar un recurso.
     * Estos datos se almacenan en el cuerpo de la solicitud HTTP
     * - nunca se almacenan en la cache, no permanecen en el historial del navegador
     * no se pueden marcar, no tienen restricciones de longitud
     *
     */

    @GetMapping("/all")
    public List<Receta> index() {
        return recetaService.findAll();
    }

    @PostMapping
    public Receta crearReceta(@RequestBody Receta receta) {
        return recetaService.create(receta);
    }

    @GetMapping("/{id}")
    public Receta buscarReceta(@PathVariable("id") Integer id) {
        return recetaService.buscarId(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Receta> editarReceta(@PathVariable("id") Integer id,
                                               @RequestParam(value = "nombre", required = false) String nombre,
                                               @RequestParam(value = "dificultad", required = false) String dificultad) {
        return recetaService.editar(id, nombre, dificultad);
    }

    @PutMapping
    public ResponseEntity<Receta> editarReceta(@RequestBody Receta receta){
        return recetaService.editar(receta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarReceta(@PathVariable("id") Integer id){
        return recetaService.eliminar(id);
    }

}
