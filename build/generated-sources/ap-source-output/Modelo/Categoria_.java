package Modelo;

import Modelo.Documento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-12-04T20:15:56")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Documento> documentoList;
    public static volatile SingularAttribute<Categoria, Integer> idSubCategoria;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}