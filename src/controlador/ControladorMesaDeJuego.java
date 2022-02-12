package controlador;

import modelo.Carta;
import modelo.EstadoInicial;
import modelo.Mazo;
import vista.VistaInicio;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorMesaDeJuego {
	private Carta _recorrerMazos;
	private JLabel _listenerCartas;
	private VistaInicio _vistaInicio;
	private Carta _idCartasMesa;
	private Carta _idCartaJugador;
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
		this._gestorDeCartas = gestorDeCartas;
		this._vistaInicio = vistaMesaJuego;
		this._mazoControladorDeListas = new Mazo();
		this._idCartasMesa = null;
		this._idCartaJugador = null;
		this._tomarCarta = false;
		this._lanzar = false;
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

		_recorrerMazos = _mazoControladorDeListas.getCartasRestantesMesa();
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = _mazoControladorDeListas.getCartasRestantesJugador();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
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

		_recorrerMazos = _gestorDeCartas.getMazoMesa().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = _gestorDeCartas.getMazoPersona().getJuego().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
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
					System.out.println("entre1");
					String idCartaMesaInstance = (String) _listenerCartas.getText();
					_idCartasMesa = _mazoControladorDeListas.InsertarId(idCartaMesaInstance, _idCartasMesa);
					_tomarCarta = true;
				} else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas()
						.getJLabelCartasJugador()) {
					if (_tomarCarta) {
						System.out.println("Chiquita");
						String idCartaJugadorInstance = (String) _listenerCartas.getText();
						_idCartaJugador = _mazoControladorDeListas.InsertarId(idCartaJugadorInstance, _idCartaJugador);
						if(_lanzar){ // revisa esta mierda coño e madre
							_mazoControladorDeListas.VerificarSumaCartas(_idCartasMesa, _idCartaJugador,
									_gestorDeCartas.getMazoMesa().getMazo().getProximo(),
									_gestorDeCartas.getMazoPersona().getJuego().getMazo().getProximo());
							_tomarCarta = false;
							_lanzar = false;
						}else {
							_mazoControladorDeListas.VerificarSumaCartas(_idCartasMesa, _idCartaJugador,
									_gestorDeCartas.getMazoMesa().getMazo(),
									_gestorDeCartas.getMazoPersona().getJuego().getMazo());
							_tomarCarta = false;
							_lanzar = true;
						}
						if(_mazoControladorDeListas.is_VerificarSumarCartas()) {
							_gestorDeCartas.setTurnoPersona(false);
							_lanzar = true;
							GestionDeturnos();
							GestionDeturnos();
						}else {
							_lanzar = false;
							_mazoControladorDeListas = new Mazo();
							_idCartasMesa = null;
							_idCartaJugador = null;
							_tomarCarta = false;	
						}
						
					}else {
						if(_lanzar == false) {
							String idCartaJugadorInstance = (String) _listenerCartas.getText();
							_mazoControladorDeListas.LanzarCartaAMesa(Integer.valueOf(idCartaJugadorInstance),
									_gestorDeCartas.getMazoMesa().getMazo().getProximo(),
									_gestorDeCartas.getMazoPersona().getJuego().getMazo().getProximo());
							 _tomarCarta = false;
								_gestorDeCartas.setTurnoPersona(true);
							GestionDeturnos();
						}else if(_lanzar) {
							String idCartaJugadorInstance = (String) _listenerCartas.getText();
							_mazoControladorDeListas.LanzarCartaAMesa(Integer.valueOf(idCartaJugadorInstance),
									_gestorDeCartas.getMazoMesa().getMazo(),
									_gestorDeCartas.getMazoPersona().getJuego().getMazo());
							 _tomarCarta = false;
								_gestorDeCartas.setTurnoPersona(true);
							GestionDeturnos();
						}
						
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
}