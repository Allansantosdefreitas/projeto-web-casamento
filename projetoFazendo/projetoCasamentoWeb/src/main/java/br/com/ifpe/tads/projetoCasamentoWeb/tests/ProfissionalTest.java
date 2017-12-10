package br.com.ifpe.tads.projetoCasamentoWeb.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Profissional;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ProfissionalRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfissionalTest {


	private Profissional profissional = new Profissional();

	public ProfissionalTest() {
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
	public void a_inserirProfissionalValidoEM() {
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();

		profissional = preencherProfissional();

		profissionalRepository.inserir(profissional);

		assertNotNull(profissional);
	}

	
	@Ignore
	@Test
	public void b_atualizarProfissionalValidoEM() {
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();

		profissional = profissionalRepository.buscar(25L);

		profissional.setEmail("michael@gmail.com");
		profissional.setLogin("michael");
		profissional.setNome("Michael");
		profissional.setSenha("michael123");
		
		/* Na atualização, põe o serviço na lista do profissional e põe no servio o id do profissional */
		List<Servico> listaServicos = new ArrayList<Servico>();
		ServicoRepository servicoRepository = new ServicoRepository();
		
		Servico servico = servicoRepository.buscar(11L);
//		servico.setProfissional(profissional);
		
		listaServicos.add(servico);
		profissional.setServicos(listaServicos);
		
		profissionalRepository.atualizar(profissional);

		assertNotNull(profissional);

	}

	@Ignore
	@Test
	public void c_consultarProfissionalValidoEM() {
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();

		profissional = profissionalRepository.buscar(22L);
		assertNotNull(profissional);

	}

	@Ignore
	@Test
	public void d_deletarProfissionalValidoEM() {
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();

		profissional = profissionalRepository.buscar(21L);

		profissionalRepository.deletar(profissional);

		profissional = profissionalRepository.buscar(21L);

		assertNull(profissional);
	}

	private static Profissional preencherProfissional() {

		// Preenchendo attrs
		Profissional profissional = new Profissional();
		
		profissional.setEmail("charlie@gmail.com");
		profissional.setLogin("charlie");
		profissional.setNome("Charlie");
		profissional.setSenha("charlie123");
		
		/* Não no cadastro, só nas atualizações. Só depois que o profissional se cadastra, ele cadastra serviços */
		//List<Servico> listaServicos = new ArrayList<Servico>();
		
		return profissional;
	}

}
