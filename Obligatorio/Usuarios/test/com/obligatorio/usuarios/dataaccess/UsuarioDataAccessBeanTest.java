/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obligatorio.usuarios.dataaccess;

import com.obligatorio.usuarios.ProveedorIdentidad;
import com.obligatorio.usuarios.Usuario;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Berretta
 */
public class UsuarioDataAccessBeanTest {
    private Context  ctx;
    private EJBContainer ejbContainer;
    
    public UsuarioDataAccessBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Opening the container" );
        ctx = ejbContainer.getContext();
    }
    
    @After
    public void tearDown() {
        ejbContainer.close();
        System.out.println("Closing the container" );
    }

    /**
     * Test of agregarUsuario method, of class UsuarioDataAccessBean.
     */
    @Test
    public void testAgregarUsuario() throws Exception {
        UsuarioDataAccessBean udab = (UsuarioDataAccessBean) ctx.lookup("java:global/classes/UsuarioDataAccessBean");
        assertNotNull(udab);
        
        Usuario u = new Usuario("Roberto", "1", ProveedorIdentidad.FACEBOOK);
        udab.agregarUsuario(u);
    }
    
    //@Test(expected = Exception.class)
   // public void testFailAgregarUsuario() throws Exception {
     //   UsuarioDataAccessBean udab = (UsuarioDataAccessBean) ctx.lookup("java:global/classes/UsuarioDataAccessBean");
       // assertNotNull(udab);
        
       // Usuario u = new Usuario();
       // udab.agregarUsuario(u);
   // }
    
}
