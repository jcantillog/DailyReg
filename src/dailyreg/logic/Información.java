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
public class Información implements Serializable{
    private String dependencia, h_in, h_out, nombre_persona, nombre_semana;
    private int id_semana, id_persona;
    boolean flexible;

    public Información(String dependencia, String h_in, String h_out, int id_semana, int id_persona, boolean flexible, String nombre_persona, String nombre_semana) {
        this.dependencia = dependencia;
        this.h_in = h_in;
        this.h_out = h_out;
        this.id_semana = id_semana;
        this.id_persona = id_persona;
        this.flexible = flexible;
        this.nombre_persona = nombre_persona;
        this.nombre_semana = nombre_semana;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getH_in() {
        return h_in;
    }

    public void setH_in(String h_in) {
        this.h_in = h_in;
    }

    public String getH_out() {
        return h_out;
    }

    public void setH_out(String h_out) {
        this.h_out = h_out;
    }

    public int getId_semana() {
        return id_semana;
    }

    public void setId_semana(int id_semana) {
        this.id_semana = id_semana;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public boolean isFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getNombre_semana() {
        return nombre_semana;
    }

    public void setNombre_semana(String nombre_semana) {
        this.nombre_semana = nombre_semana;
    }
    
    
}
