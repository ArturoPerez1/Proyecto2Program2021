package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Archivos {

    public void GuardarMazoJugador(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoJugador.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarMazoComputadora(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoComputadora.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarMazoMesa(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoMesa.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarMazoPilon(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoPilon.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarMazoAcumuladorJugador(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoAcumuladorJugador.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarMazoAcumuladorComputadora(Mazo jugador) {
        File file = new File("assets/baseDatos/MazoAcumuladorComputadora.txt");
        String tipo, numero;

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);

            while (jugador.getMazo() != null) {
                tipo = jugador.getMazo().getFigura();
                numero = jugador.getMazo().getValor();
                f.write(tipo + "\n");
                f.write(numero + "\n");
                jugador.setMazo(jugador.getMazo().getProximo());
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarNombre(String nombreJugador) {
        File file = new File("assets/baseDatos/Nombre.txt");

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);
            f.write(nombreJugador);
            f.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarTurno(boolean turno) {
        File file = new File("assets/baseDatos/Turno.txt");

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);
            f.write(turno + "\n");
            f.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarPuntosJugador(int puntos) {
        File file = new File("assets/baseDatos/PuntosJugador.txt");

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);
            f.write(puntos + "\n");
            f.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }

    public void GuardarPuntosComputadora(int puntos) {
        File file = new File("assets/baseDatos/PuntosComputadora.txt");

        try {
            boolean fileCreated = file.createNewFile();
            FileWriter f = new FileWriter(file);
            f.write(puntos + "\n");
            f.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }
    
//    public void GuardadoDeIdCartas(String nombreDelArchivo, int idCarta) {
//    	File file = new File("assets/baseDatos/" + nombreDelArchivo);
//    	boolean crearArchivo;
//    	FileWriter escribirArchivo;
//    	
//    	try {
//    		crearArchivo = file.createNewFile();
//    		escribirArchivo = new FileWriter(file);
//    		escribirArchivo.write(idCarta + "\n");
//    		escribirArchivo.close();    		
//    	}catch (IOException e) {
//    		System.out.println("Hubo una excepción del tipo: " + e);
//		}    	
//    }
//    
//    public void CargarIdGuardado(String nombreDelArchivo) {
//    	File file = new File("assets/baseDatos/" + nombreDelArchivo);
//		try {
//			Scanner sc = new Scanner(file);			
//			while(sc.hasNextLine()) {
//				String salida = sc.nextLine();
//				System.out.println(salida);
//			}
//			
//		}
//		catch(FileNotFoundException e) {
//			
//			System.out.println("Hubo una excepción del tipo: " + e);
//			
//		}
//    	
//    }
//    
//    public void BorrarId(String nombreDelArchivo) {
//    	File file = new File("assets/baseDatos/" + nombreDelArchivo);		
//		
//    	if(file.exists()) {
//			if(file.delete()) {
//				System.out.println("jeo");
//			}
//			else {
//					System.out.println("nose borrro");
//			}
//		}
//
//    }

}