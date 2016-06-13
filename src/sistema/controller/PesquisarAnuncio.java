package sistema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistema.dao.AnuncioDAO;
import sistema.dao.LoginDao;
import sistema.dao.PesquisarAnuncioPorTituloDAO;
import sistema.dao.UsuarioDAO;
import sistema.model.Anuncio;
import sistema.model.Usuario;
import sistema.util.DBUtil;

@WebServlet("/PesquisarAnuncioServlet")
public class PesquisarAnuncio extends HttpServlet {

	private AnuncioDAO dao;
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		List<Anuncio> anuncio = new ArrayList<Anuncio>();
        String titulo = request.getParameter("titulo");
        anuncio = PesquisarAnuncioPorTituloDAO.anuncioPorTitulo(titulo);
        
        
        if(anuncio != null)
        {
        	response.sendRedirect("anuncioPorTitulo.jsp");
        	HttpSession sessao = request.getSession();
            sessao.setAttribute("sessaoAnuncio",anuncio);
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
           rs.include(request, response);
        }
    }  
}