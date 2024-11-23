package controlador;

import codigo.Ficha;
import codigo.Jugador;
import codigo.PGNCreater;
import codigo.Partida;
import vista.ChessView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * Controlador de las interacciones entre la vista y la lógica del juego de ajedrez.
 * Esta clase maneja los movimientos de las piezas, el turno de los jugadores, y el registro de las partidas en formato PGN.
 * Implementa la interfaz ActionListener para gestionar los eventos de los botones en la interfaz gráfica.
 */

public class CheesController implements ActionListener {

    private ChessView vista;
    private PGNCreater pgnCreater;
    private JButton seleccionado;
    private Ficha seleccionada;
    private Partida juego;
    private String nombre;


    /**
     * Constructor que inicializa el controlador de ajedrez con la vista proporcionada.
     * También establece los jugadores, crea la partida y configura el PGNCreater.
     * Además, asigna un ActionListener al botón de guardar de la vista.
     *
     * @param vista Vista del tablero de ajedrez
     */
    public CheesController(ChessView vista) {
        this.vista = vista;
        this.vista.addController(this);
        Jugador blanco = new Jugador(true);
        Jugador negro = new Jugador(false);
        juego = new Partida(blanco, negro, vista.getMatrizCasillas());
        pgnCreater = new PGNCreater("Jugador Blanco", "Jugador Negro", vista.getTextArea());
        sacarFichas();
        vista.getBtnGuardar().addActionListener(e -> {
            nombre = vista.getTextoGuardar().getText().trim();
            try {
                pgnCreater.guardarPGN("src/partidas/" + nombre + ".pgn");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "¡Guardado correctamente!");
            vista.dispose();
        });
    }

