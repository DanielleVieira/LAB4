package controleGrupos;

import static util.Verificacoes.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import controleAlunos.Aluno;

public class Grupo {

	
	
	private String nome;
	private Set<Aluno> alunosDoGrupo;

	
	
	public Grupo(String nome) throws NullPointerException, IllegalArgumentException {
		verificaStringInvalida(nome);
		verificaNull(nome);
		this.nome = nome;
		this.alunosDoGrupo = new HashSet<>();
	}

	
	
	public boolean alocarAluno(Aluno aluno) throws NullPointerException {
		verificaNull(aluno);
		return this.alunosDoGrupo.add(aluno);
	}
	
	
	
	public String exibirAlunosDoGrupo() {
		StringBuilder str = new StringBuilder();
		Iterator<Aluno> itr = alunosDoGrupo.iterator();
		while(itr.hasNext()) {
			Aluno aluno = itr.next();
			String strAluno = String.format("* %s\n", aluno.toString());
			str.append(strAluno);
		}
		return new String(str);
	}
	
	
	
	public String getNome() {
		return this.nome;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getNome() == null) ? 0 : this.getNome().hashCode());
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
		Grupo other = (Grupo) obj;
		if (this.getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!this.getNome().equals(other.getNome()))
			return false;
		return true;
	}

}
