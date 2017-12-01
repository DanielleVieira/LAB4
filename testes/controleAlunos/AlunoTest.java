package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	
	
	private Aluno a1;
	private Aluno a2;
	private Aluno a3;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", "Computa��o");
		this.a2 = new Aluno("250", "Gabriel Reyes", "Computa��o");
		this.a3 = new Aluno("150", "Gabriel Reyes", "Computa��o");
	}

	
	
	@Test
	public void testAluno() {
		assertEquals("250", a1.getMatricula());
		assertEquals("Mei-Ling Zhou", a1.getNome());
		assertEquals("Computa��o", a1.getCurso());
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testMatriculaNull() {
		this.a1 = new Aluno(null, "Mei-Ling Zhou", "Computa��o");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		this.a1 = new Aluno("250", null, "Computa��o");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCursoNull() {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", null);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testMatriculaInvalida() {
		this.a1 = new Aluno("", "Mei-Ling Zhou", "Computa��o");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeInvalido() {
		this.a1 = new Aluno("250", " ", "Computa��o");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCursoInvalido1() {
		this.a1 = new Aluno("250", "Mei-Ling Zhou", "  ");
	}
	
	
	
	@Test
	public void testEquals() {
		//diferentes pessoas com mesma matricula
		assertTrue(this.a1.equals(this.a2));
		//mesma pessoa com diferente matricula
		assertFalse(this.a1.equals(this.a3));
		//argumento null
		assertFalse(this.a1.equals(null));
	}
	
	
	
	@Test
	public void testToString() {
		assertEquals("250 - Mei-Ling Zhou - Computa��o", a1.toString());
	}
	
}
