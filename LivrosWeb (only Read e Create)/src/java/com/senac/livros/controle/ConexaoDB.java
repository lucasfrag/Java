/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.livros.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela conexão com o banco de dados.
 * @author eduardo.reis
 */
public class ConexaoDB {
        
    public Connection connection = null;
    public ResultSet resultSet;
    
    /**
     * Este é o construtor padrão da classe ConexaoDB, através dessa implementação,
     * é realizada a conexão com o banco de dados MySQL. 
     */
    public ConexaoDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            
            System.out.println("SUCESSO NA CONEXÃO");
        } catch(ClassNotFoundException cnfe) {
            System.out.println("Falha: não encontrou a classe de conexão.");
        } catch(SQLException sqle) {
            System.out.println("Falha: não conseguiu conectar.");
        }
    }
    /**
     * Retorna uma nova conexão com o banco de dados
     * @return uma nova conexão com o banco.
     */
    public Connection abrirConexao() {
        return connection;
    }
    
    /**
     * Fecha uma conexão com o banco de dados que está aberta.
     */
    public void fecharConexao() {
        try {
            connection.close();
        } catch(SQLException sqle) {
            System.out.println("Erro ao desconectar: " + sqle.getMessage());
        }
    }
    
    /**
     * Executa um bloco de código SQL, como por exemplo uma Query de INSERT.
     * @param sql código sql que será executado
     */
    public void executaSql(String sql) {
        
        Statement statement;
        
        try {
            statement = connection.createStatement(resultSet.TYPE_SCROLL_SENSITIVE, resultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(sql);
        } catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar os dados. \n ExecutaSql: " + sqle);
        }
    }
}
