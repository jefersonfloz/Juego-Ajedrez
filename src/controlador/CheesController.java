package controlador;

import codigo.Ficha;
import codigo.Jugador;
import codigo.PGNCreater;
import codigo.Partida;
import vista.VP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheesController implements ActionListener {
    VP vista;
    Partida juego;
    PGNCreater pgnCreater;

    public CheesController(VP vista) {
        this.vista = vista;
        this.vista.addController(this);
        Jugador blanco = new Jugador(true);
        Jugador negro = new Jugador(false);
        juego = new Partida(blanco, negro, vista.getMatrizCasillas());

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Arreglo con los botones y sus índices correspondientes
        JButton[][] botones = {
                {vista.getA1(), vista.getB1(), vista.getC1(), vista.getD1(), vista.getE1(), vista.getF1(), vista.getG1(), vista.getH1()},
                {vista.getA2(), vista.getB2(), vista.getC2(), vista.getD2(), vista.getE2(), vista.getF2(), vista.getG2(), vista.getH2()},
                {vista.getA3(), vista.getB3(), vista.getC3(), vista.getD3(), vista.getE3(), vista.getF3(), vista.getG3(), vista.getH3()},
                {vista.getA4(), vista.getB4(), vista.getC4(), vista.getD4(), vista.getE4(), vista.getF4(), vista.getG4(), vista.getH4()},
                {vista.getA5(),vista.getB5(), vista.getC5(), vista.getD5(), vista.getE5(), vista.getF5(), vista.getG5(), vista.getH5()},
                {vista.getA6(),vista.getB6(), vista.getC6(), vista.getD6(), vista.getE6(), vista.getF6(), vista.getG6(), vista.getH6()},
                {vista.getA7(),vista.getB7(), vista.getC7(), vista.getD7(), vista.getE7(), vista.getF7(), vista.getG7(), vista.getH7()},
                {vista.getA8(),vista.getB8(), vista.getC8(), vista.getD8(), vista.getE8(),vista.getF8(), vista.getG8(), vista.getH8()}
        };

        // Recorre las filas de botones
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (source == botones[i][j]) {
                    // Llama a la acción correspondiente pasando el índice
                    int filaOrigen = getFila(vista.getSeleccionado(), juego.tablero);
                    int columnaOrigen = getColumna(vista.getSeleccionado(), juego.tablero);
                    int filaDestino = getFila(botones[i][j], juego.tablero);
                    int columnaDestino = getColumna(botones[i][j], juego.tablero);
                    vista.accionBoton(botones[i][j], i * botones[i].length + j);
                     return;
                }
            }
        }
    }

    private int getFila(JButton boton, JButton[][] botones) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (botones[i][j] == boton) {
                    return i;
                }
            }
        }
        return -1; // No encontrado
    }

    private int getColumna(JButton boton, JButton[][] botones) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (botones[i][j] == boton) {
                    return j;
                }
            }
        }
        return -1; // No encontrado
    }

}
