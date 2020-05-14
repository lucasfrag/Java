package br.senac.admeletronicos.bd;

import br.senac.admeletronicos.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class ProdutoBD {
    
    public void cadastrar(Produto p) throws SQLException{
        BancoDados bd = new BancoDados();
        bd.conectar();
        
        String sqlQuery = "INSERT INTO produtos (nome,fabricante) VALUES (?,?)";
        PreparedStatement consulta = bd.getConexao().prepareStatement(sqlQuery);
        consulta.setString(1, p.getNome());
        consulta.setString(2, p.getFabricante());
        
        consulta.execute();
        consulta.close();
        bd.desconectar();
    }
    
    public ArrayList<Produto> listarTodos() throws SQLException{
        BancoDados bd = new BancoDados();
        bd.conectar();
        
        String sqlSelect = "SELECT * FROM produtos";
        PreparedStatement consulta = bd.getConexao().prepareStatement(sqlSelect);
        ResultSet resultado = consulta.executeQuery();
        
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        while(resultado.next()){
            Produto p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setNome(resultado.getString("nome"));
            p.setFabricante(resultado.getString("fabricante"));
            produtos.add(p);
        }
        consulta.close();
        bd.desconectar();
        
        return produtos;
    }
}
