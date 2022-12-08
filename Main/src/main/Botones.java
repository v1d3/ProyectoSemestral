package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Botones extends JButton implements ActionListener {

    public JButton ARojo, ARosado, AAzul;
    public JButton PistaP, PistaG;

    //boolean Red=false,Pink=false,Blue=false;
    Color colorauto;
    boolean pistaP = false;
    boolean pistaG = false;
    boolean cambio = false;

    public Botones() {

        ARojo = new JButton("Rojo");
        ARosado = new JButton("Rosado");
        AAzul = new JButton("Azul");
        PistaP = new JButton("Chico");
        PistaG = new JButton("grande");
    }

    public void ActivateActionListener() {
        ARojo.addActionListener(this);
        ARosado.addActionListener(this);
        AAzul.addActionListener(this);
        PistaP.addActionListener(this);
        PistaG.addActionListener(this);

        ARojo.setFocusable(false);
        ARosado.setFocusable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ARojo) {
            colorauto = Color.red;
        }
        if (e.getSource() == ARosado) {
            colorauto = new Color(255, 0, 128);
        }
        if (e.getSource() == AAzul) {
            colorauto = Color.blue;
        }

        if (e.getSource() == PistaP) {
            pistaP = true;
            cambio = true;
        }
        if (e.getSource() == PistaG) {
            pistaG = true;
            cambio = false;
        }
    }

    public Color getcolorauto() {
        return colorauto;
    }

    public boolean getpistaP() {
        return pistaP;
    }

    public boolean getpistaG() {
        return pistaG;
    }

    public boolean getcambiopista() {
        return cambio;
    }

    public void addBotonestoPanel(PanelPrincipal pp) {

        pp.add(ARojo);
        pp.add(ARosado);
        pp.add(AAzul);
        pp.add(PistaP);
        pp.add(PistaG);
    }

    public void addButtonsCoordinate() {

        ARojo.setBounds(1020, 170, 80, 50);
        ARosado.setBounds(1180, 170, 80, 50);
        AAzul.setBounds(1100, 170, 80, 50);
        PistaP.setBounds(1045, 70, 80, 50);
        PistaG.setBounds(1155, 70, 80, 50);
    }
}