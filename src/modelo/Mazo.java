package modelo;

public class Mazo {
	private Carta _mazo;
	private Carta _listaCartasSumadasJugador;
	private Carta _listaCartasInterfaz;
	private Carta _listaCartasSumadasMesa;
	private Carta _cartasRestantesMesa;
	private Carta _cartasRestantesJugador;
	private Archivos _controlArchivos;
	private int _cantidadCartas;
	private boolean _VerificarSumarCartas;

	public Mazo() {
		this._listaCartasInterfaz = new Carta();
		this._mazo = new Carta();
		this._listaCartasSumadasJugador = null;
		this._listaCartasSumadasMesa = null;
		this._cartasRestantesMesa = null;
		this._cartasRestantesJugador = null;
		this._cantidadCartas = 0;
		this._controlArchivos = new Archivos();
	}

	public Carta getListaCartasSumadasJugador() {
		return _listaCartasSumadasJugador;
	}

	public Carta getListaCartasInterfaz() {
		return _listaCartasInterfaz;
	}

	public int getCantidadCartas() {
		return _cantidadCartas;
	}

	public void setCantidadCartas(int cantidadCartas) {
		this._cantidadCartas = cantidadCartas;
	}

	public Carta getMazo() {
		return _mazo;
	}

	public void setMazo(Carta mazo) {
		this._mazo = mazo;
	}

	public Carta getListaCartasSumadasMesa() {
		return _listaCartasSumadasMesa;
	}

	public Carta getCartasRestantesMesa() {
		return _cartasRestantesMesa;
	}

	public Carta getCartasRestantesJugador() {
		return _cartasRestantesJugador;
	}

	public boolean is_VerificarSumarCartas() {
		return _VerificarSumarCartas;
	}

	public void InsertarCarta(int id, String figura, String valor, String imagen) {
		Carta cartaAuxiliar = new Carta();
		Carta cartaAuxiliar2 = new Carta();

		cartaAuxiliar.setIndiceCarta(id);
		cartaAuxiliar.setFigura(figura);
		cartaAuxiliar.setNumero(valor);
		cartaAuxiliar.setImagen(imagen);
		cartaAuxiliar.setProximo(null);

		if (_mazo == null) {
			_mazo = cartaAuxiliar;
		} else {
			cartaAuxiliar2 = _mazo;
			while (cartaAuxiliar2.getProximo() != null) {
				cartaAuxiliar2 = cartaAuxiliar2.getProximo();
			}
			cartaAuxiliar2.setProximo(cartaAuxiliar);
		}
	}

	// --------------------------------------------------------------------------------------

	public void LanzarCartaAMesa(int idInstace, Carta mesa, Carta jugador) {
		Carta jugadorAux = new Carta();
		Carta cabeza = new Carta();
		jugadorAux.setIndiceCarta(idInstace);
		jugadorAux.setProximo(null);
		cabeza = jugadorAux;

		while (jugador != null) {
			if (jugador.getIndiceCarta() == jugadorAux.getIndiceCarta()) {
				jugadorAux.setImagen(jugador.getImagen());
				jugadorAux.setFigura(jugador.getFigura());
				jugadorAux.setNumero(jugador.getValor());
			} else {
				_cartasRestantesJugador = InsertarNoSumados(jugador.getIndiceCarta(), jugador.getFigura(),
						jugador.getValor(), jugador.getImagen(), _cartasRestantesJugador);
			}
			jugador = jugador.getProximo();
		}

		while (mesa != null) {
			_cartasRestantesMesa = InsertarNoSumados(mesa.getIndiceCarta(), mesa.getFigura(), mesa.getValor(),
					mesa.getImagen(), _cartasRestantesMesa);
			mesa = mesa.getProximo();
		}

		jugadorAux = cabeza;
		_cartasRestantesMesa = InsertarNoSumados(jugadorAux.getIndiceCarta(), jugadorAux.getFigura(),
				jugadorAux.getValor(), jugadorAux.getImagen(), _cartasRestantesMesa);
	}

