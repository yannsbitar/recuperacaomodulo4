package Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexão.connection;
import model.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cli) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO cliente(cpf,endereço,telefone,nome)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cli.getCpf());
			pstm.setString(2, cli.getEndereço());
			pstm.setString(3, cli.getTelefone());
			pstm.setString(4, cli.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			
			
			
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM Cliente WHERE idcliente = ?";

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cli) {

		String sql = "UPDATE Cliente SET cpf = ?, endereço = ?, telefone = ?, nome = ? " + " WHERE idcliente = ?";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cli.getCpf());
			pstm.setString(2, cli.getEndereço());
			pstm.setString(3, cli.getTelefone());
			pstm.setString(4, cli.getNome());
			pstm.setInt(5, cli.getId());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Cliente> getCliente() {

		String sql = "SELECT * FROM Cliente";

		List<Cliente> Clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Cliente Cliente = new Cliente();

				// Recupera o id do banco e atribui ele ao objeto
				Cliente.setId(rset.getInt("idcliente"));

				// Recupera o nome do banco e atribui ele ao objeto
				Cliente.setNome(rset.getString("nome"));

				// Recupera o cpf do banco e atribui ele ao objeto
				Cliente.setCpf(rset.getString("cpf"));

				// Recupera o telefone do banco e atribui ela ao objeto
				Cliente.setTelefone(rset.getString("telefone"));
				Cliente.setEndereço(rset.getString("endereço"));
				// Adiciono o contato recuperado, a lista de contatos
				Clientes.add(Cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return Clientes;
	}


	public Cliente getClenteiById(int id) {

		String sql = "SELECT * FROM Cliente where idcliente = ?";
		Cliente Cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			Cliente.setId(rset.getInt("idcliente"));

			// Recupera o nome do banco e atribui ele ao objeto
			Cliente.setNome(rset.getString("nome"));

			// Recupera o cpf do banco e atribui ele ao objeto
			Cliente.setCpf(rset.getString("cpf"));

			// Recupera o telefone do banco e atribui ela ao objeto
			Cliente.setTelefone(rset.getString("telefone"));
			Cliente.setEndereço(rset.getString("endereço"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Cliente;
	}
}
