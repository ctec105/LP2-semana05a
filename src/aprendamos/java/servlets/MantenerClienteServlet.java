// PASO 7:

package aprendamos.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aprendamos.java.dto.ClienteDTO;
import aprendamos.java.service.MantenerClienteService;

/**
 * Servlet implementation class GestionaMantenimientosServlet
 */

public class MantenerClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Instanciamos los servicios utilizados por este servlet (por ahora solo uno)
	MantenerClienteService servicio = new MantenerClienteService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Asumimos que llega un parámetro oculto llamado operacion
		String voperacion = request.getParameter("operacion");
		if (voperacion.equals("listaClientes")) {
			this.listarClientes(request, response);
		}
		if (voperacion.equals("registraProductos")) {

		}
		if (voperacion.equals("registraClientes")) {

		}
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos el nombre ingresado en el jsp
		String vnombre = request.getParameter("nombre");
		// invocamos al servicio para ejecutar nuestra lógica
		List<ClienteDTO> listado = servicio.listadoDeClientesPorNombre(vnombre);
		// Cargamos al request el listado de clientes
		request.setAttribute("listadito", listado);
		// invocamos a la página listado.jsp para visualizar los datos obtenidos
		request.getRequestDispatcher("/listado.jsp").forward(request, response);
	}

}