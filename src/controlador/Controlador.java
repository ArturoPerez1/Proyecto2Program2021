package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
    private Vista _vistaJuego = new Vista();
    private Modelo _modeloJuego = new Modelo();

    public Controlador(Vista vistaJuego, Modelo modeloJuego) {
        this._vistaJuego = vistaJuego;
        this._modeloJuego = modeloJuego;

//        _vistaJuego.listenerAction(new listenerVistaJuego());
    }

    public class listenerVistaJuego implements ActionListener {
        public void actionPerformed(ActionEvent eventoVistaJuego) {

            try {

            } catch (Error e) {

            }
        }
    }
}
