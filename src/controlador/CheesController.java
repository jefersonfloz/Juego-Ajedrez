package controlador;

import codigo.Ficha;
import codigo.Jugador;
import codigo.Partida;
import vista.VP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheesController{}
/*
    VP vista;
    JButton seleccionado;
    Partida juego;
    Ficha seleccionada;

    public CheesController(VP vista) {
        this.vista = vista;
        this.vista.addController(this);
        Jugador blanco = new Jugador(true);
        Jugador negro = new Jugador(false);
        juego = new Partida(blanco, negro, vista.MatrizCasillas);
        vista.getA7().addActionListener(e -> {
            accionBoton(vista.getA7(), 48);
            System.out.println("Boton A7 presionado");
        });
    }

    private void accionBoton(JButton boton, int posicion) {
        boolean turnoBlanco = juego.turnoBlanco;
        if (boton.getBackground().equals(Color.blue)) {
            seleccionada.casilla = null;
            seleccionado.setIcon(null);
            seleccionada.casilla = boton;
            if(seleccionada.tipo == 1 && ((posicion >= 0) && (posicion <=7) || (posicion >= 56) && (posicion <=63))){
                if(turnoBlanco && (posicion >= 0) && (posicion <=7)){
                    vista.promocionarPeon(boton,turnoBlanco);
                }else{
                    if(!turnoBlanco && (posicion >= 56) && (posicion <=63)){
                        vista.promocionarPeon(boton,turnoBlanco);
                    }else{
                        System.out.println("Error");
                    }
                }
            }else{
                seleccionada.poneImagenes(boton.getWidth(), boton.getHeight());
            }
            vista.pintarCasillasNormal(juego.tablero);
            actualizarTurno(turnoBlanco);
        } else {
            if (boton.getBackground().equals(Color.red)) {
                moverFicha(juego, turnoBlanco, boton, seleccionada, posicion);
            } else {
                seleccionado = null;
                seleccionada = null;
                vista.pintarCasillasNormal(juego.tablero);
                int i;
                i = 0;
                while (seleccionada == null && (i < juego.negro.fichas.size() || i < juego.blanco.fichas.size())) {
                    if (i < juego.negro.fichas.size() && !turnoBlanco) {
                        if (juego.negro.fichas.get(i).casilla.equals(boton)) {
                            seleccionado = juego.negro.fichas.get(i).casilla;
                            seleccionada = juego.negro.fichas.get(i);
                        }
                    } else {
                        if (i < juego.blanco.fichas.size() && turnoBlanco) {
                            if (juego.blanco.fichas.get(i).casilla.equals(boton)) {
                                seleccionado = juego.blanco.fichas.get(i).casilla;
                                seleccionada = juego.blanco.fichas.get(i);
                            }
                        }
                    }
                    i++;
                }
                if (seleccionada != null) {
                    if (seleccionada.tipo == 1) {
                        if((posicion >= 48) && (posicion <= 55) || (posicion >= 8) && (posicion <= 15)){
                            juego.calcularPosicionesPeon(posicion, turnoBlanco, true);
                        }else{
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
                    //JOptionPane.showMessageDialog(rootPane, "¡Las fichas BLANCAS gana la partida!");
                    vista.dispose();
                }
            } else {
                if (juego.comer(juego.blanco, comida)) {
                    //JOptionPane.showMessageDialog(rootPane, "¡Las fichas NEGRAS gana la partida!");
                    vista.dispose();
                }
            }
            seleccionada.casilla = null;
            seleccionado.setIcon(null);
            seleccionada.casilla = boton;
            if(seleccionada.tipo == 1 && ((posicion >= 0) && (posicion <=7) || (posicion >= 56) && (posicion <=63))){
                if(turnoBlanco && (posicion >= 0) && (posicion <=7)){
                    vista.promocionarPeon(boton,turnoBlanco);
                }else{
                    if(!turnoBlanco && (posicion >= 56) && (posicion <=63)){
                        vista.promocionarPeon(boton,turnoBlanco);
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

    private void actualizarTurno(boolean turnoBlanco){
        if(turnoBlanco){
            vista.tfTurno.setText("NEGRO");
            vista.tfTurno.setBackground(Color.BLACK);
            vista.tfTurno.setForeground(Color.WHITE);
        }else{
            vista.tfTurno.setText("BLANCO");
            vista.tfTurno.setBackground(Color.WHITE);
            vista.tfTurno.setForeground(Color.BLACK);
        }
        juego.cambiarTurno();
        seleccionado = null;
        seleccionada = null;
    }

    private void fireActionEvent(String buttonName) {
        // Emite el evento, puedes usar un Listener o Mediador si es necesario
        // Esto será procesado por el Controlador sin que la Vista lo conozca directamente
        System.out.println("Botón presionado: " + buttonName);
        // Ejemplo de notificación (si estás usando un Mediador o Dispatcher)
        // mediator.handleEvent(buttonName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// Obtiene el botón que activó el evento
        String comando = e.getActionCommand();

        // Aquí puedes manejar la lógica según qué botón fue presionado
        switch (comando) {
            case "A1":
                // Lógica para el botón A1
                System.out.println("Se presionó el botón A1");
                break;
            case "A2":
                // Lógica para el botón A2
                System.out.println("Se presionó el botón A2");
                break;
            case "A3":
                // Lógica para el botón A3
                System.out.println("Se presionó el botón A3");
                break;
            case "A4":
                // Lógica para el botón A4
                System.out.println("Se presionó el botón A4");
                break;
            case "A5":
                // Lógica para el botón A5
                System.out.println("Se presionó el botón A5");
                break;
            case "A6":
                // Lógica para el botón A6
                System.out.println("Se presionó el botón A6");
                break;
            case "A7":
                // Lógica para el botón A7
                System.out.println("Se presionó el botón A7");
                break;
            case "A8":
                // Lógica para el botón A8
                System.out.println("Se presionó el botón A8");
                break;
            case "B1":
                // Lógica para el botón B1
                System.out.println("Se presionó el botón B1");
                break;
            // Agregar más casos para los demás botones (B2, B3, ..., H8)
            default:
                System.out.println("Botón no definido");
                break;
        }
    }
}
*/