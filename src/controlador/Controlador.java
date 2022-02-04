package controlador;

import modelo.Archivos;
import modelo.Modelo;
import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Vista _vistaJuego = new Vista();
    private Modelo _modeloJuego = new Modelo();
    private Archivos archivosControl;

    public Controlador(Vista vistaJuego, Modelo modeloJuego) {
        this._vistaJuego = vistaJuego;
        this._modeloJuego = modeloJuego;

        _vistaJuego.getPanelJuego().startGameButton(new listenerVistaJuego());
    }

    public class listenerVistaJuego implements ActionListener {
        public void actionPerformed(ActionEvent eventoVistaJuego) {

            try {
                if (eventoVistaJuego.getSource() == _vistaJuego.getPanelJuego().getJLabelStart()) {
                    _vistaJuego.panelRecibirNombre();
                    _vistaJuego.getRecibir().RegistraButton(new listenerVistaJuego());
                } else if (eventoVistaJuego.getSource() == _vistaJuego.getRecibir().getBotonRegistrar()) {
                    archivosControl = new Archivos();
                    archivosControl.GuardarNombre(_vistaJuego);
                }

            } catch (Error e) {

            }
        }
    }
}
