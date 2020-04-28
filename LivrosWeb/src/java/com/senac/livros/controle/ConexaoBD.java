/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.livros.controle;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


/**
 *
 * @author vanessa
 */
public class ConexaoBD{
    
     private Connection conexao; //atributo
     public ResultSet rs;
        
//metodo de conexao ao banco de dados
public  ConexaoBD() {
    try {
         Class.forName("com.mysql.jdbc.Driver");
         conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/adm_eletronicos","root","");//String de conexao
            System.out.println("Sucesso na conexao");
        }catch (ClassNotFoundException ex) {
            System.out.println("Falha:nao encontrou a classe de conexao");
        }catch (SQLException ex){
            System.out.println("Falha: nao conseguiu conectar");
        }
}
public Connection abrirConexao () {
    return conexao;
}

public void fecharConexao() {
    try {
           conexao.close();
          }
    
    catch (Exception ex) {
        System.err.println("Erro ao desconectar." + ex.getMessage());
    }
}




   public void executaSql(String sql) {
        Statement stm;

        try {
            stm = conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
       }
        catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao recuperar os dados. \\n ExecutaSql:" + ex);
            
        }
        
    
}
   
}
