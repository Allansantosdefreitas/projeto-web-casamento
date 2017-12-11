package br.com.ifpe.tads.projetoCasamentoWeb.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CasamentoTest {


	

    private Casamento casamento = new Casamento();
    private Casamento casamentoGlobal = new Casamento();
    
    public CasamentoTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void a_inserirCasamentoValidoEM() {
    	CasamentoRepository casamentoRepository = new CasamentoRepository();
    	
        casamento = preencherCasamento();
        
        casamentoRepository.inserir(casamento);
        
        casamentoGlobal = casamento;
        
        assertNotNull(casamento);
    }
    
    
    @Test
    public void a_inserirCasamentoInvalidoEM() {
    	CasamentoRepository casamentoRepository = new CasamentoRepository();
    	
        casamento = preencherCasamentoInvalido();
        
        casamentoRepository.inserir(casamento);
        
        //casamentoGlobal = casamento;
        
        assertNull(casamento);
    }


    /* Tem que ajeitar aqui..falta pegar o id da última entidade inserida para
        atualizar e não criar uma nova entidade */
    @Test
    public void b_atualizarCasamentoValidoEM() {
    	CasamentoRepository casamentoRepository = new CasamentoRepository();
    	
    	//casamento = casamentoGlobal;
    	
        //casamento = casamentoRepository.buscar(casamento.getIdCasamento());

    	
   	 	casamento = casamentoRepository.buscar( 12L );

    	casamento.setNome("OUR Marriage with love");
        
        casamentoRepository.atualizar(casamento);
        
        assertNotNull(casamento);
            
    }

//
    @Test
    public void c_consultarCasamentoValidoEM() {
    	CasamentoRepository casamentoRepository = new CasamentoRepository();
    	
        casamento = casamentoRepository.buscar(1L);
        assertNotNull(casamento);

    }
    
    @Test
    public void d_deletarCasamentoValidoEM() {
    	CasamentoRepository casamentoRepository = new CasamentoRepository();
    	
    	 casamento = casamentoRepository.buscar( 19L );

    	casamentoRepository.deletar(casamento);
    	
        casamento = casamentoRepository.buscar( 19L );

        assertNull(casamento);
    }

    private static Casamento preencherCasamento() {

        // Preenchendo attrs
        Casamento casamento = new Casamento();
        casamento.setNome("Marriage of OUR Dreams");

        return casamento;
    }
    
    private static Casamento preencherCasamentoInvalido() {

        // Preenchendo attrs
        Casamento casamento = new Casamento();
        casamento.setNome(null);

        return casamento;
    }


}
