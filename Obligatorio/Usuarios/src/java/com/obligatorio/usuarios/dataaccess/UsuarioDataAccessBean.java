/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obligatorio.usuarios.dataaccess;

import com.obligatorio.usuarios.Usuario;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ignacio Berretta
 */
@Stateless
@LocalBean
public class UsuarioDataAccessBean {

    @PersistenceContext
    private EntityManager em;
    
    public UsuarioDataAccessBean(){}
    
    //<editor-fold defaultstate="collapsed" desc="Usuarios">
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void agregarUsuario(Usuario u) throws Exception{
        try{
            em.persist(u);
        }catch(Exception e) {
            throw new Exception("Usuario ya existe", e);
        }
    }
    //</editor-fold>
}
