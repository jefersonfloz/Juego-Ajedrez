
package codigo;

import javax.swing.JButton;
import java.awt.*;


/**
 * Clase que representa una partida de ajedrez con dos jugadores, un tablero de botones
 * y gestión de turnos, movimientos y capturas de piezas.
 */

public class Partida {
    private Jugador blanco;
    private Jugador negro;
    private JButton tablero[][];
    private boolean turnoBlanco;

    /**
     * Constructor que inicializa una partida con jugadores y un tablero.
     *
     * @param b Jugador que controla las piezas blancas.
     * @param n Jugador que controla las piezas negras.
     * @param t Tablero representado como una matriz de botones.
     */

    public Partida(codigo.Jugador b, codigo.Jugador n, JButton[][] t){
        this.blanco = b;
        this.negro = n;
        this.turnoBlanco = true;
        this.tablero = new JButton[8][8];
        this.tablero = t;
    }


    /**
     * Cambia el turno de juego alternando entre el jugador blanco y el negro.
     */
    public void cambiarTurno(){
        if(this.turnoBlanco){
            this.turnoBlanco = false;
        }else{
            this.turnoBlanco = true;
        }
    }

    /**
     * Verifica si una casilla está ocupada por alguna ficha del jugador dado.
     *
     * @param casilla Casilla a verificar.
     * @param jugador Jugador cuyas fichas se verificarán.
     * @return true si la casilla está ocupada, false en caso contrario.
     */
    public boolean casillaOcupada(JButton casilla, codigo.Jugador jugador) {
        boolean ocupada = false;
        for(int i=0; i<jugador.getFichas().size(); i++){
            if(casilla.equals(jugador.getFichas().get(i).casilla)){
                ocupada = true;
            }
        }
        return ocupada;
    }


    /**
     * Realiza la acción de "comer" una ficha rival, verificando si es el rey
     * para determinar si se acaba la partida.
     *
     * @param rival Jugador rival cuyas fichas se revisarán.
     * @param eliminada Ficha que se intenta eliminar.
     * @return true si la partida ha terminado (rey eliminado), false en caso contrario.
     */

    //retorna si se  ha acabado la partida
    public boolean comer(codigo.Jugador rival, codigo.Ficha eliminada){
        boolean acabado = false;
        for(int i=0; i<rival.getFichas().size(); i++){
            if(rival.getFichas().get(i).equals(eliminada)){
                if(rival.getFichas().get(i).tipo == 6){
                    acabado = true;
                }
                rival.getFichas().remove(i);
            }
        }
        return acabado;
    }
    /**
     * Calcula las posiciones posibles de movimiento para un caballo según las reglas
     * del ajedrez. Cambia el color de las casillas accesibles según su estado.
     *
     * @param posicion Índice de la posición inicial del caballo en el tablero.
     * @param turnoBlanco true si es el turno de las piezas blancas, false en caso contrario.
     */

