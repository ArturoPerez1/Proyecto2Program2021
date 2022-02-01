package modelo;

public class Jugador {
	private String nombre;
	private Mazo juego;
	private Mazo acumulado;
	private int puntos;
	
	public Jugador(){
		nombre = "";
		juego = null;
		acumulado = null;
		puntos = 0;
	}	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		juego = new Mazo();
		acumulado = new Mazo();
		puntos = 0;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Mazo getJuego() {
		return juego;
	}

	public void setJuego(Mazo juego) {
		this.juego = juego;
	}

	public Mazo getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(Mazo acumulado) {
		this.acumulado = acumulado;
	}

	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void a() {
		Jugador a = new Jugador("hola");
		a.acumulado.ImprimirMazo();
	}
}
