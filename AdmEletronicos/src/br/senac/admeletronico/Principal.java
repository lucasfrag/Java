package br.senac.admeletronico;

import br.senac.admeletronicos.model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Gabriel
 */
public class Principal {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Adm Eletronicos Desktop");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 600);
        janela.setVisible(true);
        
        JPanel painel = new JPanel();
        janela.add(painel);
        
        JButton botaoSair = new JButton("Sair");
        JButton botaoProdutos = new JButton("Produtos");
        
        painel.add(botaoProdutos);
        painel.add(botaoSair);
        
        botaoProdutos.addActionListener(new ActionListener(){
            @Override   
            public void actionPerformed(ActionEvent ae)  {
                ProdutoForm janelaProdutos = new ProdutoForm();
                janelaProdutos.setVisible(true);
            }
        });
        
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
}