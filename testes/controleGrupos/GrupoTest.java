package controleGrupos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrupoTest {

	
	
	private Grupo g1;
	private Grupo g2;
	private Grupo g3;
	
	
	
	@Before
	public void setUp() throws Exception {
		g1 = new Grupo("Listas");
		g2 = new Grupo("Listas");
		g3 = new Grupo("Cálculo");
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
	public void testEquals() {
		assertTrue(this.g1.equals(this.g2));
		assertFalse(this.g1.equals(this.g3));
		assertFalse(this.g1.equals(null));
	}
}
