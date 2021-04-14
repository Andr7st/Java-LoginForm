package andr7st.forms.login;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelImagen extends JPanel { private static final long serialVersionUID = 1L;

    /// Aquí sólo se dibuja el icono de login
    // https://www.clipartkey.com/view/TbJihh_user-icon-login-logo/
    private ImageIcon RECURSO_IMAGEN = new ImageIcon("img/LoginIcon.png");

    //// Coordenadas y tamaño de este panel
    private final int PANEL_IMAGEN_ANCHO      = 160;
    private final int PANEL_IMAGEN_ALTO       = 180;
    private final int PANEL_IMAGEN_POSICION_X = 100;
    private final int PANEL_IMAGEN_POSICION_Y =  40;

    public PanelImagen() {

        this.setBackground(Color.YELLOW);
        this.setBounds(PANEL_IMAGEN_POSICION_X, PANEL_IMAGEN_POSICION_Y, PANEL_IMAGEN_ANCHO, PANEL_IMAGEN_ALTO);
    }

    public void paint(Graphics g) {
        
        Dimension dimensionPanelImagen = getSize();
        g.drawImage(RECURSO_IMAGEN.getImage(), 0, 0, dimensionPanelImagen.width, dimensionPanelImagen.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}