package br.senac.admeletronicos.bd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class BancoDados {
    
    private Connection conexao; //Atributo
    //Metodo de Conexão ao Banco de Dados
    public void conectar(){
        try{
            
            System.out.println("Iniciando conexão ao banco de dados...");
            Class.forName("com.mysql.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/admeletronicos","root","");//String de Conexão
            System.out.println("SUCESSO DE CONEXÃO");
        } catch (SQLException ex){
            System.out.println("Falha: não conseguiu conectar!!");
        } catch (ClassNotFoundException ex){
            System.out.println("Falha: não encontriu a classe de conexão!!");
        }
    }
    
    public void desconectar(){
        try {
            if(conexao != null && !conexao.isClosed())
            { conexao.close();
                System.out.println("Desconectado com sucesso");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar "+ex.getMessage());
        }
    }
    public Connection getConexao(){
        return conexao;
    }
}