	public Carta InsertarNoSumados(int id, String figura, String valor, String imagen, Carta insertarNoSumados) {
		Carta cartaAuxiliar = new Carta();
		Carta cartaAuxiliar2 = new Carta();

		cartaAuxiliar.setIndiceCarta(id);
		cartaAuxiliar.setFigura(figura);
		cartaAuxiliar.setNumero(valor);
		cartaAuxiliar.setImagen(imagen);
		cartaAuxiliar.setProximo(null);

		if (insertarNoSumados == null) {
			insertarNoSumados = cartaAuxiliar;
		} else if (BuscarIDRepetido(insertarNoSumados, cartaAuxiliar.getIndiceCarta())) {
			cartaAuxiliar2 = insertarNoSumados;
			while (cartaAuxiliar2.getProximo() != null) {
				cartaAuxiliar2 = cartaAuxiliar2.getProximo();
			}
			cartaAuxiliar2.setProximo(cartaAuxiliar);
		}

		return insertarNoSumados;
	}

	public Carta InsertarSuma(int id, String figura, String valor, String imagen, Carta insertarCartaSuma) {
		Carta cartaAuxiliar = new Carta();
		Carta cartaAuxiliar2 = new Carta();

		cartaAuxiliar.setIndiceCarta(id);
		cartaAuxiliar.setFigura(figura);
		cartaAuxiliar.setNumero(valor);
		cartaAuxiliar.setImagen(imagen);
		cartaAuxiliar.setProximo(null);

		if (insertarCartaSuma == null) {
			insertarCartaSuma = cartaAuxiliar;
		} else if (BuscarIDRepetido(insertarCartaSuma, cartaAuxiliar.getIndiceCarta())) {
			cartaAuxiliar2 = insertarCartaSuma;
			while (cartaAuxiliar2.getProximo() != null) {
				cartaAuxiliar2 = cartaAuxiliar2.getProximo();
			}
			cartaAuxiliar2.setProximo(cartaAuxiliar);
		}

		return insertarCartaSuma;
	}

