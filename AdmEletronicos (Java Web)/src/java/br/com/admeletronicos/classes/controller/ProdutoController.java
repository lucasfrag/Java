package br.com.admeletronicos.classes.controller;

import br.com.admeletronicos.classes.model.ProdutoModel;
import br.com.admeletronicos.classes.model.bd.ProdutoBD;
import java.sql.SQLException;
import java.util.*;
import static javax.ws.rs.core.Response.status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {
    
    ProdutoBD produtoDB = new ProdutoBD();

    //Qualquer URL que não especifica o método, envia para a página inicial
    @RequestMapping("/")
      public String index() {
        return "index";
    }
  
    //Tela de cadastro de produtos
    @RequestMapping("novoProduto")
      public String form() {
        return "cadastrarProduto";
    }
      
  
    //Tela de sucesso de cadastro de produtos  
    @RequestMapping("cadastrarProduto")
        public String adicionar(ProdutoModel produto) {    
            produtoDB.inserirProduto(produto);
            return "produtoAdicionado";
    }
        
    //Listar todos os produtos    
    @RequestMapping("listarProdutos")
    public String listar(Model model) {      
      List<ProdutoModel> produtos = produtoDB.buscarProdutos(); 
      model.addAttribute("produtos", produtos);
      return "listarProdutos";
    }        
        
    
    //Link remover produto
    @RequestMapping("removerProduto")
    public String remover(@RequestParam("id") int id) 
    throws SQLException {   
        ProdutoBD produtoB = new ProdutoBD();
        ProdutoModel l = new ProdutoModel();
        l.setId(id);
        produtoB.excluirProduto(l);
        
      return "redirect:listarProdutos";
    }    
    
    //Encaminha para a tela de edição de produto
    @RequestMapping("mostrarProduto")
    public String mostrar(int id, Model model) {      
      model.addAttribute("produto", produtoDB.buscarProdutoPorId(id));
      return "mostrarProduto";
    }    
    
    //Realiza a alteração no produto (update no banco de dados)
    @RequestMapping("alterarProduto")
    public String alterar(ProdutoModel produtoModel) {      
      produtoDB.atualizarProduto(produtoModel);
      return "redirect:listarProdutos";
    }   
    
    
    @RequestMapping("filtrarProdutos")
    public String buscarComFiltros(String nome, String fabricante, Model model) {      
      model.addAttribute("produtos", produtoDB.buscarProdutosPorNomeFabricante(nome, fabricante));      
      return "listarProdutos";
    }       
    
}
