package controlador;

import modelo.Archivos;
import modelo.SemilleroCartas;
import vista.VistaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio {
    private ControladorMesaDeJuego _controladorMesaDeJuego;
    private VistaInicio _vistaJuegoInicio;
    private SemilleroCartas _semillero;
    private Archivos _archivosControl;

    public ControladorInicio(VistaInicio vistaJuego, SemilleroCartas semillero) {
        this._archivosControl = new Archivos();
        this._vistaJuegoInicio = vistaJuego;
        this._semillero = semillero;

        _vistaJuegoInicio.getPanelJuego().startGameButton(new listenerVistaJuego());
    }

    public class listenerVistaJuego implements ActionListener {
        public void actionPerformed(ActionEvent eventoVistaJuegoInicio) {

            try {
                if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelJuego().getJLabelStart()) {
                    _vistaJuegoInicio.panelRecibirNombre();
                    _vistaJuegoInicio.getRecibir().RegistraButton(new listenerVistaJuego());
                } else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getRecibir().getBotonRegistrar()) {
                    _vistaJuegoInicio.panelMenuPrincipal();
                    _vistaJuegoInicio.getPanelMenuPrincipal().addActionLister1(new listenerVistaJuego());
                    _archivosControl.GuardarNombre(_vistaJuegoInicio.getTextoJTextField());
                } else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonEmpezar()) {
                    _semillero.generarMazoPrincipalDeCartas();
                    _semillero.getMazoPrincipal().ImprimirMazo();
                    _semillero.getMazoPrincipal().barajearMazo();
                    _semillero.getMazoPrincipal().ImprimirMazo();
                    _controladorMesaDeJuego = new ControladorMesaDeJuego(_vistaJuegoInicio, _semillero);
                } else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonCargar()) {
                    _vistaJuegoInicio.mensaje("hola man1");
                } else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonSalir()) {
                    System.exit(0);
                }

            } catch (Error e) {
                System.out.println("Error" + e);
            }
        }
    }
}
