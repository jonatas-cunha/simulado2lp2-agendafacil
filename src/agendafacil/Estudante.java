package agendafacil;

public class Estudante implements Comparable<Estudante> {
	private String nome;
	private String email; //id
	
	//rever necessidade
	private int quantEventos;
	private int pontuacao;
	
	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Estudante))
			return false;
		Estudante other = (Estudante) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", email=" + email + "]";
	}
	
	@Override
	public int compareTo(Estudante e) {
		return getPontuacao() - e.getPontuacao();
	}
	
	
	public String getEmail() {
		return email;
	}

	private int getPontuacao() {
		return this.pontuacao;
	}
	
}
