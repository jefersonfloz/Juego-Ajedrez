package codigo;

import java.util.ArrayList;

public class Jugador {

    public boolean blanco;
    //   public boolean turno;
    public ArrayList<codigo.Ficha> fichas;

    public Jugador(boolean bla) {
        this.blanco = bla;
        this.fichas = new ArrayList<codigo.Ficha>();
    }

    public boolean estaLaFicha(int id) {
        boolean esta = false;
        for (int i = 0; i < fichas.size(); i++) {
            if (fichas.get(i).id == id) {
                esta = true;
            }
        }
        return true;
    }

}
