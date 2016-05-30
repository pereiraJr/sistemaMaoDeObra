package sistema.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistema.dao.UsuarioDAO;
import sistema.dao.UsuarioDAOImplementacao;
import sistema.model.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet{

	
	private UsuarioDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_USUARIO = "/listaUsuario.jsp";
    public static final String INSERIR_OU_EDITAR = "/usuario.jsp";
    
    public UsuarioController() {
        dao = new UsuarioDAOImplementacao();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "deletar" ) ) {
            forward = LISTAR_USUARIO;
            int usuarioId = Integer.parseInt( request.getParameter("usuarioId") );
            dao.excluirUsuario(usuarioId);
            request.setAttribute("usuarios", dao.listarTodosUsuarios() );
        }
        else if( action.equalsIgnoreCase( "editar" ) ) {
            forward = INSERIR_OU_EDITAR;
            int usuarioId = Integer.parseInt( request.getParameter("usuarioId") );
            Usuario usuario = dao.buscarUsuarioPorId(usuarioId);
            request.setAttribute("usuario", usuario);
        }
        else if( action.equalsIgnoreCase( "inserir" ) ) {
            forward = INSERIR_OU_EDITAR;
        }
        else {
            forward = LISTAR_USUARIO;
            request.setAttribute("usuarios", dao.listarTodosUsuarios() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome( request.getParameter( "nome" ) );
        usuario.setEmail( request.getParameter( "email" ) );
        usuario.setTelefone( request.getParameter( "telefone" ) );
        usuario.setEndereco( request.getParameter( "endereco" ) );
        String usuarioId = request.getParameter("usuarioId");
 
        if( usuarioId == null || usuarioId.isEmpty() )
            dao.adicionarUsuario(usuario);
        else {
            usuario.setUsuarioId( Integer.parseInt(usuarioId) );
            dao.alterarUsuario(usuario);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_USUARIO );
        request.setAttribute("usuarios", dao.listarTodosUsuarios());
        view.forward(request, response);
    }
 
}
