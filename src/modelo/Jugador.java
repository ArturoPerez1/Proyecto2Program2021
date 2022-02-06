package modelo;

public class Jugador {
    private String _nombre;
    private Mazo _juego;
    private Mazo _acumulado;
    private int _puntos;

    public Jugador() {
        _nombre = "";
        _juego = null;
        _acumulado = null;
        _puntos = 0;
    }

    public Jugador(String nombre) {
        this._nombre = nombre;
        _juego = new Mazo();
        _acumulado = new Mazo();
        _puntos = 0;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public Mazo getJuego() {
        return _juego;
    }

    public void setJuego(Mazo juego) {
        this._juego = juego;
    }

    public Mazo getAcumulado() {
        return _acumulado;
    }

    public void setAcumulado(Mazo acumulado) {
        this._acumulado = acumulado;
    }

    public int getPuntos() {
        return _puntos;
    }

    public void setPuntos(int puntos) {
        this._puntos = puntos;
    }

}
