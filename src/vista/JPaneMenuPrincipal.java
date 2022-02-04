package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPaneMenuPrincipal extends JPanel {
    private JPanel JPanelSalir;
    private JLabel JLabelSalir;
    private JPanel JPanelCargar;
    private JLabel JLabelCargar;
    private JPanel JPanelEmpezar;
    private JLabel JLabelEmpezar;
    private JPanel JPanelMenu;

    public JPaneMenuPrincipal() {
        setLayout(null);

        JPanelSalir = new JPanel();
        JPanelSalir.setBackground(new Color(240, 248, 255));
        JPanelSalir.setBounds(296, 367, 331, 46);
        add(JPanelSalir);
        JPanelSalir.setLayout(null);

        JLabelSalir = new JLabel("3.- SALIR");
        JLabelSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        JLabelSalir.setHorizontalAlignment(SwingConstants.CENTER);
        JLabelSalir.setForeground(Color.BLACK);
        JLabelSalir.setBackground(Color.WHITE);
        JLabelSalir.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        JLabelSalir.setBounds(0, 0, 331, 46);
        JPanelSalir.add(JLabelSalir);

        JPanelCargar = new JPanel();
        JPanelCargar.setBackground(new Color(240, 248, 255));
        JPanelCargar.setBounds(182, 255, 589, 53);
        add(JPanelCargar);
        JPanelCargar.setLayout(null);

        JLabelCargar = new JLabel(" 2.- CARGAR PARTIDA ANTERIOR");
        JLabelCargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        JLabelCargar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        JLabelCargar.setHorizontalAlignment(SwingConstants.CENTER);
        JLabelCargar.setBounds(0, 0, 589, 53);
        JPanelCargar.add(JLabelCargar);

        JPanelEmpezar = new JPanel();
        JPanelEmpezar.setBackground(new Color(240, 248, 255));
        JPanelEmpezar.setBounds(182, 157, 589, 53);
        add(JPanelEmpezar);
        JPanelEmpezar.setLayout(null);

        JLabelEmpezar = new JLabel("1.- EMPEZAR NUEVA PARTIDA");
        JLabelEmpezar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        JLabelEmpezar.setBackground(new Color(240, 248, 255));
        JLabelEmpezar.setHorizontalAlignment(SwingConstants.CENTER);
        JLabelEmpezar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        JLabelEmpezar.setBounds(0, 0, 589, 53);
        JPanelEmpezar.add(JLabelEmpezar);

        JPanelMenu = new JPanel();
        JPanelMenu.setBackground(new Color(255, 255, 204));
        JPanelMenu.setBounds(63, 49, 859, 69);
        add(JPanelMenu);
        JPanelMenu.setLayout(null);

        JLabel JLabelMenu = new JLabel("MENU PRINCIPAL CASINO GAME");
        JLabelMenu.setBounds(0, 0, 859, 69);
        JPanelMenu.add(JLabelMenu);
        JLabelMenu.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        JLabelMenu.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel JLabelFondoMenu = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("/assets/fondos/MenuFondo.jpg"));
        JLabelFondoMenu.setIcon(icon);
        JLabelFondoMenu.setBackground(new Color(248, 248, 255));
        JLabelFondoMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabelFondoMenu.setHorizontalAlignment(SwingConstants.LEFT);
        JLabelFondoMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
        JLabelFondoMenu.setBounds(0, 0, 1024, 662);
        add(JLabelFondoMenu);

    }

}
