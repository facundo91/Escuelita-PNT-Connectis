package com.dosideas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Este objeto de dominio utiliza anotaciones para relacionar la clase y sus
 * atributos con una tabla. Hibernate utiliza estas anotaciones para acceder a
 * la base de datos e interactuar con objetos de esta clase.
 *
 * @author ldeseta
 */
@Entity
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
