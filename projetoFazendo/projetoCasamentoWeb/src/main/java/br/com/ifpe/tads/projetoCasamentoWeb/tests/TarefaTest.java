package br.com.ifpe.tads.projetoCasamentoWeb.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.ifpe.tads.projetoCasamentoWeb.model.StatusTarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.TarefaRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TarefaTest {

	private Tarefa tarefa = new Tarefa();

	public TarefaTest() {
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
	public void a_inserirTarefaValidoEM() {
		TarefaRepository tarefaRepository = new TarefaRepository();

		tarefa = preencherTarefa();

		tarefaRepository.inserir(tarefa);

		assertNotNull(tarefa);
	}

	@Ignore
	@Test
	public void b_atualizarTarefaValidoEM() {
		TarefaRepository tarefaRepository = new TarefaRepository();

		tarefa = tarefaRepository.buscar(4L);

		// Preenchendo attrs
		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo("Encontrar um local");
		tarefa.setDescricao("Encontrar um local para a cerimônia após o casamento na igreja");
		tarefa.setStatus(StatusTarefa.CONCLUIDA);

		Calendar calendario = Calendar.getInstance();
		calendario.set(2017, 12, 29);
		tarefa.setData(calendario.getTime());

		tarefaRepository.atualizar(tarefa);

		assertNotNull(tarefa);

	}

	@Test
	public void c_consultarTarefaValidoEM() {
		TarefaRepository tarefaRepository = new TarefaRepository();

		tarefa = tarefaRepository.buscar(4L);
		assertNotNull(tarefa);

	}

	@Ignore
	@Test
	public void d_deletarTarefaValidoEM() {
		TarefaRepository tarefaRepository = new TarefaRepository();

		tarefa = tarefaRepository.buscar(5L);

		tarefaRepository.deletar(tarefa);

		tarefa = tarefaRepository.buscar(5L);

		assertNull(tarefa);
	}

	private static Tarefa preencherTarefa() {

		// Preenchendo attrs
		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo("Procurar Igreja");
		tarefa.setDescricao("Procurar uma igreja para a cerimônia religiosa");
		tarefa.setStatus(StatusTarefa.PENDENTE);

		Calendar calendario = Calendar.getInstance();
		calendario.set(2017, 12, 29);
		tarefa.setData(calendario.getTime());

		return tarefa;
	}

}
