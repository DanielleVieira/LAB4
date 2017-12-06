package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunosQueRespondemTest {

	
	
	private AlunosQueRespondem ar1;
	private Aluno a1;
	private Aluno a2;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.ar1 = new AlunosQueRespondem();
		this.a1 = new Aluno("500", "Gabriel Reyes", "Computa��o");
		this.a2 = new Aluno("250", "Mei-Ling Zhou", "Computa��o");
		this.ar1.cadastrarAlunosQueRespondem(a1);
	}

	
	
	@Test
	public void testCadastrarAlunosQueRespondem() {
		// cadastrar aluno
		assertTrue(this.ar1.cadastrarAlunosQueRespondem(a2));
		// cadastrar aluno j� cadastrado
		assertTrue(this.ar1.cadastrarAlunosQueRespondem(a2));
	}
	
	
	
	@Test
	public void testToString() {
		//imprimir da lista sem ter cadastrado nenhum aluno que responde
		AlunosQueRespondem ar2 = new AlunosQueRespondem();
		assertEquals("Alunos:\n", ar2.toString());
		//exibir ap�s cadastrar aluno que responde
		assertEquals("Alunos:\n1. 500 - Gabriel Reyes - Computa��o\n", this.ar1.toString());
		this.ar1.cadastrarAlunosQueRespondem(a2);
		assertEquals("Alunos:\n1. 500 - Gabriel Reyes - Computa��o\n2. 250 - Mei-Ling Zhou - Computa��o\n", this.ar1.toString());
	}
	
}
