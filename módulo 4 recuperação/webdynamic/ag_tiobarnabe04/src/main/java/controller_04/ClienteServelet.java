package controller_04;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import Dao.ClienteDAO;

import model.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/cliente-save", "/cliente-delet", "/cliente-update", "/cliente-create" })
public class ClienteServelet extends HttpServlet {

	Cliente cliente = new Cliente();

	ClienteDAO clienteDAO = new ClienteDAO();

	public ClienteServelet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/cliente":
			read(request, response);
			break;

		case "/cliente-save":
			create(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
		case "/cliente-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("/");
			break;
		}
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereço = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereço(endereço);
		cliente.setTelefone(telefone);

		clienteDAO.save(cliente);
		response.sendRedirect("./login");
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> lista = clienteDAO.getCliente();
		request.setAttribute("clientes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./adm/clientes.jsp");
		rd.forward(request, response);
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		clienteDAO.removeById(id);
		response.sendRedirect("./cliente");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("name"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEndereço(request.getParameter("endereco"));
		cliente.setTelefone(request.getParameter("telefone"));

		clienteDAO.update(cliente);
		response.sendRedirect("./cliente");
	}

}
