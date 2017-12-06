package controleAlunos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlunosQueRespondem {

	
	
	private List<Aluno> alunosQueRespondem;
	
	
	
	public AlunosQueRespondem() {
		this.alunosQueRespondem = new ArrayList<>();
	}
	
	
	
	public boolean cadastrarAlunosQueRespondem(Aluno aluno) {
		return this.alunosQueRespondem.add(aluno);
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Alunos:\n");
		for (int i = 0; i < this.alunosQueRespondem.size(); i++) {
			String alunoString = String.format("%d. %s\n", i + 1, this.alunosQueRespondem.get(i));
			str.append(alunoString);
		}
		return new String(str);
	}
	
}
