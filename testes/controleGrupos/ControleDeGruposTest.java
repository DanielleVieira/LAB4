
package controleGrupos;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import controleAlunos.ControleDeAlunos;


public class ControleDeGruposTest {

	
	
	private ControleDeGrupos cg1;
	private ControleDeAlunos ca1;

	
	
	@Before
	public void setUp() throws Exception {
		this.ca1 = new ControleDeAlunos();
		this.ca1.cadastrarAluno("500", "Gabriel Reyes", "Computação");
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computação");
		this.cg1 = new ControleDeGrupos(ca1);
		this.cg1.cadastrarGrupo("Listas");
		this.cg1.alocarAluno("500", "listas");
	}

	
	
	@Test
	public void testCadastrarGrupo() {
		//cadastrar novo grupo
		assertTrue(this.cg1.cadastrarGrupo("Cálculo"));
		//cadastrar grupo com mesmo nome de grupo ja existente
		assertFalse(this.cg1.cadastrarGrupo("listas"));
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarNomeNull() {
		this.cg1.cadastrarGrupo(null);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarNomeInvalido() {
		this.cg1.cadastrarGrupo("");
	}
	
	
	
	@Test
	public void testAlocarAluno() {
		//alocar um aluno cadastrado
		assertTrue(this.cg1.alocarAluno("250", "listas"));
		//alocar um aluno cadastrado e ja alocado
		assertTrue(this.cg1.alocarAluno("500", "listas"));
	}
		
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocarAlunoGrupoNaoCadastrado() {
		this.cg1.alocarAluno("250", "Padrões de Design");
	}
	
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocarAlunoNaoCadastrado() {
		this.cg1.alocarAluno("6000", "listas");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testAlocarAlunoNomeGrupoNull() {
		this.cg1.alocarAluno("250", null);
	}
	
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocarAlunoNomeGrupoInvalido() {
		this.cg1.alocarAluno("250", "");
	}
	
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocarAlunoMatriculaNull() {
		this.cg1.alocarAluno(null, "listas");
	}
	
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocarAlunoMatriculaInvalida() {
		this.cg1.alocarAluno("", "listas");
	}
	
	
	
	@Test
	public void testExibirGrupo() {
		//exibir grupo cadastrado
		assertEquals("Alunos do grupo Listas:\n* 500 - Gabriel Reyes - Computação\n", this.cg1.exibirGrupo("listas"));
		//exibir grupo nao cadastrado
		assertEquals("Grupo não cadastrado.", this.cg1.exibirGrupo("Cálculo"));
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testExibirGrupoNomeGrupoNull() {
		this.cg1.exibirGrupo(null);
	}
	
}
