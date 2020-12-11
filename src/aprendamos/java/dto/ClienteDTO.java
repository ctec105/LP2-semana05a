package aprendamos.java.dto;

import java.util.Date;

public class ClienteDTO {

	private String email;
	private String clave;
	private String nombre;
	private String direccion;
	private Date fecnac;
	private long telefono;

	public ClienteDTO(String email, String clave, String nombre,
			String direccion, Date fecnac, long telefono) {
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fecnac = fecnac;
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

}