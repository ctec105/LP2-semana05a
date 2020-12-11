<!-- Dentro de un jsp, en vez de usar scriptlets  y expression también podemos
     utilizar un lenguaje denominado EL: Expression Language. 
     Las más básicas son conocidas como JSTL -->
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
			<!-- Aqui va la cabecera -->
			<td colspan="2" align="center"><jsp:include page="cabecera.jsp" /></td>
		</tr>
		<tr>
			<!-- Aqui va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!-- Aqui va el cuerpo -->
			<td>
				<table class="control">
					<tr>
						<td colspan="2">Bienvenido estimado usuario, sus datos
							son:(recuperados con EL)</td>
					</tr>
					<!-- Usando "EL" recuperamos los datos de la sesión y del request.
					     En "EL" existe objetos predefinidos:
					     param , representa los parámetros que llegan en el request
					     requestScope, permite acceder a los atributos  en el request
					     sessionScope, permite accedder a los atributos en la  sesion web
					-->
					<tr>
						<td>Usuario:</td>
						<td>${sessionScope.usuario.email}</td>
					</tr>
					<tr>
						<td>Fecha Nac.:</td>
						<td>${sessionScope.usuario.fecnac}</td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td>${sessionScope.usuario.nombre}</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<!--  Aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>