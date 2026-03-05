package agendafacil;

import java.util.HashMap;
import java.util.Map;

public abstract class Evento {
	protected String titulo;
	protected String descricao;
	protected String data;
	protected int maxParticipantes;
	
	protected Map<String, Estudante> participantes;
	
	public Evento(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		
		this.participantes = new HashMap<String, Estudante>();
	}
	
	
	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", descricao=" + descricao + ", data=" + data + ", maxParticipantes="
				+ maxParticipantes + ", participantes=" + participantes + "]";
	}

	public boolean inscreverParticipante(Estudante e) {
		if (this.participantes.size() == maxParticipantes) {
			throw new IllegalArgumentException("O número máximo de vagas já foi atingido!");
		}
		
		if (this.participantes.get(e.getEmail()) != null) {
			throw new IllegalArgumentException("Esse participante já está inscrito no evento!");
		}
		
		participantes.put(e.getEmail(), e);
		return true;
	}
	
	public abstract int gerarPontuacao();
}
