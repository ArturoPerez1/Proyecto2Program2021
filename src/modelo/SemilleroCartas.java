package modelo;

import vista.Vista;

public class SemilleroCartas {
	private Cola cola;
	private Vista vistaControlador;
	
	
	public SemilleroCartas(Vista vista) {
		this.vistaControlador = vista;
		llenarCartasJugador();
	}
	
	private void llenarCartasJugador() {
		vistaControlador.getPanelContenedorCartas().setCartar1J("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar2J("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar3J("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar4J("assets/cartas/Carta1.jpeg");
		
		vistaControlador.getPanelContenedorCartas().setCartar1P("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar2P("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar3P("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCartar4P("assets/cartas/Carta1.jpeg");
		
		vistaControlador.getPanelContenedorCartas().setCarta1M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta2M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta3M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta4M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta5M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta6M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta7M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta8M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta9M("assets/cartas/Carta1.jpeg");
		vistaControlador.getPanelContenedorCartas().setCarta10M("assets/cartas/Carta1.jpeg");
	}
}
