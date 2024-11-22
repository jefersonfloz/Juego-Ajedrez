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
    PGNCreater pgnCreater;
    JButton seleccionado;
    Ficha seleccionada;
    Partida juego;

    public CheesController(VP vista) {
        this.vista = vista;
        this.vista.addController(this);
        Jugador blanco = new Jugador(true);
        Jugador negro = new Jugador(false);
        juego = new Partida(blanco, negro, vista.getMatrizCasillas());
        pgnCreater = new PGNCreater("Jugador Blanco", "Jugador Negro", vista.getTextArea());
        sacarFichas();
    }


    private void sacarFichas() {
        //Fichas blancas
        //Peones blancos
        Ficha peonBlanco0 = new Ficha(true, 0, 1, juego.tablero[6][0]);
        Ficha peonBlanco1 = new Ficha(true, 1, 1, juego.tablero[6][1]);
        Ficha peonBlanco2 = new Ficha(true, 2, 1, juego.tablero[6][2]);
        Ficha peonBlanco3 = new Ficha(true, 3, 1, juego.tablero[6][3]);
        Ficha peonBlanco4 = new Ficha(true, 4, 1, juego.tablero[6][4]);
        Ficha peonBlanco5 = new Ficha(true, 5, 1, juego.tablero[6][5]);
        Ficha peonBlanco6 = new Ficha(true, 6, 1, juego.tablero[6][6]);
        Ficha peonBlanco7 = new Ficha(true, 7, 1, juego.tablero[6][7]);
        juego.blanco.fichas.add(peonBlanco0);
        juego.blanco.fichas.add(peonBlanco1);
        juego.blanco.fichas.add(peonBlanco2);
        juego.blanco.fichas.add(peonBlanco3);
        juego.blanco.fichas.add(peonBlanco4);
        juego.blanco.fichas.add(peonBlanco5);
        juego.blanco.fichas.add(peonBlanco6);
        juego.blanco.fichas.add(peonBlanco7);
        //Torres blancos
        Ficha torreBlanco0 = new Ficha(true, 8, 2, juego.tablero[7][0]);
        Ficha torreBlanco1 = new Ficha(true, 9, 2, juego.tablero[7][7]);
        juego.blanco.fichas.add(torreBlanco0);
        juego.blanco.fichas.add(torreBlanco1);
        //Caballos blancos
        Ficha caballoBlanco0 = new Ficha(true, 10, 3, juego.tablero[7][1]);
        Ficha caballoBlanco1 = new Ficha(true, 11, 3, juego.tablero[7][6]);
        juego.blanco.fichas.add(caballoBlanco0);
        juego.blanco.fichas.add(caballoBlanco1);
        //Alfiles blancos
        Ficha alfilBlanco0 = new Ficha(true, 12, 4, juego.tablero[7][2]);
        Ficha alfilBlanco1 = new Ficha(true, 13, 4, juego.tablero[7][5]);
        juego.blanco.fichas.add(alfilBlanco0);
        juego.blanco.fichas.add(alfilBlanco1);
        //Dama blanca
        Ficha damaBlanco = new Ficha(true, 14, 5, juego.tablero[7][3]);
        juego.blanco.fichas.add(damaBlanco);
        //Rey blanco
        Ficha reyBlanco = new Ficha(true, 15, 6, juego.tablero[7][4]);
        juego.blanco.fichas.add(reyBlanco);

        //Fichas negras
        //Peones negros
        Ficha peonNegro0 = new Ficha(false, 0, 1, juego.tablero[1][0]);
        Ficha peonNegro1 = new Ficha(false, 1, 1, juego.tablero[1][1]);
        Ficha peonNegro2 = new Ficha(false, 2, 1, juego.tablero[1][2]);
        Ficha peonNegro3 = new Ficha(false, 3, 1, juego.tablero[1][3]);
        Ficha peonNegro4 = new Ficha(false, 4, 1, juego.tablero[1][4]);
        Ficha peonNegro5 = new Ficha(false, 5, 1, juego.tablero[1][5]);
        Ficha peonNegro6 = new Ficha(false, 6, 1, juego.tablero[1][6]);
        Ficha peonNegro7 = new Ficha(false, 7, 1, juego.tablero[1][7]);
        juego.negro.fichas.add(peonNegro0);
        juego.negro.fichas.add(peonNegro1);
        juego.negro.fichas.add(peonNegro2);
        juego.negro.fichas.add(peonNegro3);
        juego.negro.fichas.add(peonNegro4);
        juego.negro.fichas.add(peonNegro5);
        juego.negro.fichas.add(peonNegro6);
        juego.negro.fichas.add(peonNegro7);
        //Torres negros
        Ficha torreNegro0 = new Ficha(false, 8, 2, juego.tablero[0][0]);
        Ficha torreNegro1 = new Ficha(false, 9, 2, juego.tablero[0][7]);
        juego.negro.fichas.add(torreNegro0);
        juego.negro.fichas.add(torreNegro1);
        //Caballos negros
        Ficha caballoNegro0 = new Ficha(false, 10, 3, juego.tablero[0][1]);
        Ficha caballoNegro1 = new Ficha(false, 11, 3, juego.tablero[0][6]);
        juego.negro.fichas.add(caballoNegro0);
        juego.negro.fichas.add(caballoNegro1);
        //Alfiles negros
        Ficha alfilNegro0 = new Ficha(false, 12, 4, juego.tablero[0][2]);
        Ficha alfilNegro1 = new Ficha(false, 13, 4, juego.tablero[0][5]);
        juego.negro.fichas.add(alfilNegro0);
        juego.negro.fichas.add(alfilNegro1);
        //Dama negros
        Ficha damaNegro = new Ficha(false, 14, 5, juego.tablero[0][3]);
        juego.negro.fichas.add(damaNegro);
        //Rey negros
        Ficha reyNegro = new Ficha(false, 15, 6, juego.tablero[0][4]);
        juego.negro.fichas.add(reyNegro);
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

                    accionBoton(botones[i][j], i * botones[i].length + j);
                    return;
                }
            }
        }
    }

    public void accionBoton(JButton boton, int posicion) {
        boolean turnoBlanco = juego.turnoBlanco;
        if (boton.getBackground().equals(Color.blue)) {
            // Movimiento normal (sin captura)
            int filaOrigen = getFila(seleccionado, juego.tablero);
            int columnaOrigen = getColumna(seleccionado, juego.tablero);
            int filaDestino = getFila(boton, juego.tablero);
            int columnaDestino = getColumna(boton, juego.tablero);

            // Registrar el movimiento en PGN
            pgnCreater.registrarMovimiento(seleccionada, filaOrigen, columnaOrigen, filaDestino, columnaDestino, false);

            seleccionada.casilla = null;
            seleccionado.setIcon(null);
            seleccionada.casilla = boton;
            if (seleccionada.tipo == 1 && ((posicion >= 0) && (posicion <= 7) || (posicion >= 56) && (posicion <= 63))) {
                if (turnoBlanco && (posicion >= 0) && (posicion <= 7)) {
                    vista.promocionarPeon(boton, turnoBlanco,seleccionada);
                } else if (!turnoBlanco && (posicion >= 56) && (posicion <= 63)) {
                    vista.promocionarPeon(boton, turnoBlanco,seleccionada);
                } else {
                    System.out.println("Error");
                }
            } else {
                seleccionada.poneImagenes(boton.getWidth(), boton.getHeight());
            }
            vista.pintarCasillasNormal(juego.tablero);
            actualizarTurno(turnoBlanco);
        } else if (boton.getBackground().equals(Color.red)) {
            // Movimiento con captura
            int filaOrigen = getFila(seleccionado, juego.tablero);
            int columnaOrigen = getColumna(seleccionado, juego.tablero);
            int filaDestino = getFila(boton, juego.tablero);
            int columnaDestino = getColumna(boton, juego.tablero);

            // Registrar el movimiento con captura en PGN
            pgnCreater.registrarMovimiento(seleccionada, filaOrigen, columnaOrigen, filaDestino, columnaDestino, true);

            moverFicha(juego, turnoBlanco, boton, seleccionada, posicion);
        } else {
            // Lógica para seleccionar una pieza o resetear la selección
            seleccionado = null;
            seleccionada = null;
            vista.pintarCasillasNormal(juego.tablero);
            int i = 0;
            while (seleccionada == null && (i < juego.negro.fichas.size() || i < juego.blanco.fichas.size())) {
                if (i < juego.negro.fichas.size() && !turnoBlanco) {
                    if (juego.negro.fichas.get(i).casilla.equals(boton)) {
                        seleccionado = juego.negro.fichas.get(i).casilla;
                        seleccionada = juego.negro.fichas.get(i);
                    }
                } else if (i < juego.blanco.fichas.size() && turnoBlanco) {
                    if (juego.blanco.fichas.get(i).casilla.equals(boton)) {
                        seleccionado = juego.blanco.fichas.get(i).casilla;
                        seleccionada = juego.blanco.fichas.get(i);
                    }
                }
                i++;
            }
            if (seleccionada != null) {
                if (seleccionada.tipo == 1) {
                    if ((posicion >= 48) && (posicion <= 55) || (posicion >= 8) && (posicion <= 15)) {
                        juego.calcularPosicionesPeon(posicion, turnoBlanco, true);
                    } else {
                        juego.calcularPosicionesPeon(posicion, turnoBlanco, false);
                    }
                    System.out.println("1");
                }
                if (seleccionada.tipo == 2) {
                    juego.calcularPosicionesTorre(posicion, turnoBlanco);
                    System.out.println("2");
                }
                if (seleccionada.tipo == 3) {
                    juego.calcularPosicionesCaballo(posicion, turnoBlanco);
                    System.out.println("3");
                }
                if (seleccionada.tipo == 4) {
                    juego.calcularPosicionesAlfil(posicion, turnoBlanco);
                    System.out.println("4");
                }
                if (seleccionada.tipo == 5) {
                    juego.calcularPosicionesDama(posicion, turnoBlanco);
                    System.out.println("5");
                }
                if (seleccionada.tipo == 6) {
                    juego.calcularPosicionesRey(posicion, turnoBlanco);
                    System.out.println("6");
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



    public void moverFicha(Partida juego, boolean turnoBlanco, JButton boton, Ficha seleccionada, int posicion) {
        Ficha comida = null;
        if (turnoBlanco) {
            if (juego.casillaOcupada(boton, juego.negro)) {
                for (int i = 0; i < juego.negro.fichas.size(); i++) {
                    if (juego.negro.fichas.get(i).casilla.equals(boton)) {
                        comida = juego.negro.fichas.get(i);
                    }
                }
            }
        } else {
            if (juego.casillaOcupada(boton, juego.blanco)) {
                for (int i = 0; i < juego.blanco.fichas.size(); i++) {
                    if (juego.blanco.fichas.get(i).casilla.equals(boton)) {
                        comida = juego.blanco.fichas.get(i);
                    }
                }
            }
        }
        if (comida != null) {
            if (turnoBlanco) {
                if (juego.comer(juego.negro, comida)) {
                    JOptionPane.showMessageDialog(null, "¡Las fichas BLANCAS gana la partida!");
                    vista.dispose();
                }
            } else {
                if (juego.comer(juego.blanco, comida)) {
                    JOptionPane.showMessageDialog(null, "¡Las fichas NEGRAS gana la partida!");
                    vista.dispose();
                }
            }
            seleccionada.casilla = null;
            seleccionado.setIcon(null);
            seleccionada.casilla = boton;
            if(seleccionada.tipo == 1 && ((posicion >= 0) && (posicion <=7) || (posicion >= 56) && (posicion <=63))){
                if(turnoBlanco && (posicion >= 0) && (posicion <=7)){
                    vista.promocionarPeon(boton,turnoBlanco,seleccionada);
                }else{
                    if(!turnoBlanco && (posicion >= 56) && (posicion <=63)){
                        vista.promocionarPeon(boton,turnoBlanco,seleccionada);
                    }else{
                        System.out.println("Error");
                    }
                }
            }else{
                seleccionada.poneImagenes(boton.getWidth(), boton.getHeight());
            }
            vista.pintarCasillasNormal(juego.tablero);
            actualizarTurno(turnoBlanco);
        }
    }

    public void actualizarTurno(boolean turnoBlanco){
        if(turnoBlanco){
            vista.getTfTurno().setText("NEGRO");
            vista.getTfTurno().setBackground(Color.BLACK);
            vista.getTfTurno().setForeground(Color.WHITE);
        }else{
            vista.getTfTurno().setText("BLANCO");
            vista.getTfTurno().setBackground(Color.WHITE);
            vista.getTfTurno().setForeground(Color.BLACK);
        }
        juego.cambiarTurno();
        seleccionado = null;
        seleccionada = null;
    }


}