    /**
     * Inicializa las piezas en el tablero de ajedrez para ambas partidas (blanco y negro).
     * Coloca las fichas en sus posiciones iniciales correspondientes.
     */
    private void sacarFichas() {
        //Fichas blancas
        //Peones blancos
        Ficha peonBlanco0 = new Ficha(true, 0, 1, juego.getTablero()[6][0]);
        Ficha peonBlanco1 = new Ficha(true, 1, 1, juego.getTablero()[6][1]);
        Ficha peonBlanco2 = new Ficha(true, 2, 1, juego.getTablero()[6][2]);
        Ficha peonBlanco3 = new Ficha(true, 3, 1, juego.getTablero()[6][3]);
        Ficha peonBlanco4 = new Ficha(true, 4, 1, juego.getTablero()[6][4]);
        Ficha peonBlanco5 = new Ficha(true, 5, 1, juego.getTablero()[6][5]);
        Ficha peonBlanco6 = new Ficha(true, 6, 1, juego.getTablero()[6][6]);
        Ficha peonBlanco7 = new Ficha(true, 7, 1, juego.getTablero()[6][7]);
        juego.getBlanco().getFichas().add(peonBlanco0);
        juego.getBlanco().getFichas().add(peonBlanco1);
        juego.getBlanco().getFichas().add(peonBlanco2);
        juego.getBlanco().getFichas().add(peonBlanco3);
        juego.getBlanco().getFichas().add(peonBlanco4);
        juego.getBlanco().getFichas().add(peonBlanco5);
        juego.getBlanco().getFichas().add(peonBlanco6);
        juego.getBlanco().getFichas().add(peonBlanco7);
        //Torres blancos
        Ficha torreBlanco0 = new Ficha(true, 8, 2, juego.getTablero()[7][0]);
        Ficha torreBlanco1 = new Ficha(true, 9, 2, juego.getTablero()[7][7]);
        juego.getBlanco().getFichas().add(torreBlanco0);
        juego.getBlanco().getFichas().add(torreBlanco1);
        //Caballos blancos
        Ficha caballoBlanco0 = new Ficha(true, 10, 3, juego.getTablero()[7][1]);
        Ficha caballoBlanco1 = new Ficha(true, 11, 3, juego.getTablero()[7][6]);
        juego.getBlanco().getFichas().add(caballoBlanco0);
        juego.getBlanco().getFichas().add(caballoBlanco1);
        //Alfiles blancos
        Ficha alfilBlanco0 = new Ficha(true, 12, 4, juego.getTablero()[7][2]);
        Ficha alfilBlanco1 = new Ficha(true, 13, 4, juego.getTablero()[7][5]);
        juego.getBlanco().getFichas().add(alfilBlanco0);
        juego.getBlanco().getFichas().add(alfilBlanco1);
        //Dama blanca
        Ficha damaBlanco = new Ficha(true, 14, 5, juego.getTablero()[7][3]);
        juego.getBlanco().getFichas().add(damaBlanco);
        //Rey blanco
        Ficha reyBlanco = new Ficha(true, 15, 6, juego.getTablero()[7][4]);
        juego.getBlanco().getFichas().add(reyBlanco);

        //Fichas negras
        //Peones negros
        Ficha peonNegro0 = new Ficha(false, 0, 1, juego.getTablero()[1][0]);
        Ficha peonNegro1 = new Ficha(false, 1, 1, juego.getTablero()[1][1]);
        Ficha peonNegro2 = new Ficha(false, 2, 1, juego.getTablero()[1][2]);
        Ficha peonNegro3 = new Ficha(false, 3, 1, juego.getTablero()[1][3]);
        Ficha peonNegro4 = new Ficha(false, 4, 1, juego.getTablero()[1][4]);
        Ficha peonNegro5 = new Ficha(false, 5, 1, juego.getTablero()[1][5]);
        Ficha peonNegro6 = new Ficha(false, 6, 1, juego.getTablero()[1][6]);
        Ficha peonNegro7 = new Ficha(false, 7, 1, juego.getTablero()[1][7]);
        juego.getNegro().getFichas().add(peonNegro0);
        juego.getNegro().getFichas().add(peonNegro1);
        juego.getNegro().getFichas().add(peonNegro2);
        juego.getNegro().getFichas().add(peonNegro3);
        juego.getNegro().getFichas().add(peonNegro4);
        juego.getNegro().getFichas().add(peonNegro5);
        juego.getNegro().getFichas().add(peonNegro6);
        juego.getNegro().getFichas().add(peonNegro7);
        //Torres negros
        Ficha torreNegro0 = new Ficha(false, 8, 2, juego.getTablero()[0][0]);
        Ficha torreNegro1 = new Ficha(false, 9, 2, juego.getTablero()[0][7]);
        juego.getNegro().getFichas().add(torreNegro0);
        juego.getNegro().getFichas().add(torreNegro1);
        //Caballos negros
        Ficha caballoNegro0 = new Ficha(false, 10, 3, juego.getTablero()[0][1]);
        Ficha caballoNegro1 = new Ficha(false, 11, 3, juego.getTablero()[0][6]);
        juego.getNegro().getFichas().add(caballoNegro0);
        juego.getNegro().getFichas().add(caballoNegro1);
        //Alfiles negros
        Ficha alfilNegro0 = new Ficha(false, 12, 4, juego.getTablero()[0][2]);
        Ficha alfilNegro1 = new Ficha(false, 13, 4, juego.getTablero()[0][5]);
        juego.getNegro().getFichas().add(alfilNegro0);
        juego.getNegro().getFichas().add(alfilNegro1);
        //Dama negros
        Ficha damaNegro = new Ficha(false, 14, 5, juego.getTablero()[0][3]);
        juego.getNegro().getFichas().add(damaNegro);
        //Rey negros
        Ficha reyNegro = new Ficha(false, 15, 6, juego.getTablero()[0][4]);
        juego.getNegro().getFichas().add(reyNegro);
    }

