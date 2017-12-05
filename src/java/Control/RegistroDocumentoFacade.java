/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.RegistroDocumento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author José Carlos Grijalva González
 */
@Stateless
public class RegistroDocumentoFacade extends AbstractFacade<RegistroDocumento> {

    @PersistenceContext(unitName = "GestionDocumentosAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroDocumentoFacade() {
        super(RegistroDocumento.class);
    }
    
}
