package modelo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MenuPrincipal {

	public void menuPrincipal() {
		int opcion = 0;

		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"\n JUEGO CASINO\n\n"
						+ "1. Jugar nueva partida\n\n" 
						+ "2. Jugar partida anterior\n\n" 
						+ "3. Salir\n\n"));
							
				switch (opcion) {
				case 1:
					Partida juego = new Partida();
					juego.partidaNueva();
					break;
				case 2:

					break;
				case 3:
					JOptionPane.showMessageDialog(null, " Saliendo, hasta luego.... ");
					break;
				default:
					break;
				}
			} catch (NumberFormatException e) {

			}
		} while (opcion != 3);
	}
}
