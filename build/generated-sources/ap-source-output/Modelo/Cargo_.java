package Modelo;

import Modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-04T20:15:56")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Integer> idCargo;
    public static volatile ListAttribute<Cargo, Usuario> usuarioList;
    public static volatile SingularAttribute<Cargo, String> cargo;

}