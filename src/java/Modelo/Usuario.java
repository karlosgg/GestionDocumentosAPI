/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author José Carlos Grijalva González
 */
@Entity
@Table(name = "usuario", catalog = "gestion_documentos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByDui", query = "SELECT u FROM Usuario u WHERE u.dui = :dui"),
    @NamedQuery(name = "Usuario.findByNit", query = "SELECT u FROM Usuario u WHERE u.nit = :nit"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo"),
    @NamedQuery(name = "Usuario.findByNombreLoggin", query = "SELECT u FROM Usuario u WHERE u.nombreLoggin = :nombreLoggin"),
    @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dui", nullable = false)
    private int dui;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit", nullable = false)
    private int nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion", nullable = false, length = 250)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreLoggin", nullable = false, length = 100)
    private String nombreLoggin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrasenia", nullable = false, length = 100)
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistrador")
    private List<RegistroDocumento> registroDocumentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistrado")
    private List<RegistroDocumento> registroDocumentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Correo> correoList;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Telefono> telefonoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidos, int dui, int nit, String direccion, boolean activo, String nombreLoggin, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dui = dui;
        this.nit = nit;
        this.direccion = direccion;
        this.activo = activo;
        this.nombreLoggin = nombreLoggin;
        this.contrasenia = contrasenia;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombreLoggin() {
        return nombreLoggin;
    }

    public void setNombreLoggin(String nombreLoggin) {
        this.nombreLoggin = nombreLoggin;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<RegistroDocumento> getRegistroDocumentoList() {
        return registroDocumentoList;
    }

    public void setRegistroDocumentoList(List<RegistroDocumento> registroDocumentoList) {
        this.registroDocumentoList = registroDocumentoList;
    }

    @XmlTransient
    public List<RegistroDocumento> getRegistroDocumentoList1() {
        return registroDocumentoList1;
    }

    public void setRegistroDocumentoList1(List<RegistroDocumento> registroDocumentoList1) {
        this.registroDocumentoList1 = registroDocumentoList1;
    }

    @XmlTransient
    public List<Correo> getCorreoList() {
        return correoList;
    }

    public void setCorreoList(List<Correo> correoList) {
        this.correoList = correoList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
