
package vista;

import codigo.*;
import controlador.CheesController;

import java.awt.Color;
import javax.swing.*;

/**
 * La clase ChessView representa la vista de la interfaz gráfica del tablero
 * de ajedrez, utilizando un conjunto de botones organizados en una matriz
 * para modelar el tablero. Incluye funcionalidades para pintar las casillas,
 * gestionar los turnos, y permitir la interacción con el usuario.
 */
public class ChessView extends javax.swing.JFrame {

    private javax.swing.JButton A1;
    private javax.swing.JButton A2;
    private javax.swing.JButton A3;
    private javax.swing.JButton A4;
    private javax.swing.JButton A5;
    private javax.swing.JButton A6;
    private javax.swing.JButton A7;
    private javax.swing.JButton A8;
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton C1;
    private javax.swing.JButton C2;
    private javax.swing.JButton C3;
    private javax.swing.JButton C4;
    private javax.swing.JButton C5;
    private javax.swing.JButton C6;
    private javax.swing.JButton C7;
    private javax.swing.JButton C8;
    private javax.swing.JButton D1;
    private javax.swing.JButton D2;
    private javax.swing.JButton D3;
    private javax.swing.JButton D4;
    private javax.swing.JButton D5;
    private javax.swing.JButton D6;
    private javax.swing.JButton D7;
    private javax.swing.JButton D8;
    private javax.swing.JButton E1;
    private javax.swing.JButton E2;
    private javax.swing.JButton E3;
    private javax.swing.JButton E4;
    private javax.swing.JButton E5;
    private javax.swing.JButton E6;
    private javax.swing.JButton E7;
    private javax.swing.JButton E8;
    private javax.swing.JButton F1;
    private javax.swing.JButton F2;
    private javax.swing.JButton F3;
    private javax.swing.JButton F4;
    private javax.swing.JButton F5;
    private javax.swing.JButton F6;
    private javax.swing.JButton F7;
    private javax.swing.JButton F8;
    private javax.swing.JButton G1;
    private javax.swing.JButton G2;
    private javax.swing.JButton G3;
    private javax.swing.JButton G4;
    private javax.swing.JButton G5;
    private javax.swing.JButton G6;
    private javax.swing.JButton G7;
    private javax.swing.JButton G8;
    private javax.swing.JButton H1;
    private javax.swing.JButton H2;
    private javax.swing.JButton H3;
    private javax.swing.JButton H4;
    private javax.swing.JButton H5;
    private javax.swing.JButton H6;
    private javax.swing.JButton H7;
    private javax.swing.JButton H8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelCasillas;
    private javax.swing.JTextField tfTurno;
    private JButton[][] MatrizCasillas;
    private javax.swing.JPanel panelDerecho;
    private JTextArea textArea;
    private PGNCreater pgnCreater;
    private JButton btnGuardar;
    private JTextField textoGuardar;

