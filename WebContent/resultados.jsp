<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado de la partida</title>
</head>
<body style="background-color: green; color: white">
	<h1>Juego de las Siete y Media</h1>
	Cartas de ${partida.nombreJugador}
	<div>
		<%--Recorre todas las cartas del jugador y muestra las imagenes de las mismas --%>
		<c:forEach items="${partida.cartasJugador}" var="carta">
			<img src="imagenes/${carta.imagen}">
		</c:forEach>
	</div>
	<br> ${partida.nombreJugador} tiene ${partida.puntosJugador}
	puntos.
	<br> Cartas de la maquina
	<div>
		<%--Recorre todas las cartas de la maquina y muestra las imagenes de las mismas --%>
		<c:forEach items="${partida.cartasMaquina}" var="carta">
			<img src="imagenes/${carta.imagen}">
		</c:forEach>
	</div>
	<br> La maquina tiene ${partida.puntosMaquina} puntos.
	<div
		style="background-color: darkolivegreen; color: yellow; font: large cursive;">
		${partida.nombreJugador} ${partida.estado}</div>

	<div style="background-color: lightgreen;">
		<form action="mano.jsp">
			<input type="submit" name="nuevaPartida" value="Nueva Partida">
			<input type="hidden" name="nombreJugador"
				value="${partida.nombreJugador}">
		</form>
	</div>
	<div>Estado: ${partida.estado}</div>
</body>
</html>
