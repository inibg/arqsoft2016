/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obligatorio.usuarios;

/**
 *
 * @author inibg
 */
public enum ProveedorIdentidad {
    FACEBOOK('F');
 
    private final char codigo;

    
    public char getCodigo() {
        return codigo;
    }
    
    private ProveedorIdentidad(char codigo){
        this.codigo = codigo;
    }
}
