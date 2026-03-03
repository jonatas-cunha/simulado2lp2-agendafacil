package agendafacil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstudanteController {
	private Map<String, Estudante> estudantes;
	
	public EstudanteController() {
		this.estudantes = new HashMap<>(); 
	}
	
	/*
	 * boolean cadastrarEstudante(String nome, String email);

		String exibirEstudante(String email);
		
		String[] listarEstudantes();
	 */
	
	public Estudante getEstudante(String email) {
		return estudantes.get(email);
	}
	
	public boolean cadastrarEstudante(String nome, String email) {
		if (estudantes.get(email) != null) {
			throw new IllegalArgumentException("E-mail já cadastrado no sistema!");
		}
		
		Estudante e = new Estudante(nome, email);
		this.estudantes.put(email, e);
		return true;
	};
	
	public String exibirEstudante(String email) {
		Estudante e = this.estudantes.get(email);
		
		if (e == null) {
			return "";
		}
		
		return e.toString();
	};
	
	public String[] listarEstudantes() {
		ArrayList<String> copia = new ArrayList<String>();
		for (Estudante e : this.estudantes.values()) {
			copia.add(e.toString());
		}
		return copia.toArray(new String[0]);
	};
}
