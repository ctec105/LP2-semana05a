<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
			<!--  Aquí va la cabecera -->
			<td colspan="2" align="center">
				<jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<!--  Aquí va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!--  Aquí va el cuerpo -->
			<td class="control">
				<form action="cliente" method="post">
					<input type="hidden" name="operacion" value="registrar" />
					<table>
						<tr class="titulo">
							<td colspan="2" align="center">Registro de Clientes</td>
						</tr>
						<tr class="control">
							<td>Nombre:</td>
							<td><input type="text" name="nombre" size="25"></td>
						</tr>
						<tr class="control">
							<td>Sueldo:</td>
							<td><input type="text" name="sueldo" size="10"></td>
						</tr>
						<tr class="control">
							<td>Sexo:</td>
							<td>
								<select name="sexo">
									<option value="M">Masculino</option>
									<option value="F">Femenino</option>
								</select>
							</td>
						</tr>
						<tr class="control">
							<td>Fecha de Nacimiento:</td>
							<td><input type="text" name="fecnac" size="15"></td>
							<td>dd/MM/yyyy</td>

						</tr>
						<tr class="control">
							<td>Usuario:</td>
							<td><input type="text" name="usuario" size="8"></td>
						</tr>
						<tr class="control">
							<td>Clave:</td>
							<td><input type="text" name="clave" size="8"></td>
						</tr>
						<tr class="control">
							<td colspan="2" align="right">
								<input type="submit" name="boton01" value="Registrar">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<!--  Aquí va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>