    /**
     * Controla el evento de un botón presionado en el tablero de ajedrez.
     * Al seleccionar una ficha o casilla, el controlador maneja el movimiento de las piezas
     * y actualiza el estado del tablero.
     *
     * @param e El evento de acción que fue disparado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Arreglo con los botones y sus índices correspondientes
        JButton[][] botones = {
                {vista.getA1(), vista.getB1(), vista.getC1(), vista.getD1(), vista.getE1(), vista.getF1(), vista.getG1(), vista.getH1()},
                {vista.getA2(), vista.getB2(), vista.getC2(), vista.getD2(), vista.getE2(), vista.getF2(), vista.getG2(), vista.getH2()},
                {vista.getA3(), vista.getB3(), vista.getC3(), vista.getD3(), vista.getE3(), vista.getF3(), vista.getG3(), vista.getH3()},
                {vista.getA4(), vista.getB4(), vista.getC4(), vista.getD4(), vista.getE4(), vista.getF4(), vista.getG4(), vista.getH4()},
                {vista.getA5(), vista.getB5(), vista.getC5(), vista.getD5(), vista.getE5(), vista.getF5(), vista.getG5(), vista.getH5()},
                {vista.getA6(), vista.getB6(), vista.getC6(), vista.getD6(), vista.getE6(), vista.getF6(), vista.getG6(), vista.getH6()},
                {vista.getA7(), vista.getB7(), vista.getC7(), vista.getD7(), vista.getE7(), vista.getF7(), vista.getG7(), vista.getH7()},
                {vista.getA8(), vista.getB8(), vista.getC8(), vista.getD8(), vista.getE8(), vista.getF8(), vista.getG8(), vista.getH8()}
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

    /**
     * Maneja el evento de un botón presionado en el tablero de ajedrez. Este método determina si el movimiento es un
     * movimiento normal o un movimiento con captura, registra el movimiento en formato PGN y actualiza el tablero de ajedrez.
     * También controla la promoción de peones si alcanzan la fila final y actualiza el turno de juego.
     *
     * @param boton    El botón de la casilla en el tablero que ha sido presionado.
     * @param posicion La posición de la casilla en el tablero, representada por un índice (de 0 a 63).
     */

