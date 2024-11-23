package codigo;

import java.util.ArrayList;

/**
 * Representa un jugador en el juego, que puede controlar fichas blancas o negras.
 */
public class Jugador {

    /** Indica si el jugador controla las fichas blancas (true) o negras (false). */
    private boolean blanco;
    /** Lista de fichas controladas por el jugador. */
    private ArrayList<codigo.Ficha> fichas;


    /**
     * Constructor de la clase Jugador.
     *
     * @param bla Indica si el jugador controlará fichas blancas (true) o negras (false).
     */
    public Jugador(boolean bla) {
        this.blanco = bla;
        this.fichas = new ArrayList<codigo.Ficha>();
    }


    public boolean isBlanco() {
        return blanco;
    }

    /**
     * Obtiene la lista de fichas controladas por el jugador.
     *
     * @return Una lista de fichas controladas por el jugador.
     */
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
}
