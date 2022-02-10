package modelo;

public class EstadoInicial {
    private Mazo _mazoPrincipal;
    private Mazo _mazoMesa;
    private Jugador _persona;
    private Jugador _computadora;
    private boolean _ultimoRecoger;
    private boolean _repartePersona;
    private boolean _turnoPersona;

    public EstadoInicial() {
        _mazoPrincipal = null;
        _mazoMesa = null;
    }

    public Mazo getMazoPilon() { // retorna el mazo principal de la partida
        return _mazoPrincipal;
    }

    public void setMazoPilon(Mazo mazoPrincipal) { //setea el mazo principal de la partida al repartir cartas
        this._mazoPrincipal = mazoPrincipal;
    }

    public Mazo getMazoMesa() {
        return _mazoMesa;
    }

    public void setMazoMesa(Mazo mazoMesa) {
        this._mazoMesa = mazoMesa;
    }

    public Jugador getMazoPersona() {
        return _persona;
    }

    public void setPersona(Jugador persona) {
        this._persona = persona;
    }

    public Jugador getMazoComputadora() {
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
        EstadoInicial controladorJuego = new EstadoInicial();
        Jugador mazoPersona = new Jugador(nombre);
        Jugador mazoComputadora = new Jugador("Computadora");
        Mazo mazoMesa = new Mazo();
        Mazo mazoPrincipal = new Mazo();
        mazoPrincipal.GenerarMazoPrincipalDeCartas();
        mazoPrincipal.BarajearMazo();
        mazoPrincipal.getMazo();
        controladorJuego._persona = mazoPersona;
        controladorJuego._computadora = mazoComputadora;
        controladorJuego._mazoPrincipal = mazoPrincipal;
        controladorJuego._mazoMesa = mazoMesa;
        controladorJuego._turnoPersona = turno;
        controladorJuego._repartePersona = !turno;
        return controladorJuego;
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