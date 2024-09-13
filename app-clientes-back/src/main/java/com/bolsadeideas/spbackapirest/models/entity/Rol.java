package com.bolsadeideas.spbackapirest.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Indicamos como se genera este Id
    private Long id;
    @Column(unique = true, length = 20)
    private String username;

    //Indicamos que existe la relacion y quien es el propietario de la relacion. La clase Usuario con su atributo roles.
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
