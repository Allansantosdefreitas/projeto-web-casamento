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

import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicoTest {


	private Servico servico = new Servico();

	public ServicoTest() {
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
	public void a_inserirServicoValidoEM() {
		ServicoRepository servicoRepository = new ServicoRepository();

		servico = preencherServico();

		servicoRepository.inserir(servico);

		assertNotNull(servico);
	}

	@Ignore
	@Test
	public void b_atualizarServicoValidoEM() {
		ServicoRepository servicoRepository = new ServicoRepository();

		servico = servicoRepository.buscar(22L);

		servico.setTitulo("Buffet");
		servico.setDescricao("Buffet incluindo 10 garçons e doces e salgados");
		servico.setPreco(500F);

		Boolean statusDisponibilizado = false;
		servico.setStatusDisponibilizado(statusDisponibilizado);

		servicoRepository.atualizar(servico);

		assertNotNull(servico);

	}

	@Ignore
	@Test
	public void c_consultarServicoValidoEM() {
		ServicoRepository servicoRepository = new ServicoRepository();

		servico = servicoRepository.buscar(22L);
		assertNotNull(servico);

	}

	@Ignore
	@Test
	public void d_deletarServicoValidoEM() {
		ServicoRepository servicoRepository = new ServicoRepository();

		servico = servicoRepository.buscar(21L);

		servicoRepository.deletar(servico);

		servico = servicoRepository.buscar(21L);

		assertNull(servico);
	}

	private static Servico preencherServico() {

		// Preenchendo attrs
		Servico servico = new Servico();
		servico.setTitulo("Buffet");
		servico.setDescricao("Buffet incluindo 25 garçons, entradas, prato principal e sobremsas");
		servico.setPreco(1000F);

		Boolean statusDisponibilizado = true;
		servico.setStatusDisponibilizado(statusDisponibilizado);

		return servico;
	}

}
