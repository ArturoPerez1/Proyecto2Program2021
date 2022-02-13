package controlador;

import modelo.Archivos;
import modelo.Carta;
import modelo.EstadoInicial;
import modelo.Mazo;
import vista.PilonJugador;
import vista.VistaInicio;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorMesaDeJuego {
	private Carta _recorrerMazos;
	private JLabel _listenerCartas;
	private VistaInicio _vistaInicio;
	private Carta _idCartasMesa;
	private Carta _idCartaJugador;
	private Carta _AcumuladoJugador;
	private Mazo _mazoControladorDeListas;
	private boolean _tomarCarta;
	private boolean _lanzar;
	private EstadoInicial _gestorDeCartas;

	/**
	 * @author Arturo Perez
	 *         <p>
	 *         Este constructor inicializa y llama a las funciones de la vista que
	 *         insertaran las caras obtenidas
	 */

	public ControladorMesaDeJuego(VistaInicio vistaMesaJuego, EstadoInicial gestorDeCartas) {
		Archivos controlArchivos = new Archivos();
		controlArchivos.DeleteArchivo("assets/baseDatos/MazoAcumuladorJugador.txt");
		this._gestorDeCartas = gestorDeCartas;
		this._vistaInicio = vistaMesaJuego;
		this._mazoControladorDeListas = new Mazo();
		this._idCartasMesa = null;
		this._idCartaJugador = null;
		this._tomarCarta = false;
		this._lanzar = false;
		this._AcumuladoJugador = null;
		vistaMesaJuego.panelContenedorCartas();

		iniciarComponentes();
	}

	public void iniciarComponentesJugadas() {
		int x = 20;
		int y = 50;
		int width = 82;
		int height = 101;
		int cont = 1;
		_vistaInicio.panelContenedorCartas();

		_vistaInicio.getPanelContenedorCartas().JLabelMazoPilon(new listenerVistaJuego());
		_vistaInicio.getPanelContenedorCartas().JLabelMazoPilon1(new listenerVistaJuego());
		_vistaInicio.getPanelContenedorCartas().ButtonSalir();
		_vistaInicio.getPanelContenedorCartas().addActionListener(new listenerMesaJuego());

		_recorrerMazos = _mazoControladorDeListas.getCartasRestantesMesa();
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = _mazoControladorDeListas.getCartasRestantesJugador();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		x = 10;
		y = 10;
		while (cont <= 4) {
			_vistaInicio.getPanelContenedorCartas().CartasPc("assets/cartas/back.png", x, y, width, height);
			x += 125;
			cont++;
		}
		_gestorDeCartas.getMazoMesa().setMazo(_mazoControladorDeListas.getCartasRestantesMesa());
		_gestorDeCartas.getMazoPersona().getJuego().setMazo(_mazoControladorDeListas.getCartasRestantesJugador());

		_recorrerMazos = _mazoControladorDeListas.getListaCartasSumadasJugador();

		while (_recorrerMazos != null) {
			_AcumuladoJugador = _mazoControladorDeListas.InsertarSuma(_recorrerMazos.getIndiceCarta(),_recorrerMazos.getFigura(), _recorrerMazos.getValor(), _recorrerMazos.getImagen(),_AcumuladoJugador);
			_recorrerMazos = _recorrerMazos.getProximo();
		}

		_recorrerMazos = _mazoControladorDeListas.getListaCartasSumadasMesa();
		while (_recorrerMazos != null) {
			_AcumuladoJugador = _mazoControladorDeListas.InsertarSuma(_recorrerMazos.getIndiceCarta(),_recorrerMazos.getFigura(), _recorrerMazos.getValor(), _recorrerMazos.getImagen(),_AcumuladoJugador);
			_recorrerMazos = _recorrerMazos.getProximo();
		}

		this._mazoControladorDeListas = new Mazo();
		this._idCartasMesa = null;
		this._idCartaJugador = null;
		this._tomarCarta = false;
		this._lanzar = true;
	}

	public void iniciarComponentes() {
		int x = 20;
		int y = 50;
		int width = 82;
		int height = 101;
		int cont = 1;

		_vistaInicio.getPanelContenedorCartas().JLabelMazoPilon(new listenerVistaJuego());
		_vistaInicio.getPanelContenedorCartas().JLabelMazoPilon1(new listenerVistaJuego());
		_vistaInicio.getPanelContenedorCartas().ButtonSalir();
		_vistaInicio.getPanelContenedorCartas().addActionListener(new listenerMesaJuego());

		_recorrerMazos = _gestorDeCartas.getMazoMesa().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = _gestorDeCartas.getMazoPersona().getJuego().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		x = 10;
		y = 10;
		while (cont <= 4) {
			_vistaInicio.getPanelContenedorCartas().CartasPc("assets/cartas/back.png", x, y, width, height);
			x += 125;
			cont++;
		}

	}

	public void GestionDeturnos() {
		if (_gestorDeCartas.isTurnoPersona() == false) {
			System.out.println("computadora no implementada");
			_gestorDeCartas.setTurnoPersona(true);
		} else {
			System.out.println("Se recoge lo antes sumado por el jugador");
			iniciarComponentesJugadas();
		}
	}

	public class listenerVistaJuego implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				_listenerCartas = (JLabel) e.getSource();
				if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas().getJPanelMesa()) {
					String idCartaMesaInstance = (String) _listenerCartas.getText();
					System.out.println("TOMÓ LA CARTA DE LA MESA CON ID: " + idCartaMesaInstance);
					_idCartasMesa = _mazoControladorDeListas.InsertarId(idCartaMesaInstance, _idCartasMesa);
					_tomarCarta = true;
				} else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas()
						.getJLabelCartasJugador()) {
					if (_tomarCarta) {
						String idCartaJugadorInstance = (String) _listenerCartas.getText();
						System.out.println("TOMÓ LA CARTA DEL JUGADOR CON ID: " + idCartaJugadorInstance);
						_idCartaJugador = _mazoControladorDeListas.InsertarId(idCartaJugadorInstance, _idCartaJugador);
						if (_lanzar == false) {
							_mazoControladorDeListas.VerificarSumaCartas(_idCartasMesa, _idCartaJugador,_gestorDeCartas.getMazoMesa().getMazo().getProximo(),_gestorDeCartas.getMazoPersona().getJuego().getMazo().getProximo());
							_tomarCarta = false;
							_lanzar = false;
						} else {
							_mazoControladorDeListas.VerificarSumaCartas(_idCartasMesa, _idCartaJugador,_gestorDeCartas.getMazoMesa().getMazo(),_gestorDeCartas.getMazoPersona().getJuego().getMazo());
							_tomarCarta = true;
							_lanzar = true;
						}

						if (_mazoControladorDeListas.is_VerificarSumarCartas()) {
							_gestorDeCartas.setTurnoPersona(false);
							_lanzar = true;
							GestionDeturnos();
							GestionDeturnos();
						} else {
							_lanzar = false;
							_mazoControladorDeListas = new Mazo();
							_idCartasMesa = null;
							_idCartaJugador = null;
							_tomarCarta = false;
						}

					} else {
						if (_lanzar == false) {
							String idCartaJugadorInstance = (String) _listenerCartas.getText();
							System.out.println("SE LANZÓ LA CARTA DEL JUGADOR CON ID: " + idCartaJugadorInstance);
							_mazoControladorDeListas.LanzarCartaAMesa(Integer.valueOf(idCartaJugadorInstance),_gestorDeCartas.getMazoMesa().getMazo().getProximo(),_gestorDeCartas.getMazoPersona().getJuego().getMazo().getProximo());
							_tomarCarta = false;
							_gestorDeCartas.setTurnoPersona(true);
							GestionDeturnos();
						} else if (_lanzar) {
							String idCartaJugadorInstance = (String) _listenerCartas.getText();
							System.out.println("SE LANZÓ LA CARTA DEL JUGADOR CON ID: " + idCartaJugadorInstance);
							_mazoControladorDeListas.LanzarCartaAMesa(Integer.valueOf(idCartaJugadorInstance),_gestorDeCartas.getMazoMesa().getMazo(),_gestorDeCartas.getMazoPersona().getJuego().getMazo());
							_tomarCarta = false;
							_gestorDeCartas.setTurnoPersona(true);
							GestionDeturnos();
						}

					}
				} else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas()
						.getJLabelMaderaFondo()) {
					String pilon = (String) _listenerCartas.getText();

					if (pilon == "1") {
						int x = 5;
						int y = 50;
						int width = 82;
						int height = 101;
						int cont = 0;
						PilonJugador pilonJugador = new PilonJugador();
						Carta recorrer = _AcumuladoJugador;
						while (recorrer != null && cont <= 10) {
							pilonJugador.MostrarPilon(recorrer.getImagen(), x, y, width, height,
									recorrer.getIndiceCarta());
							x += 90;
							cont++;
							recorrer = recorrer.getProximo();
							if (cont == 10) {
								y += 120;
								cont = 0;
							}
						}

					} else if (pilon == "2") {
						System.out.println("culo1");
					}

				}

			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	public class listenerMesaJuego implements ActionListener {
		public void actionPerformed(ActionEvent eventoMesa) {

			try {
				if (eventoMesa.getSource() == _vistaInicio.getPanelContenedorCartas().getBotonSalir()) {
					System.exit(0);
				}
			} catch (Error e) {
				System.out.println("Error" + e);
			}
		}
	}
}