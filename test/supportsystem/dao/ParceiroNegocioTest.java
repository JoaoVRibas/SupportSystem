/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.dao;

import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import supportsystem.models.ParceiroNegocio;

/**
 *
 * @author joao.vmr
 */
public class ParceiroNegocioTest {
    
     public ParceiroNegocioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
        
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");
        
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        //altere os números para produzir falhas
        
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        
    }

    @Test
    public void testValidaInsercao() {

        ParceiroNegocio parceiro = new ParceiroNegocio();
        ParceiroNegocioDAO parceiroDAO = new ParceiroNegocioDAO();
        
        parceiro.setNome_pn("");

        parceiro.setId_tipo_pn(3);

        String mensagem = parceiroDAO.validaInsercao(parceiro);
        String expResult = "É NECESSÁRIO MARCAR UM TIPO, PF OU PJ";
        
        
        assertEquals(expResult, mensagem);
        
        parceiro.setId_tipo_pn(2);
        mensagem = parceiroDAO.validaInsercao(parceiro);
        expResult = "É NECESSÁRIO INSERIR UM NOME";
        
        assertEquals(expResult, mensagem);
    }

}
