package com.dosideas.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Provincia {
    
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    private String nombre;
    
    

    public Provincia(Long id) {
        this.id = id;
    }

    public Provincia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    

}
