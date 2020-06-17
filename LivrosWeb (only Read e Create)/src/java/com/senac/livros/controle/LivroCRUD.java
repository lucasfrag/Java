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
 * Classe responsável pela regra de negócio do sistema, ela contém as operações
 * CRUD do sistema.
 * @author eduardo.reis
 */
public class LivroCRUD {
    
    ConexaoDB conexaoDb = new ConexaoDB();
    Livro livro = new Livro();
    
    /**
     * Cadastra um novo livro no banco de dados.
     * @param livro Objeto da classe modelo Livro
     * @throws SQLException necessário para o funcionamento para os métodos de 
     * conexão
     */
    public void cadastrar(Livro livro) throws SQLException {
        
        String sql = "insert into livros(titulo, autor, ano_lancamento, estado_conservacao, disponivel) values(?, ?, ?, ?, ?)";
        
        try {
            conexaoDb.connection.setAutoCommit(false);
            PreparedStatement preparedStatement = conexaoDb.abrirConexao().prepareStatement(sql);
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAnoLancamento());
            preparedStatement.setString(4, livro.getEstadoConservacao());
            preparedStatement.setBoolean(5, livro.isDisponivel());
            preparedStatement.executeUpdate();
            
            conexaoDb.connection.commit();
            
        } catch(HeadlessException | SQLException ex) {
            
            if(conexaoDb.connection != null) {
                try {
                System.out.println("Rollback efetuado na transação.");
                conexaoDb.connection.rollback();
                } catch(SQLException sqle) {
                    System.out.println("Erro na transação: " + sqle);
                }
            }
        } finally {
            conexaoDb.connection.setAutoCommit(true);
        }
    }
    /**
     * Retorna uma lista de todos os livros cadastrados no banco de dados.
     * @return um ArrayList de todos os livros
     */
    public ArrayList<Livro> listaTodos() {
        
        String sql = "select * from livros";
        
        ArrayList<Livro> dados = new ArrayList<>();
        conexaoDb.abrirConexao();
        conexaoDb.executaSql(sql);

        try {
            conexaoDb.resultSet.first();
            do {
                Livro livro = new Livro();
                livro.setId(conexaoDb.resultSet.getInt("id"));
                livro.setTitulo(conexaoDb.resultSet.getString("titulo"));
                livro.setAutor(conexaoDb.resultSet.getString("autor"));
                livro.setAnoLancamento(conexaoDb.resultSet.getInt("ano_lancamento"));
                livro.setEstadoConservacao(conexaoDb.resultSet.getString("estado_conservacao"));
                livro.setDisponivel(conexaoDb.resultSet.getBoolean("disponivel"));
                
                dados.add(livro);
            } while(conexaoDb.resultSet.next());
        } catch(SQLException sqle) {
        }
        return dados;
    }
}
