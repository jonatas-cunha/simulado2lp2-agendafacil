package agendafacil;

import java.util.ArrayList;
import java.util.List;

public class EventoController {
	private List<Evento> eventos;
	
	private int iEventos;
	
	public EventoController() {
		this.eventos = new ArrayList<Evento>();
	}
	
	/*
	 * int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes);

		int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao);
		
		int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao);
		
		boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento);
		
		String exibirDetalhesEvento(int idEvento);
	 */
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		Evento e = new Palestra(titulo, descricao, data, maxParticipantes);
		eventos.add(e);
		return iEventos++;
	};
	
	
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		Evento e = new Workshop(titulo, descricao, data, maxParticipantes, duracao);
		eventos.add(e);
		return iEventos++;
	};
	
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		Evento e = new OficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificacao);
		eventos.add(e);
		return iEventos++;
	};
	
	public boolean inscreverParticipanteEmEvento(Estudante e, int idEvento) {
		Evento evento = eventos.get(idEvento);
		if (evento != null) {
			evento.inscreverParticipante(e);
			e.setPontuacao(evento.gerarPontuacao());
			return true;
		}
		
		return false;
	};
	
	public String exibirDetalhesEvento(int idEvento) {
		return this.eventos.get(idEvento).toString();
	};
}
