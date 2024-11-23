package main;

import controlador.CheesController;
import vista.ChessView;

public class Main {
    public static void main(String args[]) {
        ChessView view = new ChessView();
        CheesController controller = new CheesController(view);
        view.setVisible(true);
    }
}
