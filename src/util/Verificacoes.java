package util;

public abstract class Verificacoes {
	

	
	public static void verificaStringInvalida(String str) {
		if(ehStringVazia(str)) {
			throw new IllegalArgumentException();
		}
	}
	
	
	
	private static boolean ehStringVazia(String str) {
		return str.trim().isEmpty();
	}
	
	
	
	public static void verificaNull(Object obj) {
		if(obj == null) {
			throw new NullPointerException();
		}
	}
}