	public void sumarCartas(Carta listaCartasMesa, Carta listaCartaJugador, Carta mesaPrincipal,
			Carta jugadorPrincipal) {
		if (_VerificarSumarCartas) {
			Carta listaCartasMesaAux = new Carta();
			Carta listaCartaJugadorAux = new Carta();
			Carta cabezaMesa = mesaPrincipal;
			Carta cabezaJugador = jugadorPrincipal;

			listaCartasMesaAux = listaCartasMesa;
			listaCartaJugadorAux = listaCartaJugador;

			while (mesaPrincipal != null) {
				while (listaCartasMesaAux != null) {
					if (mesaPrincipal.getIndiceCarta() == listaCartasMesaAux.getIndiceCarta()) {
						if (mesaPrincipal.getValor() == "A") {
							_listaCartasSumadasMesa = InsertarSuma(mesaPrincipal.getIndiceCarta(),
									mesaPrincipal.getFigura(), mesaPrincipal.getValor(), mesaPrincipal.getImagen(),
									_listaCartasSumadasMesa);
						} else if (mesaPrincipal.getValor() != "J" && mesaPrincipal.getValor() != "Q"
								&& mesaPrincipal.getValor() != "k") {
							_listaCartasSumadasMesa = InsertarSuma(mesaPrincipal.getIndiceCarta(),
									mesaPrincipal.getFigura(), mesaPrincipal.getValor(), mesaPrincipal.getImagen(),
									_listaCartasSumadasMesa);
						}
					}
					listaCartasMesaAux = listaCartasMesaAux.getProximo();
				}
				listaCartasMesaAux = listaCartasMesa;
				mesaPrincipal = mesaPrincipal.getProximo();
			}

			while (jugadorPrincipal != null) {
				while (listaCartaJugadorAux != null) {
					if (jugadorPrincipal.getIndiceCarta() == listaCartaJugadorAux.getIndiceCarta()) {
						if (jugadorPrincipal.getValor() == "A") {
							_listaCartasSumadasJugador = InsertarSuma(jugadorPrincipal.getIndiceCarta(),
									jugadorPrincipal.getFigura(), jugadorPrincipal.getValor(),
									jugadorPrincipal.getImagen(), _listaCartasSumadasJugador);
						} else if (jugadorPrincipal.getValor() != "J" && jugadorPrincipal.getValor() != "Q"
								&& jugadorPrincipal.getValor() != "k") {
							_listaCartasSumadasJugador = InsertarSuma(jugadorPrincipal.getIndiceCarta(),
									jugadorPrincipal.getFigura(), jugadorPrincipal.getValor(),
									jugadorPrincipal.getImagen(), _listaCartasSumadasJugador);
						}
					}
					listaCartaJugadorAux = listaCartaJugadorAux.getProximo();
				}

				listaCartaJugadorAux = listaCartaJugador;
				jugadorPrincipal = jugadorPrincipal.getProximo();
			}

			mesaPrincipal = cabezaMesa;
			jugadorPrincipal = cabezaJugador;
			listaCartasMesaAux = listaCartasMesa;
			listaCartaJugadorAux = listaCartaJugador;

			while (mesaPrincipal != null) {
				if (listaCartasMesaAux.getProximo() != null) {
					if (mesaPrincipal.getIndiceCarta() != listaCartasMesaAux.getIndiceCarta()
							&& mesaPrincipal.getIndiceCarta() != listaCartasMesaAux.getProximo().getIndiceCarta()) {
						_cartasRestantesMesa = InsertarNoSumados(mesaPrincipal.getIndiceCarta(),
								mesaPrincipal.getFigura(), mesaPrincipal.getValor(), mesaPrincipal.getImagen(),
								_cartasRestantesMesa);
					}
				} else {
					if (mesaPrincipal.getIndiceCarta() != listaCartasMesaAux.getIndiceCarta()) {
						_cartasRestantesMesa = InsertarNoSumados(mesaPrincipal.getIndiceCarta(),
								mesaPrincipal.getFigura(), mesaPrincipal.getValor(), mesaPrincipal.getImagen(),
								_cartasRestantesMesa);
					}
				}
				mesaPrincipal = mesaPrincipal.getProximo();
			}

			while (jugadorPrincipal != null) {
				if (jugadorPrincipal.getIndiceCarta() != listaCartaJugadorAux.getIndiceCarta()) {
					_cartasRestantesJugador = InsertarNoSumados(jugadorPrincipal.getIndiceCarta(),
							jugadorPrincipal.getFigura(), jugadorPrincipal.getValor(), jugadorPrincipal.getImagen(),
							_cartasRestantesJugador);
				}
				jugadorPrincipal = jugadorPrincipal.getProximo();
			}
			_controlArchivos.GuardarMazoAcumuladorJugador(_listaCartasSumadasJugador);
			_controlArchivos.GuardarMazoAcumuladorJugador(_listaCartasSumadasMesa);
		}
	}

