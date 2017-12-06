package Modelo;

import Modelo.Categoria;
import Modelo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-06T00:59:24")
@StaticMetamodel(DocumentoReal.class)
public class DocumentoReal_ { 

    public static volatile SingularAttribute<DocumentoReal, String> descripcion;
    public static volatile SingularAttribute<DocumentoReal, String> ubicacion;
    public static volatile SingularAttribute<DocumentoReal, Integer> idDocumentoReal;
    public static volatile SingularAttribute<DocumentoReal, String> receptor;
    public static volatile SingularAttribute<DocumentoReal, Date> fechaRegistro;
    public static volatile SingularAttribute<DocumentoReal, Usuario> idUsuario;
    public static volatile SingularAttribute<DocumentoReal, String> documento;
    public static volatile SingularAttribute<DocumentoReal, Date> fechaEmision;
    public static volatile SingularAttribute<DocumentoReal, Categoria> idCategoria;
    public static volatile SingularAttribute<DocumentoReal, String> emisor;
    public static volatile SingularAttribute<DocumentoReal, Boolean> activo;

}