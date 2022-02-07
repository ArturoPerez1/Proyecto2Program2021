package modelo;

public class SemilleroCartas {
    private Mazo _mazoPrincipal;

    public SemilleroCartas() {
        _mazoPrincipal = new Mazo();
    }

    public void generarMazoPrincipalDeCartas() {

        //Picas
        _mazoPrincipal.InsertarCarta(1, "♠", "A", "1p.png");
        _mazoPrincipal.InsertarCarta(2, "♠", "2", "2p.png");
        _mazoPrincipal.InsertarCarta(3, "♠", "3", "3p.png");
        _mazoPrincipal.InsertarCarta(4, "♠", "4", "4p.png");
        _mazoPrincipal.InsertarCarta(5, "♠", "5", "5p.png");
        _mazoPrincipal.InsertarCarta(6, "♠", "6", "6p.png");
        _mazoPrincipal.InsertarCarta(7, "♠", "7", "7p.png");
        _mazoPrincipal.InsertarCarta(8, "♠", "8", "8p.png");
        _mazoPrincipal.InsertarCarta(9, "♠", "9", "9p.png");
        _mazoPrincipal.InsertarCarta(10, "♠", "10", "10p.png");
        _mazoPrincipal.InsertarCarta(11, "♠", "J", "11p.png");
        _mazoPrincipal.InsertarCarta(12, "♠", "Q", "12p.png");
        _mazoPrincipal.InsertarCarta(13, "♠", "k", "13p.png");

        //Corazones
        _mazoPrincipal.InsertarCarta(14, "♥", "A", "1c.png");
        _mazoPrincipal.InsertarCarta(15, "♥", "2", "2c.png");
        _mazoPrincipal.InsertarCarta(16, "♥", "3", "3c.png");
        _mazoPrincipal.InsertarCarta(17, "♥", "4", "4c.png");
        _mazoPrincipal.InsertarCarta(18, "♥", "5", "5c.png");
        _mazoPrincipal.InsertarCarta(19, "♥", "6", "6c.png");
        _mazoPrincipal.InsertarCarta(20, "♥", "7", "7c.png");
        _mazoPrincipal.InsertarCarta(21, "♥", "8", "8c.png");
        _mazoPrincipal.InsertarCarta(22, "♥", "9", "9c.png");
        _mazoPrincipal.InsertarCarta(23, "♥", "10", "10c.png");
        _mazoPrincipal.InsertarCarta(24, "♥", "J", "11c.png");
        _mazoPrincipal.InsertarCarta(25, "♥", "Q", "12c.png");
        _mazoPrincipal.InsertarCarta(26, "♥", "k", "13c.png");

        //Treboles
        _mazoPrincipal.InsertarCarta(27, "♣", "A", "1t.png");
        _mazoPrincipal.InsertarCarta(28, "♣", "2", "2t.png");
        _mazoPrincipal.InsertarCarta(29, "♣", "3", "3t.png");
        _mazoPrincipal.InsertarCarta(30, "♣", "4", "4t.png");
        _mazoPrincipal.InsertarCarta(31, "♣", "5", "5t.png");
        _mazoPrincipal.InsertarCarta(32, "♣", "6", "6t.png");
        _mazoPrincipal.InsertarCarta(33, "♣", "7", "7t.png");
        _mazoPrincipal.InsertarCarta(34, "♣", "8", "8t.png");
        _mazoPrincipal.InsertarCarta(35, "♣", "9", "9t.png");
        _mazoPrincipal.InsertarCarta(36, "♣", "10", "10t.png");
        _mazoPrincipal.InsertarCarta(37, "♣", "J", "11t.png");
        _mazoPrincipal.InsertarCarta(38, "♣", "Q", "12t.png");
        _mazoPrincipal.InsertarCarta(39, "♣", "k", "13t.png");

        //Diamantes
        _mazoPrincipal.InsertarCarta(40, "♦", "A", "1d.png");
        _mazoPrincipal.InsertarCarta(41, "♦", "2", "2d.png");
        _mazoPrincipal.InsertarCarta(42, "♦", "3", "3d.png");
        _mazoPrincipal.InsertarCarta(43, "♦", "4", "4d.png");
        _mazoPrincipal.InsertarCarta(44, "♦", "5", "5d.png");
        _mazoPrincipal.InsertarCarta(45, "♦", "6", "6d.png");
        _mazoPrincipal.InsertarCarta(46, "♦", "7", "7d.png");
        _mazoPrincipal.InsertarCarta(47, "♦", "8", "8d.png");
        _mazoPrincipal.InsertarCarta(48, "♦", "9", "9d.png");
        _mazoPrincipal.InsertarCarta(49, "♦", "10", "10d.png");
        _mazoPrincipal.InsertarCarta(50, "♦", "J", "11d.png");
        _mazoPrincipal.InsertarCarta(51, "♦", "Q", "12d.png");
        _mazoPrincipal.InsertarCarta(52, "♦", "k", "13d.png");
    }

    public Mazo getMazoPrincipal() {
        return _mazoPrincipal;
    }
}
