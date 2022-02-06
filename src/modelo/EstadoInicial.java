package modelo;

public class EstadoInicial {
    private Mazo _mazoPilo;
    private Mazo _mazoMesa;
    private Jugador _persona;
    private Jugador _computadora;
    private boolean _ultimoRecoger;
    private boolean _repartePersona;
    private boolean _turnoPersona;

    public EstadoInicial() {
        _mazoPilo = null;
        _mazoMesa = null;
    }

    public Mazo getMazoPilon() {
        return _mazoPilo;
    }

    public void setMazoPilon(Mazo mazoPilon) {
        this._mazoPilo = mazoPilon;
    }

    public Mazo getMazoMesa() {
        return _mazoMesa;
    }

    public void setMazoMesa(Mazo mazoMesa) {
        this._mazoMesa = mazoMesa;
    }

    public Jugador getPersona() {
        return _persona;
    }

    public void setPersona(Jugador persona) {
        this._persona = persona;
    }

    public Jugador getComputadora() {
        return _computadora;
    }

    public void setComputadora(Jugador computadora) {
        this._computadora = computadora;
    }

    public boolean isUltimoRecoger() {
        return _ultimoRecoger;
    }

    public void setUltimoRecoger(boolean ultimoRecoger) {
        this._ultimoRecoger = ultimoRecoger;
    }

    public boolean isRepartePersona() {
        return _repartePersona;
    }

    public void setRepartePersona(boolean repartePersona) {
        this._repartePersona = repartePersona;
    }

    public boolean isTurnoPersona() {
        return _turnoPersona;
    }

    public void setTurnoPersona(boolean turnoPersona) {
        this._turnoPersona = turnoPersona;
    }

    public EstadoInicial estadoInicial(String nombre, boolean turno) {
        EstadoInicial juego = new EstadoInicial();
        Jugador persona = new Jugador(nombre);
        Jugador computadora = new Jugador("Computadora");
        Mazo mesa = new Mazo();
        Mazo mazo = new Mazo();
        mazo.LlenarMazo();
        mazo.barajearMazo();
        juego._persona = persona;
        juego._computadora = computadora;
        juego._mazoPilo = mazo;
        juego._mazoMesa = mesa;
        juego._turnoPersona = turno;
        juego._repartePersona = !turno;
        return juego;
    }

    void mostrarJugadoresYAcumulado(EstadoInicial juego, Jugador mostrar, int personaMostrar) {
        Mazo mazo = mostrar.getJuego();
        Mazo mazoAcumulado = mostrar.getAcumulado();
        System.out.println("Mazo de " + mostrar.getNombre() + ": ");
        mazo.ImprimirMazo();
        if (mazoAcumulado.getMazo() != null) {
            System.out.println();
            System.out.print("Cartas Acumuladas de " + mostrar.getNombre() + ": ");
            System.out.println();
            mostrar.getAcumulado().ImprimirMazo();
        }
    }

    public void mostrarJuego(EstadoInicial mostrar) {
        System.out.println("\n JUEGO CASINO\n");
        if (mostrar._turnoPersona) System.out.println("Turno de " + mostrar._persona.getNombre() + "\n");
        else System.out.println("Turno del " + mostrar._computadora.getNombre() + "\n");
        mostrarJugadoresYAcumulado(mostrar, mostrar._computadora, 0);
        System.out.println();
        System.out.println("Mesa:");
        mostrar._mazoMesa.ImprimirMazo();
        System.out.println();
        mostrarJugadoresYAcumulado(mostrar, mostrar._persona, 1);
    }
}
