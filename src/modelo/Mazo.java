package modelo;

public class Mazo {
    private Carta mazo;
    private int cantidadCartas;

    public Mazo() {
        mazo = null;
        cantidadCartas = 0;
    }

    public Carta getMazo() {
        return mazo;
    }

    public void setMazo(Carta mazo) {
        this.mazo = mazo;
    }

    public int getCantidadCartas() {
        return cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }

    // Insertar las Cartas
    public void InsertarCarta(String tipo, String numero, int indiceCarta) {
        Carta auxiliar = new Carta();
        Carta auxiliar2 = new Carta();

        auxiliar.setTipo(tipo);
        auxiliar.setNumero(numero);
        auxiliar.setIndiceCarta(indiceCarta++);

        if (mazo == null) {
            mazo = auxiliar;
        } else {
            auxiliar2 = mazo;
            while (auxiliar2.getProximo() != null) {
                auxiliar2 = auxiliar2.getProximo();
            }
            auxiliar2.setProximo(auxiliar);
        }
    }

    public void EliminarCarta(String tipo, String numero) {
        if (mazo == null)
            System.out.println("lista vacía");
        else if (mazo.getTipo().equals(tipo) && mazo.getNumero().equals(numero)) {
            mazo = mazo.getProximo();
        } else {
            Carta actual = mazo;
            while (actual.getProximo() != null && actual.getProximo().getTipo() != tipo
                    && actual.getProximo().getNumero() != numero)
                actual = actual.getProximo();
            if (actual.getProximo() == null)
                System.out.println("elemento " + actual.getTipo() + actual.getNumero() + " no esta en la lista");
            else {
                actual.setProximo(actual.getProximo().getProximo());
            }
        }
    }

    // Llenar el Numero de las Cartas
    public void CartasMazo(String tipo, String numero, int indiceCarta) {

        numero = "AS";
        InsertarCarta(tipo, numero, indiceCarta);

        for (int i = 2; i <= 10; i++) {
            numero = String.valueOf(i);
            indiceCarta++;
            InsertarCarta(tipo, numero, indiceCarta);
        }

        numero = "J";
        indiceCarta++;
        InsertarCarta(tipo, numero, indiceCarta);
        numero = "Q";
        indiceCarta++;
        InsertarCarta(tipo, numero, indiceCarta);
        numero = "K";
        indiceCarta++;
        InsertarCarta(tipo, numero, indiceCarta);
    }

    // Llenar el Tipo de Carta
    public void LlenarMazo() {
        int indiceCarta = 1;
        String tipo = " ", numero = " ";

        tipo = "♣";// Treboles
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♥";// Corazones Rojos
        indiceCarta = 14;
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♠";// Corazones Negros
        indiceCarta = 27;
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♦";// Diamantes Rojos
        indiceCarta = 40;
        CartasMazo(tipo, numero, indiceCarta);
    }

    // Imprimir Cartas del Juego
    public void ImprimirMazo() {
        if (mazo != null) {
            int contar = 0;
            Carta auxiliar = mazo;
            while (auxiliar != null) {
                System.out.print(auxiliar.getTipo() + auxiliar.getNumero());
                if ((auxiliar.getTipo() + auxiliar.getNumero()).length() > 2)
                    System.out.print(" ");
                else
                    System.out.print("  ");
                if (contar == 4) {
                    System.out.println();
                    contar = 0;
                } else
                    contar++;
                auxiliar = auxiliar.getProximo();
            }
        } else
            System.out.print("El mazo esta vacio");
        System.out.println();
    }

    public void ImprimirMazoConIndice() {
        int opciones = 1;
        Carta actual = mazo;
        if (actual != null) {
            while (actual != null) {
                System.out.println(opciones + ". " + actual.getTipo() + " " + actual.getNumero());
                actual = actual.getProximo();
                opciones++;
            }
            System.out.println();
        } else {
            System.out.println("El mazo esta vacio");
        }
    }

    public boolean esVacia() {
        boolean log = false;
        if (mazo == null)
            log = true;
        return log;
    }

    public int RecorerMazo(Carta recorrer) {
        Carta auxiliar = recorrer;
        int contador = 0;
        while (auxiliar != null) {
            contador++;
            auxiliar = auxiliar.getProximo();
        }
        return contador;
    }

    public boolean buscarRepetidosCadenas(String valor) {
        Carta buscar = new Carta();
        buscar = mazo;
        if (esVacia())
            return true;
        while (buscar != null) {
            if (buscar.getNumero() == valor) {
                return false;
            } else {
                buscar = buscar.getProximo();
            }
        }
        return true;
    }

    public boolean buscarRepetidos(Mazo mazo, int valor) {
        Carta buscar = new Carta();
        buscar = mazo.mazo;
        if (esVacia())
            return true;
        while (buscar != null) {
            if (buscar.getIndiceCarta() == valor) {
                return false;
            } else {
                buscar = buscar.getProximo();
            }
        }
        return true;
    }

