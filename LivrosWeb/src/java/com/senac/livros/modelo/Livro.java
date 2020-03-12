/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.livros.modelo;


/**
 *
 * @author vanessa
 */
public class Livro  {
    

    /**
     * @return the serialVersionUID
     */
  

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
       
        
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String estado;
    private String disponivel;
    private String status;
    
    public int getId(){
        return id;
    }
    
    public void setId (int id){
        this.id = id;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo (String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    
    public void setAutor (String autor){
        this.autor = autor;
    } 
    
     public int getAno(){
        return ano;
    }
    
    public void setAno (int ano){
        this.ano = ano;
    }
     public String getEstado(){
        return estado;
    }
     public void setEstado (String estado){
        this.estado = estado;
    }
     
     public String getDisponivel(){
        return disponivel;
    }
     
     public void setDisponivel (String disponivel){
        this.disponivel = disponivel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
