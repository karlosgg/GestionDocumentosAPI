package Modelo;

import Modelo.Cargo;
import Modelo.Direccion;
import Modelo.Documento;
import Modelo.Telefono;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-04T20:15:56")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Cargo> idCargo;
    public static volatile ListAttribute<Usuario, Documento> documentoList;
    public static volatile SingularAttribute<Usuario, Direccion> idDireccion;
    public static volatile SingularAttribute<Usuario, Telefono> idTelefono;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> nit;
    public static volatile SingularAttribute<Usuario, String> dui;
    public static volatile SingularAttribute<Usuario, String> nombre;

}