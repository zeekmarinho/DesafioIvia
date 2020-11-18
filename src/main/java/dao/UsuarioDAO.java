package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Usuario;
import util.ConexaoJDBC;

public class UsuarioDAO {
	
	private final String SQL_INSERE_USUARIO = "INSERT INTO \"PUBLIC\".\"USUARIOS\"(\"ID\" ,\"NOME\", \"EMAIL\" \"SENHA\" \"TELEFONE\") VALUES (?,?,?,?,?);";
	private final String SQL_ALTERA_USUARIO = "UPDATE USUARIOS SET NOME=?, EMAIL=?, SENHA=?, TELEFONE=? WHERE ID=?;";
	private final String SQL_EXCLUI_USUARIO = "DELETE FROM USUARIOS WHERE ID=?";
	private final String SQL_SELECIONA_USUARIO = "SELECT * FROM USUARIOS";
	
	private PreparedStatement pst = null;
	
	//Método para Incluir Usuario
	public boolean incluirUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = ConexaoJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERE_USUARIO);
			pst.setString(1, umUsuario.getNome());
			pst.setString(2, umUsuario.getEmail());
			pst.setString(3, umUsuario.getSenha());
			pst.setString(4, umUsuario.getTelefone());
			ret = pst.execute();
			pst.close();
			ConexaoJDBC.fecharCNX();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return ret;
	}
	
	//Método para Consultar Usuario
	public ArrayList<Usuario> consultarUsuarios(){
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		Connection conn = ConexaoJDBC.conectar();
		Usuario umUsuario;
		try {
			pst = conn.prepareStatement(SQL_SELECIONA_USUARIO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umUsuario = new Usuario();
				umUsuario.setId(rs.getLong("ID"));
				umUsuario.setNome(rs.getString("NOME"));
				umUsuario.setEmail(rs.getString("EMAIL"));
				umUsuario.setSenha(rs.getString("SENHA"));
				umUsuario.setTelefone(rs.getString("TELEFONE"));
				listaDeUsuarios.add(umUsuario);
			}
			rs.close();
			pst.close();
			ConexaoJDBC.fecharCNX();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return listaDeUsuarios;
	}
	
	//Método para Alterar Usuario
	public boolean alterarUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = ConexaoJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERA_USUARIO);
			pst.setString(1, umUsuario.getNome());
			pst.setString(2, umUsuario.getEmail());
			pst.setString(3, umUsuario.getSenha());
			pst.setString(4, umUsuario.getTelefone());
			pst.setLong(5, umUsuario.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJDBC.fecharCNX();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return ret;
	}
	
	//Método para Remover Usuario
	public boolean removerUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = ConexaoJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUI_USUARIO);
			pst.setLong(1, umUsuario.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJDBC.fecharCNX();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return ret;
	}
}
