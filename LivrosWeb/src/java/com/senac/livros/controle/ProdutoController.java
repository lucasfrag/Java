/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.senac.livros.controle;


import com.senac.livros.modelo.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author vanessa
 */
@Controller
public class ProdutoController {
    
    @RequestMapping("/cadastro")
    public String cadastro(Model model){
        
        return "cadastro";
    }
    
    //salvar a acao realizada de cadastro de um novo livro//
    //essa ação abre a pagina cadastro-salvar.jsp e serve para mostrar
    //que os dados foram salvos com sucesso

    /**
     *
     * @param titulo
     * @param autor
     * @param ano
     * @param estado
     * @param disponivel
          * @return
     * @throws java.sql.SQLException
     */
        @RequestMapping("/cadastro-salvar")
    public String salvar (
            @RequestParam("titulo") String titulo,
            @RequestParam("autor") String autor,
            @RequestParam("ano") int ano,
            @RequestParam("estado") String estado,
            @RequestParam("disponivel") String disponivel) throws SQLException{   
     
        
        ProdutoCRUD livroCRUD = new ProdutoCRUD();
        Produto novoLivro = new Produto();
        
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAno(ano);
        novoLivro.setEstado(estado);
        novoLivro.setDisponivel(disponivel);
       
        
        livroCRUD.cadastrar(novoLivro);
        
        return "cadastro-salvar";
        
    }
    
    //Essa acao abre a livro.jsp

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/livros")
    public String listar (Model model){
        
        ProdutoCRUD livroCRUD = new ProdutoCRUD();
        ArrayList<Produto> livrosCadastrados  = livroCRUD.listaTodos();
        model.addAttribute("listaLivros", livrosCadastrados);
        
        return "livros";
    }      
  
    @RequestMapping("/index")
    public String index (){
        return "index";
    }
 
    /**
     *
     * @param id
     * @param titulo
     * @param autor
     * @return
     * @throws SQLException
     */
    @RequestMapping("editarBD")
    public String salvar2 (@RequestParam("id") int id,
            @RequestParam("titulo") String titulo,
            @RequestParam("autor") String autor
            )throws SQLException{
        
        ProdutoCRUD livroB = new ProdutoCRUD();
        Produto l = new Produto();
        l.setId(id);
        l.setAutor(autor);
        l.setTitulo(titulo);
        livroB.atualizarLivros(l);
        return "index";
    }
    
    @RequestMapping("/editar")
    public String atual(Model model, int id, String autor, String titulo) {
        model.addAttribute("id", id);
        model.addAttribute("autor", autor);
        model.addAttribute("titulo", titulo);

        return "editar";
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping("removerProduto")
    public String excluir(@RequestParam("id") int id)
            throws SQLException {

        ProdutoCRUD livroB = new ProdutoCRUD();
        Produto l = new Produto();
        l.setId(id);
        livroB.excluirLivros(l);
        return "index";
    }
    
}