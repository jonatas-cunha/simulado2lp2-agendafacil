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
	
	
	
	@Test
	void testCalcularPontuacaoPalestra() {
		Palestra p = new Palestra("IA", "Impactos da IA generativa", "03/03/2026", 100);
		assertEquals(p.gerarPontuacao(), 2);
	}
	
	@Test
	void testCalcularPontuacaoOficinaAprendizagem() {
		OficinaAprendizagem oa = new OficinaAprendizagem("Aprendendo com a IA", "Utilidades do Gemini", "03/03/2026", 100, 4, true);
		assertEquals(oa.gerarPontuacao(), 14);
	}
	
	@Test
	void testCalcularPontuacaoWorkShop() {
		Workshop ws = new Workshop("Apresentações de projetos com IA", "ChatGPT, Gemini, e IAs em alta", "03/03/2026", 100, 8);
		assertEquals(ws.gerarPontuacao(), 8);
	}
	
	@Test
	void testRankearEstudantesPorPontuacao() {
		evtc.cadastrarPalestra("IA", "Impactos da IA generativa", "03/03/2026", 100);
		evtc.cadastrarOficinaAprendizagem("Aprendendo com a IA", "Utilidades do Gemini", "03/03/2026", 100, 4, true);
		evtc.cadastrarWorkshop("Apresentações de projetos com IA", "ChatGPT, Gemini, e IAs em alta", "03/03/2026", 100, 8);
		
		Estudante e1 = new Estudante("CDE da Silva", "emailgenerico@gmail.com");
		estc.cadastrarEstudante("ABC da Silva", "emailgenerico@gmail.com");
		estc.cadastrarEstudante("BCD da Silva", "emailgenerico@gmail.com");
		estc.cadastrarEstudante("ABB da Silva", "emailgenerico@gmail.com");

		
		assertThrows(IllegalArgumentException.class, () -> {
			estc.cadastrarEstudante("Maria José Silva", "josemaria2026@gmail.com");
		});
	}

}
