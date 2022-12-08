package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private final PanelPrincipal panel;
    private static final Dimension WindowSize = new Dimension(1300, 800);

    public Ventana() {
        this.setLayout(new BorderLayout());

        panel = new PanelPrincipal();
        addKeyListener(panel);
        this.add(panel);
        panel.setLayout(null);
        /////////////////////////////////////////////////
        InitWindow();
    }

    private void InitWindow() {
        this.setTitle("CarRace");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WindowSize);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
