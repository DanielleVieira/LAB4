package controleAlunos;

public class Aluno {

	
	
	private final String matricula;
	private final String nome;
	private final String curso;
	
	
	
	public Aluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException {
		this.verificaStringInvalida(matricula);
		this.verificaStringInvalida(nome);
		this.verificaStringInvalida(curso);
		this.verificaNull(nome);
		this.verificaNull(nome);
		this.verificaNull(curso);
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	
	
	private void verificaStringInvalida(String str) {
		if(this.ehStringVazia(str)) {
			throw new IllegalArgumentException();
		}
	}
	
	
	
	private boolean ehStringVazia(String str) {
		return str.trim().isEmpty();
	}
	
	
	
	private void verificaNull(String str) {
		if(str == null) {
			throw new NullPointerException();
		}
	}



	public String getMatricula() {
		return matricula;
	}



	public String getNome() {
		return nome;
	}



	public String getCurso() {
		return curso;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
