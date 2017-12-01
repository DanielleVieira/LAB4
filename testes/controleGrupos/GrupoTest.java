package controleGrupos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controleAlunos.Aluno;

public class GrupoTest {

	
	
	private Grupo g1;
	private Grupo g2;
	private Grupo g3;
	private Aluno a1;
	private Aluno a2;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.g1 = new Grupo("Listas");
		this.g2 = new Grupo("Listas");
		this.g3 = new Grupo("Cálculo");
		this.a1 = new Aluno("250", "Mei-Ling Zhou", "Computação");
		this.a2 = new Aluno("500", "Gabriel Reyes", "Computação");
		this.g1.alocarAluno(a2);
	}

	
	
	@Test
	public void testGrupo() {
		assertEquals("Listas", g1.getNome());
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarNomeNull() {
		this.g1 = new Grupo(null);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarNomeInvalido() {
		this.g1 = new Grupo("");
	}

	
	
	@Test
	public void testAlocarAluno() {
		//alocando um aluno
		assertTrue(this.g1.alocarAluno(a1));
		// alocar novamente o mesmo aluno
		assertFalse(this.g1.alocarAluno(a1));
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testAlocarAlunoNull() {
		this.g1.alocarAluno(null);
	}
	
	
	
	@Test
	public void testExibirAlunosDoGrupo() {
		assertEquals("* 500 - Gabriel Reyes - Computação\n", this.g1.exibirAlunosDoGrupo());
	}
	
	
	
	@Test
	public void testEquals() {
		//grupos com mesmo nome
		assertTrue(this.g1.equals(this.g2));
		//grupos com diferentes nomes
		assertFalse(this.g1.equals(this.g3));
		//argumento nulo
		assertFalse(this.g1.equals(null));
	}
}
