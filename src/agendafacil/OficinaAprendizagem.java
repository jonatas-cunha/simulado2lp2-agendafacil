package agendafacil;

public class OficinaAprendizagem extends Evento {
	private int duracaoHoras;
	private boolean certificacao;
	
	public OficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracaoHoras = duracao;
		this.certificacao = certificacao;
	}
	
	public String gerarCertificacao() {
		return "CERTIFICADO: Certificamos que este estudante participou do evento " + super.titulo + ", com duração de " + this.duracaoHoras + " horas.";
	}
	
	@Override
	public int gerarPontuacao() {
		if (certificacao) {
			return duracaoHoras + 10;
		}
		return duracaoHoras;
	};
}
