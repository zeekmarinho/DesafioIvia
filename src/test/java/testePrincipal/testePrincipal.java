package testePrincipal;

import java.util.ArrayList;
import java.util.Scanner;

import Entidade.Usuario;
import dao.UsuarioDAO;

public class testePrincipal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		UsuarioDAO usrDAO = new UsuarioDAO();
		Usuario umUsr = new Usuario();
		
		for(int opcao = 0; opcao != 6;  ) {
			
			System.out.println("=================MENU=================");
			System.out.println("(1) Fazer Login:");
			System.out.println("(2) Incluir Usuários:");
			System.out.println("(3) Consultar Usuário:");
			System.out.println("(4) Alterar Usuário:");
			System.out.println("(5) Remover Usuário:");
			System.out.println("(6) Sair:");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case(1)://Login
				
				break;
			
			case(2)://Incluir
				
				System.out.println("=======Cadastro de Usuario=======");
				System.out.println("Informe o nome:");
				String nome = sc.nextLine();
				sc.nextLine();
				umUsr.setNome(nome);
				System.out.println("Informe o email:");
				String email = sc.nextLine();
				umUsr.setNome(email);
				System.out.println("Informe o senha:");
				String senha = sc.nextLine();
				umUsr.setNome(senha);
				System.out.println("Informe o telefone:");
				String telefone = sc.nextLine();
				umUsr.setNome(telefone);				
				usrDAO.incluirUsuario(umUsr);
								
				break;
			
			case(3)://Consultar
				
				System.out.println("=======Lista de Usuarios=======");
				ArrayList<Usuario> listUsuarios = usrDAO.consultarUsuarios();
				for(Usuario umUsuario : listUsuarios)
					System.out.println(umUsuario.toString());
				
				break;
			
			case(4)://Alterar
				
				System.out.println("=======Alterar Usuario=======");
				System.out.println("Informe o código do usuário para alterção:");
				Long codigo = sc.nextLong();
				umUsr.setId(codigo);
				System.out.println("Informe o nome:");
				String nome1 = sc.nextLine();
				umUsr.setNome(nome1);
				System.out.println("Informe o email:");
				String email1 = sc.nextLine();
				umUsr.setNome(email1);
				System.out.println("Informe o senha:");
				String senha1 = sc.nextLine();
				umUsr.setNome(senha1);
				System.out.println("Informe o telefone:");
				String telefone1 = sc.nextLine();
				umUsr.setNome(telefone1);	
				usrDAO.alterarUsuario(umUsr);
				
				break;
			
			case(5)://Remover
				
				System.out.println("=======Remover Usuario=======");
				System.out.println("Informe o código do usuário para alterção:");
				Long codigo1 = sc.nextLong();
				umUsr.setId(codigo1);
				usrDAO.removerUsuario(umUsr);
				
				break;
			
			default:
				
				System.out.println("Opção Inválida");
			}
			
			
			sc.close();
		}

	}

}