    public void accionBoton(JButton boton, int posicion) {
        boolean turnoBlanco = juego.isTurnoBlanco();
        if (boton.getBackground().equals(Color.blue)) {
            // Movimiento normal (sin captura)
            int filaOrigen = getFila(seleccionado, juego.getTablero());
            int columnaOrigen = getColumna(seleccionado, juego.getTablero());
            int filaDestino = getFila(boton, juego.getTablero());
            int columnaDestino = getColumna(boton, juego.getTablero());

            // Registrar el movimiento en PGN
            pgnCreater.registrarMovimiento(seleccionada, filaOrigen, columnaOrigen, filaDestino, columnaDestino, false);

            seleccionada.casilla = null;
            seleccionado.setIcon(null);
            seleccionada.casilla = boton;
            if (seleccionada.tipo == 1 && ((posicion >= 0) && (posicion <= 7) || (posicion >= 56) && (posicion <= 63))) {
                if (turnoBlanco && (posicion >= 0) && (posicion <= 7)) {
                    vista.promocionarPeon(boton, turnoBlanco, seleccionada);
                } else if (!turnoBlanco && (posicion >= 56) && (posicion <= 63)) {
                    vista.promocionarPeon(boton, turnoBlanco, seleccionada);
                } else {
                    System.out.println("Error");
                }
            } else {
                seleccionada.poneImagenes(boton.getWidth(), boton.getHeight());
            }
            vista.pintarCasillasNormal(juego.getTablero());
            actualizarTurno(turnoBlanco);
        } else if (boton.getBackground().equals(Color.red)) {
            // Movimiento con captura
            int filaOrigen = getFila(seleccionado, juego.getTablero());
            int columnaOrigen = getColumna(seleccionado, juego.getTablero());
            int filaDestino = getFila(boton, juego.getTablero());
            int columnaDestino = getColumna(boton, juego.getTablero());

            // Registrar el movimiento con captura en PGN
            pgnCreater.registrarMovimiento(seleccionada, filaOrigen, columnaOrigen, filaDestino, columnaDestino, true);

            moverFicha(juego, turnoBlanco, boton, seleccionada, posicion);
        } else {
            // Lógica para seleccionar una pieza o resetear la selección
            seleccionado = null;
            seleccionada = null;
            vista.pintarCasillasNormal(juego.getTablero());
            int i = 0;
            while (seleccionada == null && (i < juego.getNegro().getFichas().size() || i < juego.getBlanco().getFichas().size())) {
                if (i < juego.getNegro().getFichas().size() && !turnoBlanco) {
                    if (juego.getNegro().getFichas().get(i).casilla.equals(boton)) {
                        seleccionado = juego.getNegro().getFichas().get(i).casilla;
                        seleccionada = juego.getNegro().getFichas().get(i);
                    }
                } else if (i < juego.getBlanco().getFichas().size() && turnoBlanco) {
                    if (juego.getBlanco().getFichas().get(i).casilla.equals(boton)) {
                        seleccionado = juego.getBlanco().getFichas().get(i).casilla;
                        seleccionada = juego.getBlanco().getFichas().get(i);
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
                }
                if (seleccionada.tipo == 2) {
                    juego.calcularPosicionesTorre(posicion, turnoBlanco);
                }
                if (seleccionada.tipo == 3) {
                    juego.calcularPosicionesCaballo(posicion, turnoBlanco);
                }
                if (seleccionada.tipo == 4) {
                    juego.calcularPosicionesAlfil(posicion, turnoBlanco);
                }
                if (seleccionada.tipo == 5) {
                    juego.calcularPosicionesDama(posicion, turnoBlanco);
                }
                if (seleccionada.tipo == 6) {
                    juego.calcularPosicionesRey(posicion, turnoBlanco);
                }
            }
        }
    }

    /**
     * Obtiene la fila en la que se encuentra un botón dentro de una matriz de botones.
     *
     * @param boton   El botón que se quiere localizar.
     * @param botones La matriz de botones en la que se busca.
     * @return La fila del botón, o -1 si no se encuentra.
     */

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

    /**
     * Obtiene la columna en la que se encuentra un botón dentro de una matriz de botones.
     *
     * @param boton El botón que se quiere localizar.
     * @param botones La matriz de botones en la que se busca.
     * @return La columna del botón, o -1 si no se encuentra.
     */

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


    /**
     * Mueve una ficha en el tablero, gestionando la captura de fichas enemigas, la promoción de peones y la actualización de la partida.
     * Si el jugador mueve a una casilla ocupada por una ficha contraria, se captura la ficha enemiga.
     * Si el movimiento promueve a un peón, se promueve la ficha a una nueva pieza.
     * Después de mover la ficha, actualiza el turno y el estado del tablero.
     *
     * @param juego El objeto que contiene el estado de la partida y permite interactuar con las reglas del juego.
     * @param turnoBlanco Indica si es el turno del jugador blanco (true) o negro (false).
     * @param boton El botón en el que se desea colocar la ficha.
     * @param seleccionada La ficha que se está moviendo.
     * @param posicion La posición en la que se desea mover la ficha (usada para comprobar si se trata de una promoción de peón).
     */

    public void moverFicha(Partida juego, boolean turnoBlanco, JButton boton, Ficha seleccionada, int posicion) {
        Ficha comida = null;
        if (turnoBlanco) {
            if (juego.casillaOcupada(boton, juego.getNegro())) {
                for (int i = 0; i < juego.getNegro().getFichas().size(); i++) {
                    if (juego.getNegro().getFichas().get(i).casilla.equals(boton)) {
                        comida = juego.getNegro().getFichas().get(i);
                    }
                }
            }
        } else {
            if (juego.casillaOcupada(boton, juego.getBlanco())) {
                for (int i = 0; i < juego.getBlanco().getFichas().size(); i++) {
                    if (juego.getBlanco().getFichas().get(i).casilla.equals(boton)) {
                        comida = juego.getBlanco().getFichas().get(i);
                    }
                }
            }
        }
        if (comida != null) {
            if (turnoBlanco) {
                if (juego.comer(juego.getNegro(), comida)) {
                    JOptionPane.showMessageDialog(null, "¡Las fichas BLANCAS gana la partida!");
                    try {
                        pgnCreater.guardarPGN("src/partidas/"+nombre+".pgn");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null, "¡Guardado correctamente!");
                    vista.dispose();
                }
            } else {
                if (juego.comer(juego.getBlanco(), comida)) {
                    JOptionPane.showMessageDialog(null, "¡Las fichas NEGRAS gana la partida!");
                    try {
                        pgnCreater.guardarPGN("src/partidas/"+nombre+".pgn");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null, "¡Guardado correctamente!");
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
            vista.pintarCasillasNormal(juego.getTablero());
            actualizarTurno(turnoBlanco);
        }
    }

    /**
     * Actualiza el turno de la partida cambiando el color del fondo del panel de turno y el texto que muestra el jugador actual.
     * Después de actualizar el turno, se cambia el jugador activo en el objeto de partida.
     *
     * @param turnoBlanco Indica si el turno actual es del jugador blanco (true) o negro (false).
     */

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
