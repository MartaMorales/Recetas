package com.recetas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static final long serialVersionUID = 5882208272046798301L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "receta_Sequence")
    @SequenceGenerator(name = "receta_Sequence", sequenceName = "RECETA_SEQ")
    private int id;
    private String nombre;
    @ManyToMany(targetEntity = Paso.class)
    private List<Paso> pasos;

    @ManyToMany(targetEntity = Ingrediente.class)
    private List<Ingrediente> ingredientes;
    @ManyToOne(cascade=CascadeType.ALL)
    private Autor autor;
    private String dificultad;


}
