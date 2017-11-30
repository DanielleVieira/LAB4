package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControleDeAlunosTest {

	private ControleDeAlunos ca1;
	
	@Before
	public void setUp() throws Exception {
		this.ca1 = new ControleDeAlunos();
	}

	@Test
	public void testCadastrarAluno() {
		assertTrue(this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computa��o"));
		assertFalse(this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computa��o"));
		assertTrue(this.ca1.cadastrarAluno("140", "Mei-Ling Zhou", "Computa��o"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarMatriculaNull() {
		this.ca1.cadastrarAluno(null, "Mei-Ling Zhou", "Computa��o");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarNomeNull() {
		this.ca1.cadastrarAluno("250", null, "Computa��o");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarCursoNull() {
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarMatriculaInvalida() {
		this.ca1.cadastrarAluno("", "Mei-Ling Zhou", "Computa��o");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarNomeInvalido() {
		this.ca1.cadastrarAluno("250", " ", "Computa��o");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCursoInvalido1() {
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "  ");
	}

}
