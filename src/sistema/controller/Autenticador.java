package sistema.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistema.dao.UsuarioDAO;
import sistema.model.Usuario;

@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario user = new Usuario();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		user.setLogin(login);
		user.setSenha(senha);
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.autenticar(user)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("erro", "Usuario ou Senha Invalidos!");
			RequestDispatcher d = request.getRequestDispatcher("login.jsp");
			d.forward(request, response);
		}
	}


}
