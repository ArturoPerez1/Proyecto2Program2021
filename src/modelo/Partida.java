package modelo;

public class Partida {
    private EstadoInicial _gestionInicialJuego;
    private JuegoInterno _miJuego;

    public Partida() {
        this._gestionInicialJuego = new EstadoInicial();
//		this._miJuego = new JuegoInterno();
    }

    public EstadoInicial getGestionInicialJuego() {
        return _gestionInicialJuego;
    }

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
            if (mazoJugadores.getValor().equals("AS")) {
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
        _miJuego.juego = _gestionInicialJuego;
        if (_gestionInicialJuego.isTurnoPersona()) {
            _miJuego.turnoPersonaJugar(salir);
            _miJuego.juego.setTurnoPersona(false);
        } else {
            _miJuego.turnoComputadora();
            _miJuego.juego.setTurnoPersona(true);
        }
    }

    public void ultimoRecoger(Mazo mazoMeza, Jugador jugadores) {
        Carta carta = new Carta();
        carta = mazoMeza.getMazo();
        int cantidadCartas = jugadores.getAcumulado().getCantidadCartas();
        while (carta != null) {
            jugadores.getAcumulado().InsertarCarta(carta.getIndiceCarta(), carta.getFigura(), carta.getValor(), "");
            mazoMeza.EliminarCarta(carta.getFigura(), carta.getValor());
            carta = carta.getProximo();
            jugadores.getAcumulado().setCantidadCartas(cantidadCartas++);
        }
    }

    public void partidaNueva(String nombre) {
        _gestionInicialJuego = _gestionInicialJuego.estadoInicial(nombre, turnoAleatorio());
        boolean reparte = _gestionInicialJuego.isRepartePersona();
        boolean reparteMesa = true;
        boolean salir = false;


        _gestionInicialJuego.getMazoPilon().RepartirCartas(reparteMesa, _gestionInicialJuego.isRepartePersona(),
                _gestionInicialJuego.getMazoPersona().getJuego(), _gestionInicialJuego.getMazoComputadora().getJuego(),
                _gestionInicialJuego.getMazoMesa());

        //-------------------------------------------------
//		while (controladorJuego.getMazoPilon().getMazo() != null) {
//			controladorJuego.getMazoPilon().RepartirCartas(reparteMesa, controladorJuego.isRepartePersona(),
//					controladorJuego.getMazoPersona().getJuego(), controladorJuego.getMazoComputadora().getJuego(),
//					controladorJuego.getMazoMesa());
//			
//			reparteMesa = false;
//			if (reparte) {
//				while (controladorJuego.getMazoPersona().getJuego().getMazo() != null) {
//					turnosDeJuego(salir);
//					if (salir) {
//						System.out.println("salioiiii11.11");
//						return;
//					}
//				}
//			} else {
//				while (controladorJuego.getMazoComputadora().getJuego().getMazo() != null) {
//					turnosDeJuego(salir);
//					if (salir) {
//						System.out.println("salioiiii22.11");
//						return;
//					}
//				}
//			}
//		}
//		if (controladorJuego.getMazoMesa().getMazo() != null) {
//			if (controladorJuego.isUltimoRecoger()) {
//				System.out.println(
//						" El ultimo que recogio fue la Persona: " + controladorJuego.getMazoPersona().getNombre());
//				ultimoRecoger(controladorJuego.getMazoMesa(), controladorJuego.getMazoPersona());
//			} else {
//				System.out.println(
//						" El ultimo que recogio fue la Persona: " + controladorJuego.getMazoComputadora().getNombre());
//				ultimoRecoger(controladorJuego.getMazoMesa(), controladorJuego.getMazoComputadora());
//			}
//		}
//		controladorJuego = miJuego.juego;
//		ValoracionCartas(controladorJuego.getMazoComputadora());
//		ValoracionCartas(controladorJuego.getMazoPersona());
//		controladorJuego.mostrarJuego(controladorJuego);
//		System.out.println();
//		if (controladorJuego.getMazoPersona().getPuntos() > controladorJuego.getMazoComputadora().getPuntos()) {
//			System.out
//					.println(" El ganador es " + controladorJuego.getMazoPersona().getNombre() + " Felicidades... \n");
//			System.out.println(" " + controladorJuego.getMazoPersona().getNombre() + " "
//					+ controladorJuego.getMazoPersona().getPuntos() + " puntos\n");
//			System.out.println(" " + controladorJuego.getMazoComputadora().getNombre() + " "
//					+ controladorJuego.getMazoComputadora().getPuntos() + " puntos\n");
//		} else {
//			System.out.println(" El ganador es " + controladorJuego.getMazoComputadora().getNombre() + "\n");
//			System.out.println(" " + controladorJuego.getMazoComputadora().getNombre() + " "
//					+ controladorJuego.getMazoComputadora().getPuntos() + " puntos\n");
//			System.out.println(" " + controladorJuego.getMazoPersona().getNombre() + " "
//					+ controladorJuego.getMazoPersona().getPuntos() + " puntos\n");
//			System.out.println(" Mejor suerte para la proxima\n");
//		}
//		System.out.println(" Fin del Juego \n");
//		System.out.println(" Gracias por jugar....");
    }

}