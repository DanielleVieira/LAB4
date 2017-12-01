package controleGrupos;

import java.util.HashMap;
import java.util.Map;


public class ControleDeGrupos {

	
	
	private Map<String, Grupo> registroDeGrupos;
	

	
	public ControleDeGrupos() {
		this.registroDeGrupos = new HashMap<>();
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
	
	

	private Grupo novoGrupo(String nome) {
		return new Grupo(nome);
	}
}
