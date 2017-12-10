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

import br.com.ifpe.tads.projetoCasamentoWeb.model.Convidado;
import br.com.ifpe.tads.projetoCasamentoWeb.model.StatusConvidado;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConvidadoRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvidadoTest {


	private Convidado convidado = new Convidado();

	public ConvidadoTest() {
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
	public void a_inserirConvidadoValidoEM() {
		ConvidadoRepository convidadoRepository = new ConvidadoRepository();

		convidado = preencherConvidado();

		convidadoRepository.inserir(convidado);

		assertNotNull(convidado);
	}

	@Ignore
	@Test
	public void b_atualizarConvidadoValidoEM() {
		ConvidadoRepository convidadoRepository = new ConvidadoRepository();

		convidado = convidadoRepository.buscar(22L);

		convidado.setEmail("chekov@gmail.com");
		convidado.setLogin("chekov");
		convidado.setSenha("pchekov");
		convidado.setNome("Chekov");
	
		convidado.setStatusConvidado(StatusConvidado.CONFIRMADO);
		

		convidadoRepository.atualizar(convidado);

		assertNotNull(convidado);

	}

	@Ignore
	@Test
	public void c_consultarConvidadoValidoEM() {
		ConvidadoRepository convidadoRepository = new ConvidadoRepository();

		convidado = convidadoRepository.buscar(22L);
		assertNotNull(convidado);

	}

	@Ignore
	@Test
	public void d_deletarConvidadoValidoEM() {
		ConvidadoRepository convidadoRepository = new ConvidadoRepository();

		convidado = convidadoRepository.buscar(21L);

		convidadoRepository.deletar(convidado);

		convidado = convidadoRepository.buscar(21L);

		assertNull(convidado);
	}

	private static Convidado preencherConvidado() {

		// Preenchendo attrs
		Convidado convidado = new Convidado();
		
		convidado.setEmail("scott@gmail.com");
		convidado.setLogin("scott");
		convidado.setSenha("mscott");
		convidado.setNome("Scott");
	
		convidado.setStatusConvidado(StatusConvidado.PENDENTE);
		
		return convidado;
	}

}
