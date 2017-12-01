
package controleGrupos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ControleDeGruposTest {

	
	
	private ControleDeGrupos cg1;

	
	
	@Before
	public void setUp() throws Exception {
		this.cg1 = new ControleDeGrupos();
		this.cg1.cadastrarGrupo("Listas");
	}

	
	
	@Test
	public void testCadastrarAluno() {
		assertTrue(this.cg1.cadastrarGrupo("Cálculo"));
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
	
}
