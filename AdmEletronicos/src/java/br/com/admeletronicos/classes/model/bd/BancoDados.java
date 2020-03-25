package br.com.admeletronicos.classes.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
    
    public Connection obterConexao() throws SQLException {
        
        Connection conexao = null;
        
        try {            
            
            //Registrar o driver para evitar o erro:
            //No suitable drivers found for jdbc:MySql.
            //http://www.devmedia.com.br/forum/nao-consigo-gravar-no-banco-usando-jdbc-em-projeto-web/395387
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            //A String de conexão contém para tratar encoding: useUnicode=true&characterEncoding=utf-8
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/adm_eletronicos?useUnicode=true&characterEncoding=utf-8", "root", "");            
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());            
            System.out.println("Ocorreu um erro na conexão com o banco de dados");
            e.printStackTrace();
        } 
        
        return conexao;
    }    
    
    
    public void fecharConexao(Connection conexao){        
        try {
            if(conexao != null){
                conexao.close();
            }            
        } catch (SQLException ex) {
            System.out.println("Ocorreu erro ao fechar a conexão.");
        }   
    }
    
    public void fecharPreparedStatement(PreparedStatement ps){        
        try {
            if(ps != null) {
                ps.close();
            }            
        } catch (SQLException ex) {
            System.out.println("Ocorreu erro ao fechar o PreparedStatement.");
        }   
    }    
    
    public void fecharStatement(Statement st){        
        try {
            if(st != null){
                st.close();
            }            
        } catch (SQLException ex) {
            System.out.println("Ocorreu erro ao fechar o Statement.");
        }   
    }    
    
    
}
