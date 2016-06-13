package sistema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistema.dao.AnuncioDAO;
import sistema.dao.AnuncioDAOImplementacao;
import sistema.model.Anuncio;
import sistema.model.Usuario;

@WebServlet("/AnuncioController")
public class AnuncioController extends HttpServlet{

	private AnuncioDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_ANUNCIO = "/listaAnuncio.jsp";
    public static final String INSERIR_OU_EDITAR = "/form.jsp";
    public static final String LISTAR_ANUNCIO_USUARIO = "/anuncioPorUsuario.jsp";
    public static final String LISTAR_ANUNCIO_POR_TITULO = "/anuncioPorTitulo.jsp";
    
    public AnuncioController() {
        dao = new AnuncioDAOImplementacao();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "deletar" ) ) {
            forward = LISTAR_ANUNCIO;
            int anuncioId = Integer.parseInt( request.getParameter("anuncioId") );
            dao.excluirAnuncio(anuncioId);
            request.setAttribute("anuncios", dao.listarTodosAnuncios() );
        }
        else if( action.equalsIgnoreCase( "editar" ) ) {
            forward = INSERIR_OU_EDITAR;
            int anuncioId = Integer.parseInt( request.getParameter("anuncioId") );
            Anuncio anuncio = dao.buscarAnuncioPorId(anuncioId);
            request.setAttribute("anuncio", anuncio);
        }
        else if( action.equalsIgnoreCase( "inserir" ) ) {
            forward = INSERIR_OU_EDITAR;
        }
         
        else if ( action.equalsIgnoreCase( "listarPorUsuario")) {
        	forward = LISTAR_ANUNCIO_USUARIO;
        	Usuario usuario = (Usuario) request.getSession().getAttribute("sessaoUsuario") ;
        	int usuarioId = usuario.getUsuarioId();
        	List<Anuncio> anuncio = dao.listarAnuncioPorUsuario(usuarioId);
        	request.setAttribute("anuncios", anuncio);
            
        }
        else {
            forward = LISTAR_ANUNCIO;
            request.setAttribute("anuncios", dao.listarTodosAnuncios() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Anuncio anuncio = new Anuncio();
    	
    	anuncio.setTitulo( request.getParameter( "titulo" ) );
        anuncio.setDescricao( request.getParameter( "descricao" ) );
        String anuncioId = request.getParameter("anuncioId");
        anuncio.setUsuario((Usuario) request.getSession().getAttribute("sessaoUsuario") );
        

        if( anuncioId == null || anuncioId.isEmpty() )
            dao.adicionarAnuncio(anuncio);
        else {
        	anuncio.setAnuncioId( Integer.parseInt(anuncioId) );
            dao.alterarAnuncio(anuncio);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_ANUNCIO );
        request.setAttribute("anuncios", dao.listarTodosAnuncios());
        view.forward(request, response);
    }
}
