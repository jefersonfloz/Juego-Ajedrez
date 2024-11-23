package codigo;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 * Clase que se encarga de generar archivos PGN (Portable Game Notation) para partidas de ajedrez,
 * registrando movimientos, resultados y detalles de los jugadores.
 */

public class PGNCreater {
    /** Lista de movimientos registrados durante la partida. */
    private ArrayList<String> movimientos;

    /** Nombre del jugador con piezas blancas. */
    private String jugadorBlancas;

    /** Nombre del jugador con piezas negras. */
    private String jugadorNegras;

    /** Resultado de la partida. */
    private String resultado;

    /** Fecha en la que se jugó la partida. */
    private LocalDate fecha;

    /** Área de texto donde se actualizan los movimientos registrados. */
    private JTextArea textArea;


    /**
     * Constructor de la clase PGNCreater.
     *
     * @param jugadorBlancas Nombre del jugador con piezas blancas.
     * @param jugadorNegras Nombre del jugador con piezas negras.
     * @param textArea Área de texto donde se mostrarán los movimientos.
     */
    public PGNCreater(String jugadorBlancas, String jugadorNegras, JTextArea textArea) {
        this.movimientos = new ArrayList<>();
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.fecha = LocalDate.now();
        this.resultado = "*";
        this.textArea = textArea;
    }

    /**
    * Convierte una posición de tablero de fila y columna en notación algebraica.
            *
            * @param fila La fila del tablero (0-7).
            * @param columna La columna del tablero (0-7).
            * @return La posición en notación algebraica.
     */

    public String obtenerPosicion(int fila, int columna) {
        char letra = (char) ('a' + columna);
        int numero = 8 - fila;
        return String.valueOf(letra) + numero;
    }


    /**
     * Obtiene el símbolo de la pieza según su tipo.
     *
     * @param ficha La ficha cuya representación se necesita.
     * @return Un string con el símbolo de la pieza (R, N, B, Q, K) o vacío si es un peón.
     */
    public String obtenerSimboloPieza(Ficha ficha) {
        switch (ficha.tipo) {
            case 2: return "R";
            case 3: return "N";
            case 4: return "B";
            case 5: return "Q";
            case 6: return "K";
            default: return "";
        }
    }


    /**
     * Registra un movimiento en la partida.
     *
     * @param pieza La pieza que se movió.
     * @param filaOrigen Fila inicial de la pieza.
     * @param columnaOrigen Columna inicial de la pieza.
     * @param filaDestino Fila de destino de la pieza.
     * @param columnaDestino Columna de destino de la pieza.
     * @param captura Indica si el movimiento fue una captura.
     */
    public void registrarMovimiento(Ficha pieza, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino, boolean captura) {
        String posOrigen = obtenerPosicion(filaOrigen, columnaOrigen);
        String posDestino = obtenerPosicion(filaDestino, columnaDestino);
        String simboloPieza = obtenerSimboloPieza(pieza);

        String movimiento = simboloPieza;
        if (captura) {
            if (simboloPieza.isEmpty()) {
                movimiento += posOrigen.charAt(0);
            }
            movimiento += "x";
        }
        movimiento += posDestino;

        movimientos.add(movimiento);
        actualizarTexto();
    }


    /**
     * Actualiza el contenido del área de texto con los movimientos registrados.
     */
    private void actualizarTexto() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < movimientos.size(); i++) {
            if (i % 2 == 0) {
                // Agregar número de jugada para movimientos de las blancas
                sb.append((i / 2 + 1)).append(".");
            }
            sb.append(movimientos.get(i));

            // Agregar espacio después de cada movimiento
            if (i < movimientos.size() - 1) {
                sb.append(" ");
            }

            // Salto de línea cada 8 movimientos completos (16 jugadas individuales)
            if (i % 16 == 15) {
                sb.append("\n");
            }
        }
        textArea.setText(sb.toString());
    }

    /**
     * Establece el resultado de la partida.
     *
     * @param resultado El resultado en formato PGN (1-0, 0-1, 1/2-1/2, etc.).
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
        // Actualizar el texto para incluir el resultado
        if (!textArea.getText().isEmpty()) {
            textArea.append(" " + resultado);
        }
    }


    /**
     * Guarda la partida en formato PGN en un archivo.
     *
     * @param nombreArchivo El nombre del archivo donde se guardará la partida.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */

    public void guardarPGN(String nombreArchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("[Event \"Partida Casual\"]\n");
            writer.write("[Site \"Local\"]\n");
            writer.write("[Date \"" + fecha + "\"]\n");
            writer.write("[Round \"1\"]\n");
            writer.write("[White \"" + jugadorBlancas + "\"]\n");
            writer.write("[Black \"" + jugadorNegras + "\"]\n");
            writer.write("[Result \"" + resultado + "\"]\n\n");

            for (int i = 0; i < movimientos.size(); i++) {
                if (i % 2 == 0) {
                    writer.write((i / 2 + 1) + ". ");
                }
                writer.write(movimientos.get(i) + " ");
                if (i % 2 == 1 && (i / 2 + 1) % 6 == 0) {
                    writer.write("\n");
                }
            }
            writer.write("\n" + resultado + "\n");
        }
    }
}
