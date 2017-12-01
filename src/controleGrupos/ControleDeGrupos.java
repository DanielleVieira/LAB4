package controleGrupos;

import java.util.HashMap;
import java.util.Map;

import controleAlunos.Aluno;
import controleAlunos.ControleDeAlunos;


public class ControleDeGrupos {

	
	
	private Map<String, Grupo> registroDeGrupos;
	private ControleDeAlunos controleDeAlunos;
	

	
	public ControleDeGrupos(ControleDeAlunos controleDeAlunos) {
		this.registroDeGrupos = new HashMap<>();
		this.controleDeAlunos = controleDeAlunos;
	}


	
	public boolean cadastrarGrupo(String nome) throws NullPointerException, IllegalArgumentException {
		if(this.grupoJaExiste(nome)) {
			return false;
		}
		registroDeGrupos.put(nome.toUpperCase(), this.novoGrupo(nome));
		return true;
	}



	private boolean grupoJaExiste(String nome) {
		return this.registroDeGrupos.containsKey(nome.toUpperCase());
	}
	
	

	private Grupo novoGrupo(String nome) throws NullPointerException {
		return new Grupo(nome);
	}



	public String alocarAluno(String matricula, String nomeGrupo) throws NullPointerException {
		Aluno aluno = this.getAluno(matricula);
		Grupo grupo = this.registroDeGrupos.get(nomeGrupo.toUpperCase());
		if(aluno == null) {
			return "Aluno não cadastrado.";
		} else if(grupo == null) {
			return "Grupo não cadastrado.";
		}
		grupo.alocarAluno(aluno);
		return "ALUNO ALOCADO!";
	}

	
	
	public Aluno getAluno(String matricula) {
		return this.controleDeAlunos.getAluno(matricula);
	}



	public String exibirGrupo(String nomeGrupo) throws NullPointerException{
		Grupo grupo = this.registroDeGrupos.get(nomeGrupo.toUpperCase());
		if(grupo == null) {
			return "Grupo não cadastrado.";
		}
		return String.format("Alunos do grupo %s:\n%s", grupo.getNome(), grupo.exibirAlunosDoGrupo());
	}
	
	
}
