/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyreg.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class Sistema implements Serializable{
    private ArrayList<Semana> semanas;
    private ArrayList<Dependencia> dependencia;
    private ArrayList<Información> info;
    
    public boolean verficarSemana(int id, String nombre){
        if(semanas==null){
            semanas = new ArrayList<>();
            semanas.add(new Semana(nombre, id));
            return true;
        }else{
            for(int i=0; i < semanas.size(); i++){
                if(semanas.get(i).getId() == id || semanas.get(i).getNombre().equalsIgnoreCase(nombre)){
                    return false;
                }
            }
            semanas.add(new Semana(nombre, id));
            return true;
        }
    }
    
    public void addInfo(String nombre, int id_persona, int id_semana ,String dependencia, String flexible, String hi, String hf, String name_semana){
        boolean flex;
        if(info==null){
            info = new ArrayList<>();
            if(flexible.equalsIgnoreCase("Si")) flex = true; else flex = false;
            info.add(new Información(dependencia, hi, hf, id_semana, id_persona, flex, nombre, name_semana));
        }else{
            if(flexible.equalsIgnoreCase("Si")) flex = true; else flex = false;
            info.add(new Información(dependencia, hi, hf, id_semana, id_persona, flex, nombre, name_semana));
        }
    }
    
    public void addDependencia(String nombre){
        if(dependencia==null){
            dependencia = new ArrayList<>();
            dependencia.add(new Dependencia(nombre));
        }else{
            boolean flag = false;
            for(int i = 0; i < dependencia.size(); i++){
                if(dependencia.get(i).getNombre().equalsIgnoreCase(nombre)){
                    flag = true;
                }
            }
            
            if(!flag) dependencia.add(new Dependencia(nombre));
        }
    }
    
    public String showInfo(){
        String data = "";
        Información aux;
        for(int i = 0; i < info.size(); i++){
            aux = info.get(i);
            data += aux.getNombre_persona()+" / "+aux.getDependencia()+ " / " +aux.getH_in()+ " / "+ aux.getH_out()+ " / "+aux.getId_persona()+" / "+aux.getId_semana()+" / "+aux.isFlexible()+"\n";
        }
        return data;
    }
    
    public ArrayList<Semana> listarSemanas(){
        return semanas;
    }
    
    public ArrayList<Información> listarInfo(){
        return info;
    }
    
    public ArrayList<Dependencia> listarDependencias(){
        return dependencia;
    }
    
    public ArrayList<Información> listarInfo(String filter1, String filter2){
        ArrayList<Información> aux = new ArrayList<Información>();
        for(int i = 0; i < info.size(); i++){
            if(info.get(i).getNombre_semana().equalsIgnoreCase(filter1) && info.get(i).getDependencia().equalsIgnoreCase(filter2)){
                aux.add(info.get(i));
            }
        }
        return aux;
    }
}
