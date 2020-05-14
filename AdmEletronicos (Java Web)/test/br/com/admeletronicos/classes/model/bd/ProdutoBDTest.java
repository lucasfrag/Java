/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.admeletronicos.classes.model.bd;

import br.com.admeletronicos.classes.model.ProdutoModel;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson
 */
public class ProdutoBDTest {
    
    public ProdutoBDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of excluirProduto method, of class ProdutoBD.
     */
    @Test
    public void testExcluirProduto() {
        System.out.println("excluirProduto");
        ProdutoModel produto = null;
        ProdutoBD instance = new ProdutoBD();
        instance.excluirProduto(produto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarProduto method, of class ProdutoBD.
     */
    @Test
    public void testAtualizarProduto() {
        System.out.println("atualizarProduto");
        ProdutoModel produtoModel = null;
        ProdutoBD instance = new ProdutoBD();
        instance.atualizarProduto(produtoModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserirProduto method, of class ProdutoBD.
     */
    @Test
    public void testInserirProduto() {
        System.out.println("inserirProduto");
        ProdutoModel produto = null;
        ProdutoBD instance = new ProdutoBD();
        instance.inserirProduto(produto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProdutoPorId method, of class ProdutoBD.
     */
    @Test
    public void testBuscarProdutoPorId() {
        System.out.println("buscarProdutoPorId");
        int id = 0;
        ProdutoBD instance = new ProdutoBD();
        ProdutoModel expResult = null;
        ProdutoModel result = instance.buscarProdutoPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProdutosPorNomeFabricante method, of class ProdutoBD.
     */
    @Test
    public void testBuscarProdutosPorNomeFabricante() {
        System.out.println("buscarProdutosPorNomeFabricante");
        String nome = "";
        String fabricante = "";
        ProdutoBD instance = new ProdutoBD();
        List<ProdutoModel> expResult = null;
        List<ProdutoModel> result = instance.buscarProdutosPorNomeFabricante(nome, fabricante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProdutos method, of class ProdutoBD.
     */
    @Test
    public void testBuscarProdutos() {
        System.out.println("buscarProdutos");
        ProdutoBD instance = new ProdutoBD();
        List<ProdutoModel> expResult = null;
        List<ProdutoModel> result = instance.buscarProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
