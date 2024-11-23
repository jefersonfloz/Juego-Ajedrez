package codigo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Representa una ficha de ajedrez asociada a una casilla.
 */
public class Ficha {
    /** Indica si la ficha es blanca o negra. */
    public boolean fichaBlanca;
    /** Identificador único de la ficha. */
    public int id;
    /** Tipo de ficha: 1 - Peón, 2 - Torre, 3 - Caballo, 4 - Alfil, 5 - Dama, 6 - Rey. */
    public int tipo;
    /** Botón asociado a la ficha, que representa la casilla en el tablero. */
    public JButton casilla;


    /**
     * Constructor de la clase Ficha.
     *
     * @param fic Indica si la ficha es blanca (true) o negra (false).
     * @param id Identificador único de la ficha.
     * @param tip Tipo de ficha (1 - Peón, 2 - Torre, 3 - Caballo, 4 - Alfil, 5 - Dama, 6 - Rey).
     * @param cas Botón que representa la casilla donde se encuentra la ficha.
     */
    public Ficha(boolean fic, int id, int tip, JButton cas) {
        this.fichaBlanca = fic;
        this.id = id;
        this.tipo = tip;
        this.casilla = cas;
        poneImagenes(cas.getWidth(), cas.getHeight());
    }

    /**
     * Establece la imagen correspondiente a la ficha según su tipo y color.
     *
     * @param w Ancho de la casilla (botón).
     * @param h Altura de la casilla (botón).
     */
    public void poneImagenes(int w, int h) {
        try {
            if (fichaBlanca) {
                if (tipo == 1) {
                    ImageIcon pB = new ImageIcon("src/image/wp.png");
                    ImageIcon pB2 = new ImageIcon(pB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(pB2);
                }
                if (tipo == 2) {
                    ImageIcon tB = new ImageIcon("src/image/wr.png");
                    ImageIcon tB2 = new ImageIcon(tB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(tB2);
                }
                if (tipo == 3) {
                    ImageIcon cB = new ImageIcon("src/image/wn.png");
                    ImageIcon cB2 = new ImageIcon(cB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(cB2);
                }
                if (tipo == 4) {
                    ImageIcon aB = new ImageIcon("src/image/wb.png");
                    ImageIcon aB2 = new ImageIcon(aB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(aB2);
                }
                if (tipo == 5) {
                    ImageIcon dB = new ImageIcon("src/image/wq.png");
                    ImageIcon dB2 = new ImageIcon(dB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(dB2);
                }
                if (tipo == 6) {
                    ImageIcon rB = new ImageIcon("src/image/wk.png");
                    ImageIcon rB2 = new ImageIcon(rB.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(rB2);
                }
            } else {
                if (tipo == 1) {
                    ImageIcon pN = new ImageIcon("src/image/bp.png");
                    ImageIcon pN2 = new ImageIcon(pN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(pN2);
                }
                if (tipo == 2) {
                    ImageIcon tN = new ImageIcon("src/image/br.png");
                    ImageIcon tN2 = new ImageIcon(tN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(tN2);
                }
                if (tipo == 3) {
                    ImageIcon cN = new ImageIcon("src/image/bn.png");
                    ImageIcon cN2 = new ImageIcon(cN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(cN2);
                }
                if (tipo == 4) {
                    ImageIcon aN = new ImageIcon("src/image/bb.png");
                    ImageIcon aN2 = new ImageIcon(aN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(aN2);
                }
                if (tipo == 5) {
                    ImageIcon dN = new ImageIcon("src/image/bq.png");
                    ImageIcon dN2 = new ImageIcon(dN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(dN2);
                }
                if (tipo == 6) {
                    ImageIcon rN = new ImageIcon("src/image/bk.png");
                    ImageIcon rN2 = new ImageIcon(rN.getImage().getScaledInstance(w, h, 1));
                    casilla.setIcon(rN2);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la imagen: " + e.toString());
        }
    }

    /**
     * Representación textual de la ficha.
     *
     * @return Una cadena con información sobre el color y el tipo de la ficha.
     */

    public String toString(){
        return "Ficha blanca: "+fichaBlanca+" de tipo: "+tipo;
    }
}
