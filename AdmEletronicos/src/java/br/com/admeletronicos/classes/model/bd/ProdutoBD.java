package br.com.admeletronicos.classes.model.bd;

import br.com.admeletronicos.classes.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoBD {

    public void excluirProduto(ProdutoModel produto){
        BancoDados bd = new BancoDados();
        PreparedStatement stmt = null;
        Connection conexao = null;
        String sql = "UPDATE PRODUTO SET status = 'I' WHERE id = ?";

        try {            

            conexao = bd.obterConexao();
            
            stmt = conexao.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, produto.getId());            

            // executa
            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao excluir o produto.");

        } finally {

            //fechar a conexão e o prepared statement
            bd.fecharConexao(conexao);
            bd.fecharPreparedStatement(stmt);

        }        
    }    
    
    public void atualizarProduto(ProdutoModel produtoModel){
        BancoDados bd = new BancoDados();
        PreparedStatement stmt = null;
        Connection conexao = null;
        String sql = "UPDATE PRODUTO SET nome = ?, fabricante = ?, status = ? WHERE id = ?";
        
        try {            
            
            conexao = bd.obterConexao();
            
            stmt = conexao.prepareStatement(sql);

            //Tratamento encoding. Evitar algo assim: Ã£oÃ§Ã¡Ã            
            String nome = new String(produtoModel.getNome().getBytes("ISO-8859-1"), "UTF-8");
            String fabricante = new String(produtoModel.getFabricante().getBytes("ISO-8859-1"), "UTF-8");
            String status = new String(produtoModel.getStatus().getBytes("ISO-8859-1"), "UTF-8");
            
            // seta os valores
            stmt.setString(1, nome);
            stmt.setString(2, fabricante);
            stmt.setString(3, status);
            stmt.setInt(4, produtoModel.getId());

            // executa
            stmt.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao atualizar o produto.");
            
        } finally {
            
            //fechar a conexão e o prepared statement
            bd.fecharConexao(conexao);
            bd.fecharPreparedStatement(stmt);
            
        }        
    }       
    
    public void inserirProduto(ProdutoModel produto) {
        BancoDados bd = new BancoDados();
        PreparedStatement stmt = null;
        Connection conexao = null;
        String sql = "INSERT INTO PRODUTO (nome, fabricante) VALUES (?,?)";
        
        try {            
            
            conexao = bd.obterConexao();
            // prepared statement para inserção
            stmt = conexao.prepareStatement(sql);

            //Tratamento encoding. Evitar algo assim: Ã£oÃ§Ã¡Ã
            String nome = new String(produto.getNome().getBytes("ISO-8859-1"), "UTF-8");
            String fabricante = new String(produto.getFabricante().getBytes("ISO-8859-1"), "UTF-8");

            // seta os valores
            stmt.setString(1, nome);
            stmt.setString(2, fabricante);

            // executa
            stmt.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao salvar o produto.");
            
        } finally {
            
            //fechar a conexão e o prepared statement
           // bd.fecharConexao(conexao);
            bd.fecharPreparedStatement(stmt);
            
        }        
    }    

        public ProdutoModel buscarProdutoPorId(int id){
        
        ProdutoModel produto = new ProdutoModel();
        
        BancoDados bd = new BancoDados();
        PreparedStatement pstmt = null;       
        Connection conexao = null;
        String sql = "SELECT ID, NOME, FABRICANTE, STATUS FROM PRODUTO WHERE id =  ?";
        
        try {            
            
            conexao = bd.obterConexao();            
            
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            
                       
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {               
                produto.setId(rs.getInt("ID"));
        	produto.setNome(rs.getString("NOME"));
                produto.setFabricante(rs.getString("FABRICANTE")); 
                produto.setStatus(rs.getString("STATUS"));
            }            
            

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao buscar o produto por id: " + id);
            
        } finally {
            
            //fechar a conexão e o prepared statement
            bd.fecharPreparedStatement(pstmt);
            bd.fecharConexao(conexao);            
            
        }        
        
        return produto;
    } 
        
    public List<ProdutoModel> buscarProdutosPorNomeFabricante(String nome, String fabricante){
        
        List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
        
        BancoDados bd = new BancoDados();
        Statement statement = null;
        Connection conexao = null;
        String sql = "SELECT * FROM PRODUTO WHERE 1 = 1 ";
        
        try {            
            
            conexao = bd.obterConexao();
          
            statement = conexao.createStatement();
            
            //Tratamento encoding. Evitar algo assim: Ã£oÃ§Ã¡Ã
            String nome2 = new String(nome.getBytes("ISO-8859-1"), "UTF-8");
            String fabricante2 = new String(fabricante.getBytes("ISO-8859-1"), "UTF-8");

            
            //Se preencheu o filtro de nome, concatenar na busca
            if(nome2 != null && !nome2.equals("")){
               sql = sql + " AND nome LIKE '%" + nome2 + "%'"; 
               //Exemplo: SELECT * FROM PRODUTO WHERE 1 = 1 AND nome like '%aaae%'
            }
            
            //Se preencheu o filtro de fabricante, concatenar na busca
            if(fabricante2 != null && !fabricante2.equals("")){
                sql = sql + " AND fabricante LIKE '%" + fabricante2 + "%'"; 
                //Exemplo: SELECT * FROM PRODUTO WHERE 1 = 1 AND fabricante like '%aaae%'
            }
            
            System.out.println("SQL a ser executado: " + sql);
            
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setId(rs.getInt("ID"));
        	produto.setNome(rs.getString("NOME"));
                produto.setFabricante(rs.getString("FABRICANTE"));
                produto.setStatus(rs.getString("STATUS"));
                
                listaProdutos.add(produto);
            }    
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao buscar os produtos por nome e fabricante.");
            
        } finally {
            
            //fechar a conexão e o prepared statement
            bd.fecharConexao(conexao);
            bd.fecharStatement(statement);
            
        }        
        System.err.println("- " + listaProdutos.size());
        return listaProdutos;
    }     
    
    public List<ProdutoModel> buscarProdutos(){
        
        List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
        
        BancoDados bd = new BancoDados();
        Statement statement = null;
        Connection conexao = null;
        String sql = "SELECT * FROM PRODUTO";
        
        try {            
            
            conexao = bd.obterConexao();

            statement = conexao.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setId(rs.getInt("ID"));
        	   produto.setNome(rs.getString("NOME"));
                produto.setFabricante(rs.getString("FABRICANTE"));
                produto.setStatus(rs.getString("STATUS"));
                
                listaProdutos.add(produto);
            }            
            

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu erro ao buscar os produtos.");
            
        } finally {
            
            //fechar a conexão e o prepared statement
            bd.fecharConexao(conexao);
            bd.fecharStatement(statement);
            
        }        
        
        return listaProdutos;
    }    
    
}
