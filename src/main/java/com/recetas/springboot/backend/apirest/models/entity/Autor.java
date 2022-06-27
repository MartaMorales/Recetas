package com.recetas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "autores")
public class Autor implements Serializable {

    private static final long serialVersionUID = 628719963119467863L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "autor_Sequence")
    @SequenceGenerator(name = "autor_Sequence", sequenceName = "AUTOR_SEQ")
    private int id;
    private String nombre;
    private String apellidos;
    private String nivel;
}
