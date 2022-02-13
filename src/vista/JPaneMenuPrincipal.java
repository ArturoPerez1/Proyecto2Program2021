package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPaneMenuPrincipal extends JPanel {
	private JPanel JPanelSalir;
	private JButton JButtonSalir;
	private JPanel JPanelCargar;
	private JButton JButtonCargar;
	private JPanel JPanelEmpezar;
	private JButton JButtonEmpezar;
	private JPanel JPanelMenu;
	private JLabel JLabelMenu;

	public JPaneMenuPrincipal() {
		setLayout(null);

		JPanelSalir();
		JButtonSalir();
		JPanelCargar();
		JButtonCargar();
		JPanelEmpezar();
		JButtonEmpezar();
		JPanelMenu();
		JLabelMenu();
		JLabelFondoMenu();
	}

	public JButton getJButtonSalir() {
		return JButtonSalir;
	}

	public JButton getJButtonCargar() {
		return JButtonCargar;
	}

	public JButton getJButtonEmpezar() {
		return JButtonEmpezar;
	}

	private void JPanelSalir() {
		JPanelSalir = new JPanel();
		JPanelSalir.setBackground(new Color(240, 248, 255));
		JPanelSalir.setBounds(296, 367, 331, 46);
		add(JPanelSalir);
		JPanelSalir.setLayout(null);

	}

	private void JButtonSalir() {
		JButtonSalir = new JButton("3.- SALIR");
		JButtonSalir.setHorizontalAlignment(SwingConstants.CENTER);
		JButtonSalir.setForeground(Color.BLACK);
		JButtonSalir.setBackground(new Color(240, 248, 255));
		JButtonSalir.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		JButtonSalir.setBounds(0, 0, 331, 46);
		JPanelSalir.add(JButtonSalir);
	}

	private void JPanelCargar() {
		JPanelCargar = new JPanel();
		JPanelCargar.setBackground(new Color(240, 248, 255));
		JPanelCargar.setBounds(182, 255, 589, 53);
		add(JPanelCargar);
		JPanelCargar.setLayout(null);
	}

	private void JButtonCargar() {
		JButtonCargar = new JButton(" 2.- CARGAR PARTIDA ANTERIOR");
		JButtonCargar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		JButtonCargar.setBackground(new Color(240, 248, 255));
		JButtonCargar.setHorizontalAlignment(SwingConstants.CENTER);
		JButtonCargar.setBounds(0, 0, 589, 53);
		JPanelCargar.add(JButtonCargar);
	}

	private void JPanelEmpezar() {
		JPanelEmpezar = new JPanel();
		JPanelEmpezar.setBackground(new Color(240, 248, 255));
		JPanelEmpezar.setBounds(182, 157, 589, 53);
		add(JPanelEmpezar);
		JPanelEmpezar.setLayout(null);
	}

	private void JButtonEmpezar() {
		JButtonEmpezar = new JButton("1.- EMPEZAR NUEVA PARTIDA");
		JButtonEmpezar.setBackground(new Color(240, 248, 255));
		JButtonEmpezar.setHorizontalAlignment(SwingConstants.CENTER);
		JButtonEmpezar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		JButtonEmpezar.setBounds(0, 0, 589, 53);
		JPanelEmpezar.add(JButtonEmpezar);
	}

	private void JPanelMenu() {
		JPanelMenu = new JPanel();
		JPanelMenu.setBackground(new Color(255, 255, 204));
		JPanelMenu.setBounds(63, 49, 859, 69);
		add(JPanelMenu);
		JPanelMenu.setLayout(null);
	}

	private void JLabelMenu() {
		JLabelMenu = new JLabel("MENU PRINCIPAL CASINO GAME");
		JLabelMenu.setBounds(0, 0, 859, 69);
		JPanelMenu.add(JLabelMenu);
		JLabelMenu.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
		JLabelMenu.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void JLabelFondoMenu() {
		JLabel JLabelFondoMenu = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/MenuFondo.jpg"));
		JLabelFondoMenu.setIcon(icon);
		JLabelFondoMenu.setBackground(new Color(248, 248, 255));
		JLabelFondoMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabelFondoMenu.setHorizontalAlignment(SwingConstants.LEFT);
		JLabelFondoMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		JLabelFondoMenu.setBounds(0, 0, 1024, 662);
		add(JLabelFondoMenu);
	}

	public void addActionLister1(ActionListener actionListener) {
		JButtonEmpezar.addActionListener(actionListener);
		JButtonSalir.addActionListener(actionListener);
		JButtonCargar.addActionListener(actionListener);
	}

}