	public void VerificarSumaCartas(Carta listaCartasMesa, Carta listaCartaJugador, Carta mesaPrincipal,
			Carta jugadorPrincipal) {
		Carta cabezaMesa = new Carta();
		Carta cabezaJugador = new Carta();
		Carta mesaPrincipalAux = new Carta();
		Carta jugadorPrincipalAux = new Carta();
		int valorCartaMesaFinal = 0;
		int valorJugadorFinal = 0;

		cabezaMesa = listaCartasMesa;
		cabezaJugador = listaCartaJugador;

		mesaPrincipalAux = mesaPrincipal;
		jugadorPrincipalAux = jugadorPrincipal;

		while (mesaPrincipal != null) {
			while (listaCartasMesa != null) {
				if (mesaPrincipal.getIndiceCarta() == listaCartasMesa.getIndiceCarta()) {
					if (mesaPrincipal.getValor() == "A") {
						valorCartaMesaFinal += 1;
					} else if (mesaPrincipal.getValor() != "J" && mesaPrincipal.getValor() != "Q"
							&& mesaPrincipal.getValor() != "k") {
						valorCartaMesaFinal += Integer.valueOf(mesaPrincipal.getValor());
					} else if (mesaPrincipal.getValor() == "J" || mesaPrincipal.getValor() == "Q"
							|| mesaPrincipal.getValor() == "k") {

						if (mesaPrincipal.getValor() == "k") {
							valorCartaMesaFinal += 13;
						} else if (mesaPrincipal.getValor() == "Q") {
							valorCartaMesaFinal += 12;
						} else if (mesaPrincipal.getValor() == "J") {
							valorCartaMesaFinal += 11;
						}

					}
				}
				listaCartasMesa = listaCartasMesa.getProximo();
			}
			listaCartasMesa = cabezaMesa;
			mesaPrincipal = mesaPrincipal.getProximo();
		}

		while (jugadorPrincipal != null) {
			while (listaCartaJugador != null) {
				if (jugadorPrincipal.getIndiceCarta() == listaCartaJugador.getIndiceCarta()) {
					if (jugadorPrincipal.getValor() == "A") {
						valorJugadorFinal += 1;
					} else if (jugadorPrincipal.getValor() != "J" && jugadorPrincipal.getValor() != "Q"
							&& jugadorPrincipal.getValor() != "k") {
						valorJugadorFinal += Integer.valueOf(jugadorPrincipal.getValor());
					} else if (jugadorPrincipal.getValor() == "J" || jugadorPrincipal.getValor() == "Q"
							|| jugadorPrincipal.getValor() == "k") {

						if (jugadorPrincipal.getValor() == "k") {
							valorJugadorFinal += 13;
						} else if (jugadorPrincipal.getValor() == "Q") {
							valorJugadorFinal += 12;
						} else if (jugadorPrincipal.getValor() == "J") {
							valorJugadorFinal += 11;
						}

					}
				}
				listaCartaJugador = listaCartaJugador.getProximo();
			}
			if (valorJugadorFinal > 0) {
				break;
			} else {
				listaCartaJugador = cabezaJugador;
				jugadorPrincipal = jugadorPrincipal.getProximo();
			}
		}

		jugadorPrincipal = jugadorPrincipalAux;
		mesaPrincipal = mesaPrincipalAux;
		listaCartaJugador = cabezaJugador;
		listaCartasMesa = cabezaMesa;

		if (valorJugadorFinal == valorCartaMesaFinal) {
			_VerificarSumarCartas = true;
			System.out.println("se puede");
			sumarCartas(listaCartasMesa, listaCartaJugador, mesaPrincipal, jugadorPrincipal);
		} else {
			_VerificarSumarCartas = false;
			System.out.println("no puedes jajja");
		}
	}

	public Carta InsertarId(String idCarta, Carta cartaInsertar) {
		Carta cartaAux = new Carta();
		Carta cartaAux1 = new Carta();
		int convertId = Integer.valueOf(idCarta);

		cartaAux.setIndiceCarta(convertId);

		if (cartaInsertar == null) {
			cartaInsertar = cartaAux;
		} else if (BuscarIDRepetido(cartaInsertar, convertId)) {
			cartaAux1 = cartaInsertar;
			while (cartaAux1.getProximo() != null) {
				cartaAux1 = cartaAux1.getProximo();
			}
			cartaAux1.setProximo(cartaAux);
		}

		return cartaInsertar;
	}

