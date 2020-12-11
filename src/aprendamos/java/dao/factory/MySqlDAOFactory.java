package aprendamos.java.dao.factory;

import aprendamos.java.dao.interfaces.ClienteDAO;
import aprendamos.java.dao.interfaces.FacturaDAO;
import aprendamos.java.dao.interfaces.ProductoDAO;
import aprendamos.java.dao.mysql.MySqlClienteDAO;

public class MySqlDAOFactory extends DAOFactory {

	// Estamos aplicando la 2da forma de polimorfismo.
	// Una clase puede ser enmascarada con la interface que implementa
	@Override
	public ClienteDAO getClienteDAO() {
		return new MySqlClienteDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return null;
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		return null;
	}

}