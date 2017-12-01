
package controleGrupos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controleAlunos.ControleDeAlunos;


public class ControleDeGruposTest {

	
	
	private ControleDeGrupos cg1;
	private ControleDeAlunos ca1;

	
	
	@Before
	public void setUp() throws Exception {
		this.ca1 = new ControleDeAlunos();
		this.ca1.cadastrarAluno("500", "Gabriel Reyes", "Computa��o");
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computa��o");
		this.cg1 = new ControleDeGrupos(ca1);
		this.cg1.cadastrarGrupo("Listas");
		this.cg1.alocarAluno("500", "listas");
	}

	
	
	@Test
	public void testCadastrarGrupo() {
		//cadastrar novo grupo
		assertTrue(this.cg1.cadastrarGrupo("C�lculo"));
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
		assertEquals("ALUNO ALOCADO!", cg1.alocarAluno("250", "listas"));
		//alocar um aluno cadastrado e ja alocado
		assertEquals("ALUNO ALOCADO!", cg1.alocarAluno("500", "listas"));
		//grupo nao cadastrado
		assertEquals("Grupo n�o cadastrado.", cg1.alocarAluno("250", "Padr�es de Design"));
		// aluno nao cadastrado
		assertEquals("Aluno n�o cadastrado.", cg1.alocarAluno("6000", "listas"));
		//grupo invalido
		assertEquals("Grupo n�o cadastrado.", cg1.alocarAluno("250", ""));
		//matricula invalida
		assertEquals("Aluno n�o cadastrado.", cg1.alocarAluno("", "listas"));
		assertEquals("Aluno n�o cadastrado.", cg1.alocarAluno(null, "listas"));
	}
		
	
	
	@Test(expected = NullPointerException.class)
	public void testAlocarAlunoNomeGrupoNull() {
		this.cg1.alocarAluno("250", null);
	}
	
	
	
	@Test
	public void testExibirGrupo() {
		//exibir grupo cadastrado
		assertEquals("Alunos do grupo Listas:\n* 500 - Gabriel Reyes - Computa��o\n", this.cg1.exibirGrupo("listas"));
		//exibir grupo nao cadastrado
		assertEquals("Grupo n�o cadastrado.", this.cg1.exibirGrupo("C�lculo"));
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testExibirGrupoNomeGrupoNull() {
		this.cg1.exibirGrupo(null);
	}
}
