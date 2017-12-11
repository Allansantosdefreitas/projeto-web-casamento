package br.com.ifpe.tads.projetoCasamentoWeb.repository;

public class FabricaRepository {

	private static FabricaRepository INSTANCIA;

	public FabricaRepository() {

	}

	public static FabricaRepository getInstance() {
		
		if(INSTANCIA == null) {
			INSTANCIA = new FabricaRepository();
		}
		
		return INSTANCIA;
	}
	
	public static CasamentoRepository CasamentoRepository() {
		return new CasamentoRepository();
	}

	public static ConjugeRepository ConjugeRepository() {
		return new ConjugeRepository();
	}

	public static ConvidadoRepository ConvidadoRepository() {
		return new ConvidadoRepository();
	}

	public static ConviteRepository ConviteRepository() {
		return new ConviteRepository();
	}

	public static DespesaRepository DespesaRepository() {
		return new DespesaRepository();
	}

	public static ProfissionalRepository ProfissionalRepository() {
		return new ProfissionalRepository();
	}

	public static ServicoRepository ServicoRepository() {
		return new ServicoRepository();
	}

	public static TarefaRepository TarefaRepository() {
		return new TarefaRepository();
	}

	public static UsuarioRepository UsuarioRepository() {
		return new UsuarioRepository();
	}
}
