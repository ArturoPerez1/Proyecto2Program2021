package modelo;

public class EstadoInicial {
	private Mazo mazoPilon;
	private Mazo mazoMesa;
	private Jugador persona;
	private Jugador computadora;
	private boolean ultimoRecoger;
	private boolean repartePersona;
	private boolean turnoPersona;

	public EstadoInicial() {
		mazoPilon = null;
		mazoMesa = null;
	}

	public Mazo getMazoPilon() {
		return mazoPilon;
	}

	public void setMazoPilon(Mazo mazoPilon) {
		this.mazoPilon = mazoPilon;
	}

	public Mazo getMazoMesa() {
		return mazoMesa;
	}

	public void setMazoMesa(Mazo mazoMesa) {
		this.mazoMesa = mazoMesa;
	}

	public Jugador getPersona() {
		return persona;
	}

	public void setPersona(Jugador persona) {
		this.persona = persona;
	}

	public Jugador getComputadora() {
		return computadora;
	}

	public void setComputadora(Jugador computadora) {
		this.computadora = computadora;
	}

	public boolean isUltimoRecoger() {
		return ultimoRecoger;
	}

	public void setUltimoRecoger(boolean ultimoRecoger) {
		this.ultimoRecoger = ultimoRecoger;
	}

	public boolean isRepartePersona() {
		return repartePersona;
	}

	public void setRepartePersona(boolean repartePersona) {
		this.repartePersona = repartePersona;
	}

	public boolean isTurnoPersona() {
		return turnoPersona;
	}

	public void setTurnoPersona(boolean turnoPersona) {
		this.turnoPersona = turnoPersona;
	}

	public EstadoInicial estadoInicial(String nombre, boolean turno) {
		EstadoInicial juego = new EstadoInicial();
		Jugador persona = new Jugador(nombre);
		;
		Jugador computadora = new Jugador("Computadora");
		Mazo mesa = new Mazo();
		Mazo mazo = new Mazo();
		mazo.LlenarMazo();
		mazo.barajearMazo();
		juego.persona = persona;
		juego.computadora = computadora;
		juego.mazoPilon = mazo;
		juego.mazoMesa = mesa;
		juego.turnoPersona = turno;
		juego.repartePersona = !turno;
		return juego;
	}

	void mostrarJugadoresYAcumulado(EstadoInicial juego, Jugador mostrar, int personaMostrar) {
		Mazo mazo = mostrar.getJuego();
		Mazo mazoAcumulado = mostrar.getAcumulado();
		System.out.println("Mazo de " + mostrar.getNombre() + ": ");
		mazo.ImprimirMazo();
		if (mazoAcumulado.getMazo() != null) {
			System.out.println();
			System.out.print("Cartas Acumuladas de " + mostrar.getNombre() + ": ");
			System.out.println();
			mostrar.getAcumulado().ImprimirMazo();
		}
	}

	public void mostrarJuego(EstadoInicial mostrar) {
		System.out.println("\n JUEGO CASINO\n");
		if (mostrar.turnoPersona)
			System.out.println("Turno de " + mostrar.persona.getNombre() + "\n");
		else
			System.out.println("Turno del " + mostrar.computadora.getNombre() + "\n");
		mostrarJugadoresYAcumulado(mostrar, mostrar.computadora, 0);
		System.out.println();
		System.out.println("Mesa:");
		mostrar.mazoMesa.ImprimirMazo();
		System.out.println();
		mostrarJugadoresYAcumulado(mostrar, mostrar.persona, 1);
		// System.out.println(" MAZO DEL JUEGO: ");
		// mostrar.mazoPilon.ImprimirMazo();
	}
}
