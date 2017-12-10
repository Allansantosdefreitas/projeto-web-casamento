package br.com.ifpe.tads.projetoCasamentoWeb.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Despesa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.DespesaRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DespesaTest {

	private Despesa despesa = new Despesa();

	public DespesaTest() {
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
	public void a_inserirDespesaValidoEM() {
		DespesaRepository despesaRepository = new DespesaRepository();

		despesa = preencherDespesa();

		despesaRepository.inserir(despesa);

		assertNotNull(despesa);
	}

	@Ignore
	@Test
	public void b_atualizarDespesaValidoEM() {
		DespesaRepository despesaRepository = new DespesaRepository();

		despesa = despesaRepository.buscar(4L);

		despesa.setDespesaAtual(2000D);
		despesa.setDespesaPrevista(20000D);
		
		despesaRepository.atualizar(despesa);

		assertNotNull(despesa);

	}

	@Test
	public void c_consultarDespesaValidoEM() {
		DespesaRepository despesaRepository = new DespesaRepository();

		despesa = despesaRepository.buscar(4L);
		assertNotNull(despesa);

	}

	@Ignore
	@Test
	public void d_deletarDespesaValidoEM() {
		DespesaRepository despesaRepository = new DespesaRepository();

		despesa = despesaRepository.buscar(5L);

		despesaRepository.deletar(despesa);

		despesa = despesaRepository.buscar(5L);

		assertNull(despesa);
	}

	private static Despesa preencherDespesa() {

		// Preenchendo attrs
		Despesa despesa = new Despesa();
		despesa.setDespesaAtual(0D);
		despesa.setDespesaPrevista(0D);
		
		return despesa;
	}

}
