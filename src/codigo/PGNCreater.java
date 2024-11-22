package codigo;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class PGNCreater {
    private ArrayList<String> movimientos;
    private String jugadorBlancas;
    private String jugadorNegras;
    private String resultado;
    private LocalDate fecha;
    private JTextArea textArea;

    public PGNCreater(String jugadorBlancas, String jugadorNegras, JTextArea textArea) {
        this.movimientos = new ArrayList<>();
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.fecha = LocalDate.now();
        this.resultado = "*";
        this.textArea = textArea;
    }

    public String obtenerPosicion(int fila, int columna) {
        char letra = (char) ('a' + columna);
        int numero = 8 - fila;
        return String.valueOf(letra) + numero;
    }

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

    public void setResultado(String resultado) {
        this.resultado = resultado;
        // Actualizar el texto para incluir el resultado
        if (!textArea.getText().isEmpty()) {
            textArea.append(" " + resultado);
        }
    }

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
