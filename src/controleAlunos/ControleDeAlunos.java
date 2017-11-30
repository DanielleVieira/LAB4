package controleAlunos;

import java.util.HashSet;
import java.util.Set;

public class ControleDeAlunos {

	
		
	private Set<Aluno> registroDeAlunos;
	
	
	
	public ControleDeAlunos() {
		this.registroDeAlunos = new HashSet<>();
	}



	public boolean cadastrarAluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException {
		return registroDeAlunos.add(this.novoAluno(matricula, nome, curso));
	}



	private Aluno novoAluno(String matricula, String nome, String curso) {
		return new Aluno(matricula, nome, curso);
	}
	
}
