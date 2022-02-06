package modelo;

public class SemilleroCartas {
    private Cola _cola;

    public SemilleroCartas() {
        _cola = new Cola();
    }

    public void generarMazoPrincipalDeCartas() {

        //Picas
        _cola.insertar(1, "♠", "A", "1p.png");
        _cola.insertar(2, "♠", "2", "2p.png");
        _cola.insertar(3, "♠", "3", "3p.png");
        _cola.insertar(4, "♠", "4", "4p.png");
        _cola.insertar(5, "♠", "5", "5p.png");
        _cola.insertar(6, "♠", "6", "6p.png");
        _cola.insertar(7, "♠", "7", "7p.png");
        _cola.insertar(8, "♠", "8", "8p.png");
        _cola.insertar(9, "♠", "9", "9p.png");
        _cola.insertar(10, "♠", "10", "10p.png");
        _cola.insertar(11, "♠", "J", "11p.png");
        _cola.insertar(12, "♠", "Q", "12p.png");
        _cola.insertar(13, "♠", "k", "13p.png");

        //Corazones
        _cola.insertar(14, "♥", "A", "1c.png");
        _cola.insertar(15, "♥", "2", "2c.png");
        _cola.insertar(16, "♥", "3", "3c.png");
        _cola.insertar(17, "♥", "4", "4c.png");
        _cola.insertar(18, "♥", "5", "5c.png");
        _cola.insertar(19, "♥", "6", "6c.png");
        _cola.insertar(20, "♥", "7", "7c.png");
        _cola.insertar(21, "♥", "8", "8c.png");
        _cola.insertar(22, "♥", "9", "9c.png");
        _cola.insertar(23, "♥", "10", "10c.png");
        _cola.insertar(24, "♥", "J", "11c.png");
        _cola.insertar(25, "♥", "Q", "12c.png");
        _cola.insertar(26, "♥", "k", "13c.png");

        //Treboles
        _cola.insertar(27, "♣", "A", "1t.png");
        _cola.insertar(28, "♣", "2", "2t.png");
        _cola.insertar(29, "♣", "3", "3t.png");
        _cola.insertar(30, "♣", "4", "4t.png");
        _cola.insertar(31, "♣", "5", "5t.png");
        _cola.insertar(32, "♣", "6", "6t.png");
        _cola.insertar(33, "♣", "7", "7t.png");
        _cola.insertar(34, "♣", "8", "8t.png");
        _cola.insertar(35, "♣", "9", "9t.png");
        _cola.insertar(36, "♣", "10", "10t.png");
        _cola.insertar(37, "♣", "J", "11t.png");
        _cola.insertar(38, "♣", "Q", "12t.png");
        _cola.insertar(39, "♣", "k", "13t.png");

        //Diamantes
        _cola.insertar(40, "♦", "A", "1d.png");
        _cola.insertar(41, "♦", "2", "2d.png");
        _cola.insertar(42, "♦", "3", "3d.png");
        _cola.insertar(43, "♦", "4", "4d.png");
        _cola.insertar(44, "♦", "5", "5d.png");
        _cola.insertar(45, "♦", "6", "6d.png");
        _cola.insertar(46, "♦", "7", "7d.png");
        _cola.insertar(47, "♦", "8", "8d.png");
        _cola.insertar(48, "♦", "9", "9d.png");
        _cola.insertar(49, "♦", "10", "10d.png");
        _cola.insertar(50, "♦", "J", "11d.png");
        _cola.insertar(51, "♦", "Q", "12d.png");
        _cola.insertar(52, "♦", "k", "13d.png");
    }

    public Cola get_cola() {
        return _cola;
    }
}
