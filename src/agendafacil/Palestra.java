package agendafacil;

public class Palestra extends Evento {
	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}
	
	@Override
	public double gerarPontuacao() {
		return 2;
	};
}
