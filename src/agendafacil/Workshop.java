package agendafacil;

public class Workshop extends Evento {
	private int duracaoHoras;
	
	public Workshop (String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracaoHoras = duracao;
	}
	
	@Override
	public double gerarPontuacao() {
		return this.duracaoHoras;
	};
}
