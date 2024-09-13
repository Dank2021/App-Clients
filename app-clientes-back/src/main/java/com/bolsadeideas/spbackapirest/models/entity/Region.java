package com.bolsadeideas.spbackapirest.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="regiones")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se define la estrategia por una entidad autoincremental.
    private long id;
    private String nombre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
