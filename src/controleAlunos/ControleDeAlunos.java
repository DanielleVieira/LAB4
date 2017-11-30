package controleAlunos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
		Set<String> matriculas = this.registroDeAlunos.keySet();
		Iterator<String> iterator = matriculas.iterator(); 
		
		while(iterator.hasNext()) {
			String matricula = iterator.next();
			if(matricula.equals(mat)) {
				return true;
			}
		}
		return false;
	}
	
	

	private Aluno novoAluno(String matricula, String nome, String curso) {
		return new Aluno(matricula, nome, curso);
	}



	public String exibirAluno(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
