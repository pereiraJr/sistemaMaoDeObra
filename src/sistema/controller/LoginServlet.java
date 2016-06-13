 package sistema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistema.dao.LoginDao;
import sistema.dao.UsuarioDAO;
import sistema.model.Anuncio;
import sistema.model.Usuario;
import sistema.util.DBUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String login = request.getParameter("userName");
		String pass = request.getParameter("password");
		Usuario usuario = LoginDao.checkUser(login, pass);

		if(usuario != null){
			response.sendRedirect("index.jsp");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("sessaoUsuario",usuario);
		}else{
			out.println("Login ou Senha incorretos");
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.include(request, response);
		}
	}  
}