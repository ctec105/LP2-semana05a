package aprendamos.java.service;

import aprendamos.java.dao.factory.DAOFactory;
import aprendamos.java.dao.interfaces.ClienteDAO;
import aprendamos.java.dto.ClienteDTO;
import aprendamos.java.util.Constantes;

/* Por cada caso de uso de sistema podremos tener un componente service
 La funcionalidad del caso de uso será implementada por el servicio
 Un servicio puede llamar a uno o más daos (los que necesite)
 */

public class LogueoService {

	// Referenciamos la fábrica específica de daos y le indicamos nuestro origen de datos (MYSQL)
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);

	// Le pedimos a la fábrica específica el o los daos que necesitemos
	ClienteDAO objClienteDAO = fabrica.getClienteDAO();

	// Operaciones
	public ClienteDTO validaUsuario(ClienteDTO objcliente) {
		ClienteDTO objCli = null;
		// Antes de llamar al dao podemos tener lógica de negocio
		objCli = objClienteDAO.buscaUsuarioPorId(objcliente.getEmail());
		// Después de llamar al dao podemos tener también lógica de negocio
		System.out.println("Hemos validado con DAO :)");
		return objCli;
	}

}