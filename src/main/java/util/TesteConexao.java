package util;

import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) {
		
		Connection c = ConexaoJDBC.conectar();
		
		if(c==null) {
			System.out.println("N�o conectou!!!");
		}else {
			System.out.println("Conectado");
		}
		

	}

}
