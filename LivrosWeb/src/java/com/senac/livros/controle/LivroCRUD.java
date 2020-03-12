/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.livros.controle;

import com.senac.livros.modelo.Livro;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.util.ArrayList;

/**
 *
 * @author vanessa
 */
public class LivroCRUD {
    ConexaoBD conexaobd = new ConexaoBD();
    Livro livros = new Livro();
    
    //Metodo que insere os dados no banco dados
    
    /**
     *
     * @param livros
     * @throws java.sql.SQLException
     */
    public void cadastrar(Livro livros) throws SQLException {
        String sql ="insert into livros (titulo, autor, ano, estado, disponivel, status) values (?,?,?,?,?,?)";
        
        try {
        PreparedStatement ps = conexaobd.abrirConexao().prepareStatement(sql);
        
       
        ps.setString (1, livros.getTitulo());
        ps.setString (2, livros.getAutor());
        ps.setInt(3, livros.getAno());        
        ps.setString (4, livros.getEstado());        
        ps.setString (5, livros.getDisponivel());
        ps.setString (6,"A");
        ps.execute();
        
        } catch (HeadlessException | SQLException ex){
         
    }
    }


    public ArrayList<Livro> listaTodos() {
        String sql = "SELECT * FROM livros where status = 'A'";
        ArrayList<Livro> dados = new ArrayList<>();
        conexaobd.abrirConexao();
        conexaobd.executaSql(sql);
        
        
        try {
            conexaobd.rs.first();
            
            do{
                //preenchendo tabela
                Livro lv = new Livro();
                
                lv.setId(conexaobd.rs.getInt("id"));
                lv.setTitulo(conexaobd.rs.getString("titulo"));
                lv.setAutor(conexaobd.rs.getString("autor"));
                lv.setAno(conexaobd.rs.getInt("ano"));
                lv.setEstado(conexaobd.rs.getString("estado"));
                lv.setDisponivel(conexaobd.rs.getString("disponivel"));
                
                
                dados.add(lv);
                                     
            } while (conexaobd.rs.next());
            
        } catch (SQLException ex){
            
        }
        return dados;
        
    }
    //botao excluir tem a funcao update dos arquivos, nao exclui apenas nao e listado na tela.

    /**
     *
     * @param livros
     * @throws java.sql.SQLException
     */
        public void excluirLivros(Livro livros) throws SQLException{
        
            String sqlQuery= "UPDATE livros SET status= 'I' WHERE id = ?";
        
        try(PreparedStatement consulta = conexaobd.abrirConexao() .prepareStatement(sqlQuery)) {
            consulta.setInt(1,livros.getId());
            consulta.execute();
            consulta.close();
            conexaobd.fecharConexao();
            
        }
    }
        
        
         public void atualizarLivros(Livro livros) throws SQLException{
        String sqlQuery= "UPDATE livros SET Titulo= ?, Autor=? WHERE id = ?";
        
        try(PreparedStatement consulta = conexaobd.abrirConexao() .prepareStatement(sqlQuery)) {
            consulta.setString(1, livros.getTitulo());
            consulta.setString(2, livros.getAutor());
            consulta.setInt(3,livros.getId());
            
            consulta.execute();
            consulta.close();
            conexaobd.fecharConexao();
        }
    }
    
}
