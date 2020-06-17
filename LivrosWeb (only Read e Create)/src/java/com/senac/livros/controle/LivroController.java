/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.livros.controle;

import com.senac.livros.modelo.Livro;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe responsável por gerenciar os End-points da aplicação, utilizando os 
 * métodos da classe LivrosCRUD.
 * @author eduardo.reis
 */
@Controller
public class LivroController {

    /**
     * Redireciona o programa para a tela de cadastro.
     * @return um String que direcionará o programa para a URI /cadastro
     */
    @RequestMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
    
    /**
     * Salva um novo livro no banco dados.
     * @param titulo recebe um String com o título do livro
     * @param autor recebe um String com o nome do autor do livro
     * @param ano recebe um Integer com o ano de lançamento do livro
     * @param estado recebe um String com o estado de conservação do livro
     * @param disponivel recebe um boolean com a disponibilidade do livro.
     * @return um String para redirecionar à tela pós-cadastro
     * @throws SQLException necessaria para os métodos de conexão com o banco
     * de dados
     */
    @RequestMapping("/cadastro-salvar")
    public String salvar(@RequestParam(required = false, value = "titulo") String titulo,
            @RequestParam(required = false, value = "autor") String autor,
            @RequestParam(required = false, value = "ano") Integer ano,
            @RequestParam(required = false, value = "estado") String estado,
            @RequestParam(required = false, value = "disponivel") boolean disponivel) throws SQLException {
       LivroCRUD livroCRUD = new LivroCRUD();
       Livro novoLivro = new Livro();
       novoLivro.setTitulo(titulo);
       novoLivro.setAutor(autor);
       novoLivro.setAnoLancamento(ano);
       novoLivro.setEstadoConservacao(estado);
       novoLivro.setDisponivel(disponivel);
       livroCRUD.cadastrar(novoLivro);
       
       return "cadastro-salvar";
    }
    
    /**
     * Adiciona os atributos recebidos do arquivo.jsp à um ArrayList, e invoca o
     * método de listagem dos livros cadastrados no banco de dados.
     * @param model recebe a variável criada no .jsp com a lista iterada de atri-
     * butos de Livro
     * @return um String que redireciona para a URI '/lista'
     */
    @RequestMapping("/lista")
    public String listar(Model model) {
        LivroCRUD livroCRUD = new LivroCRUD();
        ArrayList<Livro> livrosCadastrados = livroCRUD.listaTodos();
        model.addAttribute("listaLivros", livrosCadastrados);
        return "livros";
    }
    /**
     * Exibe a página principal do programa.
     * @return um String que redireciona para a URI '/index'
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
