package modelo;

public class Partida {
    private EstadoInicial _gestionInicialJuego;
    private JuegoInterno _miJuego;
    private Carta listaCartaJugador;
    private Carta listaCartaPc;
    private  boolean reparteMesa;

    public Partida() {
        this._gestionInicialJuego = new EstadoInicial();
        this.listaCartaJugador = null;
        this.listaCartaPc = null;
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
    
    // esta es la funcion que devuelve el puntaje
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

    public void turnosDeJuego() {
        _miJuego.juego = _gestionInicialJuego;
        if (_gestionInicialJuego.isTurnoPersona()) {
        	//llamar a la interfaz del jugador;
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
        reparteMesa = true;
    }
    
    //------------------------------------------------------
    //SISTEMA DE TURNOS Y PARTIDA COMPLETA;
    public void TurnosYPartidaCompleta() {    
        if(_gestionInicialJuego.isRepartePersona()) {
        	System.out.println("ESTÁ REPARTIENDO EL JUGADOR");
            //SE REPARTE A TODOS PRIMERO;
        	if(reparteMesa) {
        		_gestionInicialJuego.getMazoPilon().RepartirCartas(reparteMesa, _gestionInicialJuego.isRepartePersona(),
                    _gestionInicialJuego.getMazoPersona().getJuego(), _gestionInicialJuego.getMazoComputadora().getJuego(),
                    _gestionInicialJuego.getMazoMesa());
        		reparteMesa = false;
        	}
        	else {
        		_gestionInicialJuego.getMazoPilon().RepartirCartas(reparteMesa, _gestionInicialJuego.isRepartePersona(),
                        _gestionInicialJuego.getMazoPersona().getJuego(), _gestionInicialJuego.getMazoComputadora().getJuego(),
                        _gestionInicialJuego.getMazoMesa());
        	}
        	System.out.println("holaSoyReparte" + _gestionInicialJuego.isRepartePersona());
        }
//        else {
//        	System.out.println("ESTÁ REPARTIENDO EL COMPUTADOR");
//            //SE REPARTE A TODOS PRIMERO;
//        	if(reparteMesa) {
//        		_gestionInicialJuego.getMazoPilon().RepartirCartas(reparteMesa, _gestionInicialJuego.isRepartePersona(),
//                    _gestionInicialJuego.getMazoPersona().getJuego(), _gestionInicialJuego.getMazoComputadora().getJuego(),
//                    _gestionInicialJuego.getMazoMesa());
//        		reparteMesa = false;
//        	}
//        	else {
//        		_gestionInicialJuego.getMazoPilon().RepartirCartas(reparteMesa, _gestionInicialJuego.isRepartePersona(),
//                        _gestionInicialJuego.getMazoPersona().getJuego(), _gestionInicialJuego.getMazoComputadora().getJuego(),
//                        _gestionInicialJuego.getMazoMesa());
//        	}
//        }
    }
    //------------------------------------------------------
}