    public Carta baraja() {
        int valor;
        Mazo lista = new Mazo();
        do {
            valor = (int) (1 + Math.random() * 52);
            if (buscarRepetidos(lista, valor))
                lista.InsertarCarta(" ", " ", valor);
        } while (RecorerMazo(lista.mazo) != 52);
        return lista.mazo;
    }

    public void barajearMazo() {
        Mazo mazoBarajeado = new Mazo();
        Carta lista = new Carta();
        Carta actual = new Carta();
        lista = baraja();
        actual = mazo.getProximo();
        while (lista != null) {
            if (lista.getIndiceCarta() == actual.getIndiceCarta()) {
                Carta nuevaCarta = new Carta(actual.getTipo(), actual.getNumero(), actual.getIndiceCarta(), null);
                ;
                mazoBarajeado.InsertarCarta(nuevaCarta.getTipo(), nuevaCarta.getNumero(), nuevaCarta.getIndiceCarta());
                lista = lista.getProximo();
                actual = mazo;
            } else {
                actual = actual.getProximo();
            }
        }
        mazo = mazoBarajeado.mazo;
    }

    public Carta sacarCartaPorValor(String valor) {
        Carta recorerMazo = new Carta();
        Carta buscarCorNegros = new Carta();
        recorerMazo = mazo;
        while (recorerMazo != null) {
            if (recorerMazo.getNumero() == valor) {
                if ((buscarRepetidosCadenas(valor)) && (recorerMazo.getIndiceCarta() < 27)
                        && (recorerMazo.getIndiceCarta() > 39)) {
                    buscarCorNegros = recorerMazo.getProximo();
                    while (buscarCorNegros != null) {
                        if ((buscarCorNegros.getNumero() == valor)
                                && ((buscarCorNegros.getIndiceCarta() > 26) && (buscarCorNegros.getIndiceCarta() < 40)))
                            return buscarCorNegros;
                        buscarCorNegros = buscarCorNegros.getProximo();
                    }
                }
                return recorerMazo;
            }
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public Carta sacarCartaPorValor2(String valor) {
        Carta recorerMazo = new Carta();
        recorerMazo = mazo;
        while (recorerMazo != null) {
            if (recorerMazo.getNumero().equals(valor)) {
                return recorerMazo;
            }
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public Carta sacarCartaMazo(int posicion) {
        Carta recorerMazo = new Carta();
        recorerMazo = mazo;
        for (int i = 1; i < posicion; i++) {
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public void RepartirCartas(boolean reparteMesa, boolean reparte, Mazo mazoJugador, Mazo mazoComputadora,
                               Mazo mazoMesa) {
        Carta aux = new Carta();
        int repartir = 1;
        aux = mazo;
        if (aux != null) {
            if (reparte) {
                while (repartir <= 4) {
                    mazoComputadora.InsertarCarta(aux.getTipo(), aux.getNumero(), aux.getIndiceCarta());
                    EliminarCarta(aux.getTipo(), aux.getNumero());
                    aux = aux.getProximo();
                    mazoJugador.InsertarCarta(aux.getTipo(), aux.getNumero(), aux.getIndiceCarta());
                    EliminarCarta(aux.getTipo(), aux.getNumero());
                    aux = aux.getProximo();
                    repartir++;
                }
            } else {
                while (repartir <= 4) {
                    mazoJugador.InsertarCarta(aux.getTipo(), aux.getNumero(), aux.getIndiceCarta());
                    EliminarCarta(aux.getTipo(), aux.getNumero());
                    aux = aux.getProximo();
                    mazoComputadora.InsertarCarta(aux.getTipo(), aux.getNumero(), aux.getIndiceCarta());
                    EliminarCarta(aux.getTipo(), aux.getNumero());
                    aux = aux.getProximo();
                    repartir++;
                }
            }
            repartir = 1;
            if (reparteMesa) {
                while (repartir <= 4) {
                    mazoMesa.InsertarCarta(aux.getTipo(), aux.getNumero(), aux.getIndiceCarta());
                    EliminarCarta(aux.getTipo(), aux.getNumero());
                    aux = aux.getProximo();
                    repartir++;
                }
            }
        }
    }

    public Carta BuscarCarta(Mazo auxiliar, String tipo, String numero) {
        Carta carta = auxiliar.mazo;
        if (auxiliar.mazo != null) {
            while (carta != null) {
                if (carta.getTipo().equals(tipo) && carta.getNumero().equals(numero)) {
                    return carta;
                }
                carta = carta.getProximo();
            }
        } else {
            System.out.println("\nUsted ya no tiene cartas");
            return carta = null;
        }
        return carta;
    }
}
