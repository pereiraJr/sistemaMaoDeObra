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
        Usuario usuario = new Usuario();
        
        
        usuario.setLogin(login);
        
        if(LoginDao.checkUser(login, pass))
        {
        	response.sendRedirect("index.jsp");
        	HttpSession sessao = request.getSession();
            sessao.setAttribute("sessaoUsuario",usuario);
           // sessao.setAttribute("idusuario", usuario.getUsuarioId(usuario));
           //RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
           //rs.include(request, r	esponse);
        }
        else
        {
           out.println("Login ou Senha incorretos");
           RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
           rs.include(request, response);
        }
    }  
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Connection conn;
//	Statement statement = null;
//	
//	public LoginServlet() {
//		conn = DBUtil.getConnection();
//	}
//	
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
//
//		String userName = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		Usuario usuario = new Usuario(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
//
//		usuario.setLogin(userName); //setting the username and password through the loginBean object then only you can get it in future.
//		usuario.setSenha(password);
////
////		try{
////			PrintWriter out = response.getWriter();
////		statement = conn.createStatement();
////		ResultSet rs = statement.executeQuery("select * from usuario where login = '"+userName+"' and senha ='"+password+"'");
////		
////		if(rs.next())
////        {
////         //String redirectedPage = "/parentPage";
////         response.sendRedirect("index.jsp");
////        }else{
////        out.println("password is not match please try again");
////        }
////		
////		
////		}catch(Exception e){}
////		
////		
////		
//		
//		
//		LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
//
//		String userValidate = loginDao.authenticateUser(usuario); //Calling authenticateUser function
//
//		if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
//		{
//			request.setAttribute("userName", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
//			request.getRequestDispatcher("/index.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
//			//response.sendRedirect("index.jsp");
//		}
//		else
//		{
//			request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
//			request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
//		}
//	}
//
