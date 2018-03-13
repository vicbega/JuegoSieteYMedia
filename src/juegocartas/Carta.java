/*
 * Bean Carta
 * Representa una carta de la baraja espagnola
 */
package juegocartas;

import java.text.NumberFormat;

/**
 *
 * @author jose
 */
public class Carta implements java.io.Serializable {
	private int numero;
	private String palo;

	public Carta() {
	}

	public Carta(int numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}

	public String getNombre() {
		return numero + " de " + palo;
	}

	/*
	 * metodo getValor si el valor de la carta es menor a 10 el valor de la carta
	 * sera el correspondiente a su numero sino valdra medio punto
	 */
	public double getValor() {
		return numero < 10 ? numero : 0.5;
	}

	public String getImagen() {
		NumberFormat formato = NumberFormat.getIntegerInstance();
		formato.setMinimumIntegerDigits(2);
		return palo + "_" + formato.format(numero) + ".png";
	}
}
