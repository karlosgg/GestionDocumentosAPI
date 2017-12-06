/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author José Carlos Grijalva González
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "GestionDocumentosAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
  
    public Usuario getUserb(String us, String pa){
         System.out.println("Usuario: "+us+" Contra: "+pa);
         Usuario usuario = null;
         String consulta;
        try{
         consulta="SELECT u FROM Usuario u WHERE u.nombreLoggin = :nombreLoggin AND u.contrasenia = :contrasenia ";
         Query query=em.createQuery(consulta);
         query.setParameter("nombreLoggin", us);
         query.setParameter("contrasenia", pa);
         List<Usuario> lista = query.getResultList();
         if(!lista.isEmpty()){
             usuario = lista.get(0);
         }
            System.out.println(usuario);
      }catch(Exception ex){
          System.out.println("eeee "+ex.getMessage());
      }finally{
           
      }
      return usuario;
    }
}
