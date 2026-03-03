package agendafacil;

public class AgendaFacil {
	private EstudanteController estudanteController;
	private EventoController eventoController;
	
	public AgendaFacil() {
		this.estudanteController = new EstudanteController();
		this.eventoController = new EventoController();
	}
	
	public boolean cadastrarEstudante(String nome, String email) {
		return estudanteController.cadastrarEstudante(nome, email);
	};
	
	public String exibirEstudante(String email) {
		return estudanteController.exibirEstudante(email);
	};
	
	public String[] listarEstudantes() {
		return estudanteController.listarEstudantes();
	};
	
	
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		return eventoController.cadastrarPalestra(titulo, descricao, data, maxParticipantes);
	};
	
	
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		return eventoController.cadastrarWorkshop(titulo, descricao, data, maxParticipantes, duracao);
	};
	
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		return eventoController.cadastrarOficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificacao);
	};
	
	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento) {
		return eventoController.inscreverParticipanteEmEvento(estudanteController.getEstudante(emailParticipante), idEvento);
	};
	
	public String exibirDetalhesEvento(int idEvento) {
		return eventoController.exibirDetalhesEvento(idEvento);
	};
	
}
