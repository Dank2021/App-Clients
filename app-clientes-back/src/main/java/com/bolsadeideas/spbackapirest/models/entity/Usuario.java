package com.bolsadeideas.spbackapirest.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity     //Marcamos la clase indicando que esta mapeada a una tabla
@Table(name = "usuarios")   //Para indicar el nombre de la tabla
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Indicamos como se genera este Id
    private Long id;
    @Column(unique = true, length = 20)
    private String username;
    @Column(length = 60)
    private String password;
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})}
    )
    private List<Rol> roles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /*
     * cascade = CascadeType.ALL :
     * Si se realiza una accion sobre el usuario, afecta a todos su roles (Creacion, eliminacion, etc).
     *
     *
     * >2 : Por medio de la anotacion @JoinTable se puede personalizar la tabla que se creara debido a la relacion ManytoMany
     *      Con name se asigna el nombre deseado, joinColumns para el nombre de la columna del usuario y inversejoincolumns
     *      para el nombre de la columna del rol.
     *
     *      Luego con uniqueContraints, indicamos que al crear, se debe tener en cuenta la restriccion de que ni usuario_id ni
     *      rol_id son unicos. No se pueden repetir.
     * */
}
