package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControleDeAlunosTest {

	
	
	private ControleDeAlunos ca1;

	
	
	@Before
	public void setUp() throws Exception {
		this.ca1 = new ControleDeAlunos();
		this.ca1.cadastrarAluno("250", "Gabriel Reyes", "Computação");
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

	
	
	@Test
	public void testExibirAluno() {
		ControleDeAlunos ca2 = new ControleDeAlunos();
		assertEquals("Aluno: 250 - Gabriel Reyes - Computação", this.ca1.exibirAluno("250"));
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno("2500"));
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno(""));
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno(null));
		assertEquals("Aluno não cadastrado.", ca2.exibirAluno("250"));
	} 
}
