package modelo;

import javax.swing.*;
import java.util.Scanner;

public class JuegoInterno {
    Scanner leer = new Scanner(System.in);
    EstadoInicial juego = new EstadoInicial();
    private String sumaTotal;

    public int mostarOpcionesParaLanzarYRecoger(Mazo mazoMostrar, int identificar) {
        int opciones, opcion;
        Mazo mazoJugador = new Mazo();
        mazoJugador = mazoMostrar;
        do {
            juego.mostrarJuego(juego);
            System.out.println("Opciones: \n");
            mazoJugador.ImprimirMazoConIndice();
            opciones = mazoJugador.RecorerMazo(mazoJugador.getMazo());
            if (identificar == 1)
                System.out.println("Que carta desea recoger: ");
            if (identificar == 2)
                System.out.println("Con que carta desea recoger la suma: ");
            if (identificar == 3) {
                System.out.println("Si ya termino de escoger las cartas de la suma... ");
                System.out.println("introduzca 0\n\n");
                return 0;
            }
            if (identificar == 4)
                System.out.println("Que carta desea Lanzar: ");
            if (identificar == 5)
                System.out.println("Que carta desea emparejar con la mesa: ");
            if (identificar == 6)
                System.out.println("Con cual carta desea recoger lo emparejado: ");
            if (identificar == 7)
                System.out.println("Con caul carta desea robar el emparejamiento: ");
            opcion = leer.nextInt();
            if ((opcion > opciones) || (opcion < 1)) {
                System.out.println("Opcion no valida");
            }
        } while ((opcion > opciones) || (opcion < 1));
        return opcion;
    }

    // Recoger----------------------------------------------------------------------------------------------------------------------------------------
    boolean PuedeRecoger(Carta mazoMesa, Mazo mazoJugador, Mazo cartas) {
        boolean logico = false;
        Carta mesaRecorrer = new Carta();
        Carta jugadoresRecorrer = new Carta();
        mesaRecorrer = mazoMesa;
        jugadoresRecorrer = mazoJugador.getMazo();
        while (mesaRecorrer != null) {
            while (jugadoresRecorrer != null) {
                if (mesaRecorrer.getValor().equals(jugadoresRecorrer.getValor())) {
                    if (cartas.buscarRepetidos(cartas, mesaRecorrer.getIndiceCarta()))
                        cartas.InsertarCarta(mesaRecorrer.getFigura(), mesaRecorrer.getValor(),
                                mesaRecorrer.getIndiceCarta());
                    logico = true;
                }
                jugadoresRecorrer = jugadoresRecorrer.getProximo();
            }
            jugadoresRecorrer = mazoJugador.getMazo();
            mesaRecorrer = mesaRecorrer.getProximo();
        }
        return logico;
    }

    public Mazo guardarPosiblesOpciones(Mazo mesaSacar, Carta cartas) {
        Mazo guardados = new Mazo();
        Carta mesaRecorrer = new Carta();
        mesaRecorrer = mesaSacar.getMazo();
        while (cartas != null) {
            while (mesaRecorrer != null) {
                if (mesaRecorrer.getIndiceCarta() == cartas.getIndiceCarta()) {
                    guardados.InsertarCarta(mesaRecorrer.getFigura(), mesaRecorrer.getValor(),
                            mesaRecorrer.getIndiceCarta());
                }
                mesaRecorrer = mesaRecorrer.getProximo();
            }
            mesaRecorrer = mesaSacar.getMazo();
            cartas = cartas.getProximo();
        }
        return guardados;
    }

