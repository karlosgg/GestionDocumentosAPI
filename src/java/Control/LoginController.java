/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/**
 *
 * @author José Carlos Grijalva González
 */

@ManagedBean
public class LoginController{
    private String username;
     
    private String password;
    @EJB
    private Control.UsuarioFacade ejbFacade;
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String login(ActionEvent event) throws IOException {
        
        String redireccion = "";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Usuario usuario =null;
        if(username!=null && password !=null){
            usuario =ejbFacade.getUserb(username, password);
        }
        
        if(usuario!=null) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            redireccion = "welcome/dashboard.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
        return redireccion;
    }   
    
    public void logOut() throws IOException {
        
        String redireccion="";
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", null);
        redireccion = "./../login.xhtml";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salir", "Hasta pronto");
        FacesContext.getCurrentInstance().addMessage(null, message);
//        context.addCallbackParam("loggedIn", loggedIn);
        FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
        
    }
}
