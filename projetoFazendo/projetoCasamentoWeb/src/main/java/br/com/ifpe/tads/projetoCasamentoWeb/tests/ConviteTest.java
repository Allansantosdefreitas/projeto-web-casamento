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

import br.com.ifpe.tads.projetoCasamentoWeb.model.Convite;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConviteRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConviteTest {


	private Convite convite = new Convite();

	public ConviteTest() {
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
	public void a_inserirConviteValidoEM() {
		ConviteRepository conviteRepository = new ConviteRepository();

		convite = preencherConvite();

		conviteRepository.inserir(convite);

		assertNotNull(convite);
	}

	@Ignore
	@Test
	public void b_atualizarConviteValidoEM() {
		ConviteRepository conviteRepository = new ConviteRepository();

		convite = conviteRepository.buscar(22L);

		convite.setDestinatarios("peter@gmail.com");
		convite.setMensagem("Hi! You are invited to my wedding, at Agamenon Magalhaes avenue, 1557, "
				+ "19 PM in Dec 22, 2019.");

		conviteRepository.atualizar(convite);

		assertNotNull(convite);

	}

	@Ignore
	@Test
	public void c_consultarConviteValidoEM() {
		ConviteRepository conviteRepository = new ConviteRepository();

		convite = conviteRepository.buscar(22L);
		assertNotNull(convite);

	}

	@Ignore
	@Test
	public void d_deletarConviteValidoEM() {
		ConviteRepository conviteRepository = new ConviteRepository();

		convite = conviteRepository.buscar(21L);

		conviteRepository.deletar(convite);

		convite = conviteRepository.buscar(21L);

		assertNull(convite);
	}

	private static Convite preencherConvite() {

		// Preenchendo attrs
		Convite convite = new Convite();
		
		convite.setDestinatarios("allan.allan@gmail.com");
		convite.setMensagem("Olá! Você está convidado para o meu casamento. Será em 21/12/2019 na igreja A, às 19h "
				+ "da noite e a celebração será na Casa de Festas Ômega.");
		
		return convite;
	}

}
