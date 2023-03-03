package conexion.dominio.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaCrud
 */
@WebServlet("/ConectaCrud")
public class ConectaCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCrud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String jdbcUrl ="jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
		String usuario ="root";
		String password="";
		String Driver="com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out=response.getWriter();
			
			out.print("Nombre de la BD: " + jdbcUrl + "\n") ;
			
			Class.forName(Driver);
			
			Connection miConexion = DriverManager.getConnection(jdbcUrl, usuario, password);
			
			out.print("Conectado");
			
			miConexion.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
