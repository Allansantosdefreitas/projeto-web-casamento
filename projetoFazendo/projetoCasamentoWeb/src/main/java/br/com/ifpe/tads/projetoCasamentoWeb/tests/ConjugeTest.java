package br.com.ifpe.tads.projetoCasamentoWeb.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConjugeRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConjugeTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	private Conjuge conjuge = new Conjuge();

	public ConjugeTest() {
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
	public void a_inserirConjugeValidoEM() {
		ConjugeRepository conjugeRepository = new ConjugeRepository();

		conjuge = preencherConjuge();

		conjugeRepository.inserir(conjuge);

		assertNotNull(conjuge);
	}

	@Test
	public void b_atualizarConjugeValidoEM() {
		ConjugeRepository conjugeRepository = new ConjugeRepository();

		conjuge = conjugeRepository.buscar(22L);

		conjuge.setNome("Hilde Knag");
		conjuge.setEmail("hilde@gmail.com");
		conjuge.setLogin("hilde");
		conjuge.setSenha("hilde");

		conjugeRepository.atualizar(conjuge);

		assertNotNull(conjuge);

	}

	@Test
	public void c_consultarConjugeValidoEM() {
		ConjugeRepository conjugeRepository = new ConjugeRepository();

		conjuge = conjugeRepository.buscar(22L);
		assertNotNull(conjuge);

	}

	@Test
	public void d_deletarConjugeValidoEM() {
		ConjugeRepository conjugeRepository = new ConjugeRepository();

		conjuge = conjugeRepository.buscar(21L);

		conjugeRepository.deletar(conjuge);

		conjuge = conjugeRepository.buscar(21L);

		assertNull(conjuge);
	}

	private static Conjuge preencherConjuge() {

		// Preenchendo attrs
		Conjuge conjuge = new Conjuge();
		conjuge.setNome("Sofia Amundsen");
		conjuge.setEmail("sofia@gmail.com");
		conjuge.setLogin("sofia");
		conjuge.setSenha("sophie");

		return conjuge;
	}

}
