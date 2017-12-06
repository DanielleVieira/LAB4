package menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import controleAlunos.ControleDeAlunos;
import controleGrupos.ControleDeGrupos;

public class Menu {

	
	
	private static Scanner sc = new Scanner(System.in);
	private static ControleDeAlunos ca = new ControleDeAlunos();
	private static ControleDeGrupos cg = new ControleDeGrupos(ca);
	private static String opcao;
	private static final String MENU = "(C)adastrar Aluno\n"
									+ "(E)xibir Aluno\n"
									+ "(N)ovo Grupo\n"
									+ "(A)locar Aluno no Grupo e Imprimir Grupos\n"
									+ "(R)egistrar Resposta de Aluno\n"
									+ "(I)mprimir Alunos que Responderam\n"
									+ "(O)ra, vamos fechar o programa!\n\n"
									+ "Opção> ";
	
	
	
	public static void main(String[] args) {
		do {
			System.out.print(MENU);
			opcao = sc.nextLine();
			System.out.println();
			switch (opcao) {
			case "C":
				cadastrarAluno();
				break;
			case "E":
				exibirAluno();
				break;
			case "N":
				cadastrarGrupo();
				break;
			case "A":
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String escolha = sc.nextLine();
				System.out.println();
				if(escolha.equals("A")) {
					alocarAluno();
				} else if(escolha.equals("I")) {
					exibirGrupo();
				}
				break;
			case "R":
				cadastrarAlunosQueRespondem();
				break;
			case "I":
				exibirAlunosQueRespondem();
				break;
			case "O":
				System.exit(0);

			default:
				System.out.println("Opcao Inválida!");
				System.out.println();
				break;
			}
			
		} while (!opcao.equals("O"));

	}



	private static void exibirAlunosQueRespondem() {
		System.out.println(ca.exibirAlunosQueRespondem());
	}



	private static void cadastrarAlunosQueRespondem() {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		if(ca.cadastrarAlunosQueRespondem(matricula)) {
			System.out.println("ALUNO REGISTRADO!");
		} else {
			System.out.println("Aluno não cadastrado.");
		}
		System.out.println();
	}



	private static void exibirGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = sc.nextLine();
		System.out.println();
		System.out.println(cg.exibirGrupo(nomeGrupo));
	}



	private static void alocarAluno() {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = sc.nextLine();
		try {
			if(cg.alocarAluno(matricula, nomeGrupo)) {
				System.out.println("ALUNO ALOCADO!");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}



	private static void cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nome = sc.nextLine();
		if(cg.cadastrarGrupo(nome)) {
			System.out.println("CADASTRO REALIZADO!");
		} else {
			System.out.println("GRUPO JÁ CADASTRADO!");
		}
		System.out.println();
	}



	private static void cadastrarAluno() {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		if(ca.cadastrarAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO!");
		} else {
			System.out.println("MATRÍCULA JÁ CADASTRADA!");
		}	
		System.out.println();
	}
	
	
	
	private static void exibirAluno() {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		System.out.println();
		System.out.println(ca.exibirAluno(matricula));
		System.out.println();
	}

}