    public void calcularPosicionesCaballo(int posicion, boolean turnoBlanco) {
        int x = posicion / 8;
        int y = posicion % 8;
        int i = x;
        int j = y;
        if (turnoBlanco) {
            i = x - 1;
            j = y + 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 2;
            j = y + 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 1;
            j = y + 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 2;
            j = y + 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 1;
            j = y - 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 2;
            j = y - 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 1;
            j = y - 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 2;
            j = y - 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
        } else {
            i = x - 1;
            j = y + 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 2;
            j = y + 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 1;
            j = y + 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 2;
            j = y + 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 1;
            j = y - 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x - 2;
            j = y - 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 1;
            j = y - 2;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
            i = x + 2;
            j = y - 1;
            if ((i >= 0) && (i < 8) && (j < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                } else {
                    if (!casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.blue);
                    }
                }
            }
        }

    }
    /**
     * Calcula las posiciones posibles de movimiento para un alfil según las reglas
     * del ajedrez. Cambia el color de las casillas accesibles según su estado.
     *
     * @param posicion Índice de la posición inicial del alfil en el tablero.
     * @param turnoBlanco true si es el turno de las piezas blancas, false en caso contrario.
     */

    public void calcularPosicionesAlfil(int posicion, boolean turnoBlanco) {
        int x = posicion / 8;
        int y = posicion % 8;
        int i = x - 1;
        int j = y - 1;
        boolean ocupada = false;
        if (turnoBlanco) {
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if(!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)){
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i--;
                j--;
            }
            ocupada = false;
            i = x + 1;
            j = y + 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i++;
                j++;
            }
            ocupada = false;
            i = x + 1;
            j = y - 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i++;
                j--;
            }
            ocupada = false;
            i = x - 1;
            j = y + 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], negro)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i--;
                j++;
            }
        } else {
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i--;
                j--;
            }
            ocupada = false;
            i = x + 1;
            j = y + 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i++;
                j++;
            }
            ocupada = false;
            i = x + 1;
            j = y - 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i++;
                j--;
            }
            ocupada = false;
            i = x - 1;
            j = y + 1;
            while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);
                } else {
                    ocupada = true;
                    if (casillaOcupada(tablero[i][j], blanco)) {
                        tablero[i][j].setBackground(Color.red);
                    }
                }
                i--;
                j++;
            }
        }
    }

    public void calcularPosicionesDama(int posicion, boolean turnoBlanco) {
        calcularPosicionesAlfil(posicion, turnoBlanco);
        calcularPosicionesTorre(posicion, turnoBlanco);
    }

    public void calcularPosicionesTorre(int posicion, boolean turnoBlanco) {
        int x = posicion / 8;
        int y = posicion % 8;
        int i = x - 1;
        int j = y;
        boolean ocupada = false;
        while ((i >= 0) && (i < 8) && !ocupada) {
            if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                tablero[i][j].setBackground(Color.blue);
            } else {
                ocupada = true;
                if (turnoBlanco && casillaOcupada(tablero[i][j], negro) || !turnoBlanco && casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            i--;
        }
        i = x + 1;
        j = y;
        ocupada = false;
        while ((i >= 0) && (i < 8) && !ocupada) {
            if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                tablero[i][j].setBackground(Color.blue);
            } else {
                ocupada = true;
                if (turnoBlanco && casillaOcupada(tablero[i][j], negro) || !turnoBlanco && casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            i++;
        }
        i = x;
        j = y + 1;
        ocupada = false;
        while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
            if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                tablero[i][j].setBackground(Color.blue);
            } else {
                ocupada = true;
                if (turnoBlanco && casillaOcupada(tablero[i][j], negro) || !turnoBlanco && casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            j++;
        }
        i = x;
        j = y - 1;
        ocupada = false;
        while ((i >= 0) && (i < 8) && (j < 8) && (j >= 0) && !ocupada) {
            if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                tablero[i][j].setBackground(Color.blue);
            } else {
                ocupada = true;
                if (turnoBlanco && casillaOcupada(tablero[i][j], negro) || !turnoBlanco && casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            j--;
        }
    }
    public void calcularPosicionesRey(int posicion, boolean turnoBlanco) {
        int x = posicion / 8;
        int y = posicion % 8;
        int i = x;
        int j = y;
        if (turnoBlanco) {
            for(i=x-1; i<x+2; i++){
                for(j=y-1; j<y+2; j++){
                    if((i != x) || (j != y)){
                        if ((i >= 0) && (i < 8) && (j >= 0) && (j < 8)) {
                            if (casillaOcupada(tablero[i][j], negro)) {
                                tablero[i][j].setBackground(Color.red);
                            } else {
                                if (!casillaOcupada(tablero[i][j], blanco)) {
                                    tablero[i][j].setBackground(Color.blue);
                                }
                            }
                        }
                    }
                }
            }
        }else{
            for(i=x-1; i<x+2; i++){
                for(j=y-1; j<y+2; j++){
                    if((i != x) || (j != y)){
                        if ((i >= 0) && (i < 8) && (j >= 0) && (j < 8)) {
                            if (casillaOcupada(tablero[i][j], blanco)) {
                                tablero[i][j].setBackground(Color.red);
                            } else {
                                if (!casillaOcupada(tablero[i][j], negro)) {
                                    tablero[i][j].setBackground(Color.blue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void calcularPosicionesPeon(int posicion, boolean turnoBlanco, boolean primerTurno) {
        int x = posicion / 8;
        int y = posicion % 8;
        int i, j;

        // Movimiento hacia arriba para las blancas
        if (turnoBlanco) {
            // Una casilla adelante
            i = x - 1; j = y;
            if ((i >= 0) && (j >= 0) && (j < 8)) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);

                    // Dos casillas adelante (si es el primer turno)
                    if (primerTurno) {
                        int i2 = x - 2; // Segunda casilla adelante
                        if ((i2 >= 0) && !casillaOcupada(tablero[i2][j], negro) && !casillaOcupada(tablero[i2][j], blanco)) {
                            tablero[i2][j].setBackground(Color.blue);
                        }
                    }
                }
            }
            // Diagonal izquierda (captura)
            i = x - 1; j = y - 1;
            if ((i >= 0) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            // Diagonal derecha (captura)
            i = x - 1; j = y + 1;
            if ((i >= 0) && (j < 8)) {
                if (casillaOcupada(tablero[i][j], negro)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
        } else { // Movimiento hacia abajo para las negras
            // Una casilla adelante
            i = x + 1; j = y;
            if ((i < 8) && (j >= 0) && (j < 8)) {
                if (!casillaOcupada(tablero[i][j], negro) && !casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.blue);

                    // Dos casillas adelante (si es el primer turno)
                    if (primerTurno) {
                        int i2 = x + 2; // Segunda casilla adelante
                        if ((i2 < 8) && !casillaOcupada(tablero[i2][j], negro) && !casillaOcupada(tablero[i2][j], blanco)) {
                            tablero[i2][j].setBackground(Color.blue);
                        }
                    }
                }
            }
            // Diagonal izquierda (captura)
            i = x + 1; j = y - 1;
            if ((i < 8) && (j >= 0)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            // Diagonal derecha (captura)
            i = x + 1; j = y + 1;
            if ((i < 8) && (j < 8)) {
                if (casillaOcupada(tablero[i][j], blanco)) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
        }
    }


    public Jugador getNegro() {
        return negro;
    }

    public Jugador getBlanco() {
        return blanco;
    }

    public JButton[][] getTablero() {
        return tablero;
    }

    public boolean isTurnoBlanco() {
        return turnoBlanco;
    }
}
