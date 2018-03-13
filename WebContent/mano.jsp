<%--Añade la libreria --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--Elimina el beans actual en caso de existir --%>
<c:if test="${!empty param.nuevaPartida}">
	<c:remove var="partida" scope="session" />
</c:if>

<%--Crea un beans con la clase Partida --%>
<jsp:useBean id="partida" class="juegocartas.Partida" scope="session" />

<%--Asigna al nombre del jugador el nombre introducido en el formulario --%>
<c:if test="${!empty param.nombreJugador}">
	<c:set target="${partida}" property="nombreJugador"
		value="${param.nombreJugador}" />
</c:if>

<%--Llama al metodo 'plantarse' de la clase 'Partida' al plantarse --%>
<c:if test="${!empty param.plantarse}">
    ${partida.plantarse()}
</c:if>

<%--Llama al metodo 'pedirCarta' de la clase 'Partida' al pedir carta --%>
<c:if test="${!empty param.pedirCarta}">
    ${partida.pedirCarta()}
</c:if>

<%--Si el estado de la partida es diferente a 'jugando' el juego la dará por finalizada y pasara al recuento de puntos --%>
<c:if test="${partida.estado != 'jugando'}">
    Se terminó el juego
    <c:redirect url="resultados.jsp" />
</c:if>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body style="background-color: green; color: white;">
	<h1>Juego de las Siete y Media</h1>
	Cartas de ${partida.nombreJugador}
	<div>
		<%--Recorre todas las cartas del jugador y muestra la imagen de las mismas --%>
		<c:forEach items="${partida.cartasJugador}" var="carta">
			<img src="imagenes/${carta.imagen}">
		</c:forEach>
	</div>
	<br> ${partida.nombreJugador} tiene ${partida.puntosJugador}
	puntos.
	<div style="background-color: lightgreen;">
		<form>
			<input type="submit" name="pedirCarta" value="Pedir Carta"> <input
				type="submit" name="plantarse" value="Me planto">
		</form>
	</div>
	<div>Estado: ${partida.estado}</div>
</body>
</html>