    /**
     * Constructor de la clase ChessView.
     * Inicializa la interfaz gráfica, configura la matriz de casillas
     * y establece el color inicial del tablero.
     */
    public ChessView() {
        initComponents();
        pgnCreater = new PGNCreater("Jugador Blanco", "Jugador Negro", textArea);

        MatrizCasillas = new JButton[8][8];
        JButton ArrayButtons[] = {A1, B1, C1, D1, E1, F1, G1, H1,
                A2, B2, C2, D2, E2, F2, G2, H2,
                A3, B3, C3, D3, E3, F3, G3, H3,
                A4, B4, C4, D4, E4, F4, G4, H4,
                A5, B5, C5, D5, E5, F5, G5, H5,
                A6, B6, C6, D6, E6, F6, G6, H6,
                A7, B7, C7, D7, E7, F7, G7, H7,
                A8, B8, C8, D8, E8, F8, G8, H8};
        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++, n++) {
                MatrizCasillas[i][j] = ArrayButtons[n];
            }
        }
        pintarCasillasNormal(MatrizCasillas);
        this.setBackground(Color.yellow);
        tfTurno.setText("BLANCO");
        tfTurno.setBackground(Color.WHITE);
        tfTurno.setForeground(Color.BLACK);
    }

    /**
     * Pinta las casillas del tablero con el patrón de ajedrez estándar.
     *
     * @param MatrizCasillas La matriz de botones que representan las casillas del tablero.
     */

    public void pintarCasillasNormal(JButton[][] MatrizCasillas) {
        int i, j;
        for (i = 0; i < 8; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 6) {
                for (j = 0; j < 8; j += 2) {
                    MatrizCasillas[i][j].setBackground(Color.WHITE);
                }
            } else {
                for (j = 1; j < 8; j += 2) {
                    MatrizCasillas[i][j].setBackground(Color.WHITE);
                }
            }
        }
        for (i = 0; i < 8; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7) {
                for (j = 0; j < 8; j += 2) {
                    this.MatrizCasillas[i][j].setBackground(Color.BLACK);
                }
            } else {
                for (j = 1; j < 8; j += 2) {
                    this.MatrizCasillas[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

    /**
     * Este método inicializa los componentes de la interfaz gráfica, incluidos los botones
     * que representan las casillas del tablero de ajedrez. Es un método generado automáticamente
     * por herramientas de diseño visual como NetBeans y no debería ser modificado manualmente
     * en la mayoría de los casos.
     *
     * Configura los elementos básicos del panel de casillas y crea los botones
     * para cada casilla del tablero, desde A1 hasta H8.
     *
     * Se utiliza la anotación {@code @SuppressWarnings("unchecked")} para suprimir
     * advertencias generadas automáticamente por el compilador sobre tipos genéricos.
     */


    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelCasillas = new javax.swing.JPanel();
        A1 = new javax.swing.JButton();
        B1 = new javax.swing.JButton();
        C1 = new javax.swing.JButton();
        D1 = new javax.swing.JButton();
        E1 = new javax.swing.JButton();
        F1 = new javax.swing.JButton();
        G1 = new javax.swing.JButton();
        H1 = new javax.swing.JButton();
        A2 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        C2 = new javax.swing.JButton();
        D2 = new javax.swing.JButton();
        E2 = new javax.swing.JButton();
        F2 = new javax.swing.JButton();
        G2 = new javax.swing.JButton();
        H2 = new javax.swing.JButton();
        A3 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        C3 = new javax.swing.JButton();
        D3 = new javax.swing.JButton();
        E3 = new javax.swing.JButton();
        F3 = new javax.swing.JButton();
        G3 = new javax.swing.JButton();
        H3 = new javax.swing.JButton();
        A4 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        C4 = new javax.swing.JButton();
        D4 = new javax.swing.JButton();
        E4 = new javax.swing.JButton();
        F4 = new javax.swing.JButton();
        G4 = new javax.swing.JButton();
        H4 = new javax.swing.JButton();
        A5 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        C5 = new javax.swing.JButton();
        D5 = new javax.swing.JButton();
        E5 = new javax.swing.JButton();
        F5 = new javax.swing.JButton();
        G5 = new javax.swing.JButton();
        H5 = new javax.swing.JButton();
        A6 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        C6 = new javax.swing.JButton();
        D6 = new javax.swing.JButton();
        E6 = new javax.swing.JButton();
        F6 = new javax.swing.JButton();
        G6 = new javax.swing.JButton();
        H6 = new javax.swing.JButton();
        A7 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        C7 = new javax.swing.JButton();
        D7 = new javax.swing.JButton();
        E7 = new javax.swing.JButton();
        F7 = new javax.swing.JButton();
        G7 = new javax.swing.JButton();
        H7 = new javax.swing.JButton();
        A8 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        C8 = new javax.swing.JButton();
        D8 = new javax.swing.JButton();
        E8 = new javax.swing.JButton();
        F8 = new javax.swing.JButton();
        G8 = new javax.swing.JButton();
        H8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelDerecho = new javax.swing.JPanel();
        textArea = new JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfTurno = new javax.swing.JTextField();
        textoGuardar = new javax.swing.JTextField();
        btnGuardar = new JButton("Guardar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajedrez");
        setResizable(false);

        panelCasillas.setPreferredSize(new java.awt.Dimension(400, 400));
        panelCasillas.setRequestFocusEnabled(false);
        panelCasillas.setLayout(new java.awt.GridLayout(8, 8));

        panelCasillas.add(A1);
        panelCasillas.add(B1);
        panelCasillas.add(C1);
        panelCasillas.add(D1);
        panelCasillas.add(E1);
        panelCasillas.add(F1);
        panelCasillas.add(G1);
        panelCasillas.add(H1);
        panelCasillas.add(A2);
        panelCasillas.add(B2);
        panelCasillas.add(C2);
        panelCasillas.add(D2);
        panelCasillas.add(E2);
        panelCasillas.add(F2);
        panelCasillas.add(G2);
        panelCasillas.add(H2);
        panelCasillas.add(A3);
        panelCasillas.add(B3);
        panelCasillas.add(C3);
        panelCasillas.add(D3);
        panelCasillas.add(E3);
        panelCasillas.add(F3);
        panelCasillas.add(G3);
        panelCasillas.add(H3);
        panelCasillas.add(A4);
        panelCasillas.add(B4);
        panelCasillas.add(C4);
        panelCasillas.add(D4);
        panelCasillas.add(E4);
        panelCasillas.add(F4);
        panelCasillas.add(G4);
        panelCasillas.add(H4);
        panelCasillas.add(A5);
        panelCasillas.add(B5);
        panelCasillas.add(C5);
        panelCasillas.add(D5);
        panelCasillas.add(E5);
        panelCasillas.add(F5);
        panelCasillas.add(G5);
        panelCasillas.add(H5);
        panelCasillas.add(A6);
        panelCasillas.add(B6);
        panelCasillas.add(C6);
        panelCasillas.add(D6);
        panelCasillas.add(E6);
        panelCasillas.add(F6);
        panelCasillas.add(G6);
        panelCasillas.add(H6);
        panelCasillas.add(A7);
        panelCasillas.add(B7);
        panelCasillas.add(C7);
        panelCasillas.add(D7);
        panelCasillas.add(E7);
        panelCasillas.add(F7);
        panelCasillas.add(G7);
        panelCasillas.add(H7);
        panelCasillas.add(A8);
        panelCasillas.add(B8);
        panelCasillas.add(C8);
        panelCasillas.add(D8);
        panelCasillas.add(E8);
        panelCasillas.add(F8);
        panelCasillas.add(G8);
        panelCasillas.add(H8);

        panelDerecho = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.GridLayout(8, 1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("8");
        jPanel1.add(jLabel8);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("7");
        jPanel1.add(jLabel7);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("6");
        jPanel1.add(jLabel6);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("5");
        jPanel1.add(jLabel5);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("4");
        jPanel1.add(jLabel4);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3");
        jPanel1.add(jLabel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2");
        jPanel1.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1");
        jPanel1.add(jLabel1);


        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("a");
        jPanel3.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("b");
        jPanel3.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("c");
        jPanel3.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("d");
        jPanel3.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("e");
        jPanel3.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("f");
        jPanel3.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("g");
        jPanel3.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("h");
        jPanel3.add(jLabel16);

        // Configuración del panel derecho
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

// Configuración del JTextArea con un JScrollPane
        textArea.setEditable(false);
        textArea.setText("Información del juego:\n");
        textArea.setFont(new java.awt.Font("Tahoma", 0, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panelDerecho.add(scrollPane, java.awt.BorderLayout.CENTER);

        panelDerecho.add(textArea, java.awt.BorderLayout.SOUTH);
        // Configuración del botón Guardar
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14));

        textoGuardar = new JTextField(20);

        panelDerecho.add(new JLabel("Nombre del archivo:")); // Etiqueta descriptiva
        panelDerecho.add(textoGuardar);

        panelDerecho.add(btnGuardar, java.awt.BorderLayout.SOUTH);

        tfTurno.setEditable(false);
        tfTurno.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        tfTurno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTurno.setText("BLANCO");


        // Ajustar el diseño principal
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTurno)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelCasillas, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelDerecho, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfTurno, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelCasillas, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelDerecho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Asocia un controlador a los botones del tablero de ajedrez y a otros botones relacionados,
     * permitiendo manejar eventos de clic en cada casilla.
     *
     * @param controller el controlador de tipo {@code CheesController} que manejará
     *                   los eventos de acción de los botones del tablero.
     *
     * Este método utiliza el patrón MVC (Modelo-Vista-Controlador), donde la vista
     * (los botones) delega la lógica de negocio al controlador al ocurrir un evento.
     * Cada botón del tablero (A1 a H8) y el botón {@code btnGuardar} se configura
     * para que invoque los métodos del controlador cuando se haga clic.
     */
    public void addController(CheesController controller) {
        A1.addActionListener(controller);
        B1.addActionListener(controller);
        C1.addActionListener(controller);
        D1.addActionListener(controller);
        E1.addActionListener(controller);
        F1.addActionListener(controller);
        G1.addActionListener(controller);
        H1.addActionListener(controller);

        A2.addActionListener(controller);
        B2.addActionListener(controller);
        C2.addActionListener(controller);
        D2.addActionListener(controller);
        E2.addActionListener(controller);
        F2.addActionListener(controller);
        G2.addActionListener(controller);
        H2.addActionListener(controller);

        A3.addActionListener(controller);
        B3.addActionListener(controller);
        C3.addActionListener(controller);
        D3.addActionListener(controller);
        E3.addActionListener(controller);
        F3.addActionListener(controller);
        G3.addActionListener(controller);
        H3.addActionListener(controller);

        A4.addActionListener(controller);
        B4.addActionListener(controller);
        C4.addActionListener(controller);
        D4.addActionListener(controller);
        E4.addActionListener(controller);
        F4.addActionListener(controller);
        G4.addActionListener(controller);
        H4.addActionListener(controller);

        A5.addActionListener(controller);
        B5.addActionListener(controller);
        C5.addActionListener(controller);
        D5.addActionListener(controller);
        E5.addActionListener(controller);
        F5.addActionListener(controller);
        G5.addActionListener(controller);
        H5.addActionListener(controller);

        A6.addActionListener(controller);
        B6.addActionListener(controller);
        C6.addActionListener(controller);
        D6.addActionListener(controller);
        E6.addActionListener(controller);
        F6.addActionListener(controller);
        G6.addActionListener(controller);
        H6.addActionListener(controller);

        A7.addActionListener(controller);
        B7.addActionListener(controller);
        C7.addActionListener(controller);
        D7.addActionListener(controller);
        E7.addActionListener(controller);
        F7.addActionListener(controller);
        G7.addActionListener(controller);
        H7.addActionListener(controller);

        A8.addActionListener(controller);
        B8.addActionListener(controller);
        C8.addActionListener(controller);
        D8.addActionListener(controller);
        E8.addActionListener(controller);
        F8.addActionListener(controller);
        G8.addActionListener(controller);
        H8.addActionListener(controller);
        btnGuardar.addActionListener(controller);
    }


    /**
     * Maneja la promoción de un peón al llegar al final del tablero,
     * permitiendo al usuario seleccionar la nueva pieza a través de un diálogo.
     *
     * @param boton        el botón del tablero que representa la casilla donde
     *                     se encuentra el peón que será promovido.
     * @param turnoBlanco  un booleano que indica si el turno actual es de las piezas blancas
     *                     ({@code true} para blancas, {@code false} para negras).
     * @param seleccionada la pieza que será promovida, cuya propiedad {@code tipo}
     *                     será modificada para reflejar la nueva pieza seleccionada.
     *
     * Este método muestra un diálogo modal con opciones para la promoción
     * del peón (Torre, Caballo, Alfil, Dama). Según la selección del usuario,
     * cambia el tipo de la pieza y actualiza el icono del botón correspondiente
     * con la nueva figura.
     */


    public void promocionarPeon(JButton boton, boolean turnoBlanco, Ficha seleccionada) {
        String[] opciones = {"Torre", "Caballo", "Alfil", "Dama"};
        int n = JOptionPane.showOptionDialog(rootPane,
                "Tu peón ha llegado al final del tablero, ¿en qué nueva figura desea convertirla?",
                "Level UP", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);

        if (n >= 0 && n <= 3) {
            String color = turnoBlanco ? "w" : "b";
            String[] figuras = {"r", "n", "b", "q"};
            seleccionada.tipo = n + 2; // Torre: 2, Caballo: 3, Alfil: 4, Dama: 5
            ImageIcon icono = new ImageIcon("src/image/" + color + figuras[n] + ".png");
            boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), 1)));
        }
    }

    /**
     * Obtiene el campo de texto que muestra el turno actual.
     *
     * @return el JTextField que indica el turno.
     */

    public JTextField getTfTurno() {
        return tfTurno;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A7.
     *
     * @return el JButton de la casilla A7.
     */
    public JButton getA7() {
        return A7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A1.
     *
     * @return el JButton de la casilla A1.
     */
    public JButton getA1() {
        return A1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A2.
     *
     * @return el JButton de la casilla A2.
     */
    public JButton getA2() {
        return A2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A3.
     *
     * @return el JButton de la casilla A3.
     */
    public JButton getA3() {
        return A3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A4.
     *
     * @return el JButton de la casilla A4.
     */
    public JButton getA4() {
        return A4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A5.
     *
     * @return el JButton de la casilla A5.
     */
    public JButton getA5() {
        return A5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A6.
     *
     * @return el JButton de la casilla A6.
     */
    public JButton getA6() {
        return A6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla A8.
     *
     * @return el JButton de la casilla A8.
     */
    public JButton getA8() {
        return A8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B1.
     *
     * @return el JButton de la casilla B1.
     */
    public JButton getB1() {
        return B1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B2.
     *
     * @return el JButton de la casilla B2.
     */
    public JButton getB2() {
        return B2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B3.
     *
     * @return el JButton de la casilla B3.
     */
    public JButton getB3() {
        return B3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B4.
     *
     * @return el JButton de la casilla B4.
     */
    public JButton getB4() {
        return B4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B5.
     *
     * @return el JButton de la casilla B5.
     */
    public JButton getB5() {
        return B5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B6.
     *
     * @return el JButton de la casilla B6.
     */
    public JButton getB6() {
        return B6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B7.
     *
     * @return el JButton de la casilla B7.
     */
    public JButton getB7() {
        return B7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla B8.
     *
     * @return el JButton de la casilla B8.
     */
    public JButton getB8() {
        return B8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C1.
     *
     * @return el JButton de la casilla C1.
     */
    public JButton getC1() {
        return C1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C2.
     *
     * @return el JButton de la casilla C2.
     */
    public JButton getC2() {
        return C2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C3.
     *
     * @return el JButton de la casilla C3.
     */
    public JButton getC3() {
        return C3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C4.
     *
     * @return el JButton de la casilla C4.
     */
    public JButton getC4() {
        return C4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C5.
     *
     * @return el JButton de la casilla C5.
     */
    public JButton getC5() {
        return C5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C6.
     *
     * @return el JButton de la casilla C6.
     */
    public JButton getC6() {
        return C6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C7.
     *
     * @return el JButton de la casilla C7.
     */
    public JButton getC7() {
        return C7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla C8.
     *
     * @return el JButton de la casilla C8.
     */
    public JButton getC8() {
        return C8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D1.
     *
     * @return el JButton de la casilla D1.
     */
    public JButton getD1() {
        return D1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D2.
     *
     * @return el JButton de la casilla D2.
     */
    public JButton getD2() {
        return D2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D3.
     *
     * @return el JButton de la casilla D3.
     */
    public JButton getD3() {
        return D3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D4.
     *
     * @return el JButton de la casilla D4.
     */
    public JButton getD4() {
        return D4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D5.
     *
     * @return el JButton de la casilla D5.
     */
    public JButton getD5() {
        return D5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D6.
     *
     * @return el JButton de la casilla D6.
     */
    public JButton getD6() {
        return D6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D7.
     *
     * @return el JButton de la casilla D7.
     */
    public JButton getD7() {
        return D7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla D8.
     *
     * @return el JButton de la casilla D8.
     */
    public JButton getD8() {
        return D8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E1.
     *
     * @return el JButton de la casilla E1.
     */
    public JButton getE1() {
        return E1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E2.
     *
     * @return el JButton de la casilla E2.
     */
    public JButton getE2() {
        return E2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E3.
     *
     * @return el JButton de la casilla E3.
     */
    public JButton getE3() {
        return E3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E4.
     *
     * @return el JButton de la casilla E4.
     */
    public JButton getE4() {
        return E4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E5.
     *
     * @return el JButton de la casilla E5.
     */
    public JButton getE5() {
        return E5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E6.
     *
     * @return el JButton de la casilla E6.
     */
    public JButton getE6() {
        return E6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E7.
     *
     * @return el JButton de la casilla E7.
     */
    public JButton getE7() {
        return E7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla E8.
     *
     * @return el JButton de la casilla E8.
     */
    public JButton getE8() {
        return E8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F1.
     *
     * @return el JButton de la casilla F1.
     */
    public JButton getF1() {
        return F1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F2.
     *
     * @return el JButton de la casilla F2.
     */
    public JButton getF2() {
        return F2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F3.
     *
     * @return el JButton de la casilla F3.
     */
    public JButton getF3() {
        return F3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F4.
     *
     * @return el JButton de la casilla F4.
     */
    public JButton getF4() {
        return F4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F5.
     *
     * @return el JButton de la casilla F5.
     */
    public JButton getF5() {
        return F5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F6.
     *
     * @return el JButton de la casilla F6.
     */
    public JButton getF6() {
        return F6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F7.
     *
     * @return el JButton de la casilla F7.
     */
    public JButton getF7() {
        return F7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla F8.
     *
     * @return el JButton de la casilla F8.
     */
    public JButton getF8() {
        return F8;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G1.
     *
     * @return el JButton de la casilla G1.
     */
    public JButton getG1() {
        return G1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G2.
     *
     * @return el JButton de la casilla G2.
     */
    public JButton getG2() {
        return G2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G3.
     *
     * @return el JButton de la casilla G3.
     */
    public JButton getG3() {
        return G3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G4.
     *
     * @return el JButton de la casilla G4.
     */
    public JButton getG4() {
        return G4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G5.
     *
     * @return el JButton de la casilla G5.
     */
    public JButton getG5() {
        return G5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G6.
     *
     * @return el JButton de la casilla G6.
     */
    public JButton getG6() {
        return G6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G7.
     *
     * @return el JButton de la casilla G7.
     */
    public JButton getG7() {
        return G7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla G8.
     *
     * @return el JButton de la casilla G8.
     */
    public JButton getG8() {
        return G8;
    }


    /**
     * Obtiene el botón correspondiente a la casilla H1.
     *
     * @return el JButton de la casilla H1.
     */
    public JButton getH1() {
        return H1;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H2.
     *
     * @return el JButton de la casilla H2.
     */
    public JButton getH2() {
        return H2;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H3.
     *
     * @return el JButton de la casilla H3.
     */
    public JButton getH3() {
        return H3;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H4.
     *
     * @return el JButton de la casilla H4.
     */
    public JButton getH4() {
        return H4;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H5.
     *
     * @return el JButton de la casilla H5.
     */
    public JButton getH5() {
        return H5;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H6.
     *
     * @return el JButton de la casilla H6.
     */
    public JButton getH6() {
        return H6;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H7.
     *
     * @return el JButton de la casilla H7.
     */
    public JButton getH7() {
        return H7;
    }

    /**
     * Obtiene el botón correspondiente a la casilla H8.
     *
     * @return el JButton de la casilla H8.
     */
    public JButton getH8() {
        return H8;
    }


    /**
     * Obtiene la matriz de botones que representan las casillas del tablero.
     *
     * @return un arreglo bidimensional de JButton que representa las casillas.
     */

    public JButton[][] getMatrizCasillas() {
        return MatrizCasillas;
    }

    /**
     * Obtiene el área de texto utilizada para mostrar mensajes en la interfaz.
     *
     * @return el JTextArea asociado a los mensajes.
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Obtiene el botón utilizado para guardar el estado del juego.
     *
     * @return el JButton asociado a la acción de guardar.
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    /**
     * Obtiene el campo de texto donde se ingresa el nombre para guardar el juego.
     *
     * @return el JTextField asociado al nombre de guardado.
     */
    public JTextField getTextoGuardar(){
        return textoGuardar;
    }
}
