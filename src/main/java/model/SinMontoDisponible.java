package model;

public class SinMontoDisponible extends Exception {
	public SinMontoDisponible() {
		super("Presupuesto insuficiente");
	}
}
