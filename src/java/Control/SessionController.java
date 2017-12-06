/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Carlos Grijalva González
 */
@ManagedBean
public class SessionController {
    
    public void isOpen(){
        try{
            Usuario usuario=null;
            usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if(usuario==null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../login.xhtml");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Sesión no iniciada");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }catch(Exception e){
            
        }
    }
    
     public void isLogged(){
        try{
            Usuario usuario=null;
            usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if(usuario!=null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("welcome/dashboard.xhtml");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Sesión iniciada");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }catch(Exception e){
            
        }
    }
     
     public void isFirst(){
        try{
            
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
           
        }catch(Exception e){
            
        }
    }
     
     public boolean isAdmin(){
         boolean admin=false;
         Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         if(usuario!=null){
             if(usuario.getIdRol().getIdRol() == 1){
                 admin=true;
             }
         }
         return admin;
     }
}
