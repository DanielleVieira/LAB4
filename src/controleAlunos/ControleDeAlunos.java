package controleAlunos;

import java.util.HashMap;
import java.util.Map;

public class ControleDeAlunos {

	
		
	private Map<String, Aluno> registroDeAlunos;
	
	
	
	public ControleDeAlunos() {
		this.registroDeAlunos = new HashMap<>();
	}



	public boolean cadastrarAluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException {
		if(this.matriculaJaExiste(matricula)) {
			return false;
		}
		registroDeAlunos.put(matricula, this.novoAluno(matricula, nome, curso));
		return true;
	}



	private boolean matriculaJaExiste(String mat) {
		return this.registroDeAlunos.containsKey(mat);
	}
	
	

	private Aluno novoAluno(String matricula, String nome, String curso) {
		return new Aluno(matricula, nome, curso);
	}



	public String exibirAluno(String matricula) {
		Aluno aluno = this.getAluno(matricula);
		if(aluno == null) {
			return "Aluno não cadastrado.";
		} 
		return aluno.toString();
	}
	
	
	
	private Aluno getAluno(String matricula) {
		return this.registroDeAlunos.get(matricula);
	}
	
}
