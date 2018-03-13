package juegocartas;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Partida implements java.io.Serializable {
	private String nombreJugador;
	private List<Carta> cartasJugador;
	private List<Carta> cartasMaquina;
	private Baraja baraja;
	private String estado;
	int manos;

	public Partida() {
		estado = "jugando";
		baraja = new Baraja();
		baraja.barajar();
		cartasJugador = new LinkedList();
		cartasMaquina = new LinkedList();
		manos = 0;
	}

	public String getNombreJugador() {

		return nombreJugador;
	}

	public List<Carta> getCartasJugador() {

		return cartasJugador;
	}

	public List<Carta> getCartasMaquina() {

		return cartasMaquina;
	}

	public Baraja getBaraja() {

		return baraja;
	}

	public String getEstado() {

		return estado;
	}

	public int getManos() {

		return manos;
	}

	public void setNombreJugador(String nombreJugador) {

		this.nombreJugador = nombreJugador;
	}

	public double getPuntosJugador() {

		double puntos = 0;

		for (Carta c : cartasJugador) {

			puntos += c.getValor();
		}

		return puntos;
	}

	public double getPuntosMaquina() {

		double puntos = 0;

		for (Carta c : cartasMaquina) {

			puntos += c.getValor();
		}

		return puntos;
	}

	/*
	 * metodo pedirCarta incrementa las manos jugadas en 1 nos dara una carta de la
	 * baraja para posteriormente calcularnos la puntuacion y cambiar al estado
	 * correspondiente
	 */
	public void pedirCarta() {

		manos++;

		cartasJugador.add(baraja.extraerCarta());

		if (getPuntosJugador() == 7.5) {

			estado = "ha ganado";

		} else if (getPuntosJugador() > 7.5) {

			estado = "ha perdido";
		}
	}

	/*
	 * Cuando el jugador se ha plantado es el turno de la maquina, que pedira carta
	 * mientras su puntuacion sea menor que la del jugador En caso de pasarse se
	 * cambiara el estado del jugador a "ha ganado". Si la maquina no se pasa y deja
	 * de jugar significara que ha obtenido la misma puntuacion que el jugador
	 * ("ha empatado") o una superior ("ha perdido")
	 */
	public void plantarse() {

		while (getPuntosMaquina() < getPuntosJugador()) {

			cartasMaquina.add(baraja.extraerCarta());
		}

		if (getPuntosMaquina() > 7.5) {

			estado = "ha ganado";
		}

		if (estado.equals("jugando")) {

			if (getPuntosJugador() == getPuntosMaquina()) {

				estado = "ha empatado";

			} else {

				estado = "ha perdido";
			}
		}
	}
}