	private boolean BuscarIDRepetido(Carta listaCartasInterfaz, int convertId) {
		Carta cartaAux = new Carta();
		cartaAux = listaCartasInterfaz;

		while (cartaAux.getProximo() != null) {
			if (cartaAux.getIndiceCarta() == convertId) {
				return false;
			} else {
				cartaAux = cartaAux.getProximo();
			}
		}
		return true;
	}
	//----------------------------------------------------------------------------------------

	public void BarajearMazo() {
		Mazo mazoBarajeado = new Mazo();
		Carta lista = new Carta();
		Carta actual = new Carta();
		lista = Baraja(); // Devuelve un mazo con indices Random
		lista = lista.getProximo();
		actual = _mazo.getProximo(); // Primera Carta del Mazo

		while (lista != null) {

			if (lista.getIndiceCarta() == actual.getIndiceCarta()) {
				Carta nuevaCarta = new Carta(actual.getIndiceCarta(), actual.getFigura(), actual.getValor(),
						actual.getImagen(), null);
				mazoBarajeado.InsertarCarta(nuevaCarta.getIndiceCarta(), nuevaCarta.getFigura(), nuevaCarta.getValor(),
						nuevaCarta.getImagen());
				lista = lista.getProximo();
				actual = _mazo;
			} else {
				actual = actual.getProximo();
			}

		}

		_mazo = mazoBarajeado._mazo;
	}

	public Carta Baraja() {
		Mazo lista = new Mazo();
		int valor;

		do {
			valor = (int) (1 + Math.random() * 52);

			if (BuscarRepetidos(lista, valor)) {
				lista.InsertarCarta(valor, " ", "", "");
			}

		} while (RecorerMazo(lista._mazo) != 52);

		return lista._mazo;
	}

	public boolean BuscarRepetidos(Mazo mazo, int valor) {
		Carta buscar = new Carta();
		buscar = mazo._mazo;

		if (_mazo == null)
			return true;

		while (buscar != null) {
			if (buscar.getIndiceCarta() == valor) {
				return false;
			} else {
				buscar = buscar.getProximo();
			}
		}
		return true;
	}

	public int RecorerMazo(Carta recorrer) {
		Carta auxiliar = recorrer.getProximo();
		int contador = 0;

		while (auxiliar != null) {
			contador++;
			auxiliar = auxiliar.getProximo();
		}
		return contador;
	}

