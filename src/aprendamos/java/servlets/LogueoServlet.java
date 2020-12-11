//PASO 6:

package aprendamos.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aprendamos.java.dto.ClienteDTO;
import aprendamos.java.service.LogueoService;

/**
 * Servlet implementation class LogueoServlet
 */

public class LogueoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// Instanciamos el o los servicios necesarios
	LogueoService servicio = new LogueoService();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperamos los parámetros que llegan en el request
		String vusuario = request.getParameter("usuario");
		String vclave = request.getParameter("clave");
		System.out.println("Usuario ingresado: " + vusuario);
		System.out.println("Clave ingresada: " + vclave);

		// 2. Implementamos un poco de lógica para validar el usuario y la clave
		ClienteDTO candidato = new ClienteDTO(vusuario, vclave, null, null, null, 0);
		ClienteDTO validado = servicio.validaUsuario(candidato);

		// 3. Dependiendo del resultado de la validación, el servlet invocará
		// a bienvenida.jsp o rebotará al logueo.jsp
		if (validado != null) {
			// Al menos el usuario existe
			if (validado.getClave().equals(vclave)) {
				// Exito total validamos si existen una sesión activa, de
				// existir la matamos y creamos una nueva sesión web 
				// cargando en ella, los datos del usuario validado
				if (request.isRequestedSessionIdValid()) {
					HttpSession tempo = request.getSession(false);
					tempo.invalidate();
				}
				// Crear una nueva sesión
				HttpSession lasesion = request.getSession(true);
				// Cargar los datos del usuario validado a la sesión
				lasesion.setAttribute("usuario", validado);
				// Despachamos a bienvenida.jsp
				request.getRequestDispatcher("/bienvenida.jsp").forward(request, response);
			} else {
				// Cargarmos atrobutos al request
				request.setAttribute("msg", "Lo sentimos, clave incorrecta!");
				request.getRequestDispatcher("/logueo.jsp").forward(request, response);
			}
		} else {
			// No existe el usuario (el email)
			request.setAttribute("msg", "Lo sentimos, usuario no existe!");
			request.getRequestDispatcher("/logueo.jsp").forward(request, response);
		}
	}
}