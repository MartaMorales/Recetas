package com.recetas.springboot.backend.apirest.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Paso implements Serializable {

    private static final long serialVersionUID = 2437079463298874251L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "paso_Sequence")
    @SequenceGenerator(name = "paso_Sequence", sequenceName = "PASO_SEQ")
    private int id;
    private String descripcion;
    private int orden;
    private String tiempo;
}
