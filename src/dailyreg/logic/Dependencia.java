/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyreg.logic;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 */
public class Dependencia implements Serializable{
    private String nombre;

    public Dependencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
