package controleAlunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControleDeAlunosTest {

	
	
	private ControleDeAlunos ca1;

	
	
	@Before
	public void setUp() throws Exception {
		this.ca1 = new ControleDeAlunos();
		this.ca1.cadastrarAluno("500", "Gabriel Reyes", "Computação");
	}

	
	
	@Test
	public void testCadastrarAluno() {
		//cadastrar novo aluno
		assertTrue(this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computação"));
		// cadastrar aluno com uma matricula ja cadastrada
		assertFalse(this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "Computação"));
		//cadastrar mesmo aluno com matricula diferente
		assertTrue(this.ca1.cadastrarAluno("140", "Mei-Ling Zhou", "Computação"));
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarMatriculaNull() {
		this.ca1.cadastrarAluno(null, "Mei-Ling Zhou", "Computação");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarNomeNull() {
		this.ca1.cadastrarAluno("250", null, "Computação");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarCursoNull() {
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", null);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarMatriculaInvalida() {
		this.ca1.cadastrarAluno("", "Mei-Ling Zhou", "Computação");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarNomeInvalido() {
		this.ca1.cadastrarAluno("250", " ", "Computação");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCursoInvalido1() {
		this.ca1.cadastrarAluno("250", "Mei-Ling Zhou", "  ");
	}

	
	
	@Test
	public void testExibirAluno() {
		ControleDeAlunos ca2 = new ControleDeAlunos();
		// matricula cadastrada
		assertEquals("Aluno: 500 - Gabriel Reyes - Computação", this.ca1.exibirAluno("500"));
		//matricula nao cadastrada
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno("2500"));
		//matricula invalida
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno(""));
		//matricula nula
		assertEquals("Aluno não cadastrado.", this.ca1.exibirAluno(null));
		// registroDeAlunos sem nenhum cadastro feito
		assertEquals("Aluno não cadastrado.", ca2.exibirAluno("250"));
	} 
	
	
	
	@Test
	public void testCadastrarAlunosQueRespondem() {
		//matricula cadastrada
		assertTrue(this.ca1.cadastrarAlunosQueRespondem("500"));
		//matricula nao cadastrada
		assertFalse(this.ca1.cadastrarAlunosQueRespondem("50000"));
		// matricula invalida
		assertFalse(this.ca1.cadastrarAlunosQueRespondem("   "));
		// matricula nula
		assertFalse(this.ca1.cadastrarAlunosQueRespondem(null));
	}
	
	
	
	@Test
	public void testExibirAlunosQueRespondem() {
		//imprimir da lista sem ter cadastrado nenhum aluno que responde
		assertEquals("Alunos:\n", this.ca1.exibirAlunosQueRespondem());
		//exibir após cadastrar aluno que responde
		this.ca1.cadastrarAlunosQueRespondem("500");
		assertEquals("Alunos:\n1. 500 - Gabriel Reyes - Computação\n", this.ca1.exibirAlunosQueRespondem());
		this.ca1.cadastrarAlunosQueRespondem("500");
		assertEquals("Alunos:\n1. 500 - Gabriel Reyes - Computação\n2. 500 - Gabriel Reyes - Computação\n", this.ca1.exibirAlunosQueRespondem());
	}
}
