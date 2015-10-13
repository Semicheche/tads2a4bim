package br.unive.cadastro.model;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoH2Impl implements ClienteDao {
	
	
	private static Connection con; 
	
	private void abrirConexao() throws SQLException {
		String url = "jdbc:h2:~/2a4bim";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);

	}
	
	private Connection getConnection(){
		synchronized (con) {
			if(con == null){
				try {
					abrirConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return con;
		}
		
	}

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO....";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Cliente c) {
		String sql = "UPDATE ...";
	}

	@Override
	public void excluir(Cliente c) {
		String sql = "DELETE FROM ..";
		
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorExemplo(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
