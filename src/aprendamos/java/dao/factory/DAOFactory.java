package aprendamos.java.dao.factory;

import aprendamos.java.dao.interfaces.ClienteDAO;
import aprendamos.java.dao.interfaces.FacturaDAO;
import aprendamos.java.dao.interfaces.ProductoDAO;

/*
 * Creamos la fábrica especifica de DAOS
 * */

public abstract class DAOFactory {

	// Definimos unas constantes por cada bd
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;

	/*
	 * Existirá un método get por cada DAO que exista en el sistema Ejemplo:
	 * public abstract ArticuloDAO getArticuloDAO();
	 */

	// Registramos nuestros daos incluído DAOFactory
	public abstract ClienteDAO getClienteDAO();

	public abstract ProductoDAO getProductoDAO();

	public abstract FacturaDAO getFacturaDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		case DB2:
			return new Db2DAOFactory();
		case SQLSERVER:
			return new SqlServerDAOFactory();
		case XML:
			return new XmlDAOFactory();
		default:
			return null;
		}
	}

}