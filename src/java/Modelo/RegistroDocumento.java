/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José Carlos Grijalva González
 */
@Entity
@Table(name = "registro_documento", catalog = "gestion_documentos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroDocumento.findAll", query = "SELECT r FROM RegistroDocumento r"),
    @NamedQuery(name = "RegistroDocumento.findByIdRegistroDocumento", query = "SELECT r FROM RegistroDocumento r WHERE r.idRegistroDocumento = :idRegistroDocumento"),
    @NamedQuery(name = "RegistroDocumento.findByFechaRegistro", query = "SELECT r FROM RegistroDocumento r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RegistroDocumento.findByDescripcion", query = "SELECT r FROM RegistroDocumento r WHERE r.descripcion = :descripcion")})
public class RegistroDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRegistroDocumento", nullable = false)
    private Integer idRegistroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @JoinColumn(name = "idDocumentoReal", referencedColumnName = "idDocumentoReal", nullable = false)
    @ManyToOne(optional = false)
    private DocumentoReal idDocumentoReal;
    @JoinColumn(name = "idUsuarioRegistrador", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistrador;
    @JoinColumn(name = "idUsuarioRegistrado", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistrado;

    public RegistroDocumento() {
    }

    public RegistroDocumento(Integer idRegistroDocumento) {
        this.idRegistroDocumento = idRegistroDocumento;
    }

    public RegistroDocumento(Integer idRegistroDocumento, Date fechaRegistro) {
        this.idRegistroDocumento = idRegistroDocumento;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdRegistroDocumento() {
        return idRegistroDocumento;
    }

    public void setIdRegistroDocumento(Integer idRegistroDocumento) {
        this.idRegistroDocumento = idRegistroDocumento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DocumentoReal getIdDocumentoReal() {
        return idDocumentoReal;
    }

    public void setIdDocumentoReal(DocumentoReal idDocumentoReal) {
        this.idDocumentoReal = idDocumentoReal;
    }

    public Usuario getIdUsuarioRegistrador() {
        return idUsuarioRegistrador;
    }

    public void setIdUsuarioRegistrador(Usuario idUsuarioRegistrador) {
        this.idUsuarioRegistrador = idUsuarioRegistrador;
    }

    public Usuario getIdUsuarioRegistrado() {
        return idUsuarioRegistrado;
    }

    public void setIdUsuarioRegistrado(Usuario idUsuarioRegistrado) {
        this.idUsuarioRegistrado = idUsuarioRegistrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroDocumento != null ? idRegistroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDocumento)) {
            return false;
        }
        RegistroDocumento other = (RegistroDocumento) object;
        if ((this.idRegistroDocumento == null && other.idRegistroDocumento != null) || (this.idRegistroDocumento != null && !this.idRegistroDocumento.equals(other.idRegistroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RegistroDocumento[ idRegistroDocumento=" + idRegistroDocumento + " ]";
    }
    
}
