package aprendamos.java.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aprendamos.java.dao.interfaces.ClienteDAO;
import aprendamos.java.dto.ClienteDTO;
import aprendamos.java.util.MySqlConexion;

/*Por cada entidad de nuestro modelo de datos normalmente tendremos un DAO

 Un DAO define todas las operaciones que necesitemos realizar sobre una entidad

 Un DAO expone sus métodos al mundo a través de su interface

 La clase nos dice "cómo" vamos a hacerlo :)*/

public class MySqlClienteDAO implements ClienteDAO {

	// METODO QUE ELIMINAR UN CLIENTE POR EMAIL
	@Override
	public void eliminaClientePorId(String email) {

	}

	// MÉTODO QUE REGISTRA UN NUEVO CLIENTE
	public void registraNuevoCliente(ClienteDTO objCli) {

	}

	// METODO QUE BUSCA CLIENTES POR SU ID
	public ClienteDTO buscaUsuarioPorId(String email) {
		ClienteDTO objCli = null;
		Connection cn = MySqlConexion.obtenerConexion();
		try {
			// Definimos la sentencia
			String sentencia = "select mail,clave,nombre,"
					+ "direccion,fecnac,telefono "
					+ "from tb_cliente where mail = ? ";
			// La preparamos
			PreparedStatement pst = cn.prepareStatement(sentencia);
			// Asignamos valores a las interrogantes
			pst.setString(1, email);
			// Ejecutamos
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				// caso de exito, si existe el email
				objCli = new ClienteDTO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getLong(6));
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objCli;
	}

	// METODO PARA LISTAR CLIENTES POR UN DETERMINADO NOMBRE O LETRA
	public List<ClienteDTO> listadoDeClientesPorNombre(String nombre) {
		Connection cn = MySqlConexion.obtenerConexion();
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		try {
			// Definimos la sentencia
			String sentencia = "select mail,clave,nombre,"
					+ "direccion,fecnac,telefono "
					+ "from tb_cliente where nombre like ? ";
			// La preparamos
			PreparedStatement pst = cn.prepareStatement(sentencia);
			// Asignamos valores a las interrogantes
			pst.setString(1, "%" + nombre + "%");
			// Ejecutamos
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Caso de exito, si existe el email
				ClienteDTO objCli = new ClienteDTO(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getLong(6));
				clientes.add(objCli);
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

}