package agendafacil;

public class Palestra extends Evento {
	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}
	
	@Override
	public int gerarPontuacao() {
		return 2;
	};
}