    void recogerCartas(Mazo sacarMesa, Jugador jugadorPuntos, Mazo insertarAcumulado, Mazo lista, boolean identificar) {
        int opciones, opcion;
        Mazo sacarJugador = new Mazo();
        sacarJugador = jugadorPuntos.getJuego();
        Mazo cartaOpciones = new Mazo();
        cartaOpciones = guardarPosiblesOpciones(sacarMesa, lista.getMazo());
        if (identificar) {
            opcion = mostarOpcionesParaLanzarYRecoger(cartaOpciones, 1);
            juego.setUltimoRecoger(true);
        } else {
            opciones = sacarJugador.RecorerMazo(cartaOpciones.getMazo());
            opcion = (int) (1 + Math.random() * opciones);
            juego.setUltimoRecoger(false);
        }
        Carta cartaMesa = cartaOpciones.sacarCartaMazo(opcion);
        System.out.println();
        System.out.println("   " + jugadorPuntos.getNombre() + " recoge la carta: " + cartaMesa.getFigura() + " "
                + cartaMesa.getValor());
        Carta mazoJugador = sacarJugador.sacarCartaPorValor2(cartaMesa.getValor());
        System.out.println(" mazoJugador: " + mazoJugador.getFigura() + " " + cartaMesa.getValor());
        insertarAcumulado.InsertarCarta(cartaMesa.getFigura(), cartaMesa.getValor(), cartaMesa.getIndiceCarta());
        insertarAcumulado.InsertarCarta(mazoJugador.getFigura(), mazoJugador.getValor(), mazoJugador.getIndiceCarta());
        insertarAcumulado.setCantidadCartas(insertarAcumulado.getCantidadCartas() + 2);
        sacarMesa.EliminarCarta(cartaMesa.getFigura(), cartaMesa.getValor());
        sacarMesa.setCantidadCartas(sacarMesa.getCantidadCartas() - 1);
        sacarJugador.EliminarCarta(mazoJugador.getFigura(), mazoJugador.getValor());
        sacarJugador.setCantidadCartas(sacarJugador.getCantidadCartas() - 1);

        if (sacarMesa.getMazo() == null) {
            jugadorPuntos.setPuntos(jugadorPuntos.getPuntos() + 1);
            System.out.println("----------------------------------------------------------Clareza en la mesa para "
                    + jugadorPuntos.getNombre());
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // Lanzar Carta------------------------------------------------------------------------------------------------------------------------
    public void lanzarCarta(Jugador jugadores, Mazo lanzaAmesa, Mazo sacaDMazoJugador, boolean identificar) {
        int opciones, opcion;
        Carta lanzarAmesa = new Carta();
        if (identificar) {
            opcion = mostarOpcionesParaLanzarYRecoger(juego.getPersona().getJuego(), 4);
        } else {
            opciones = sacaDMazoJugador.RecorerMazo(sacaDMazoJugador.getMazo());
            opcion = (int) (1 + Math.random() * opciones);
        }
        lanzarAmesa = sacaDMazoJugador.sacarCartaMazo(opcion);
        System.out.println();
        System.out.println("   " + jugadores.getNombre() + " lanza la carta: " + lanzarAmesa.getFigura() + " "
                + lanzarAmesa.getValor());
        juego.getMazoMesa().InsertarCarta(lanzarAmesa.getFigura(), lanzarAmesa.getValor(), lanzarAmesa.getIndiceCarta());
        juego.getMazoMesa().setCantidadCartas(juego.getMazoMesa().getCantidadCartas() + 1);
        jugadores.getJuego().EliminarCarta(lanzarAmesa.getFigura(), lanzarAmesa.getValor());
        jugadores.getJuego().setCantidadCartas(jugadores.getJuego().getCantidadCartas() - 1);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------
    //AgruparSumasDeCartas
    public void RecogerCartaAgrupada(Mazo mazoJugador, Mazo mazoAgrupadorJugador) {
        String tipo, numero;
        Carta carta = new Carta();
        System.out.print("\nIngrese el tipo de la carta (de su mano): ");
        tipo = leer.nextLine();
        leer.nextLine();
        System.out.print("\nIngrese el numero de la carta (de su mano): ");
        numero = leer.nextLine();
        leer.nextLine();

        if (mazoJugador != null) {
            carta = mazoJugador.BuscarCarta(mazoJugador, tipo, numero);
            if (carta != null) {
                if (carta.getValor().equals(sumaTotal)) {
                    mazoAgrupadorJugador.InsertarCarta(carta.getFigura(), carta.getValor(), carta.getIndiceCarta());
                    mazoJugador.EliminarCarta(carta.getFigura(), carta.getValor());
                } else {
                    System.out.println("\nLa suma de las carta no es igual a la carta que tienes en la mano.");
                }
            } else {
                System.out.println("\nNo se encontro esta carta en su mano.");
            }
        } else {
            System.out.println("\n");
        }

    }

    public void AgruparSumaDeCartas(Mazo mazoJugador, Mazo mazoMesa, Mazo mazoAgrupadorJugador) {
        String tipo, numero, tip, num, t, n;
        Carta carta = new Carta(), carta2 = new Carta(), carta3 = new Carta();
        Mazo aux = new Mazo(), aux2 = new Mazo(), aux3 = new Mazo();
        int auxSuma = 0, cantidad = 0, suma = 0;
        aux = mazoJugador;
        aux2 = mazoMesa;
        aux3 = mazoJugador;

        System.out.print("\nIngrese el tipo de la carta (de su mano): ");
        tipo = leer.nextLine();
        System.out.print("\nIngrese el numero de la carta (de su mano): ");
        numero = leer.nextLine();
        leer.nextLine();

        if (numero.equals("AS") || numero.equals("2") || numero.equals("3") || numero.equals("4") || numero.equals("5")
                || numero.equals("6") || numero.equals("7") || numero.equals("8") || numero.equals("9")
                || numero.equals("10")) {
            if (numero.equals("AS")) {
                auxSuma = 1;
            } else {
                auxSuma = Integer.parseInt(numero);
            }
            if (auxSuma >= 1 || auxSuma <= 10) {
                carta = aux.BuscarCarta(aux, tipo, numero);
                if (carta != null) {
                    System.out.print("\nIngrese la otra carta de tipo (de su mano): ");
                    tip = leer.nextLine();
                    System.out.print("\nIngrese la otra carta de numero (de su mano): ");
                    num = leer.nextLine();
                    leer.nextLine();
                    carta2 = aux3.BuscarCarta(aux3, tip, num);

                    if (carta2 != null) {
                        System.out.println("\nCuantas cartas quieres agarrar: ");
                        cantidad = leer.nextInt();
                        leer.nextLine();
                        for (int i = 1; i <= cantidad; i++) {
                            System.out.print("\nIngrese el tipo de la carta (de la mesa): ");
                            t = leer.nextLine();
                            System.out.print("\nIngrese el numero de la carta (de la mesa): ");
                            n = leer.nextLine();
                            leer.nextLine();
                            carta3 = aux2.BuscarCarta(aux2, t, n);

                            if (t.equals(carta3.getFigura()) && n.equals(carta3.getValor()) && carta3 != null) {
                                mazoAgrupadorJugador.InsertarCarta(t, n, i++);
                                mazoAgrupadorJugador.InsertarCarta(tip, num, i + 1);
                                mazoMesa.EliminarCarta(t, n);
                                mazoJugador.EliminarCarta(tip, num);
                                if (carta3.getValor().equals("AS")) {
                                    suma++;
                                } else {
                                    suma = suma + (Integer.parseInt(carta3.getValor()));
                                }
                            } else {
                                System.out.println("\nEsta carta no esta en la mesa ingrese otra por favor.");
                                i--;
                            }

                        }

                        if (suma == auxSuma) {
                            sumaTotal = suma + "";
                        }
                    }

                } else {
                    System.out.println("\nUsted no tiene esta carta en su mano.");
                }
            } else {
                System.out.println("\nUsted no tiene esa carta.");
            }

        } else {
            System.out.println("\nUsted no tiene esa carta en su mano");

        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void turnoPersonaJugar(boolean salir) {
        Mazo cartas = new Mazo();
        int opcion;
        boolean permitir = true;
        boolean opcionI = false;
        Archivos archivo = new Archivos();
        juego.mostrarJuego(juego);
        do {
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        " opciones: \n" + " 1. Recoger Carta igual: \n" + " 2. Agrupar suma de carta: \n"
                                + " 3. Recoger suma de cartas: \n" + " 4. Emparejamiento con mano: \n"
                                + " 5. Emparejamientos con mesa: \n" + " 6. Robar emparejamientos: \n"
                                + " 7. Lanzar Carta: \n" + " 8. Guardar Partida y Salir. \n" + " Su opcion(1-8): "));
                if ((opcion < 1) || (opcion > 8)) {
                    System.out.println("\n\tOpcion invalida \n\n\t");
                    opcionI = false;
                } else {
                    opcionI = true;
                }
            } while (opcionI != true);

            switch (opcion) {
                case 1:
                    if (PuedeRecoger(juego.getMazoMesa().getMazo(), juego.getPersona().getJuego(), cartas)) {
                        recogerCartas(juego.getMazoMesa(), juego.getPersona(), juego.getPersona().getAcumulado(), cartas,
                                true);
                        permitir = false;
                    } else {
                        System.out.println("No hay carta para recoger");
                    }
                    break;
                case 2:
                    AgruparSumaDeCartas(juego.getPersona().getJuego(), juego.getMazoMesa(),
                            juego.getPersona().getAcumulado());
                    break;
                case 3:
                    RecogerCartaAgrupada(juego.getPersona().getJuego(), juego.getPersona().getAcumulado());
                    break;
                case 4:
                    System.out.println("No terminado....");
                    break;
                case 5:
                    System.out.println("No terminado....");
                    break;
                case 6:
                    System.out.println("No terminado....");
                    break;
                case 7:
                    lanzarCarta(juego.getPersona(), juego.getMazoMesa(), juego.getPersona().getJuego(), true);
                    permitir = false;
                    break;
                case 8:
                    archivo.GuardarMazoJugador(juego.getPersona().getJuego());
                    archivo.GuardarMazoComputadora(juego.getComputadora().getJuego());
                    archivo.GuardarMazoMesa(juego.getMazoMesa());
                    archivo.GuardarMazoPilon(juego.getMazoPilon());
                    archivo.GuardarMazoAcumuladorJugador(juego.getPersona().getAcumulado());
                    archivo.GuardarMazoAcumuladorComputadora(juego.getComputadora().getAcumulado());
                    archivo.GuardarTurno(juego.isTurnoPersona());
                    archivo.GuardarPuntosJugador(juego.getPersona().getPuntos());
                    archivo.GuardarPuntosComputadora(juego.getComputadora().getPuntos());
                    break;
            }

        } while (permitir && opcion != 8);
    }

    //TURNO COMPUTADOR-----------------------------------------------------------------------------------------
    public void turnoComputadora() {
        int opcion;
        Mazo cartas = new Mazo();
        boolean validar = false;
        juego.mostrarJuego(juego);
        if (PuedeRecoger(juego.getMazoMesa().getMazo(), juego.getComputadora().getJuego(), cartas))
            validar = true;
        if (validar) {
            opcion = 1;
        } else {
            if (validar) {
                opcion = 2;
            } else {
                if (validar) {
                    opcion = 3;
                } else {
                    opcion = 4;
                }
            }
        }
        switch (opcion) {
            case 1:
                if (validar)
                    recogerCartas(juego.getMazoMesa(), juego.getComputadora(), juego.getComputadora().getAcumulado(),
                            cartas, false);
                break;
            case 4:
                lanzarCarta(juego.getComputadora(), juego.getMazoMesa(), juego.getComputadora().getJuego(), false);
                break;
        }
    }
}