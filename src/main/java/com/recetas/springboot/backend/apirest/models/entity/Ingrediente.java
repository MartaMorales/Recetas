package com.recetas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 4521157100591488335L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ingrediente_Sequence")
    @SequenceGenerator(name = "ingrediente_Sequence", sequenceName = "INGREDIENTE_SEQ")
    private int id;
    private String nombre;
    private String tipo;
    private double cantidad;
    private String unidad;

    @ManyToMany(targetEntity = Receta.class)
    private List<Receta> recetas;
    @Column(name = "materia_prima")
    private boolean materiaPrima;
}
