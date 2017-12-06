/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author José Carlos Grijalva González
 */
@Entity
@Table(name = "documento_real", catalog = "gestion_documentos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoReal.findAll", query = "SELECT d FROM DocumentoReal d"),
    @NamedQuery(name = "DocumentoReal.findByIdDocumentoReal", query = "SELECT d FROM DocumentoReal d WHERE d.idDocumentoReal = :idDocumentoReal"),
    @NamedQuery(name = "DocumentoReal.findByUbicacion", query = "SELECT d FROM DocumentoReal d WHERE d.ubicacion = :ubicacion"),
    @NamedQuery(name = "DocumentoReal.findByEmisot", query = "SELECT d FROM DocumentoReal d WHERE d.emisot = :emisot"),
    @NamedQuery(name = "DocumentoReal.findByReceptor", query = "SELECT d FROM DocumentoReal d WHERE d.receptor = :receptor"),
    @NamedQuery(name = "DocumentoReal.findByFechaEmision", query = "SELECT d FROM DocumentoReal d WHERE d.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "DocumentoReal.findByActivo", query = "SELECT d FROM DocumentoReal d WHERE d.activo = :activo"),
    @NamedQuery(name = "DocumentoReal.findByDescripcion", query = "SELECT d FROM DocumentoReal d WHERE d.descripcion = :descripcion")})
public class DocumentoReal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumentoReal", nullable = false)
    private Integer idDocumentoReal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ubicacion", nullable = false, length = 150)
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "emisot", nullable = false, length = 150)
    private String emisot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "receptor", nullable = false, length = 150)
    private String receptor;
    @Basic(optional = true)
    @Column(name = "fechaEmision", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "img", nullable = false)
    private byte[] img;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentoReal")
    private List<RegistroDocumento> registroDocumentoList;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    public DocumentoReal() {
    }

    public DocumentoReal(Integer idDocumentoReal) {
        this.idDocumentoReal = idDocumentoReal;
    }

    public DocumentoReal(Integer idDocumentoReal, String ubicacion, String emisot, String receptor, Date fechaEmision, boolean activo, byte[] img) {
        this.idDocumentoReal = idDocumentoReal;
        this.ubicacion = ubicacion;
        this.emisot = emisot;
        this.receptor = receptor;
        this.fechaEmision = fechaEmision;
        this.activo = activo;
        this.img = img;
    }

    public Integer getIdDocumentoReal() {
        return idDocumentoReal;
    }

    public void setIdDocumentoReal(Integer idDocumentoReal) {
        this.idDocumentoReal = idDocumentoReal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmisot() {
        return emisot;
    }

    public void setEmisot(String emisot) {
        this.emisot = emisot;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<RegistroDocumento> getRegistroDocumentoList() {
        return registroDocumentoList;
    }

    public void setRegistroDocumentoList(List<RegistroDocumento> registroDocumentoList) {
        this.registroDocumentoList = registroDocumentoList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoReal != null ? idDocumentoReal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoReal)) {
            return false;
        }
        DocumentoReal other = (DocumentoReal) object;
        if ((this.idDocumentoReal == null && other.idDocumentoReal != null) || (this.idDocumentoReal != null && !this.idDocumentoReal.equals(other.idDocumentoReal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DocumentoReal[ idDocumentoReal=" + idDocumentoReal + " ]";
    }
    
}
