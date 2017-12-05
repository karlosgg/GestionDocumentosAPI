package Modelo;

import Modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-04T20:15:56")
@StaticMetamodel(Telefono.class)
public class Telefono_ { 

    public static volatile SingularAttribute<Telefono, Integer> idTelefono;
    public static volatile ListAttribute<Telefono, Usuario> usuarioList;
    public static volatile SingularAttribute<Telefono, String> telefono;

}