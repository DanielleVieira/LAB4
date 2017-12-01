package controleAlunos;

import static util.Verificacoes.*;

public class Aluno {



	private String matricula;
	private String nome;
	private String curso;



	public Aluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException {
		verificaStringInvalida(matricula);
		verificaStringInvalida(nome);
		verificaStringInvalida(curso);
		verificaNull(nome);
		verificaNull(nome);
		verificaNull(curso);
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	


	public String getMatricula() {
		return this.matricula;
	}



	public String getNome() {
		return this.nome;
	}



	public String getCurso() {
		return this.curso;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getMatricula() == null) ? 0 : this.getMatricula().hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (this.getMatricula() == null) {
			if (other.getMatricula() != null)
				return false;
		} else if (!this.getMatricula().equals(other.getMatricula()))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("Aluno: %s - %s - %s", this.getMatricula(), this.getNome(), this.getCurso());
	}
}
