package Modelo;

import Modelo.Categoria;
import Modelo.Ubicacion;
import Modelo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-04T20:15:56")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, Date> fechaAlmacenamiento;
    public static volatile SingularAttribute<Documento, Integer> idDocumento;
    public static volatile SingularAttribute<Documento, Usuario> idUsuario;
    public static volatile SingularAttribute<Documento, Ubicacion> idUbicacion;
    public static volatile SingularAttribute<Documento, Categoria> idCategoria;
    public static volatile SingularAttribute<Documento, String> tituloDocumento;

}