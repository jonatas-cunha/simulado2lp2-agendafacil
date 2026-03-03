package agendafacil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Testes {

	private EstudanteController estc;
	private EventoController evtc;
	
	@BeforeEach
	void setUp() throws Exception {
		this.estc = new EstudanteController();
		this.evtc = new EventoController();
	}

	@Test
	void testCadastrarEstudanteJaExistente() {
		estc.cadastrarEstudante("José Maria Silva", "josemaria2026@gmail.com");
		assertThrows(IllegalArgumentException.class, () -> {
			estc.cadastrarEstudante("Maria José Silva", "josemaria2026@gmail.com");
		});
	}
	
	@Test
	void testInscreverParticipanteJaInscritoEmEvento() {
		Estudante e = new Estudante("José Maria Silva", "josemaria2026@gmail.com");
		evtc.cadastrarPalestra("IA", "Impactos da IA generativa", "03/03/2026", 100);
		evtc.inscreverParticipanteEmEvento(e, 0);
		assertThrows(IllegalArgumentException.class, () -> {
			evtc.inscreverParticipanteEmEvento(e, 0);
		});
	}
	
	@Test
	void testInscreverEmEventoLotado() {
		Estudante e1 = new Estudante("José Maria Silva", "josemaria2026@gmail.com");
		Estudante e2 = new Estudante("Joãozin", "joaozinnn@gmail.com");
		evtc.cadastrarPalestra("IA", "Impactos da IA generativa", "03/03/2026", 1);
		evtc.inscreverParticipanteEmEvento(e1, 0);
		assertThrows(IllegalArgumentException.class, () -> {
			evtc.inscreverParticipanteEmEvento(e2, 0);
		});
	}

}
