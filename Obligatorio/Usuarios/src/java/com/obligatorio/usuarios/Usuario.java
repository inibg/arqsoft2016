package com.obligatorio.usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ignacio Berretta
 */

@NamedQueries({
    @NamedQuery(name = "obtenerUsuario", 
            query = "SELECT u FROM Usuario u WHERE u.nombre = :nombreusuario"),
    @NamedQuery(name = "obtenerTodosLosUsuarios", query = "SELECT u FROM Usuario u")
})


@Entity
@Table(name = "usuario", uniqueConstraints= { 
    @UniqueConstraint(columnNames={"usuario_external_id", "proveedor_identidad"})})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_Id")
    private Long id;
    
    @NotNull
    @Column(name = "usuario_nombre")
    @Size(min = 3, max = 50)
    private String nombre;
    
    @NotNull
    @Column(name = "usuario_external_id")
    private String externalId;
    
    @NotNull
    @Column(name = "proveedor_identidad")
    @Enumerated(EnumType.STRING)
    private ProveedorIdentidad proveedorIdentidad;

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
    
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ProveedorIdentidad getProveedorIdentidad() {
        return proveedorIdentidad;
    }

    public void setProveedorIdentidad(ProveedorIdentidad proveedorIdentidad) {
        this.proveedorIdentidad = proveedorIdentidad;
    }

    
    public Usuario(){}
    
    public Usuario(String nombre, String externalId, ProveedorIdentidad pi){
        this.setNombre(nombre);
        this.setExternalId(externalId);
        this.setProveedorIdentidad(pi);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        hash = 53 * hash + (this.getNombre() != null ? this.getNombre().hashCode() : 0);
        hash = 53 * hash + (this.getExternalId() != null ? this.getExternalId().hashCode() : 0);
        hash = 53 * hash + (this.getProveedorIdentidad() != null ? this.getProveedorIdentidad().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.getNombre() == null && other.getNombre() != null) || (this.getNombre() != null 
                && !this.getNombre().equals(other.getNombre()))){
            return false;
        }
        if ((this.getExternalId() == null && other.getExternalId() != null) || (this.getExternalId() != null
                && !this.getExternalId().equals(other.getExternalId()))){
            return false;
        }
        if ((this.getProveedorIdentidad() == null && other.getProveedorIdentidad() != null) || (
                this.getProveedorIdentidad() != null && !this.getProveedorIdentidad().equals(other.getProveedorIdentidad()))){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.obligatorio.usuarios.Usuario[ id=" + id + " nombre=" + nombre + 
               " externalId=" + externalId + " proveedorIdentidad=" + 
                proveedorIdentidad + " ]";
    }    
}