	public void RepartirCartas(boolean reparteMesa, boolean reparte, Mazo mazoJugador, Mazo mazoComputadora,
			Mazo mazoMesa) {
		Carta aux = new Carta();
		int repartir = 1;
		aux = _mazo.getProximo();

		if (aux != null) {
			if (reparte) {
				while (repartir <= 4) {
					mazoComputadora.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(),
							aux.getImagen());
					EliminarCarta(aux.getFigura(), aux.getValor());
					aux = aux.getProximo();
					mazoJugador.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
					EliminarCarta(aux.getFigura(), aux.getValor());
					aux = aux.getProximo();
					repartir++;
				}
			} else {
				while (repartir <= 4) {
					mazoJugador.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
					EliminarCarta(aux.getFigura(), aux.getValor());
					aux = aux.getProximo();
					mazoComputadora.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(),
							aux.getImagen());
					EliminarCarta(aux.getFigura(), aux.getValor());
					aux = aux.getProximo();
					repartir++;
				}
			}
			repartir = 1;
			if (reparteMesa) {
				while (repartir <= 4) {
					mazoMesa.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
					EliminarCarta(aux.getFigura(), aux.getValor());
					aux = aux.getProximo();
					repartir++;
				}
			}
		}
	}

	public void EliminarCarta(String tipo, String numero) {
		if (_mazo == null)
			System.out.println("lista vacía");
		else if (_mazo.getFigura().equals(tipo) && _mazo.getValor().equals(numero)) {
			_mazo = _mazo.getProximo();
		} else {
			Carta actual = _mazo;
			while (actual.getProximo() != null && actual.getProximo().getFigura() != tipo
					&& actual.getProximo().getValor() != numero)
				actual = actual.getProximo();
			if (actual.getProximo() == null)
				System.out.println("elemento " + actual.getFigura() + actual.getValor() + " no esta en la lista");
			else {
				actual.setProximo(actual.getProximo().getProximo());
			}
		}
	}

	public void GenerarMazoPrincipalDeCartas() {

		// Picas
		InsertarCarta(1, "♠", "A", "1p.png");
		InsertarCarta(2, "♠", "2", "2p.png");
		InsertarCarta(3, "♠", "3", "3p.png");
		InsertarCarta(4, "♠", "4", "4p.png");
		InsertarCarta(5, "♠", "5", "5p.png");
		InsertarCarta(6, "♠", "6", "6p.png");
		InsertarCarta(7, "♠", "7", "7p.png");
		InsertarCarta(8, "♠", "8", "8p.png");
		InsertarCarta(9, "♠", "9", "9p.png");
		InsertarCarta(10, "♠", "10", "10p.png");
		InsertarCarta(11, "♠", "J", "11p.png");
		InsertarCarta(12, "♠", "Q", "12p.png");
		InsertarCarta(13, "♠", "k", "13p.png");

		// Corazones
		InsertarCarta(14, "♥", "A", "1c.png");
		InsertarCarta(15, "♥", "2", "2c.png");
		InsertarCarta(16, "♥", "3", "3c.png");
		InsertarCarta(17, "♥", "4", "4c.png");
		InsertarCarta(18, "♥", "5", "5c.png");
		InsertarCarta(19, "♥", "6", "6c.png");
		InsertarCarta(20, "♥", "7", "7c.png");
		InsertarCarta(21, "♥", "8", "8c.png");
		InsertarCarta(22, "♥", "9", "9c.png");
		InsertarCarta(23, "♥", "10", "10c.png");
		InsertarCarta(24, "♥", "J", "11c.png");
		InsertarCarta(25, "♥", "Q", "12c.png");
		InsertarCarta(26, "♥", "k", "13c.png");

		// Treboles
		InsertarCarta(27, "♣", "A", "1t.png");
		InsertarCarta(28, "♣", "2", "2t.png");
		InsertarCarta(29, "♣", "3", "3t.png");
		InsertarCarta(30, "♣", "4", "4t.png");
		InsertarCarta(31, "♣", "5", "5t.png");
		InsertarCarta(32, "♣", "6", "6t.png");
		InsertarCarta(33, "♣", "7", "7t.png");
		InsertarCarta(34, "♣", "8", "8t.png");
		InsertarCarta(35, "♣", "9", "9t.png");
		InsertarCarta(36, "♣", "10", "10t.png");
		InsertarCarta(37, "♣", "J", "11t.png");
		InsertarCarta(38, "♣", "Q", "12t.png");
		InsertarCarta(39, "♣", "k", "13t.png");

		// Diamantes
		InsertarCarta(40, "♦", "A", "1d.png");
		InsertarCarta(41, "♦", "2", "2d.png");
		InsertarCarta(42, "♦", "3", "3d.png");
		InsertarCarta(43, "♦", "4", "4d.png");
		InsertarCarta(44, "♦", "5", "5d.png");
		InsertarCarta(45, "♦", "6", "6d.png");
		InsertarCarta(46, "♦", "7", "7d.png");
		InsertarCarta(47, "♦", "8", "8d.png");
		InsertarCarta(48, "♦", "9", "9d.png");
		InsertarCarta(49, "♦", "10", "10d.png");
		InsertarCarta(50, "♦", "J", "11d.png");
		InsertarCarta(51, "♦", "Q", "12d.png");
		InsertarCarta(52, "♦", "k", "13d.png");
	}

	// Llenar el Numero de las Cartas
	public void CartasMazo(String tipo, String numero, int indiceCarta) {

		numero = "AS";
		InsertarCarta(indiceCarta, tipo, numero, "");

		for (int i = 2; i <= 10; i++) {
			numero = String.valueOf(i);
			indiceCarta++;
			InsertarCarta(indiceCarta, tipo, numero, "");
		}

		numero = "J";
		indiceCarta++;
		InsertarCarta(indiceCarta, tipo, numero, "");
		numero = "Q";
		indiceCarta++;
		InsertarCarta(indiceCarta, tipo, numero, "");
		numero = "K";
		indiceCarta++;
		InsertarCarta(indiceCarta, tipo, numero, "");
	}

	// Imprimir Cartas del Juego
	public void ImprimirMazo() {
		if (_mazo != null) {
			int contar = 0;
			Carta auxiliar = _mazo;

			while (auxiliar != null) {
				System.out.print(auxiliar.getFigura() + auxiliar.getValor());
				if ((auxiliar.getFigura() + auxiliar.getValor()).length() > 2)
					System.out.print(" ");
				else
					System.out.print("  ");
				if (contar == 4) {
					System.out.println();
					contar = 0;
				} else
					contar++;
				auxiliar = auxiliar.getProximo();
			}

		} else
			System.out.print("El mazo esta vacio");
		System.out.println();
	}

	public void ImprimirMazoConIndice() {
		int opciones = 1;
		Carta actual = _mazo;

		if (actual != null) {
			while (actual != null) {
				System.out.println(opciones + ". " + actual.getFigura() + " " + actual.getValor());
				actual = actual.getProximo();
				opciones++;
			}
			System.out.println();
		} else {
			System.out.println("El mazo esta vacio");
		}
	}

	public boolean buscarRepetidosCadenas(String valor) {
		Carta buscar = new Carta();
		buscar = _mazo;

		if (_mazo == null)
			return true;
		while (buscar != null) {
			if (buscar.getValor() == valor) {
				return false;
			} else {
				buscar = buscar.getProximo();
			}
		}
		return true;
	}

	public Carta sacarCartaPorValor(String valor) {
		Carta recorerMazo = new Carta();
		Carta buscarCorNegros = new Carta();
		recorerMazo = _mazo;

		while (recorerMazo != null) {
			if (recorerMazo.getValor() == valor) {
				if ((buscarRepetidosCadenas(valor)) && (recorerMazo.getIndiceCarta() < 27)
						&& (recorerMazo.getIndiceCarta() > 39)) {
					buscarCorNegros = recorerMazo.getProximo();
					while (buscarCorNegros != null) {
						if ((buscarCorNegros.getValor() == valor)
								&& ((buscarCorNegros.getIndiceCarta() > 26) && (buscarCorNegros.getIndiceCarta() < 40)))
							return buscarCorNegros;
						buscarCorNegros = buscarCorNegros.getProximo();
					}
				}
				return recorerMazo;
			}
			recorerMazo = recorerMazo.getProximo();
		}
		return recorerMazo;
	}

	public Carta sacarCartaPorValor2(String valor) {
		Carta recorerMazo = new Carta();
		recorerMazo = _mazo;

		while (recorerMazo != null) {
			if (recorerMazo.getValor().equals(valor)) {
				return recorerMazo;
			}
			recorerMazo = recorerMazo.getProximo();
		}
		return recorerMazo;
	}

	public Carta sacarCartaMazo(int posicion) {
		Carta recorerMazo = new Carta();
		recorerMazo = _mazo;

		for (int i = 1; i < posicion; i++) {
			recorerMazo = recorerMazo.getProximo();
		}
		return recorerMazo;
	}

	public Carta BuscarCarta(Mazo auxiliar, String tipo, String numero) {
		Carta carta = auxiliar._mazo;

		if (auxiliar._mazo != null) {
			while (carta != null) {
				if (carta.getFigura().equals(tipo) && carta.getValor().equals(numero)) {
					return carta;
				}
				carta = carta.getProximo();
			}
		} else {
			System.out.println("\nUsted ya no tiene cartas");
			return carta = null;
		}
		return carta;
	}
}