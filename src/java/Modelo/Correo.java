/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José Carlos Grijalva González
 */
@Entity
@Table(name = "correo", catalog = "gestion_documentos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c"),
    @NamedQuery(name = "Correo.findByIdCorreo", query = "SELECT c FROM Correo c WHERE c.idCorreo = :idCorreo"),
    @NamedQuery(name = "Correo.findByCorreo", query = "SELECT c FROM Correo c WHERE c.correo = :correo"),
    @NamedQuery(name = "Correo.findByActivo", query = "SELECT c FROM Correo c WHERE c.activo = :activo"),
    @NamedQuery(name = "Correo.findByDescripcion", query = "SELECT c FROM Correo c WHERE c.descripcion = :descripcion")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCorreo", nullable = false)
    private Integer idCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Correo() {
    }

    public Correo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public Correo(Integer idCorreo, String correo, boolean activo) {
        this.idCorreo = idCorreo;
        this.correo = correo;
        this.activo = activo;
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Correo[ idCorreo=" + idCorreo + " ]";
    }
    
}
