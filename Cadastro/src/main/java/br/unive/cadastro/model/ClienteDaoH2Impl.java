package br.unive.cadastro.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoH2Impl implements ClienteDao {

	private static Connection con;

	private void abrirConexao() throws SQLException {
		String url = "jdbc:h2:~/2a4bim";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);

	}

	private Connection getConnection() {
		if (con == null) {
			try {
				abrirConexao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (con) {
			return con;
		}

	}

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO CLIENTES (ID, NOME, ENDERECO, TELEFONE, CIDADE, UF) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereço());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getCidade());
			ps.setString(6, c.getUf().toString());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Cliente c) {
		String sql = "UPDATE CLIENTES SET ID = ?, NOME = ?, ENDERECO = ?, TELEFONE = ?, CIDADE = ?, UF = ? WHERE ID = ? ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEndereço());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getUf().toString());
			ps.setInt(6, c.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Cliente c) {
		String sql = "DELETE * FROM CLIENTES WHRERE ID = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();
			// instancia modelTable e atualiza a tabela

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM CLIENTES";

		ArrayList<Cliente> lista = new ArrayList<>();
		Cliente c = new Cliente();
		try {
			try {
				st = getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {

					c.setId(result.getInt("id"));
					c.setNome(result.getString("nome"));
					c.setEndereço(result.getString("endereco"));
					c.setTelefone(result.getString("telefone"));
					c.setCidade(result.getString("cidade"));
					c.setUf(Uf.valueOf(result.getString("uf")));

					lista.add(c);

				}

			} finally {
				if (st != null)
					st.close();
					
				if (result != null)
					result.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
