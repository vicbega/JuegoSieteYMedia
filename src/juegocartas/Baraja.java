/*
 * Bean Baraja
 * Representa una baraja de cartas
 */
package juegocartas;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Baraja implements java.io.Serializable {

	private List<Carta> cartas;

	public Baraja() {
		cartas = new LinkedList();
		rellenar(cartas, "oros");
		rellenar(cartas, "espadas");
		rellenar(cartas, "copas");
		rellenar(cartas, "bastos");
	}

	/*
	 * metodo rellenar recorre numeros del 1 hasta el 12 insertando solo los valores
	 * correctos de una baraja española
	 */
	private void rellenar(List<Carta> cartas, String palo) {
		for (int i = 1; i <= 12; i++) {

			if (i < 8 || i > 9) {

				cartas.add(new Carta(i, palo));
			}
		}
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public int getNumeroCartas() {
		return cartas.size();
	}

	public void barajar() {
		Collections.shuffle(cartas);
	}

	public Carta extraerCarta() {
		return cartas.remove(0);
	}
}