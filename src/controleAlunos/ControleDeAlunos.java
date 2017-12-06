package controleAlunos;

import java.util.HashMap;
import java.util.Map;

public class ControleDeAlunos {

	
		
	private Map<String, Aluno> registroDeAlunos;
	private AlunosQueRespondem alunosquerespondem;
	
	
	
	public ControleDeAlunos() {
		this.registroDeAlunos = new HashMap<>();
		this.alunosquerespondem = new AlunosQueRespondem();
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
	
	

	private Aluno novoAluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException {
		return new Aluno(matricula, nome, curso);
	}



	public String exibirAluno(String matricula) {
		Aluno aluno = this.getAluno(matricula);
		if(aluno == null) {
			return "Aluno não cadastrado.";
		} 
		return String.format("Aluno: %s", aluno.toString());
	}
	
	
	
	public Aluno getAluno(String matricula) {
		return this.registroDeAlunos.get(matricula);
	}



	public boolean cadastrarAlunosQueRespondem(String matricula) {
		Aluno aluno = this.getAluno(matricula);
		if(aluno == null) {
			return false;
		} 
		return this.alunosquerespondem.cadastrarAlunosQueRespondem(aluno);
	}



	public String exibirAlunosQueRespondem() {
		return this.alunosquerespondem.toString();
	}
	
}
