package andr7st;

import javax.swing.*;

public class VentanaLogin extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 9155571621262263447L;

    private final int VENTANA_ALTO  = 480;
    private final int VENTANA_ANCHO = 720;

    public VentanaLogin() {

        this.setTitle("Login | Andr7st");
        this.setSize(VENTANA_ANCHO, VENTANA_ALTO);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

      

    }
    
}
