package br.senac.admeletronicos.model;

public class Produto {
    
    private int id;
    private String nome;
    private String fabricante;
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getFabricante(){
        return fabricante;
    }
    
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    
    public void setId(int newId) {
        id = newId;
    }
    
    public int getId(){
        return id;
    }
}
