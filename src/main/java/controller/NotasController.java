/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.NotasGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Notas;
import gestion.EstudianteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Estudiante;


/**
 *
 * @author jdavi
 */
@Named(value = "notasController")
@SessionScoped
public class NotasController extends Notas implements Serializable {

    /**
     * Creates a new instance of NotasController
     */
    public NotasController() {
        super("", "", "", 0);
    }
    
    
    public String inserta(){
        
        if (NotasGestion.insertar(this)){
            return "notas.xhtml";
            
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaNotasForm:idEstudiante", mensaje);
            return "editanotas.xhtml";
        }
        
    }
    
    public String modifica(){
        
        if (NotasGestion.actualiza(this)){
            return "notas.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaNotasForm:idEstudiante", mensaje);
            return "editanotas.xhtml";   
        }
    }
    
    public String elimina(){
        
        if (NotasGestion.eliminar(this)){
            return "notas.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaNotasForm:idEstudiante", mensaje);
            return "editanotas.xhtml";
            
        }
   
    }
    
    public String edita(String id){
        
        Notas notas= NotasGestion.getNotas(id);
        
        if (notas!=null){
            
            this.setIdEstudiante(notas.getIdEstudiante());
            this.setIdMateria(notas.getIdMateria());
            this.setIdPeriodo(getIdPeriodo());
            this.setNota(notas.getNota());
            
        
            return "editanotas.xhtml";
            
            
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "editanotas.xhtml";
            
        }

    }

    public List<Notas> getNotas(){
        
        return NotasGestion.getNotas();
        
    }
    
    
    
}
