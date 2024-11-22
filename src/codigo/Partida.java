
package codigo;

import javax.swing.JButton;
import java.awt.*;

public class Partida {
    public codigo.Jugador blanco;
    public codigo.Jugador negro;
    public JButton tablero[][];
    public boolean turnoBlanco;

    public Partida(codigo.Jugador b, codigo.Jugador n, JButton[][] t){
        this.blanco = b;
        this.negro = n;
        this.turnoBlanco = true;
        this.tablero = new JButton[8][8];
        this.tablero = t;
    }

    public void cambiarTurno(){
        if(this.turnoBlanco){
            this.turnoBlanco = false;
        }else{
            this.turnoBlanco = true;
        }
    }

    public boolean casillaOcupada(JButton casilla, codigo.Jugador jugador) {
        boolean ocupada = false;
        for(int i=0; i<jugador.fichas.size(); i++){
            if(casilla.equals(jugador.fichas.get(i).casilla)){
                ocupada = true;
            }
        }
        return ocupada;
    }

    //retorna si se  ha acabado la partida
    public boolean comer(codigo.Jugador rival, codigo.Ficha eliminada){
        boolean acabado = false;
        for(int i=0; i<rival.fichas.size(); i++){
            if(rival.fichas.get(i).equals(eliminada)){
                if(rival.fichas.get(i).tipo == 6){
                    acabado = true;
                }
                rival.fichas.remove(i);
            }
        }
        return acabado;
    }


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

}
