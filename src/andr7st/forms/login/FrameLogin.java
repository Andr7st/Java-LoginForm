package andr7st.forms.login;
/**
 * @author Andrés Segura.
 * 
 * Ejercicio: Crear una ventana de login
 * 
 */
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrameLogin extends JFrame {


    private static final long serialVersionUID = 9155571621262263447L;
    
    public ImageIcon iconoVentana = new ImageIcon("img/icono.png");

    private final int VENTANA_ALTO = 620;
    private final int VENTANA_ANCHO = 360;

    public static final Color COLOR_1 = new Color(45,45,45); //(124, 45, 82);
    public static final Color COLOR_2 = new Color(240,240,240);

    public FrameLogin() {

        this.setTitle("Login | Andr7st");
        this.setSize(VENTANA_ANCHO, VENTANA_ALTO);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(iconoVentana.getImage());
        this.add(new PanelPrincipal());
    }

    public class PanelPrincipal extends JPanel { private static final long serialVersionUID = 1L;

        public PanelPrincipal() {

            this.setBackground(COLOR_1);
            this.setLayout(null);
            this.add(new PanelImagen());
            this.add(new PanelFuncionLogin());

        } 
    }
}
