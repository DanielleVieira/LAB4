package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	private Aluno a1;
	
	@Before
	public void setUp() throws Exception {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", "Computação");
	}

	@Test
	public void testAluno() {
		assertEquals("250", a1.getMatricula());
		assertEquals("Mei-Ling Zhou", a1.getNome());
		assertEquals("Computação", a1.getCurso());
	}
	
	@Test(expected = NullPointerException.class)
	public void testMatriculaNull() {
		this.a1 = new Aluno(null, "Mei-Ling Zhou", "Computação");
	}
	
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		this.a1 = new Aluno("250", null, "Computação");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCursoNull() {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMatriculaInvalida() {
		this.a1 = new Aluno("", "Mei-Ling Zhou", "Computação");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeInvalido() {
		this.a1 = new Aluno("250", " ", "Computação");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCursoInvalido1() {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", "  ");
	}
	
}
