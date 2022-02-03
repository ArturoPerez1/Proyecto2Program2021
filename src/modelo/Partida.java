package modelo;

import java.util.Scanner;

public class Partida {
	private EstadoInicial juego = new EstadoInicial();
	private JuegoInterno miJuego = new JuegoInterno();
	private Scanner entrada;

	public boolean turnoAleatorio() {
		boolean turnoPersona;
		int aleatorio = (int) (1 + Math.random() * 2);
		if (aleatorio == 1)
			turnoPersona = true;
		else
			turnoPersona = false;
		return turnoPersona;
	}

	public void ValoracionCartas(Jugador jugadores) {
		Carta mazoJugadores = jugadores.getAcumulado().getMazo();
		int contarCartas = 0, cartaCorNegro = 0, puntos = 0;
		while (mazoJugadores != null) {
			if ((mazoJugadores.getIndiceCarta() > 26) && (mazoJugadores.getIndiceCarta() < 40)) {
				cartaCorNegro++;
			}
			if (mazoJugadores.getIndiceCarta() == 28) {
				puntos += 1;
			}
			if (mazoJugadores.getIndiceCarta() == 49) {
				puntos += 2;
			}
			if (mazoJugadores.getNumero().equals("AS")) {
				puntos += 1;
			}
			mazoJugadores = mazoJugadores.getProximo();
			contarCartas++;
		}
		if (contarCartas > 26) {
			puntos += 3;
		}
		if (cartaCorNegro > 6) {
			puntos += 1;
		}
		if (jugadores.getAcumulado().getCantidadCartas() == 26) {
			if (cartaCorNegro > 6) {
				puntos += 3;
			}
		}
		jugadores.setPuntos(puntos);
	}

	public void turnosDeJuego(boolean salir) {
		miJuego.juego = juego;
		if (juego.isTurnoPersona()) {
			miJuego.turnoPersonaJugar(salir);
			miJuego.juego.setTurnoPersona(false);
			// System.out.println(salir);
		} else {
			miJuego.turnoComputadora();
			miJuego.juego.setTurnoPersona(true);
		}
	}

	public void ultimoRecoger(Mazo mazoMeza, Jugador jugadores) {
		Carta carta = new Carta();
		carta = mazoMeza.getMazo();
		int cantidadCartas = jugadores.getAcumulado().getCantidadCartas();
		while (carta != null) {
			jugadores.getAcumulado().InsertarCarta(carta.getTipo(), carta.getNumero(), carta.getIndiceCarta());
			mazoMeza.EliminarCarta(carta.getTipo(), carta.getNumero());
			carta = carta.getProximo();
			jugadores.getAcumulado().setCantidadCartas(cantidadCartas++);
		}
	}

	public void partidaNueva() {
		entrada = new Scanner(System.in);
		String nombre;
		boolean salir = false;
		System.out.print(" Cual es tu nombre: ");
		nombre = entrada.nextLine();
		juego = juego.estadoInicial(nombre, turnoAleatorio());
		boolean reparte = juego.isRepartePersona();
		boolean reparteMesa = true;
		while (juego.getMazoPilon().getMazo() != null) {
			juego.getMazoPilon().RepartirCartas(reparteMesa, juego.isRepartePersona(), juego.getPersona().getJuego(),
					juego.getComputadora().getJuego(), juego.getMazoMesa());
			reparteMesa = false;
			if (reparte) {
				while (juego.getPersona().getJuego().getMazo() != null) {
					turnosDeJuego(salir);
					if (salir) {
						System.out.println("salioiiii11.11");
						return;
					}
				}
			} else {
				while (juego.getComputadora().getJuego().getMazo() != null) {
					turnosDeJuego(salir);
					if (salir) {
						System.out.println("salioiiii22.11");
						return;
					}
				}
			}
		}
		if (juego.getMazoMesa().getMazo() != null) {
			if (juego.isUltimoRecoger()) {
				System.out.println(" El ultimo que recogio fue la Persona: " + juego.getPersona().getNombre());
				ultimoRecoger(juego.getMazoMesa(), juego.getPersona());
			} else {
				System.out.println(" El ultimo que recogio fue la Persona: " + juego.getComputadora().getNombre());
				ultimoRecoger(juego.getMazoMesa(), juego.getComputadora());
			}
		}
		juego = miJuego.juego;
		ValoracionCartas(juego.getComputadora());
		ValoracionCartas(juego.getPersona());
		juego.mostrarJuego(juego);
		System.out.println();
		if (juego.getPersona().getPuntos() > juego.getComputadora().getPuntos()) {
			System.out.println(" El ganador es " + juego.getPersona().getNombre() + " Felicidades... \n");
			System.out
					.println(" " + juego.getPersona().getNombre() + " " + juego.getPersona().getPuntos() + " puntos\n");
			System.out.println(
					" " + juego.getComputadora().getNombre() + " " + juego.getComputadora().getPuntos() + " puntos\n");
		} else {
			System.out.println(" El ganador es " + juego.getComputadora().getNombre() + "\n");
			System.out.println(
					" " + juego.getComputadora().getNombre() + " " + juego.getComputadora().getPuntos() + " puntos\n");
			System.out
					.println(" " + juego.getPersona().getNombre() + " " + juego.getPersona().getPuntos() + " puntos\n");
			System.out.println(" Mejor suerte para la proxima\n");
		}
		System.out.println(" Fin del Juego \n");
		System.out.println(" Gracias por jugar....");
	}
}